package com.indranil.adviewtask.controller.api;


import android.content.Context;
import android.util.Log;

import com.indranil.adviewtask.model.constants.FailureCodes;
import com.indranil.adviewtask.model.listners.GridListner;
import com.indranil.adviewtask.model.listners.ListListner;
import com.indranil.adviewtask.model.listners.ResponseProgressListner;
import com.indranil.adviewtask.model.pojo.GridResponseModel;
import com.indranil.adviewtask.model.pojo.ResponseModel;
import com.indranil.adviewtask.view.utils.InternetConnectionCheck;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiManager {

    public static void getListDetails(final Context context, final ListListner listListner, final ResponseProgressListner listner){
        if (InternetConnectionCheck.haveNetworkConnection(context)) {
            Api api = RestManager.getInstance();
            Call<ResponseModel> call = api.getItemList();
            listner.onResponseInProgress();
            call.enqueue(new Callback<ResponseModel>() {
                @Override
                public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                    ResponseModel responseModel = response.body();
                    if (responseModel.getErrorcode().equals("0")){
                            listListner.getHeaderList(responseModel.getResults().getData());
                            listner.onResponseCompleted(1);
                    }else{
                        listner.onResponseFailed(FailureCodes.RESPONSE_NULL);
                    }
                }

                @Override
                public void onFailure(Call<ResponseModel> call, Throwable t) {
                    listner.onResponseFailed(FailureCodes.API_ERROR);
                }
            });
        }else{
            listner.onResponseFailed(FailureCodes.NO_INTERNET);
        }
    }

    public static  void getGridDetails(final Context context,String url,final GridListner gridListner, final ResponseProgressListner listner){
        if (InternetConnectionCheck.haveNetworkConnection(context)){
            Api api = RestManager.getInstance();
            Call<GridResponseModel> call = api.getItemGrid(url);
            listner.onResponseInProgress();
            call.enqueue(new Callback<GridResponseModel>() {
                @Override
                public void onResponse(Call<GridResponseModel> call, Response<GridResponseModel> response) {
                    GridResponseModel responseModel = response.body();
                    if (responseModel.getError().getStatus().equals(1)){
                        gridListner.getGridList(responseModel.getResults());
                        listner.onResponseCompleted(2);
                    }else{
                        listner.onResponseFailed(FailureCodes.RESPONSE_NULL);
                    }
                }

                @Override
                public void onFailure(Call<GridResponseModel> call, Throwable t) {
                    listner.onResponseFailed(FailureCodes.API_ERROR);
                }
            });
        }else{
            listner.onResponseFailed(FailureCodes.NO_INTERNET);
        }
    }
}

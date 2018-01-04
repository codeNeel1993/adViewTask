package com.indranil.adviewtask.controller.api;

import com.indranil.adviewtask.model.pojo.GridResponseModel;
import com.indranil.adviewtask.model.pojo.ResponseModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;


public interface Api {

    @GET("commonfilter.php?city=Bangalore&state=&vid=89&level=1&search=Restaurants&hotkey=1&wap=2&jdlite=0/")
    Call<ResponseModel> getItemList();

    @GET
    Call<GridResponseModel> getItemGrid(@Url String url);
}

package com.indranil.adviewtask.controller.api;

import com.indranil.adviewtask.model.pojo.GridResponseModel;
import com.indranil.adviewtask.model.pojo.ResponseModel;

import retrofit2.Call;
import retrofit2.http.GET;


public interface Api {

    @GET("commonfilter.php?city=Bangalore&state=&vid=89&level=1&search=Restaurants&hotkey=1&wap=2&jdlite=0/")
    Call<ResponseModel> getItemList();

    @GET("searchziva.php?city=Bangalore&state=&case=spcall&stype=category_list&search=Restaurants&national_catid=10408936")
    Call<GridResponseModel> getItemGrid();
}

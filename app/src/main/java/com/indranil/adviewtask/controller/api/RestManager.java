package com.indranil.adviewtask.controller.api;

import com.google.gson.JsonSyntaxException;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.indranil.adviewtask.model.constants.Constants.Base_url;


public class RestManager {

    private static Retrofit retrofit;


    public static Api getInstance() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(Base_url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit.create(Api.class);
    }



}

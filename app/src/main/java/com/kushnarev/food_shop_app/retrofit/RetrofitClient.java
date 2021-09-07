package com.kushnarev.food_shop_app.retrofit;

import com.kushnarev.food_shop_app.POJO.Photos_POJO;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/";
    private Api_Interfice api_interfice;
    private static RetrofitClient INSTANCE;
    private static Retrofit retrofit = null;

    public RetrofitClient() {

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();


        api_interfice = retrofit.create(Api_Interfice.class);
    }

    public static RetrofitClient getINSTANCE() {
        if (null == INSTANCE){
            INSTANCE = new RetrofitClient();
        }

        return INSTANCE;
    }
    public Call<List<Photos_POJO>> getPhoto(){
        return api_interfice.getPosts();
    }

}

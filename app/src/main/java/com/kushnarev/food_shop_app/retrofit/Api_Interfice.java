package com.kushnarev.food_shop_app.retrofit;

import com.kushnarev.food_shop_app.POJO.Photos_POJO;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api_Interfice {

    @GET("photos") //https://jsonplaceholder.typicode.com/photos
    Call<List<Photos_POJO>> getPosts();



}

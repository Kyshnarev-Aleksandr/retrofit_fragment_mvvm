package com.kushnarev.food_shop_app.modelView;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.kushnarev.food_shop_app.POJO.Photos_POJO;
import com.kushnarev.food_shop_app.retrofit.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostviewModel extends ViewModel {

    public MutableLiveData<List<Photos_POJO>> mutableLiveData = new MutableLiveData<>();

    public void getPosts(){

        RetrofitClient.getINSTANCE().getPhoto().enqueue(new Callback<List<Photos_POJO>>() {
            @Override
            public void onResponse(Call<List<Photos_POJO>> call, Response<List<Photos_POJO>> response) {
                if (response.isSuccessful() && response.body() != null){
                    mutableLiveData.setValue(response.body());


                }
            }

            @Override
            public void onFailure(Call<List<Photos_POJO>> call, Throwable t) {

            }

        });
    }


}

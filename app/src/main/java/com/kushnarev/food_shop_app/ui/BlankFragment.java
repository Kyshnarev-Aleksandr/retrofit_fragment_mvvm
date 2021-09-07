package com.kushnarev.food_shop_app.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kushnarev.food_shop_app.POJO.Photos_POJO;
import com.kushnarev.food_shop_app.R;
import com.kushnarev.food_shop_app.adapter.ImageAdapter;
import com.kushnarev.food_shop_app.modelView.PostviewModel;
import com.kushnarev.food_shop_app.retrofit.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class BlankFragment extends Fragment {

    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    ImageAdapter adapter;
    List<Photos_POJO> postsList = new ArrayList<>();

    PostviewModel postviewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blank, container, false);

        recyclerView = view.findViewById(R.id.recycleView);
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        adapter = new ImageAdapter(postsList);
        recyclerView.setAdapter(adapter);

        fetchPosts();


        return view;
    }

    private void fetchPosts() {

        postviewModel = ViewModelProviders.of(getActivity()).get(PostviewModel.class);
        postviewModel.getPosts();

        postviewModel.mutableLiveData.observe(getViewLifecycleOwner(), new Observer<List<Photos_POJO>>() {
            @Override
            public void onChanged(List<Photos_POJO> photos_pojos) {
                adapter.getPostsList(photos_pojos);
            }
        });



        adapter.notifyDataSetChanged();

    }
}
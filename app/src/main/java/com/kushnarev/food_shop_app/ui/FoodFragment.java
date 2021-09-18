package com.kushnarev.food_shop_app.ui;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

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


public class FoodFragment extends Fragment {

    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    ImageAdapter adapter;
    List<Photos_POJO> postsList = new ArrayList<>();

    PostviewModel postviewModel;

    Button button1, button2, button3;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blank, container, false);

        button1 = view.findViewById(R.id.button1);
        button2 = view.findViewById(R.id.button2);
        button3 = view.findViewById(R.id.button3);

        recyclerView = view.findViewById(R.id.recycleView);
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        adapter = new ImageAdapter(postsList);
        recyclerView.setAdapter(adapter);

        ClickButton();

        fetchPosts();


        return view;
    }

    private void ClickButton() {

        button1.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                button1.setBackgroundResource(R.drawable.top_navigation);
                button1.setTextColor(R.color.neon);
                button2.setBackgroundResource(R.color.white);
                button2.setTextColor(R.color.gray);
                button3.setBackgroundResource(R.color.white);
                button3.setTextColor(R.color.gray);

                layoutManager = new LinearLayoutManager(getContext());
                recyclerView.setLayoutManager(layoutManager);
                adapter.notifyDataSetChanged();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                button2.setBackgroundResource(R.drawable.top_navigation);
                button2.setTextColor(R.color.neon);
                button3.setBackgroundResource(R.color.white);
                button3.setTextColor(R.color.gray);
                button1.setBackgroundResource(R.color.white);
                button1.setTextColor(R.color.gray);

                layoutManager = new GridLayoutManager(getContext(), 2);
                recyclerView.setLayoutManager(layoutManager);
                adapter.notifyDataSetChanged();
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                button3.setBackgroundResource(R.drawable.top_navigation);
                button3.setTextColor(R.color.neon);
                button1.setBackgroundResource(R.color.white);
                button1.setTextColor(R.color.gray);
                button2.setBackgroundResource(R.color.white);
                button2.setTextColor(R.color.gray);
                layoutManager = new GridLayoutManager(getContext(), 3);
                recyclerView.setLayoutManager(layoutManager);
                adapter.notifyDataSetChanged();
            }
        });

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
    }
}
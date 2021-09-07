package com.kushnarev.food_shop_app.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.kushnarev.food_shop_app.R;
import com.kushnarev.food_shop_app.ui.BlankFragment;

public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new BlankFragment()).commit();

    }



}
package com.example.roomcomparison;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.example.roomcomparison.viewModel.MatchViewModel;

public class MainActivity extends AppCompatActivity {

    MatchViewModel mMatchViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMatchViewModel = new ViewModelProvider(this).get(MatchViewModel.class);
        mMatchViewModel.dummyQuery();
    }
}
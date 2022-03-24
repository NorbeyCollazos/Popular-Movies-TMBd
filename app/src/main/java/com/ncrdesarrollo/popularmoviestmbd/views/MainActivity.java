package com.ncrdesarrollo.popularmoviestmbd.views;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.ncrdesarrollo.popularmoviestmbd.R;
import com.ncrdesarrollo.popularmoviestmbd.interfaces.IMovieList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}
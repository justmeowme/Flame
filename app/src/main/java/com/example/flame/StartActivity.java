package com.example.flame;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class StartActivity extends AppCompatActivity {

    ImageView mStart;
    TextView mContinue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        mStart = findViewById(R.id.button);
        mStart.setOnClickListener(v -> startActivity(new Intent(StartActivity.this, TestActivity.class)));

        mContinue = findViewById(R.id.textView);
        mContinue.setOnClickListener(v -> startActivity(new Intent(StartActivity.this, LevelsActivity .class)));


    }
}
package com.example.flame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    ProgressBar progressBar;
    TextView mCount;
    int progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        progressBar = findViewById(R.id.progressBar);
        progress = 0;
        mCount = findViewById(R.id.count);

        final int oneMin = 1600; // 1 minute in milli seconds

        new CountDownTimer(oneMin, 20) {
            public void onTick(long millisUntilFinished) {

                long finishedSeconds = oneMin - millisUntilFinished;
                int total = (int) (((float)finishedSeconds / (float)oneMin) * 100.0);
                progressBar.setProgress(total);
                mCount.setText(String.valueOf(total)+"%");

            }

            public void onFinish() {
                startActivity(new Intent(MainActivity.this, StartActivity.class));
            }
        }.start();


    }
}
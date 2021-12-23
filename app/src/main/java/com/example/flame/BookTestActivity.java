package com.example.flame;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class BookTestActivity extends AppCompatActivity {

    Button mCheck;
    ImageView toLeft, toRight, mCross;
    TextView mRus;
    EditText mTat;
    int current_word, all_words_done;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_test);

        mCheck = findViewById(R.id.check);
        mRus = findViewById(R.id.rus_name);
        toLeft = findViewById(R.id.left);
        toRight = findViewById(R.id.right);
        mTat = findViewById(R.id.translation);

        mCross = findViewById(R.id.crossme);
        mCross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (all_words_done == 1){
                    startActivity(new Intent(BookTestActivity.this, Level1Kitchen.class));
                } else{
                    AlertDialog.Builder builder = new AlertDialog.Builder(BookTestActivity.this);
                    View view = getLayoutInflater().inflate(R.layout.alert_close_book, null);
                    builder.setView(view);

                    AlertDialog alert = builder.create();

                    Button formClose = view.findViewById(R.id.close);
                    Button formDontClose = view.findViewById(R.id.dont_close);

                    formClose.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            startActivity(new Intent(BookTestActivity.this, Level1Kitchen.class));
                        }
                    });

                    formDontClose.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            alert.dismiss();
                        }
                    });


                    alert.show();
                }
            }
        });

        String[] rus_test = BookActivity.array_rus;
        String[] tat_test = BookActivity.array_tat;
        String[] is_correct = BookActivity.array_rus;

        all_words_done = 0;
        current_word = 0;
        mRus.setText(rus_test[current_word]);

        mCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tat_test[current_word].equals(mTat.getText().toString().trim())){
                    Toast.makeText(BookTestActivity.this, "Правильно!", Toast.LENGTH_SHORT).show();

                } else{
                    Toast.makeText(BookTestActivity.this, "Пока неправильно", Toast.LENGTH_SHORT).show();
                }
            }
        });

        toLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTat.setText("");
                if (current_word > 0){
                    mRus.setText(rus_test[current_word-1]);
                    current_word -= 1;
                }
            }
        });

        toRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (current_word == tat_test.length-1){
                    all_words_done = 1;
                    Toast.makeText(BookTestActivity.this, "Ты прошел все слова", Toast.LENGTH_SHORT).show();
                }
                if (current_word < tat_test.length-1){
                    mRus.setText(rus_test[current_word+1]);
                    mTat.setText("");
                    current_word += 1;

                }
            }
        });


    }
}
package com.example.flame;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class BookActivity extends AppCompatActivity {

    ImageView mCross, toLeft, toRight;
    int current_word;
    TextView tatarName, rusName;
    int all_words_done;
    public static String[] array_rus;
    public static String[] array_tat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        all_words_done = 0;

        array_rus = new String[]{"Стол", "Интерьер", "Мебель", "Плита", "Холодильник"};
        array_tat = new String[]{"өстәл", "Интерьер", "Мебель", "Плитә", "Суыткыч"};

        mCross = findViewById(R.id.crossme);
        mCross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (all_words_done == 1){
                    startActivity(new Intent(BookActivity.this, Level1Kitchen.class));
                } else{
                    AlertDialog.Builder builder = new AlertDialog.Builder(BookActivity.this);
                    View view = getLayoutInflater().inflate(R.layout.alert_close_book, null);
                    builder.setView(view);

                    AlertDialog alert = builder.create();

                    Button formClose = view.findViewById(R.id.close);
                    Button formDontClose = view.findViewById(R.id.dont_close);

                    formClose.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            startActivity(new Intent(BookActivity.this, Level1Kitchen.class));
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

        toLeft = findViewById(R.id.left);
        toRight = findViewById(R.id.right);

        tatarName = findViewById(R.id.tatar_name);
        rusName = findViewById(R.id.rus_name);

        current_word = 0;
        tatarName.setText(array_tat[current_word]);
        rusName.setText(array_rus[current_word]);

        toLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (current_word > 0){
                    tatarName.setText(array_tat[current_word-1]);
                    rusName.setText(array_rus[current_word-1]);
                    current_word -= 1;
                }
            }
        });

        toRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (current_word == array_tat.length-1){
                    all_words_done = 1;
                    startActivity(new Intent(BookActivity.this, BookTestActivity.class));
                }
                if (current_word < array_tat.length-1){
                    tatarName.setText(array_tat[current_word+1]);
                    rusName.setText(array_rus[current_word+1]);
                    current_word += 1;
                }
            }
        });

    }
}
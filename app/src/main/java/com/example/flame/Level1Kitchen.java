package com.example.flame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.IOException;
import java.util.ArrayList;

public class Level1Kitchen extends AppCompatActivity {

    LinearLayout backgroundKitchen;
    ConstraintLayout menu;
    ImageView mRefrigerator, mGarnitur1, mGarnitur2, mOven, mTable;

    ImageView mBook;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level1_kitchen);

        mRefrigerator = findViewById(R.id.refrigerator);
        backgroundKitchen = findViewById(R.id.back_kitchen);
        mGarnitur1 = findViewById(R.id.garnitur1);
        mGarnitur2 = findViewById(R.id.garnitur2);
        mOven = findViewById(R.id.oven);
        mTable = findViewById(R.id.table);
        menu = findViewById(R.id.upper_menu);

        mTable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Level1Kitchen.this);
                View view = getLayoutInflater().inflate(R.layout.alert_ask, null);
                builder.setView(view);

                AlertDialog alert = builder.create();

                EditText formWord = view.findViewById(R.id.word);
                Button formSubmit = view.findViewById(R.id.check);

                formSubmit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String user_word = formWord.getText().toString().trim();
                        if (user_word.equals("стол")){
                            mTable.setImageResource(R.drawable.ic_table);
                            alert.dismiss();
                        } else{
                            Toast.makeText(Level1Kitchen.this, "Вы ввели слово неправильно", Toast.LENGTH_LONG).show();
                        }
                    }
                });
                alert.show();
            }
        });

        mRefrigerator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Level1Kitchen.this);
                View view = getLayoutInflater().inflate(R.layout.alert_ask, null);
                builder.setView(view);

                AlertDialog alert = builder.create();

                EditText formWord = view.findViewById(R.id.word);
                Button formSubmit = view.findViewById(R.id.check);

                formSubmit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String user_word = formWord.getText().toString().trim();
                        if (user_word.equals("холодильник")){
                            mRefrigerator.setImageResource(R.drawable.ic_refrigirator);
                            alert.dismiss();
                        } else{
                            Toast.makeText(Level1Kitchen.this, "Вы ввели слово неправильно", Toast.LENGTH_LONG).show();
                        }
                    }
                });
                alert.show();
            }
        });

        backgroundKitchen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Level1Kitchen.this);
                View view = getLayoutInflater().inflate(R.layout.alert_ask, null);
                builder.setView(view);

                AlertDialog alert = builder.create();

                EditText formWord = view.findViewById(R.id.word);
                Button formSubmit = view.findViewById(R.id.check);

                formSubmit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String user_word = formWord.getText().toString().trim();
                        if (user_word.equals("интерьер")){
                            backgroundKitchen.setBackgroundResource(R.drawable.ic_back_kitchen);
                            menu.setBackgroundColor(Color.parseColor("#BFEFF7"));
                            alert.dismiss();
                        } else{
                            Toast.makeText(Level1Kitchen.this, "Вы ввели слово неправильно", Toast.LENGTH_LONG).show();
                        }
                    }
                });
                alert.show();

            }
        });

        mGarnitur1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Level1Kitchen.this);
                View view = getLayoutInflater().inflate(R.layout.alert_ask, null);
                builder.setView(view);

                AlertDialog alert = builder.create();

                EditText formWord = view.findViewById(R.id.word);
                Button formSubmit = view.findViewById(R.id.check);

                formSubmit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String user_word = formWord.getText().toString().trim();
                        if (user_word.equals("мебель")){
                            mGarnitur1.setImageResource(R.drawable.ic_garnitur1);
                            mGarnitur2.setImageResource(R.drawable.ic_garnitur2);
                            alert.dismiss();
                        } else{
                            Toast.makeText(Level1Kitchen.this, "Вы ввели слово неправильно", Toast.LENGTH_LONG).show();
                        }
                    }
                });
                alert.show();
            }
        });

        mGarnitur2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Level1Kitchen.this);
                View view = getLayoutInflater().inflate(R.layout.alert_ask, null);
                builder.setView(view);

                AlertDialog alert = builder.create();

                EditText formWord = view.findViewById(R.id.word);
                Button formSubmit = view.findViewById(R.id.check);

                formSubmit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String user_word = formWord.getText().toString().trim();
                        if (user_word.equals("мебель")){
                            mGarnitur1.setImageResource(R.drawable.ic_garnitur1);
                            mGarnitur2.setImageResource(R.drawable.ic_garnitur2);
                            alert.dismiss();
                        } else{
                            Toast.makeText(Level1Kitchen.this, "Вы ввели слово неправильно", Toast.LENGTH_LONG).show();
                        }
                    }
                });

                alert.show();
            }
        });

        mOven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Level1Kitchen.this);
                View view = getLayoutInflater().inflate(R.layout.alert_ask, null);
                builder.setView(view);

                AlertDialog alert = builder.create();

                EditText formWord = view.findViewById(R.id.word);
                Button formSubmit = view.findViewById(R.id.check);

                formSubmit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String user_word = formWord.getText().toString().trim();
                        if (user_word.equals("плита")){
                            mOven.setImageResource(R.drawable.ic_oven);
                            alert.dismiss();
                        } else{
                            Toast.makeText(Level1Kitchen.this, "Вы ввели слово неправильно", Toast.LENGTH_LONG).show();
                        }
                    }
                });

                alert.show();
            }
        });

        mBook = findViewById(R.id.book);
        mBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Level1Kitchen.this, BookActivity.class));
            }
        });

    }

}
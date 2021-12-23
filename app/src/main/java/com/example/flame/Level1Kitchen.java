package com.example.flame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
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
import java.util.Timer;
import java.util.TimerTask;

public class Level1Kitchen extends AppCompatActivity {

    LinearLayout backgroundKitchen;
    ConstraintLayout menu;
    ImageView mRefrigerator, mGarnitur1, mGarnitur2, mOven, mTable;

    ImageView mBook;
    int dX = 0;                         //смещение по Х координате, нужно для движения
    int end_X = 0;                      //конечная точка, до которой мы можем дойти(должна быть перепресвоена нужным значением)
    ImageView player;
    Button left,right;
    @SuppressLint("ClickableViewAccessibility") //отключили раздражающую подсветку
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
        player = findViewById(R.id.player);         //пользователь
        left = findViewById(R.id.ButtonLeft);       //левая кнопка
        right = findViewById(R.id.ButtonRight);     //правая кнопка

        new Handler().postDelayed(new Runnable() {      //ставим отложенный запуск кода, ибо инициализация ещё не прошла
            @Override
            public void run() {
                end_X = (int)player.getX();             //получаем конечную координату, за которую мы не должны выходить(при условии, что пользователь изначально стоит в конце карты)
                move(-(player.getX()/10),true);     //Двигаем пользователя в начало(аля в 0 координаты)
            }
        },100);

        left.setOnTouchListener(new View.OnTouchListener() {        //обработчик левой кнопки
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        dX = -1;
                        break;
                    case MotionEvent.ACTION_UP:
                        dX = 0;
                        break;
                }
                return false;
            }
        });

        right.setOnTouchListener(new View.OnTouchListener() {       //обработчик правой кнопки
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        dX = 1;
                        break;
                    case MotionEvent.ACTION_UP:
                        dX = 0;
                        break;
                }
                    return false;
            }
        });

        /*
        * Костыль отвечающий за передвежения пользователя, вызывается каждые 10 mls
        * В нем можно сделать аниманию(наверное)
        */
        Handler h = new Handler();
        Runnable run = new Runnable() {
            @Override
            public void run() {
                if(dX != 0)
                    move(dX);
                h.postDelayed(this, 10);
            }
        };
        h.removeCallbacks(run);
        h.postDelayed(run,1000);    //Вызываем единожды, чтобы запустить костыль
        /*
        * ---------------------------Конец костыля-------------------------------
        */

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
    void move(float dX)
    {
        move(dX,false);
    }
    void move(float dX, boolean force)
    {
        if(force)
        {
            if(dX < 0)
                player.setRotationY(180);
            else
                player.setRotationY(0);
            player.setX(player.getX()+(dX*10));
        }
        else {
            if (dX < 0) {
                player.setRotationY(180);
                if (player.getX() > 0)
                    player.setX(player.getX() + (dX * 10));
            } else {
                player.setRotationY(0);
                if (player.getX() < end_X)
                    player.setX(player.getX() + (dX * 10));
            }
        }
        //это использовать предпочтительнее, однако проблема с правильным вызовом функции
        //player.animate().x(player.getX()+(dX*50)).setDuration(500).start();
    }
}
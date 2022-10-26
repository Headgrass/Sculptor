package ru.alexeew.sculptor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window w = getWindow();
        w.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION //скрываем нижнюю панель
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY); // появляется поверх игры и исчезает
        //Выключим ночную тему - начало
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        //Выключим ночную тему - конец

        setContentView(R.layout.activity_main);

        ImageView sculpture = findViewById(R.id.sculpture);
        sculpture.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    // если коснулся картинки, сработает этот код
                    v.animate().scaleX(0.99f).scaleY(0.99f).setDuration(0);
                } else if(event.getAction() == MotionEvent.ACTION_UP) {
                    // если отпустил палец, сработает этот код
                    v.animate().scaleX(1f).scaleY(1f).setDuration(0);
                }
                return true;
            }
        });
    }
}
package com.example.pengenalanangkadanhuruf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class HomeActivity extends AppCompatActivity {
    private Button openAngkaButton, openHurufButton, openQuizButton;
    public MediaPlayer clickSound;
    ImageButton exitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        openAngkaButton = (Button) findViewById(R.id.openAngka);
        openHurufButton = (Button) findViewById(R.id.openHuruf);
        clickSound = MediaPlayer.create(this, R.raw.pop);
        openQuizButton = findViewById(R.id.openQuiz);
        exitBtn = findViewById(R.id.exitApp);

        openAngkaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickSound.start();
                openBelajarAngkaActivity();
            }
        });

        openHurufButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickSound.start();
                openBelajarHurufActivity();
            }
        });

        openQuizButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickSound.start();
                openQuizActivity();
            }
        });

        exitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HomeActivity.this.finish();
                System.exit(0);
            }
        });
    }

    public void openBelajarAngkaActivity() {
        Intent intent = new Intent(this, BelajarAngkaActivity.class);
        startActivity(intent);
        finish();
    }

    public void openBelajarHurufActivity() {
        Intent intent = new Intent(this, BelajarHurufActivity.class);
        startActivity(intent);
        finish();
    }

    public void openQuizActivity() {
        Intent intent = new Intent(this, QuizActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onBackPressed() { }
}
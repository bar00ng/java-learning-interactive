package com.example.pengenalanangkadanhuruf;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class QuizActivity extends AppCompatActivity {
    private CardView cardBuah, cardHewan;
    private ImageButton backToHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        cardBuah = findViewById(R.id.cardBuah);
        cardHewan = findViewById(R.id.cardHewan);
        backToHome = findViewById(R.id.backToHome);

        cardBuah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openQuizBuahActivity();
            }
        });

        cardHewan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openQuizHewanActivity();
            }
        });

        backToHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openHomeActivity();
            }
        });
    }

    private void openQuizBuahActivity() {
        Intent intent = new Intent(this, QuizBuahActivity.class);
        startActivity(intent);
        finish();
    }

    private void openQuizHewanActivity() {
        Intent intent = new Intent(this, QuizHewanActivity.class);
        startActivity(intent);
        finish();
    }

    private void openHomeActivity() {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onBackPressed() { }
}
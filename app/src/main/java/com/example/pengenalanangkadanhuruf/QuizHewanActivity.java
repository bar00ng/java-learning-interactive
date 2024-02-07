package com.example.pengenalanangkadanhuruf;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;

public class QuizHewanActivity extends AppCompatActivity {
    private ViewPager2 viewPager;

    private QuizHewanAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_hewan);

        viewPager = findViewById(R.id.quizHewanViewPager);
        adapter = new QuizHewanAdapter(this);
        viewPager.setAdapter(adapter);
        viewPager.setUserInputEnabled(false);
    }

    public void navigateToNextPage() {
        if (viewPager.getCurrentItem() == (adapter.getItemCount() - 1)) {
            // Jika saat ini berada di halaman terakhir, pindah ke activity lainnya
            Intent intent = new Intent(this, SelamatActivity.class);
            startActivity(intent);
            finish();
        } else {
            viewPager.setCurrentItem(viewPager.getCurrentItem() + 1, true);
        }
    }

    @Override
    public void onBackPressed() { }
}
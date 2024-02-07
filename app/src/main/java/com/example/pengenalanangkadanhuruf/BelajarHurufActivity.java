package com.example.pengenalanangkadanhuruf;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class BelajarHurufActivity extends AppCompatActivity {
    private ImageButton backToHome, next, prev;
    public MediaPlayer clickSound;
    ViewPager2 viewPager2;
    ArrayList<ViewPagerItem> viewPagerItemArrayList;
    DataAdapter dataAdapter;
    TextToSpeech textToSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_belajar_huruf);

        backToHome = findViewById(R.id.backToHome);
        next = findViewById(R.id.nextButton);
        prev = findViewById(R.id.prevButton);
        clickSound = MediaPlayer.create(this, R.raw.pop);

        viewPager2 = findViewById(R.id.hurufViewPager);
        List<String> alphabetList = getData.getAlphabetList();
        List<String> textToSpeakList = getData.getTextToSpeakList();

        viewPagerItemArrayList = new ArrayList<>();

        for (String alphabet : alphabetList) {
            ViewPagerItem viewPagerItem = new ViewPagerItem(alphabet);
            viewPagerItemArrayList.add(viewPagerItem);
        }

        dataAdapter = new DataAdapter(viewPagerItemArrayList);

        viewPager2.setAdapter(dataAdapter);
        viewPager2.setClipToPadding(false);
        viewPager2.setClipChildren(false);
        viewPager2.setOffscreenPageLimit(2);
        viewPager2.setUserInputEnabled(false);
        viewPager2.getChildAt(0).setOverScrollMode(View.OVER_SCROLL_NEVER);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (viewPager2.getCurrentItem() + 1 < dataAdapter.getItemCount()) {
                    clickSound.start();
                    viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1);
                }
            }
        });

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (viewPager2.getCurrentItem()  > 0) {
                    clickSound.start();
                    viewPager2.setCurrentItem(viewPager2.getCurrentItem() - 1);
                }
            }
        });

        backToHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickSound.start();
                backToHome();
            }
        });

        onViewPageChangePage();

        setUpTts();

        dataAdapter.onTtsClickListener(new DataAdapter.onTtsClickListener() {
            @Override
            public void onTtsClick(int position) {
                String text = textToSpeakList.get(position);
                textToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, null);
            }
        });
    }

    private void onViewPageChangePage() {
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                Log.d("ViewPager2", "Pos : " + position + ". Max : " + dataAdapter.getItemCount());
                if (position < 1) {
                    prev.setVisibility(View.GONE);
                } else if (position > 0) {
                    prev.setVisibility(View.VISIBLE);
                }

                if (position  >= dataAdapter.getItemCount() - 1) {
                    next.setVisibility(View.GONE);
                } else if(position < dataAdapter.getItemCount()) {
                    next.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    private void backToHome() {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
        finish();
    }

    private void setUpTts() {
        textToSpeech = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    int result = textToSpeech.setLanguage(new Locale("id", "ID"));

                    if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                        Log.e("TTS", "Bahasa Indonesia tidak didukung");
                        Log.d("TTS", "Berganti ke Bahasa Inggris USA");
                        textToSpeech.setLanguage(Locale.US);
                    } else {
                        textToSpeech.setLanguage(new Locale("id", "ID"));
                        Log.d("TTS", "Bahasa Indonesia Berhasil Digunakan");
                    }
                } else {
                    Log.e("TTS", "Inisialisasi TextToSpeech gagal");
                }
            }
        });
    }

    @Override
    public void onBackPressed() { }
}
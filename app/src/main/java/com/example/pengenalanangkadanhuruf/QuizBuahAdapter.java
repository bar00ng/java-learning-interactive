package com.example.pengenalanangkadanhuruf;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuizBuahAdapter extends FragmentStateAdapter {
    private List<Integer> fragmentOrder;

    public QuizBuahAdapter(FragmentActivity fa) {
        super(fa);
        initializeFragmentOrder();
    }

    private void initializeFragmentOrder() {
        // Inisialisasi urutan fragment secara acak
        fragmentOrder = new ArrayList<>();
        for (int i = 0; i < getItemCount(); i++) {
            fragmentOrder.add(i);
        }
        Collections.shuffle(fragmentOrder);
    }

    @Override
    public Fragment createFragment(int position) {
        int orderedPosition = fragmentOrder.get(position);
        switch (orderedPosition) {
            case 0:
                return new QuizBuahFragmentOne();
            case 1:
                return new QuizBuahFragmentTwo();
            case 2:
                return new QuizBuahFragmentThree();
            default:
                return null;
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}

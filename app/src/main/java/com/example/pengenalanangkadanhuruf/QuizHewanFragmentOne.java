package com.example.pengenalanangkadanhuruf;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link QuizHewanFragmentOne#newInstance} factory method to
 * create an instance of this fragment.
 */
public class QuizHewanFragmentOne extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    ImageButton hintButton;
    Button optionOne, optionTwo, optionThree;
    Animation animation;
    MediaPlayer clickSound, correctSound, wrongSound;
    Activity activity;

    public QuizHewanFragmentOne() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment QuizHewanFragmentOne.
     */
    // TODO: Rename and change types and number of parameters
    public static QuizHewanFragmentOne newInstance(String param1, String param2) {
        QuizHewanFragmentOne fragment = new QuizHewanFragmentOne();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_quiz_hewan_one, container, false);
        activity = getActivity();

        hintButton = v.findViewById(R.id.hintButton);
        optionOne = v.findViewById(R.id.optionOne);
        optionTwo = v.findViewById(R.id.optionTwo);
        optionThree = v.findViewById(R.id.optionThree);

        animation = AnimationUtils.loadAnimation(getContext(), R.anim.horizontal_shake);

        clickSound = MediaPlayer.create(getContext(), R.raw.pop);
        correctSound = MediaPlayer.create(getContext(), R.raw.quiz_correct);
        wrongSound = MediaPlayer.create(getContext(), R.raw.quiz_wrong);

        hintButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickSound.start();
                optionOne.startAnimation(animation);
            }
        });

        optionOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                correctSound.start();
                if (activity instanceof QuizHewanActivity) {
                    ((QuizHewanActivity) activity).navigateToNextPage();
                }
            }
        });

        optionTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wrongSound.start();
                if (activity instanceof QuizHewanActivity) {
                    ((QuizHewanActivity) activity).navigateToNextPage();
                }
            }
        });

        optionThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wrongSound.start();
                if (activity instanceof QuizHewanActivity) {
                    ((QuizHewanActivity) activity).navigateToNextPage();
                }
            }
        });

        return v;
    }
}
package com.example.pengenalanangkadanhuruf;

import java.util.ArrayList;
import java.util.List;

public class getData {
    public static List<String> getAlphabetList() {
        List<String> alphabetList = new ArrayList<>();
        alphabetList.add("Aa");
        alphabetList.add("Bb");
        alphabetList.add("Cc");
        alphabetList.add("Dd");
        alphabetList.add("Ee");
        alphabetList.add("Ff");
        alphabetList.add("Gg");
        alphabetList.add("Hh");
        alphabetList.add("Ii");
        alphabetList.add("Jj");
        alphabetList.add("Kk");
        alphabetList.add("Ll");
        alphabetList.add("Mm");
        alphabetList.add("Nn");
        alphabetList.add("Oo");
        alphabetList.add("Pp");
        alphabetList.add("Qq");
        alphabetList.add("Rr");
        alphabetList.add("Ss");
        alphabetList.add("Tt");
        alphabetList.add("Uu");
        alphabetList.add("Vv");
        alphabetList.add("Ww");
        alphabetList.add("Xx");
        alphabetList.add("Yy");
        alphabetList.add("Zz");

        return alphabetList;
    }

    public static List<String> getTextToSpeakList() {
        List<String> textToSpeakList = new ArrayList<>();
        textToSpeakList.add("A");
        textToSpeakList.add("B");
        textToSpeakList.add("C");
        textToSpeakList.add("D");
        textToSpeakList.add("E");
        textToSpeakList.add("F");
        textToSpeakList.add("G");
        textToSpeakList.add("H");
        textToSpeakList.add("I");
        textToSpeakList.add("J");
        textToSpeakList.add("K");
        textToSpeakList.add("L");
        textToSpeakList.add("M");
        textToSpeakList.add("N");
        textToSpeakList.add("O");
        textToSpeakList.add("P");
        textToSpeakList.add("Q");
        textToSpeakList.add("R");
        textToSpeakList.add("S");
        textToSpeakList.add("T");
        textToSpeakList.add("U");
        textToSpeakList.add("V");
        textToSpeakList.add("W");
        textToSpeakList.add("X");
        textToSpeakList.add("Y");
        textToSpeakList.add("Z");

        return textToSpeakList;
    }

    public static List<String> getAngkaList() {
        List<String> angkaList = new ArrayList<>();
        for (int i = 0; i <= 100; i++) {
            angkaList.add(String.valueOf(i));
        }
        return angkaList;
    }
}

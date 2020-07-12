package com.example.cultura.data;

import com.example.cultura.R;
import com.example.cultura.model.myChallenge;

import java.util.ArrayList;

public class myChallengeData {
    private static String[] numOfObject ={
            "0/3",
            "0/4",
            "2/3"
    };

    private static String[] time = {
            "23j 45m tersedia",
            "8j 32m tersedia",
            "1j 5m tersedia"
    };

    private static String[] namePlace = {
            "Candi Singosari",
            "Monumen Juang '45",
            "Candi Penataran"

    };

    private static String[] location = {
            "Malang",
            "Malang",
            "Blitar"
    };

    private static int[] photoPlace = {
            R.drawable.candisingosari_square,
            R.drawable.monumenjuang_square,
            R.drawable.candi_penataran
    };

    public static ArrayList<myChallenge> getListData() {
        ArrayList<myChallenge> list = new ArrayList<>();
        for (int position = 0; position < namePlace.length; position++) {
            myChallenge challenge = new myChallenge();
            challenge.setNumOfObject(numOfObject[position]);
            challenge.setNameOfPlace(namePlace[position]);
            challenge.setTime(time[position]);
            challenge.setLocation(location[position]);
            challenge.setImage(photoPlace[position]);
            list.add(challenge);
        }
        return list;
    }

}

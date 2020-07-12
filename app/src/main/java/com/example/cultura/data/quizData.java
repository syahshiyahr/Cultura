package com.example.cultura.data;

import com.example.cultura.R;
import com.example.cultura.model.quiz;

import java.util.ArrayList;

public class quizData {
    private static String[] numOfObject ={
            "3/3"
    };


    private static String[] namePlace = {
            "Museum Brawijaya"

    };

    private static int[] photoPlace = {
            R.drawable.museumbrawijaya_square
    };

    public static ArrayList<quiz> getListData() {
        ArrayList<quiz> list = new ArrayList<>();
        for (int position = 0; position < namePlace.length; position++) {
            quiz q = new quiz();
            q.setNumOfObject(numOfObject[position]);
            q.setNameOfPlace(namePlace[position]);
            q.setImage(photoPlace[position]);
            list.add(q);
        }
        return list;
    }

}

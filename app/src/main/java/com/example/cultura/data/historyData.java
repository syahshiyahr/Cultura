package com.example.cultura.data;

import com.example.cultura.R;
import com.example.cultura.model.history;
import com.example.cultura.model.myChallenge;

import java.util.ArrayList;

public class historyData {
    private static String[] object ={
            "5/5",
            "3/3"
    };
    private static String[] time = {
            "Selesai 30/04/2020",
            "Selesai 22/04/2020"
    };
    public static String[] name ={
            "Taman Sari",
            "Candi Prambanan"
    };
    public static int[] image={
            R.drawable.tamansari,
            R.drawable.prambanan
    };

    public static ArrayList<history> getListData() {
        ArrayList<history> list = new ArrayList<>();
        for (int position = 0; position < name.length; position++) {
            history hst = new history();
            hst.setImage(image[position]);
            hst.setName(name[position]);
            hst.setTime(time[position]);
            hst.setObject(object[position]);
            list.add(hst);
        }
        return list;
    }


}

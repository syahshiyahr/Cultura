package com.example.cultura.data;

import com.example.cultura.model.quiz;
import com.example.cultura.model.redeem;

import java.util.ArrayList;

public class redeemData {
    private static String[] judul ={
            "Kaos Cultura Exclusive",
            "Tiket Masuk Jatim Park 3",
            "Voucher Disc. 20% Singosari Resort"
    };
    private static String[] expired = {
            "Tidak ada",
            "19 Agustus 2020",
            "22 September 2020"
    };
    private static String[] poin = {
            "800",
            "1600",
            "1000"
    };
    public static ArrayList<redeem> getListData() {
        ArrayList<redeem> list = new ArrayList<>();
        for (int position = 0; position < judul.length; position++) {
            redeem q = new redeem();
            q.setJudul(judul[position]);
            q.setExpired(expired[position]);
            q.setPoin(poin[position]);
            list.add(q);
        }
        return list;
    }
}

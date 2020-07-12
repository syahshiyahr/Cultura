package com.example.cultura.data;

public class SoalPilihanGanda {

    //membuat array untuk pertanyaan
    public String pertanyaan[] = {
            "Berikut ini adalah benda-benda koleksi yang ada di museum brawijaya, kecuali ..",
            "Tank Amfibi LVT digunakan tentara belanda untuk menduduki kota Malang pada masa ...",
            "Tank yang digunakan arek Suroboyo untuk melawan sekutu adalah ..",
            "Nama halaman depan museum Brawijaya adalah ...",
            "Patung yang ada di Museum Brawijaya adalah ..",

    };

    //membuat array untuk pilihan jawaban
    private String pilihanJawaban[][] = {
            {"Senjata PSU","Meriam Si Buang","Arca Ganesha"},
            {"Perang Kemerdekaan I","Perang Kemerdekaan II","Masa Penjajahan"},
            {"Tank buatan Jepang","Tank buatan Belanda","Tank buatan Indonesia"},
            {"Agne Yastra Loka","Widya Loka","Yastra Buang"},
            {"Bung Tomo","Jendral Sudirman","Gajahmada"},
    };

    //membuat array untuk jawaban benar
    private String jawabanBenar[] = {
            "Arca Ganesha",
            "Perang Kemerdekaan I",
            "Tank buatan Jepang",
            "Agne Yastra Loka",
            "Jendral Sudirman",
    };

    //membuat getter untuk mengambil pertanyaan
    public String getPertanyaan(int x){
        String soal = pertanyaan[x];
        return soal;
    }

    //membuat getter untuk mengambil pilihan jawaban 1
    public String getPilihanJawaban1(int x){
        String jawaban1 = pilihanJawaban[x][0];
        return jawaban1;
    }

    //membuat getter untuk mengambil pilihan jawaban 2
    public String getPilihanJawaban2(int x){
        String jawaban2 = pilihanJawaban[x][1];
        return jawaban2;
    }

    //membuat getter untuk mengambil pilihan jawaban 3
    public String getPilihanJawaban3(int x){
        String jawaban3 = pilihanJawaban[x][2];
        return jawaban3;
    }

    //membuat getter untuk mengambil jawaban benar
    public String getJawabanBenar(int x){
        String jawaban = jawabanBenar[x];
        return jawaban;
    }

}

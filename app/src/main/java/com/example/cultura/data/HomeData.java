package com.example.cultura.data;

import com.example.cultura.R;
import com.example.cultura.adapter.CardPagerAdapter;
import com.example.cultura.model.home;

public class HomeData {
    private static int[] image ={

            R.drawable.monumen_juang,
            R.drawable.candi_singosari,
            R.drawable.candi_kidal,
            R.drawable.museum_brawijaya
    };

    private static String[] name ={

            "Monumen Juang",
            "Candi Singosari",
            "Candi Kidal",
            "Museum Brawijaya"
    };

    private static String[] desc ={

            "Monumen Juang 45 dibangun pada 20 Mei 1975. Ide pembuatan monumen ini berasal dari Pemerintah ....",
            "Candi Singasari merupakan candi Hindu - Buddha peninggalan bersejarah dari Kerajaan Singosari .... ",
            "Obyek wisata sejarah di Malang candi Kidal merupakan candi Hindu peninggalan dari dinasti ....",
            "Salah satu wisata sejarah dan edukasi yang ada di tengah kota Malang adalah Museum Brawijaya yang menyimpan ...."


    };

    private static String[] jarak ={

            "6,1 Km",
            "12,1 Km",
            "17,7 Km",
            "4 Km"
    };

    private static String[] objek ={

            "5 Objek",
            "3 Objek",
            "3 Objek",
            "4 Objek"
    };

    public static CardPagerAdapter getListData() {
        CardPagerAdapter cvHomeAdapter = new CardPagerAdapter();
        for (int position = 0; position < name.length; position++) {
            home home = new home(image[position], name[position],desc[position],jarak[position],objek[position]);
            cvHomeAdapter.addCardItem(home);
        }
        return cvHomeAdapter;
    }
}

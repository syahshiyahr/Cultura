package com.example.cultura;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cultura.ui.home.HomeFragment;

public class HasilSkoringActivity extends AppCompatActivity implements View.OnClickListener{
    TextView mtvHasilAkhir, mPoint;
    Button mbtnMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil_skoring);

        mtvHasilAkhir = (TextView) findViewById(R.id.tvSkorAkhir);
        mPoint = (TextView) findViewById(R.id.tvPoint);
        mbtnMenu = (Button) findViewById(R.id.btnMenu);

        setSkor();

        mbtnMenu.setOnClickListener(this);
    }

    public void setSkor(){
        //hasil lemparan (putExtra) dari activity sebelumnya ditampung dalam variabel lokal
        String activity = getIntent().getStringExtra("activity");
        String skorPilGan = getIntent().getStringExtra("skorAkhir");

        if(activity.equals("PilihanGanda")){ //jika var activity bernilai PilihanGanda
            //dipastikan activity sebelumnya datang dari kelas KuisPilihanGanda
            //maka skornya diatur dari skorPilGan
            mtvHasilAkhir.setText("Kamu mendapatkan skor "+skorPilGan+" dan kamu mendapatkan tambahan poin sebesar");
            mPoint.setText(skorPilGan+" Point");

        }
    }

    public void onBackPressed(){
        Toast.makeText(this, "Tidak bisa kembali, silahkan tekan menu", Toast.LENGTH_SHORT).show();
        //jadi yang awalnya klik tombol back maka akan kembali ke activity sebelumnya
        //kali ini ketika tombol back diklik maka
        //hanya muncul Toast
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnMenu:
                Intent ok = new Intent (HasilSkoringActivity.this, MainActivity.class);
                startActivity(ok);
                finish();
                break;

        }
    }
}

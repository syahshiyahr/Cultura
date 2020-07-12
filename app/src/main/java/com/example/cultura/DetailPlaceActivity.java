package com.example.cultura;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class DetailPlaceActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView back;
    private Button takeChallengeDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_place);

        back = findViewById(R.id.btn_back);
        takeChallengeDetail = findViewById(R.id.takeChallengeDetail);

        back.setOnClickListener(this);
        takeChallengeDetail.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btn_back:
                onBackPressed();
                break;
            case R.id.takeChallengeDetail:
                Intent a = new Intent(this, MapsActivity.class);
                startActivity(a);
        }
    }
}

package com.example.cultura;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import static android.graphics.Color.BLACK;

public class HistoryObjectActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView btn_back;
    private RelativeLayout image2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_object);

        btn_back = findViewById(R.id.btn_back);
        btn_back.setOnClickListener(this);

        image2 = findViewById(R.id.icon_image2);
        image2.setOnClickListener(this);



    }
    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btn_back:
                onBackPressed();
                break;
            case R.id.icon_image2:
                Intent detail = new Intent(this, PopUpDetailObjectActivity.class);
                startActivity(detail);
                break;
        }

    }
}

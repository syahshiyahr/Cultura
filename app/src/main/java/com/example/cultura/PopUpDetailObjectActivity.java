package com.example.cultura;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class PopUpDetailObjectActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageView close;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_up_detail_object);

        close = findViewById(R.id.btn_close);
        close.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btn_close:
                onBackPressed();
                break;
        }
    }
}

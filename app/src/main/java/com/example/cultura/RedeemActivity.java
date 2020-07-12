package com.example.cultura;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cultura.adapter.CardViewChallengeAdapter;
import com.example.cultura.adapter.CardViewRedeemAdapter;
import com.example.cultura.data.myChallengeData;
import com.example.cultura.data.redeemData;
import com.example.cultura.model.redeem;

import java.util.ArrayList;

public class RedeemActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView judul, expire, poin;
    private ImageView btn_back;
    private RecyclerView rvRedeem;
    private ArrayList<redeem> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_redeem);

        judul = findViewById(R.id.tv_judul);
        expire = findViewById(R.id.tvExpires);
        poin = findViewById(R.id.poin_redeem);

        rvRedeem = findViewById(R.id.redeemRv);
        rvRedeem.setHasFixedSize(true);

        list.addAll(redeemData.getListData());
        rvRedeem.setLayoutManager(new LinearLayoutManager(this));
        CardViewRedeemAdapter cvRedeemAdapter = new CardViewRedeemAdapter(list);
        rvRedeem.setAdapter(cvRedeemAdapter);

        btn_back = findViewById(R.id.btn_back);
        btn_back.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btn_back:
                onBackPressed();
                break;
        }
    }
}

package com.example.cultura;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cultura.adapter.CardViewChallengeAdapter;
import com.example.cultura.data.myChallengeData;
import com.example.cultura.model.myChallenge;

import java.util.ArrayList;

public class MyChallengeActivity extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView rvChallenge;
    private ArrayList<myChallenge> list = new ArrayList<>();
    TextView nameOfPlace, solveChallenge;
    private ImageView btn_back, btn_history;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_challenge);

        nameOfPlace = findViewById(R.id.tv_nameOfPlace);

        rvChallenge = findViewById(R.id.myChallenge);
        rvChallenge.setHasFixedSize(true);

        list.addAll(myChallengeData.getListData());
        rvChallenge.setLayoutManager(new LinearLayoutManager(this));
        CardViewChallengeAdapter cvChallengeAdapter = new CardViewChallengeAdapter(list);
        rvChallenge.setAdapter(cvChallengeAdapter);

        btn_back = findViewById(R.id.btn_back);
        btn_back.setOnClickListener(this);

        btn_history = findViewById(R.id.btn_history);
        btn_history.setOnClickListener(this);



    }
    private void setChallenge(myChallenge challenge){
        nameOfPlace.setText(challenge.getNameOfPlace());
    }

    @Override
    public void onClick(View v) {


        switch (v.getId()){
            case R.id.btn_back:
                onBackPressed();
                break;
            case R.id.btn_history:
                Intent history = new Intent(this, HistoryActivity.class);
                startActivity(history);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                break;
        }

    }
}

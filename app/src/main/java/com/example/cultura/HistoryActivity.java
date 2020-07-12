package com.example.cultura;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cultura.adapter.CardViewHistoryAdapter;
import com.example.cultura.data.historyData;
import com.example.cultura.model.history;

import java.util.ArrayList;

public class HistoryActivity extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView rvHistory;
    private ArrayList<history> list = new ArrayList<>();
    TextView name;
    private ImageView btn_back;
    Activity thisActivity = (Activity)this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        name = findViewById(R.id.tv_nameOfPlace);
        rvHistory = findViewById(R.id.history);
        rvHistory.setHasFixedSize(true);

        list.addAll(historyData.getListData());
        rvHistory.setLayoutManager(new LinearLayoutManager(this));
        CardViewHistoryAdapter cvHistoryAdapter = new CardViewHistoryAdapter(list);
        rvHistory.setAdapter(cvHistoryAdapter);

        btn_back = findViewById(R.id.btn_back);
        btn_back.setOnClickListener(this);

    }
    private void setChallenge(history history){
        name.setText(history.getName());
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_back:
                onBackPressed();
                break;
        }

    }
}

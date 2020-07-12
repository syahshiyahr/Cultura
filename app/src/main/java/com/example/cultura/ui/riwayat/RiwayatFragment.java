package com.example.cultura.ui.riwayat;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cultura.R;
import com.example.cultura.adapter.CardViewHistoryAdapter;
import com.example.cultura.data.historyData;
import com.example.cultura.model.history;

import java.util.ArrayList;

public class RiwayatFragment extends Fragment {

    private RiwayatViewModel riwayatViewModel;
    private RecyclerView rvHistory;
    private ArrayList<history> list = new ArrayList<>();
    TextView name;
    private ImageView btn_back;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_riwayat, container, false);
        name = view.findViewById(R.id.tv_nameOfPlace);
        rvHistory = view.findViewById(R.id.history);
        rvHistory.setHasFixedSize(true);

        list.addAll(historyData.getListData());
        rvHistory.setLayoutManager(new LinearLayoutManager(getContext()));
        CardViewHistoryAdapter cvHistoryAdapter = new CardViewHistoryAdapter(list);
        rvHistory.setAdapter(cvHistoryAdapter);

        return view;
    }

    private void setChallenge(history history){
        name.setText(history.getName());
    }



}
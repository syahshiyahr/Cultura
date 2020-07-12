package com.example.cultura.ui.tantangan;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cultura.R;
import com.example.cultura.adapter.CardViewChallengeAdapter;
import com.example.cultura.data.myChallengeData;
import com.example.cultura.model.myChallenge;

import java.util.ArrayList;

public class TantanganFragment extends Fragment {
    private RecyclerView rvChallenge;
    private ArrayList<myChallenge> list = new ArrayList<>();
    TextView nameOfPlace, solveChallenge;
    private ImageView btn_back, btn_history;

    private TantanganViewModel tantanganViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tantangan, container, false);
        nameOfPlace = view.findViewById(R.id.tv_nameOfPlace);

        rvChallenge = view.findViewById(R.id.myChallenge);
        rvChallenge.setHasFixedSize(true);

        list.addAll(myChallengeData.getListData());
        rvChallenge.setLayoutManager(new LinearLayoutManager(getContext()));
        CardViewChallengeAdapter cvChallengeAdapter = new CardViewChallengeAdapter(list);
        rvChallenge.setAdapter(cvChallengeAdapter);


        return view;
    }
}
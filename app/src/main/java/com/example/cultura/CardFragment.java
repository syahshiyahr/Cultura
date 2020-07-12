package com.example.cultura;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

public class CardFragment extends Fragment {
    private TextView selengkapnya;
    private Button takeChallenge;

    private CardView cardView;

    public static Fragment getInstance(int position) {
        CardFragment f = new CardFragment();
        Bundle args = new Bundle();
        args.putInt("position", position);
        f.setArguments(args);

        return f;
    }

    @SuppressLint("DefaultLocale")
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.item_viewpager, container, false);

        cardView = (CardView) view.findViewById(R.id.cardView);
        cardView.setMaxCardElevation(cardView.getCardElevation() * CardAdapter.MAX_ELEVATION_FACTOR);

        TextView s = (TextView) view.findViewById(R.id.selengkapnya);
        s.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent in=new Intent(getActivity(),DetailPlaceActivity.class);
                startActivity(in);

            }
        });

;

        Button b=(Button) view.findViewById(R.id.takeChallenge);
        b.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent in=new Intent(getActivity(),MapsActivity.class);
                startActivity(in);

            }
        });

        return view;
    }

    public CardView getCardView() {
        return cardView;
    }
}

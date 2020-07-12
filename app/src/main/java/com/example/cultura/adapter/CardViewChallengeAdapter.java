package com.example.cultura.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.cultura.HistoryObjectActivity;
import com.example.cultura.KuisPilihanGandaActivity;
import com.example.cultura.MapsActivity;
import com.example.cultura.R;
import com.example.cultura.model.myChallenge;

import java.util.ArrayList;

public class CardViewChallengeAdapter extends RecyclerView.Adapter<CardViewChallengeAdapter.CardViewViewHolder> {
    private ArrayList<myChallenge> listChallenge;

    public CardViewChallengeAdapter(ArrayList<myChallenge> list) {
        this.listChallenge = list;
    }

    @NonNull
    @Override
    public CardViewChallengeAdapter.CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mychallenge,parent,false);
        return new CardViewChallengeAdapter.CardViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewChallengeAdapter.CardViewViewHolder holder, int position) {
        final myChallenge myChallenge = listChallenge.get(position);

        Glide.with(holder.itemView.getContext())
                .load(myChallenge.getImage())
                .apply(new RequestOptions().override(350, 550))
                .into(holder.photo);
        holder.numOfObject.setText(myChallenge.getNumOfObject());
        holder.time.setText(myChallenge.getTime());
        holder.location.setText(myChallenge.getLocation());
        holder.nameOfPlace.setText(myChallenge.getNameOfPlace());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), MapsActivity.class);
                v.getContext().startActivity(i);

            }
        });


    }

    @Override
    public int getItemCount() {
        return listChallenge.size();
    }
    class CardViewViewHolder extends RecyclerView.ViewHolder{
        ImageView photo;
        TextView numOfObject, time, nameOfPlace, location;

        public CardViewViewHolder(@NonNull View itemView) {
            super(itemView);

            photo = itemView.findViewById(R.id.img_item_photo);
            numOfObject = itemView.findViewById(R.id.tv_object);
            time = itemView.findViewById(R.id.tv_time);
            location = itemView.findViewById(R.id.tv_location);
            nameOfPlace = itemView.findViewById(R.id.tv_nameOfPlace);

        }
    }

}

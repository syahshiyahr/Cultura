package com.example.cultura.adapter;

import android.app.Activity;
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
import com.example.cultura.R;
import com.example.cultura.model.history;
import com.example.cultura.model.myChallenge;
import com.example.cultura.ui.riwayat.RiwayatFragment;

import java.util.ArrayList;

public class CardViewHistoryAdapter extends RecyclerView.Adapter<CardViewHistoryAdapter.CardViewViewHolder> {
    private ArrayList<history> listHistory;
    Activity mActivity;

    public CardViewHistoryAdapter(ArrayList<history> list) {
        this.listHistory = list;
    }

    @NonNull
    @Override
    public CardViewHistoryAdapter.CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_history,parent,false);
        return new CardViewHistoryAdapter.CardViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHistoryAdapter.CardViewViewHolder holder, int position) {
        final history hst = listHistory.get(position);

        Glide.with(holder.itemView.getContext())
                .load(hst.getImage())
                .apply(new RequestOptions().override(350, 550))
                .into(holder.photo);
        holder.object.setText(hst.getObject());
        holder.name.setText(hst.getName());
        holder.time.setText(hst.getTime());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), HistoryObjectActivity.class);
                v.getContext().startActivity(i);

            }
        });

    }

    @Override
    public int getItemCount() {
        return listHistory.size();
    }
    class CardViewViewHolder extends RecyclerView.ViewHolder{
        ImageView photo;
        TextView object, name, time;

        public CardViewViewHolder(@NonNull View itemView) {
            super(itemView);

            photo = itemView.findViewById(R.id.img_item_photo);
            object = itemView.findViewById(R.id.tv_object);
            name = itemView.findViewById(R.id.tv_nameOfPlace);
            time = itemView.findViewById(R.id.tv_timeGet);

        }
    }

}

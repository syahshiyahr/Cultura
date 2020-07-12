package com.example.cultura.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.cultura.R;
import com.example.cultura.model.redeem;

import java.util.ArrayList;

public class CardViewRedeemAdapter extends RecyclerView.Adapter<CardViewRedeemAdapter.CardViewViewHolder> {
    private ArrayList<redeem> listRedeem;

    public CardViewRedeemAdapter(ArrayList<redeem> list) {
        this.listRedeem = list;
    }

    @NonNull
    @Override
    public CardViewRedeemAdapter.CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_redeem,parent,false);
        return new CardViewRedeemAdapter.CardViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewRedeemAdapter.CardViewViewHolder holder, int position) {
        final redeem redeem = listRedeem.get(position);

        holder.judul.setText(redeem.getJudul());
        holder.expire.setText(redeem.getExpired());
        holder.poin.setText(redeem.getPoin());


    }

    @Override
    public int getItemCount() {
        return listRedeem.size();
    }
    class CardViewViewHolder extends RecyclerView.ViewHolder{
        TextView judul, expire, poin, expireTv, term;

        public CardViewViewHolder(@NonNull View itemView) {
            super(itemView);

            judul = itemView.findViewById(R.id.tv_judul);
            expire = itemView.findViewById(R.id.tvExpires);
            poin = itemView.findViewById(R.id.poin_redeem);
            expireTv = itemView.findViewById(R.id.Expires);
            term = itemView.findViewById(R.id.term);

        }
    }
}

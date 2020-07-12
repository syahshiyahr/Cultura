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
import com.example.cultura.KuisPilihanGandaActivity;
import com.example.cultura.R;
import com.example.cultura.model.myChallenge;
import com.example.cultura.model.quiz;

import java.util.ArrayList;

public class CardViewQuizAdapter extends RecyclerView.Adapter<CardViewQuizAdapter.CardViewViewHolder> {
    private ArrayList<quiz> listQuiz;

    public CardViewQuizAdapter(ArrayList<quiz> list) {
        this.listQuiz = list;
    }

    @NonNull
    @Override
    public CardViewQuizAdapter.CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_quiz,parent,false);
        return new CardViewQuizAdapter.CardViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewQuizAdapter.CardViewViewHolder holder, int position) {
        final quiz quiz = listQuiz.get(position);

        Glide.with(holder.itemView.getContext())
                .load(quiz.getImage())
                .apply(new RequestOptions().override(350, 550))
                .into(holder.photo);
        holder.numOfObject.setText(quiz.getNumOfObject());
        holder.nameOfPlace.setText(quiz.getNameOfPlace());

//        if(holder.nameOfPlace.getText().toString().equals("Museum Brawijaya")){
//            holder.solveChallenge.setVisibility(View.VISIBLE);
//            holder.time.setVisibility(View.GONE);
//        }else{
//            holder.solveChallenge.setVisibility(View.INVISIBLE);
//        }

        holder.solveChallenge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent solve = new Intent(v.getContext(), KuisPilihanGandaActivity.class);
                v.getContext().startActivity(solve);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listQuiz.size();
    }
    class CardViewViewHolder extends RecyclerView.ViewHolder{
        ImageView photo;
        TextView numOfObject, nameOfPlace, solveChallenge;

        public CardViewViewHolder(@NonNull View itemView) {
            super(itemView);

            photo = itemView.findViewById(R.id.img_item_photo);
            numOfObject = itemView.findViewById(R.id.tv_object);
            nameOfPlace = itemView.findViewById(R.id.tv_nameOfPlace);
            solveChallenge = itemView.findViewById(R.id.tv_solve_challenge);

        }
    }

}

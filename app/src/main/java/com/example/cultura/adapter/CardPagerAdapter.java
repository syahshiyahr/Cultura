package com.example.cultura.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.cultura.CardAdapter;
import com.example.cultura.CardFragment;
import com.example.cultura.DetailPlaceActivity;
import com.example.cultura.MapsActivity;
import com.example.cultura.R;
import com.example.cultura.data.HomeData;
import com.example.cultura.model.home;

import java.util.ArrayList;
import java.util.List;

public class CardPagerAdapter extends PagerAdapter implements CardAdapter {
    private List<CardView> mViews;
    private List<home> mData;
    private float mBaseElevation;
    private List<CardFragment> fragments;
    private float baseElevation;

    public CardPagerAdapter() {
        mData = new ArrayList<>();
        mViews = new ArrayList<>();
    }



    public void addCardItem(home item) {
        mViews.add(null);
        mData.add(item);
    }


    public float getBaseElevation() {
        return mBaseElevation;
    }

    @Override
    public CardView getCardViewAt(int position) {
        return mViews.get(position);
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = LayoutInflater.from(container.getContext())
                .inflate(R.layout.item_viewpager, container, false);
        container.addView(view);
        bind(mData.get(position), view);
        CardView cardView = (CardView) view.findViewById(R.id.cardView);

        TextView s = (TextView) view.findViewById(R.id.selengkapnya);
        s.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent in=new Intent(v.getContext(), DetailPlaceActivity.class);
                v.getContext().startActivity(in);

            }
        });

        ;

        Button b=(Button) view.findViewById(R.id.takeChallenge);
        b.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent in=new Intent(v.getContext(), MapsActivity.class);
                v.getContext().startActivity(in);

            }
        });

        if (mBaseElevation == 0) {
            mBaseElevation = cardView.getCardElevation();
        }

        cardView.setMaxCardElevation(mBaseElevation * MAX_ELEVATION_FACTOR);
        mViews.set(position, cardView);

        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
        mViews.set(position, null);
    }

    private void bind(home item, View view) {
        TextView name = view.findViewById(R.id.name_home);
        TextView desc= view.findViewById(R.id.desc_home);
        TextView jarak= view.findViewById(R.id.jarak_home);
        TextView objek = view.findViewById(R.id.objek_home);
        ImageView image = view.findViewById(R.id.img_item_photo);
        name.setText(item.getName());
        desc.setText(item.getDesc());
        jarak.setText(item.getJarak());
        objek.setText(item.getObjek());
        Glide.with(view.getContext())
                .load(item.getImage())
                .centerCrop()
                .placeholder(item.getImage())
                .into(image);
    }

}




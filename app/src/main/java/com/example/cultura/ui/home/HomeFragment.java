package com.example.cultura.ui.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;

import com.example.cultura.CardFragmentPagerAdapter;
import com.example.cultura.R;
import com.example.cultura.ShadowTransformer;
import com.example.cultura.adapter.CardPagerAdapter;
import com.example.cultura.data.HomeData;
import com.example.cultura.model.home;

import java.util.ArrayList;

public class HomeFragment extends Fragment implements View.OnClickListener {

    private HomeViewModel homeViewModel;
    private Button TakeChallenge;
    private TextView More;
    private ImageView iconmyChallenge;
    private ArrayList<home> list = new ArrayList<>();
    private boolean mShowingFragments = false;
    private ViewPager viewPager;
    private CardPagerAdapter cvHomeAdapter;
    private CardFragmentPagerAdapter pagerAdapter;
    private ShadowTransformer mfragmentCardShadowTransformer, mCardShadowTransformer;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        viewPager = view.findViewById(R.id.viewPager);

        //34
        cvHomeAdapter = new CardPagerAdapter();

        cvHomeAdapter = HomeData.getListData();
        pagerAdapter = new CardFragmentPagerAdapter(getFragmentManager(), dpToPixels(2, getContext()));

        ShadowTransformer mCardShadowTransformer = new ShadowTransformer(viewPager, cvHomeAdapter);
        mfragmentCardShadowTransformer = new ShadowTransformer(viewPager, pagerAdapter);
        mfragmentCardShadowTransformer.enableScaling(true);
        mCardShadowTransformer.enableScaling(true);

        //45-47
        viewPager.setAdapter(cvHomeAdapter);
        viewPager.setPageTransformer(false, mfragmentCardShadowTransformer);
        viewPager.setOffscreenPageLimit(3);
        viewPager.setPageMargin(-50);


        return view;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

    }



    /**
     * Change value in dp to pixels
     * @param dp
     * @param context
     */
    public static float dpToPixels(int dp, Context context) {
        return dp * (context.getResources().getDisplayMetrics().density);
    }

    public void onBackPressed() {
        Intent i = new Intent(Intent.ACTION_MAIN);
        i.addCategory(Intent.CATEGORY_HOME);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(i);
    }

    @Override
    public void onClick(View v) {

    }
}
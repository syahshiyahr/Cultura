package com.example.cultura;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cultura.adapter.CardPagerAdapter;
import com.example.cultura.data.HomeData;
import com.example.cultura.model.home;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener{
    private Button TakeChallenge;
    private TextView More;
    private ImageView iconmyChallenge;
    private ArrayList<home> list = new ArrayList<>();
    private boolean mShowingFragments = false;
    private ViewPager viewPager;
    private CardPagerAdapter cvHomeAdapter;
    private CardFragmentPagerAdapter pagerAdapter;
    private ShadowTransformer mfragmentCardShadowTransformer, mCardShadowTransformer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        viewPager = findViewById(R.id.viewPager);

        //34
        cvHomeAdapter = new CardPagerAdapter();

        cvHomeAdapter = HomeData.getListData();
        pagerAdapter = new CardFragmentPagerAdapter(getSupportFragmentManager(), dpToPixels(2, this));

        ShadowTransformer mCardShadowTransformer = new ShadowTransformer(viewPager, cvHomeAdapter);
        mfragmentCardShadowTransformer = new ShadowTransformer(viewPager, pagerAdapter);
        mfragmentCardShadowTransformer.enableScaling(true);
        mCardShadowTransformer.enableScaling(true);

        //45-47
        viewPager.setAdapter(cvHomeAdapter);
        viewPager.setPageTransformer(false, mfragmentCardShadowTransformer);
        viewPager.setOffscreenPageLimit(3);
        viewPager.setPageMargin(-50);


        iconmyChallenge = findViewById(R.id.myChallengeicon);
        iconmyChallenge.setOnClickListener(this);


    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
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

    @Override
    public void onBackPressed() {
        Intent i = new Intent(Intent.ACTION_MAIN);
        i.addCategory(Intent.CATEGORY_HOME);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(i);
    }

    @Override
    public void onClick(View v) {


        switch (v.getId()){
            case R.id.myChallengeicon:
                Intent mc = new Intent(this, MyChallengeActivity.class);
                startActivity(mc);
                break;
        }
    }
}
package com.example.cultura;

import android.os.Bundle;

import com.example.cultura.ui.pembelian.PembelianFragment;
import com.example.cultura.ui.tantangan.TantanganFragment;
import com.example.cultura.ui.home.HomeFragment;
import com.example.cultura.ui.profile.ProfileFragment;
import com.example.cultura.ui.quiz.QuizFragment;
import com.example.cultura.ui.riwayat.RiwayatFragment;

import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private AppBarConfiguration mAppBarConfiguration;
    DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawer = findViewById(R.id.drawer_layout);
        final ImageButton btnOpenDrawer = (ImageButton) findViewById(R.id.menu);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        loadFragment(new HomeFragment());

        btnOpenDrawer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawer.openDrawer(Gravity.LEFT);
            }
        });
        ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(this, drawer, R.string.app_name, R.string.app_name);
        drawer.addDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();
    }

    private void loadFragment(Fragment fragment) {
        FragmentTransaction tx = getSupportFragmentManager().beginTransaction();
        tx.replace(R.id.nav_host_fragment, fragment);
        tx.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        Fragment fragment;

        switch (id) {
            case R.id.nav_home:
                fragment = new HomeFragment();
                //mereplace frame layout yang disediakan di activity_main.xml menjadi layout HomeFragment
                getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, fragment, fragment.getClass().getSimpleName()).commit();

                drawer.closeDrawers();
                return true;
            case R.id.nav_profile:
                fragment = new ProfileFragment();
                //mereplace frame layout yang disediakan di activity_main.xml menjadi layout HomeFragment
                getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, fragment, fragment.getClass().getSimpleName()).commit();
                drawer.closeDrawers();
                return true;
            case R.id.nav_challenge:
                fragment = new TantanganFragment();
                //mereplace frame layout yang disediakan di activity_main.xml menjadi layout HomeFragment
                getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, fragment, fragment.getClass().getSimpleName()).commit();
                drawer.closeDrawers();
                return true;
            case R.id.nav_kuis:
                fragment = new QuizFragment();
                //mereplace frame layout yang disediakan di activity_main.xml menjadi layout HomeFragment
                getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, fragment, fragment.getClass().getSimpleName()).commit();
                drawer.closeDrawers();
                return true;
            case R.id.nav_riwayat:
                fragment = new RiwayatFragment();
                //mereplace frame layout yang disediakan di activity_main.xml menjadi layout HomeFragment
                getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, fragment, fragment.getClass().getSimpleName()).commit();
                drawer.closeDrawers();
                return true;
            case R.id.nav_poin:
                fragment = new PembelianFragment();
                //mereplace frame layout yang disediakan di activity_main.xml menjadi layout HomeFragment
                getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, fragment, fragment.getClass().getSimpleName()).commit();
                drawer.closeDrawers();
                return true;
            default:
                fragment = new HomeFragment();
                break;
        }
        return false;
    }
}

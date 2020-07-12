package com.example.cultura.ui.pembelian;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.cultura.R;
import com.example.cultura.RedeemActivity;

public class PembelianFragment extends Fragment implements View.OnClickListener{

    private PembelianViewModel pembelianViewModel;
    private Button mRedeem;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_pembelian, container, false);

        mRedeem = view.findViewById(R.id.redeem);
        mRedeem.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.redeem:
                Intent a = new Intent(getContext(), RedeemActivity.class);
                startActivity(a);
                break;
        }
    }
}
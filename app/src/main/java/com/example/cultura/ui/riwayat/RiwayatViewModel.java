package com.example.cultura.ui.riwayat;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class RiwayatViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public RiwayatViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is tools fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
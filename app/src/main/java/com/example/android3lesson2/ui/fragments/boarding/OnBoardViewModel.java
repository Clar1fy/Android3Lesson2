package com.example.android3lesson2.ui.fragments.boarding;

import androidx.lifecycle.ViewModel;

import com.example.android3lesson2.data.local.PreferencesHelper;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class OnBoardViewModel extends ViewModel {
    PreferencesHelper preferencesHelper;

    @Inject
    public OnBoardViewModel(PreferencesHelper preferencesHelper) {
        this.preferencesHelper = preferencesHelper;
    }

    public boolean getBoolean() {
        return preferencesHelper.getBoolean();
    }

    public void setBoolean(boolean isShown) {
        preferencesHelper.setBoolean(isShown);
    }
}

package com.example.thermostat.contract;

import com.example.thermostat.model.Bungalow;

import java.util.List;

public interface MainContract {

    interface View {
        void getBungalow(Bungalow bungalow);
        void getAllBungalows(List<Bungalow> bungalows);
        void showError(Throwable t);
        void showProgress();
        void hideProgress();
    }

    interface Presenter {
        void getBungalow();
        void getAllBungalows();
        void detachView();
    }
}

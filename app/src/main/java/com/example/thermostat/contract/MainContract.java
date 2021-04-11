package com.example.thermostat.contract;

import com.example.thermostat.model.Bungalow;

import java.util.List;

public class MainContract {

    interface View {
        void getBungalow(Bungalow bungalow);
        void getAllBungalows(List<Bungalow> bungalows);
        void showError(Throwable t);
    }

    interface Presenter {
        void getBungalow();
        void getAllBungalows();
        void detachView();
    }
}

package com.example.thermostat.contract;

import com.example.thermostat.model.Bungalow;

public class MainContract {

    interface View {
        void getBungalow(Bungalow bungalow);
        void showError(Throwable t);
    }

    interface Presenter {
        void getBungalow();
        void detachView();
    }
}

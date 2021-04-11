package com.example.thermostat.presenter;

import com.example.thermostat.contract.MainContract;
import com.example.thermostat.dataSource.ApiRequest;
import com.example.thermostat.model.Bungalow;

import java.util.List;

public class PresenterImp implements MainContract.Presenter, ApiListener {
    private MainContract.View view;
    private ApiRequest apiRequest;

    public PresenterImp(MainContract.View view) {
        this.view = view;
        apiRequest = new ApiRequest(this);
    }


    @Override
    public void getBungalow() {
        apiRequest.getSingleBungalow();

    }

    @Override
    public void getAllBungalows() {
        view.showProgress();
        apiRequest.getAllBungalows();
    }

    @Override
    public void detachView() {
        view = null;

    }

    @Override
    public void onSuccess(Bungalow bungalow) {
        view.getBungalow(bungalow);

    }

    @Override
    public void onSuccess(List<Bungalow> bungalows) {
        view.hideProgress();
        view.getAllBungalows(bungalows);


    }

    @Override
    public void onError(Throwable t) {
        view.hideProgress();
        view.showError(t);

    }
}

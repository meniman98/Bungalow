package com.example.thermostat.dataSource;

import com.example.thermostat.model.Bungalow;
import com.example.thermostat.network.BungalowService;
import com.example.thermostat.presenter.ApiListener;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiRequest {


    private ApiListener apiListener;
    private Call<List<Bungalow>> callList;
    private Call<Bungalow> callBungalow;
    private Call<Bungalow> putCallBungalow;


    public ApiRequest(ApiListener apiListener) {
        this.apiListener = apiListener;
        callList = BungalowService.getBungalow().getAllBungalows();
        callBungalow = BungalowService.getBungalow().getSingleBungalow();
    }

    public ApiRequest(ApiListener apiListener, Bungalow bungalow) {
        this.apiListener = apiListener;
        putCallBungalow = BungalowService.getBungalow().putBungalow(bungalow);
    }

    public void getSingleBungalow() {
        callBungalow.enqueue(new Callback<Bungalow>() {
            @Override
            public void onResponse(Call<Bungalow> call, Response<Bungalow> response) {
                Bungalow bungalow = response.body();

                apiListener.onSuccess(bungalow);
            }

            @Override
            public void onFailure(Call<Bungalow> call, Throwable t) {
                apiListener.onError(t);

            }
        });
    }


    public void getAllBungalows() {
        callList.enqueue(new Callback<List<Bungalow>>() {
            @Override
            public void onResponse(Call<List<Bungalow>> call, Response<List<Bungalow>> response) {
                List<Bungalow> bungalows = response.body();

                apiListener.onSuccess(bungalows);
            }

            @Override
            public void onFailure(Call<List<Bungalow>> call, Throwable t) {
                apiListener.onError(t);
            }
        });
    }

    public void patchBungalow() {
        putCallBungalow.enqueue(new Callback<Bungalow>() {
            @Override
            public void onResponse(Call<Bungalow> call, Response<Bungalow> response) {
               Bungalow bungalow = response.body();

               apiListener.onSuccess(bungalow);
            }

            @Override
            public void onFailure(Call<Bungalow> call, Throwable t) {
            apiListener.onError(t);
            }
        });
    }
}


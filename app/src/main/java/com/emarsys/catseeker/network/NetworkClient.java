package com.emarsys.catseeker.network;

import android.util.Log;

import com.emarsys.catseeker.model.CatMessageModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkClient {

    // region Singleton
    private static final NetworkClient ourInstance = new NetworkClient();

    public static NetworkClient getInstance() {
        return ourInstance;
    }

    private NetworkClient() {
    }
// endregion

    // region Public methods
    public void postCatMessage(String message) {
        SelinaService selinaService = retrofit().create(SelinaService.class);
        Call<Void> call = selinaService.postCat(new CatMessageModel(message));
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Log.d("CAT", response.toString());
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Log.d("CAT", t.toString());
            }
        });
    }
// endregion

    // region Private methods
    private Retrofit retrofit() {
        return new Retrofit.Builder()
                .baseUrl("https://hooks.slack.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
// endregion

}

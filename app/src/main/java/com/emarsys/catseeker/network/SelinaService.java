package com.emarsys.catseeker.network;

import com.emarsys.catseeker.model.CatMessageModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Path;

interface SelinaService {

    @POST("services/{secret}")
    Call<Void> postCat(
            @Path(value = "secret", encoded = true) String secret,
            @Body CatMessageModel catMessageModel);
}

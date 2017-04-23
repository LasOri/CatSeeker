package com.emarsys.catseeker.network;

import com.emarsys.catseeker.model.CatMessageModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

interface SelinaService {

    @POST("services/T4LT76Z1C/B520F9R29/nac4RzLaUILJ5AtT99mcdJuT")
    Call<Void> postCat(@Body CatMessageModel catMessageModel);
}

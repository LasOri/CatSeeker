package com.emarsys.catseeker.network

import com.emarsys.catseeker.model.CatMessageModel
import com.emarsys.catseeker.model.MetaData
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Path

interface SelinaService {
    @POST("services/{secret}")
    fun postCat(
            @Body catMessageModel: CatMessageModel,
            @Path(value = "secret", encoded = true) secret: String = MetaData.apiSecret
    ): Call<Void>
}
package com.sematec.basic.api

import com.sematec.basic.entities.LoginRequestEntity
import com.sematec.basic.entities.PixabayEntity
import com.sematec.basic.entities.UserEnity
import com.sematec.basic.entities.VehicleEntity
import retrofit2.Call
import retrofit2.http.*

interface Api {

    @GET("https://pixabay.com/api/")
    fun getImages(
        // @Path("api_version") apiVersion: String
        @Query("key") key: String,
        @Query("q") word: String
    ): Call<PixabayEntity>


    @GET("https://pixabay.com/api/")
    fun getAllImages(
        // @Path("api_version") apiVersion: String
        @Query("key") key: String,
        @Query("q") word: String
    ): Call<PixabayEntity>


    @POST("http://amirteymoori.ir/parkup/public/api/login")
    fun login(
        @Body request: LoginRequestEntity
    ): Call<UserEnity>


    @GET("http://amirteymoori.ir/parkup/public/api/vehicles")
    fun getVehicles(
        @Header("Authorization") token: String
    ): Call<List<VehicleEntity>>


}
package com.example.aop_part3_chapter07

import retrofit2.Call
import retrofit2.http.GET

interface HouseService {
    @GET("/v3/fdc1ae00-f463-4b69-997a-5dde31d38e54")
    fun getHouseList(): Call<HouseDto>
}
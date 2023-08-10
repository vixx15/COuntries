package com.example.countries.api

import com.example.countries.dto.Countries
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("/v3.1/all")
    fun getCountries():Call<ArrayList<Countries>>
}
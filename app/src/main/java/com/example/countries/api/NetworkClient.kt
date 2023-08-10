package com.example.countries.api

import com.example.countries.dto.Countries
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkClient {

    private val retrofit = Retrofit.Builder().baseUrl("https://restcountries.com/")
        .addConverterFactory(GsonConverterFactory.create()).build().create(ApiService::class.java)


    fun getCountries() : Call<ArrayList<Countries>> {

        return retrofit.getCountries()
    }

}
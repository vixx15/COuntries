package com.example.countries


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import com.example.countries.api.NetworkClient
import com.example.countries.databinding.ActivityMainBinding
import com.example.countries.dto.Countries
import retrofit2.Call
import retrofit2.Call.*
import retrofit2.Callback
import retrofit2.Callback.*
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var client = NetworkClient()
    private var countries: ArrayList<Countries>? = null
    var countryNames= ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)
        countries()

    }

    private fun countries() {

        client.getCountries().enqueue(object : Callback<ArrayList<Countries>> {


            override fun onResponse(
                call: Call<ArrayList<Countries>>,
                response: Response<ArrayList<Countries>>
            ) {
                if (response.isSuccessful) {
                    countries = response.body()
                    Log.i("SUCC",countries?.get(0)?.name?.common ?: "Empty")
                    for(country in countries!!){
                        countryNames.add(country.name?.common.toString())

                    }
                    Log.i("SUCC",countryNames.get(0))
                    var adapter=ArrayAdapter<String>(this@MainActivity,R.layout.listview,R.id.textView,countryNames)
                    var simpleList=findViewById<ListView>(R.id.simpleListView)
                    simpleList.adapter = adapter

                } else {

                    Log.i("FAIL","Did not respond")
                }
            }

            override fun onFailure(call: Call<ArrayList<Countries>>, t: Throwable) {
                Toast.makeText(this@MainActivity, t.localizedMessage, Toast.LENGTH_LONG).show()
               Log.e("My act",t.message,t)
                t.printStackTrace()
            }


        })
    }
}
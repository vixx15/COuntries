package com.example.countries


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.countries.api.NetworkClient
import com.example.countries.databinding.ActivityMainBinding
import com.example.countries.dto.Countries
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var client = NetworkClient()
    private var countries: ArrayList<Countries>? = null
    var countryNames = ArrayList<ItemViewModel>()
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
                    Log.i("SUCC", countries?.get(0)?.name?.common ?: "Empty")

                    for (country in countries!!) {
                        if (country.capital.size > 0) {
                            countryNames.add(
                                ItemViewModel(
                                    country.name?.common ?: "empty",
                                    country.population,
                                    country.capital?.get(0),
                                    country.flags?.png
                                )
                            )
                        } else countryNames.add(
                            ItemViewModel(
                                country.name?.common ?: "empty", country.population, "",
                                country.flags?.png
                            )
                        )

                    }

                    Log.i("SUCC", countryNames.get(0).name)
                    val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
                    recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
                    val adapter = CountriesAdapter(countryNames)
                    recyclerView.adapter = adapter
                    //var adapter=ArrayAdapter<String>(this@MainActivity,R.layout.listview,R.id.textView,countryNames)
                    //var simpleList=findViewById<ListView>(R.id.simpleListView)
                    //simpleList.adapter = adapter

                    adapter.setOnClickListener(object : CountriesAdapter.OnClickListener {
                        override fun onClick(position: Int, model: ItemViewModel) {
                            val intent = Intent(this@MainActivity, DetailsActivity::class.java)
                            intent.putExtra(NEXT_SCREEN, model)
                            startActivity(intent)
                        }
                    })
                } else {

                    Log.i("FAIL", "Did not respond")
                }
            }

            override fun onFailure(call: Call<ArrayList<Countries>>, t: Throwable) {
                Toast.makeText(this@MainActivity, t.localizedMessage, Toast.LENGTH_LONG).show()
                Log.e("My act", t.message, t)
                t.printStackTrace()
            }


        })
    }

    companion object {

        val NEXT_SCREEN = "details_screen"
    }
}
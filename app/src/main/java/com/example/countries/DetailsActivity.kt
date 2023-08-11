package com.example.countries

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import com.example.countries.databinding.ActivityDetailsBinding
import java.util.concurrent.Executors

class DetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var countrList: ItemViewModel? = null
        if (intent.hasExtra(MainActivity.NEXT_SCREEN)) {

            countrList = intent.getSerializableExtra(MainActivity.NEXT_SCREEN) as ItemViewModel
        }

        if (countrList != null) {
            binding?.countryName?.text = countrList.name
            if (countrList.population != null)
                binding.population.text = countrList.population.toString()
            if (countrList.captial != null)
                binding.capital.text = countrList.captial
            if (countrList.img != null) {
                val executor = Executors.newSingleThreadExecutor()
                val handler = Handler(Looper.getMainLooper())
                var image: Bitmap? = null


                executor.execute {
                    val imageURL = countrList.img

                    try {
                        val `in`=java.net.URL(imageURL).openStream()
                        image=BitmapFactory.decodeStream(`in`)

                        handler.post{
                            binding.countryFlag.setImageBitmap(image)
                        }
                    }catch (e:Exception){

                        Log.e("ERROR IMAGE", e.message.toString())
                    }

                }
            }

        }
    }
}
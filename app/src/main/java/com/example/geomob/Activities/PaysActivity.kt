package com.example.geomob.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.geomob.Adapters.CountryPagesAdapter
import com.example.geomob.Database.PaysDatabase
import com.example.geomob.R
import com.example.geomob.Threads.AppExecutors
import kotlinx.android.synthetic.main.activity_pays.*

class PaysActivity : AppCompatActivity() {

    private val NUM_PAGES = 3
    private var countryCode = ""
    private var countryName = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pays)


        countryCode = intent.getStringExtra("countryCode")
        countryName = intent.getStringExtra("countryName")


        val pagerAdapter = CountryPagesAdapter(this,supportFragmentManager, NUM_PAGES)
        mPager.adapter = pagerAdapter

        tabLayout.setupWithViewPager(mPager)
    }

    fun getCountryCode() : String{
        return countryCode
    }

    fun getCountryName() : String{
        return countryName
    }



}

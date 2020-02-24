package com.example.weatherreport

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.weatherreport.Datasource.Remote.Weather
import kotlinx.android.synthetic.main.activity_main.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class MainActivity : AppCompatActivity() {

    lateinit var weatherURl : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        EventBus.getDefault().register(this)
    }

    override fun onStop() {
        super.onStop()
        EventBus.getDefault().unregister(this)
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onUserResponse(userResponse: Weather) {
        

    }

    fun executeAsyncOkHttpCall() {

        var zipcode = etZip.text.toString()
        weatherURl = "https://api.openweathermap.org/data/2.5/weather?zip=$zipcode,us&appid=5f82f53a11f5a31bc88b724f36ae4e61"
        val okHttpHelper = OkHttpHelper()
        okHttpHelper.makeAsyncApiCall(weatherURl)
    }


    fun onClick(view: View) {
        executeAsyncOkHttpCall()
    }
}

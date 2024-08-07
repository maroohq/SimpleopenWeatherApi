package com.example.apidemoopenweather


import android.annotation.SuppressLint
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apidemoopenweather.models.Forecast3hour
import com.example.apidemoopenweather.models.weatherModel
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.json.JSONObject
import java.net.MalformedURLException
import java.net.URL


class MainActivity : AppCompatActivity() {

    lateinit var frag : itemFragment
    lateinit var fragManager: FragmentManager
    lateinit var dataList : List<Forecast3hour>

    val BASE_URL = "https://api.openweathermap.org/data/2.5/forecast"
    val PARAM_LAT = "lat"
    val LAT = -25.7459277
    val PARAM_LON = "lon"
    val LON = 28.1879101
    val PARAM_API_KEY = "appid"
    val API_KEY = "insert your api key here "

    @SuppressLint("UseRequireInsteadOfGet")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        CoroutineScope(Dispatchers.IO).launch {

            //connecting to the internet
            try {
                val data = buildURLForWeather()?.readText()

                if (data != null) {
                    launch(Dispatchers.Main) {

                        frag = itemFragment()
                        val jsonObj = Gson().fromJson<weatherModel>(data,weatherModel::class.java)
                        val dataList = jsonObj.list


                        fragManager = supportFragmentManager
                        fragManager.beginTransaction().replace(R.id.frameLayout,frag,"current").commit()
                        fragManager.executePendingTransactions()
                        frag.setAdapter(dataList)







                    }
                }
            }
            catch (e:Exception)
            {
                e.printStackTrace()
            }
        }




    }



    fun buildURLForWeather(): URL? {
        val buildUri: Uri = Uri.parse(BASE_URL).buildUpon()
            .appendQueryParameter(
                PARAM_API_KEY,
                API_KEY
            ) .appendQueryParameter(
                PARAM_LAT,
                LAT.toString()
            ).appendQueryParameter(
                PARAM_LON,
                LON.toString()
            ).build()

        var url: URL? = null

        try {
            url = URL(buildUri.toString())
        } catch (e: MalformedURLException) {
            e.printStackTrace()
        }

        Log.i("OpenApi", "buildURLForWeather: $url")

        return url






    }
}
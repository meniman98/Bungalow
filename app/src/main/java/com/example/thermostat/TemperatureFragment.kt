package com.example.thermostat

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.thermostat.dataSource.ApiRequest
import com.example.thermostat.model.Bungalow
import com.example.thermostat.network.BungalowService
import com.example.thermostat.network.Repo
import com.example.thermostat.presenter.ApiListener
import com.marcinmoskala.arcseekbar.ArcSeekBar
import com.marcinmoskala.arcseekbar.ProgressListener
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO

class TemperatureFragment : Fragment() {
    private lateinit var seekBar: ArcSeekBar
    private lateinit var setTemperature: TextView
    var temper: String? = null
    private lateinit var actualTemper: TextView
    private lateinit var apiRequest: ApiRequest
    private lateinit var patchRequest: ApiRequest
    private var bungalow = Bungalow()
    private lateinit var job: Job
    private lateinit var submitButton: Button
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_temperature, container, false)
    }

    @InternalCoroutinesApi
    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)
        //main code here
        actualTemper = view.findViewById(R.id.tvActualTemp)
        seekBar = view.findViewById(R.id.seekBar)
        setTemperature = view.findViewById(R.id.tvTemperature)
        submitButton = view.findViewById(R.id.btnSetTemp)
        val colourArray = resources.getIntArray(R.array.gradient)
        seekBar.setProgressGradient(*colourArray)
        seekBar.onProgressChangedListener = ProgressListener { i ->
            var i = i;

            i += 10
            temper = i.toString()
            setTemperature.setText("$temper°")
        }

        // connection
        //patch request
        //1 onclick listener
        // 2 async task and pass callback
        // 3 patch request within async task
        // 4 in onsuccess execute callback so the ui thead will be active
        //5 within callback (ui thread) pass value



            CoroutineScope(IO).launch {
                while (NonCancellable.isActive) {
                    getRequest()
                    apiRequest.getSingleBungalow()
                    delay(2000L)
                }

            }


        //apiRequest.getSingleBungalow()
        //patchRequest.patchBungalow()


    }


    private fun patchRequest() {
        patchRequest = ApiRequest(object : ApiListener {
            override fun onSuccess(bungalow: Bungalow?) {
                var content: String = ""
                content += "temperature:" + 20


            }

            override fun onSuccess(bungalows: MutableList<Bungalow>?) {

            }

            override fun onError(t: Throwable?) {

            }
        }, bungalow)

    }


    private suspend fun getRequest() {
        // get request
        apiRequest = ApiRequest(object : ApiListener {
            override fun onSuccess(bungalow: Bungalow?) {
                // actualTemper.append(bungalow?.temperature.toString() ?: "Error")
                updateTextview(bungalow?.temperature.toString())

            }

            override fun onSuccess(bungalows: MutableList<Bungalow>?) {

            }

            override fun onError(t: Throwable?) {

            }

        })

    }

    private fun updateTextview(temp: String) {
        //actualTemper.append(bungalow?.temperature.toString() ?: "Error")
        actualTemper.append(temp)
    }


}
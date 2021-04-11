package com.example.thermostat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.thermostat.dataSource.ApiRequest
import com.example.thermostat.model.Bungalow
import com.example.thermostat.network.BungalowService
import com.example.thermostat.network.Repo
import com.example.thermostat.presenter.ApiListener
import com.marcinmoskala.arcseekbar.ArcSeekBar
import com.marcinmoskala.arcseekbar.ProgressListener

class TemperatureFragment : Fragment() {
    private lateinit var seekBar: ArcSeekBar
    private lateinit var setTemperature: TextView
    var temper: String? = null
    private lateinit var actualTemper: TextView
    private lateinit var apiRequest: ApiRequest
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_temperature, container, false)
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)
        //main code here
        actualTemper = view.findViewById(R.id.tvActualTemp)
        seekBar = view.findViewById(R.id.seekBar)
        setTemperature = view.findViewById(R.id.tvTemperature)
        actualTemper = view.findViewById(R.id.tvActualTemp)
        val colourArray = resources.getIntArray(R.array.gradient)
        seekBar.setProgressGradient(*colourArray)
        seekBar.onProgressChangedListener = ProgressListener { i ->
            var i = i
            i += 10
            temper = i.toString()
            setTemperature.setText("$temper°")
        }

        // connection

        //connection
        var repo: Repo = BungalowService.getBungalow()
        apiRequest = ApiRequest(object : ApiListener {
            override fun onSuccess(bungalow: Bungalow?) {
                actualTemper.setText(bungalow?.temperature.toString() ?: "Error")


            }

            override fun onSuccess(bungalows: MutableList<Bungalow>?) {
                TODO("Not yet implemented")
            }

            override fun onError(t: Throwable?) {
                TODO("Not yet implemented")
            }

        })
    }


}
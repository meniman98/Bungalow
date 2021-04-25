package com.example.thermostat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.thermostat.dataSource.ApiRequest
import com.example.thermostat.model.Bungalow
import com.example.thermostat.presenter.ApiListener
import com.marcinmoskala.arcseekbar.ArcSeekBar
import com.marcinmoskala.arcseekbar.ProgressListener
import kotlinx.coroutines.*

class TemperatureFragment : Fragment() {

    // seekbar and button
    private lateinit var seekBar: ArcSeekBar
    private lateinit var submitButton: Button

    // temperatures
    private lateinit var setTemperature: TextView
    private lateinit var actualTemper: TextView
    private lateinit var desiredTemper: TextView

    // logic
    private lateinit var apiRequest: ApiRequest
    private lateinit var patchRequest: ApiRequest

    private lateinit var temper: String
    private var bungalow = Bungalow()

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

        // temperatures
        actualTemper = view.findViewById(R.id.numActualTemp)
        setTemperature = view.findViewById(R.id.tvSetTemp)
        desiredTemper = view.findViewById(R.id.numDesiredTemp)

        // seekbar and button
        seekBar = view.findViewById(R.id.seekBar)
        submitButton = view.findViewById(R.id.btnSetTemp)

        // set colour gradient
        val colourArray = resources.getIntArray(R.array.gradient)
        seekBar.setProgressGradient(*colourArray)

        // seekbar onChange
        seekBar.onProgressChangedListener = ProgressListener { i ->
            var seekbarValue = i;

            seekbarValue += 10
            temper = "$seekbarValue °"
            setTemperature.text = temper
        }
    }


}
package com.example.thermostat

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.thermostat.dataSource.ApiRequest
import com.example.thermostat.model.Bungalow
import com.marcinmoskala.arcseekbar.ArcSeekBar
import com.marcinmoskala.arcseekbar.ProgressListener
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO

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
    private var seekbarValue: Int = 0
    private var actualTemperValue = 14

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
            seekbarValue = i;

            seekbarValue += 10
            temper = "$seekbarValue °"
            setTemperature.text = temper
        }

        // button onClick
        submitButton.setOnClickListener { v: View? ->
            Log.i("TemperFrag", "clicked!")
            setDesiredTemp()
            if (actualTemperValue < seekbarValue) {
                CoroutineScope(IO).launch {
                    gradualIncrease()
                }
            } else {
                CoroutineScope(IO).launch {
                    gradualDecrease()
                }
            }

        }
    }

    private suspend fun gradualDecrease() {
        while (actualTemperValue != seekbarValue) {
            actualTemperValue--
            delay(1000L)
        }

    }

    // set temperature for desired temperature
    private fun setDesiredTemp() {
        val temper = "$seekbarValue °"
        desiredTemper.text = temper
    }
    private fun setActualTemp() {
        val temper = "$actualTemperValue °"
        actualTemper.text = temper
    }

    private suspend fun gradualIncrease() {
        while (actualTemperValue != seekbarValue) {
            actualTemperValue++
            delay(1000L)
        }

    }


}
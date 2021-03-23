package com.example.thermostat

import android.graphics.Rect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.TouchDelegate
import android.view.View
import com.marcinmoskala.arcseekbar.ArcSeekBar

class MainActivity : AppCompatActivity() {
    lateinit var seekBar: ArcSeekBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.temperature)
        seekBar = findViewById(R.id.seekBar)

        val parent = seekBar.parent as View
        val delegateArea = Rect()

        parent.post {
            seekBar.getHitRect(delegateArea)

            delegateArea.top += 500
            delegateArea.bottom += 500

            parent.touchDelegate = TouchDelegate(delegateArea, seekBar)
        }

    }
}
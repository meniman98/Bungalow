package com.example.thermostat;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.marcinmoskala.arcseekbar.ArcSeekBar;
import com.marcinmoskala.arcseekbar.ProgressListener;


public class TemperatureFragment extends Fragment {


    public TemperatureFragment() {
        // Required empty public constructor
    }

    ArcSeekBar seekBar;
    TextView temperature;
    String temper;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_temperature, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //main code here
        seekBar = view.findViewById(R.id.seekBar);
        temperature = view.findViewById(R.id.tvTemperature);


        int[] colourArray = getResources().getIntArray(R.array.gradient);
        seekBar.setProgressGradient(colourArray);


        seekBar.setOnProgressChangedListener(new ProgressListener() {
            @Override
            public void invoke(int i) {
                i +=10;
                temper = String.valueOf(i);
                temperature.setText( temper.concat(" C°") );
            }
        });
    }
}
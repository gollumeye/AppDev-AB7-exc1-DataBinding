package com.example.sheet7_exc1_databinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.sheet7_exc1_databinding.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        ArrayList<String> spinnerEntries = new ArrayList<>();
        spinnerEntries.add("meter to inch");
        spinnerEntries.add("inch to meter");
        spinnerEntries.add("celsius to fahrenheit");
        spinnerEntries.add("fahrenheit to celcius");
        spinnerEntries.add("kilometers to miles");
        spinnerEntries.add("miles to kilometers");
        spinnerEntries.add("knots to meter per second");
        spinnerEntries.add("meter per second to knots");

        binding.setSpinnerArrayEntries(spinnerEntries);

        binding.button.setOnClickListener(e->{
            String conversion_mode = binding.spinner.getSelectedItem().toString();
            if(!binding.frominput.getText().toString().equals("")){
                Double from_value = Double.parseDouble(binding.frominput.getText().toString());
                String result;

                switch (conversion_mode) {
                    case ("meter to inch"):
                        result = Double.toString(from_value*39.701);
                        binding.setToInput(result);
                        break;
                    case ("inch to meter"):
                        result = Double.toString(from_value*0.0254);
                        binding.setToInput(result);
                        break;
                    case ("celsius to fahrenheit"):
                        result = Double.toString(from_value* (9 / 5) + 32);
                        binding.setToInput(result);
                        break;
                    case ("fahrenheit to celcius"):
                        result = Double.toString( (from_value - 32) * (5 / 9));
                        binding.setToInput(result);
                        break;
                    case ("kilometers to miles"):
                        result = Double.toString(from_value*0.621371);
                        binding.setToInput(result);
                        break;
                    case ("miles to kilometers"):
                        result = Double.toString(from_value*1.609);
                        binding.setToInput(result);
                        break;
                    case ("knots to meter per second"):
                        result = Double.toString(from_value*0.51);
                        binding.setToInput(result);
                        break;
                    case ("meter per second to knots"):
                        result = Double.toString(from_value*1.94384);
                        binding.setToInput(result);

                        break;
                    default:
                        ;
                }
            }
            else{
                binding.setToInput("");
            }
        });
    }
}
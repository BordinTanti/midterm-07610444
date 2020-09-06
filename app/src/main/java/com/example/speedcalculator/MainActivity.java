package com.example.speedcalculator;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button calBut = findViewById(R.id.calButton);
        calBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText speedEditText = findViewById(R.id.speedEditText);
                EditText timeEditText  = findViewById(R.id.timeEditText);
                TextView avarage = findViewById(R.id.averageCalTextView);
                String speedText = speedEditText.getText().toString();
                String timeText = timeEditText.getText().toString();

                if(speedEditText.length() == 0|| timeText.length()==0){
                    Toast t = Toast.makeText(MainActivity.this,
                            R.string.required,
                            Toast.LENGTH_SHORT);
                    t.show();

                }else if(timeText.equals("0")){
                    Toast t = Toast.makeText(MainActivity.this,
                            R.string.time_greater_zero,
                            Toast.LENGTH_SHORT);
                    t.show();
                }else{
                    double speedNum = Double.parseDouble(speedText);
                    double timeNum = Double.parseDouble(timeText);
                    double cal = (speedNum/timeNum)*3.6 ;
                    String str = String.format(Locale.getDefault(),"%.2f",cal);
                    avarage.setText(str);
                    if(cal > 80){
                        AlertDialog.Builder speedLimit= new AlertDialog.Builder(MainActivity.this);
                        speedLimit.setTitle(R.string.speed_calculator);
                        speedLimit.setMessage(R.string.over_limit);
                        speedLimit.setPositiveButton("OK",null);
                        speedLimit.show();
                    }
                }




            }
        });
        Button clear = findViewById(R.id.clearButton);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText speedEditText = findViewById(R.id.speedEditText);
                EditText timeEditText  = findViewById(R.id.timeEditText);
                TextView avarage = findViewById(R.id.averageCalTextView);
                speedEditText.setText(null);
                timeEditText.setText(null);
                avarage.setText(null);
            }
        });


    }
}
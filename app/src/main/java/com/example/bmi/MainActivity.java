package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        EditText edtWeight, editHeightFt, edtHeightIn;
        Button btnCalculate;
        TextView txtResult;
        LinearLayout llMain;

        edtWeight = findViewById(R.id.edtWeight);
        editHeightFt = findViewById(R.id.edtHeightFt);
        edtHeightIn = findViewById(R.id.edtHeightIn);
        btnCalculate = findViewById(R.id.btnCalculate);
        txtResult = findViewById(R.id.txtResult);
        llMain = findViewById(R.id.llMain);



        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int wt = Integer.parseInt(edtWeight.getText().toString());
                int ft = Integer.parseInt(editHeightFt.getText().toString());
                int in = Integer.parseInt(edtHeightIn.getText().toString());

                int totalIn = ft * 12 + in; // Convert feet and inches to inches

                double totalCm = totalIn * 2.54; // Convert inches to centimeters

                double totalM = totalCm / 100; // Convert centimeters to meters

                double bmi = wt / (totalM * totalM); // Calculate BMI

                if (bmi > 25) {
                    txtResult.setText("you are over-weighted");
                    llMain.setBackgroundColor(getResources().getColor(R.color.colorOW));
                } else if (bmi < 18) {
                    txtResult.setText("you are under-weighted");
                    llMain.setBackgroundColor(getResources().getColor(R.color.colorUW));
                } else {
                    txtResult.setText("you are healthy");
                    llMain.setBackgroundColor(getResources().getColor(R.color.colorH));


                }

            }
        });
    }
}
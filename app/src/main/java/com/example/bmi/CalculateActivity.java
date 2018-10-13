package com.example.bmi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CalculateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate);


        final Button calculate = findViewById(R.id.calculate_button);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText heightEditor = findViewById(R.id.height_editText);
                EditText weightEditor = findViewById(R.id.weight_editText);

                int h = Integer.parseInt(heightEditor.getText().toString() );
                int w = Integer.parseInt(weightEditor.getText().toString() );
                float bmi = calBMI(h,w);
                String pp="";
                if (bmi <18.5) {
                    pp ="ผอม";
                }
                else if (bmi < 25){
                    pp ="ปกติ";

                }
                else if (bmi <30){
                    pp ="อ้วน";

                }
                else  {

                    pp="อ้วนเกินไป";
                }
                Toast t = Toast.makeText(CalculateActivity.this , pp , Toast.LENGTH_LONG);
                t.show();
            }
        });
    }
    private float calBMI (int h, int w) {

        float height = h/100f;
        float bmi = w / (height*height);
        return  bmi;
    }
}

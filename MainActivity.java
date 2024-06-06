package com.example.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText ed1;
    Button but1;
    Spinner sp1,sp2;
    TextView txt1;
    String currency1=" ";
    String currency2=" ";

    String[] type={"US Dollar(USD)","Euro(EUR)","Japanese Yen(JPY)","British Pound(GBP)","Swiss France(CHF)","Canadian Dollar(CAD)","Australian Dollar(AUD)",
            "Chinese Yuan(CNY)","Swedish Krona(SEK)","New Zealand Dollar(NZD)","Mexican Peso(MXN)","Singapore Dollar(SGD)","Hong Kong Dollar(HKD)",
            "Norwegian Krone(NOK)","South Korean Won(KRW)","Sri Lankan Rupees(LKR)","Indian Rupees(INR)",};

    double[] values = {1,1.10,0.0073,1.25,1.12,0.75,0.65,0.14,0.092,0.61,0.058,0.74,0.13,0.094,0.00076,0.0033,0.012};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1 = findViewById(R.id.editText1);
        sp1 = findViewById(R.id.spinner1);
        sp2 = findViewById(R.id.spinner2);
        but1 = findViewById(R.id.button1);
        txt1 = findViewById(R.id.textView4);


        ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_spinner_item,type);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item );
        sp1.setAdapter(adapter);
        sp2.setAdapter(adapter);

        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
                String value1 = parent.getItemAtPosition(position).toString();
                Toast.makeText(MainActivity.this, value1, Toast.LENGTH_SHORT);
                currency1 = value1;
                //txt1.setText(value1);
                txt1.setText(currency1);
                //currency1 = txt1.getText().toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        sp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
                String value2 = parent.getItemAtPosition(position).toString();
                Toast.makeText(MainActivity.this, value2, Toast.LENGTH_SHORT);
                currency2 = value2;
                txt1.setText(value2);
                //currency2 = txt1.getText().toString();

            }


            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



    }

    public void equalEvent(View view) {

        double temp1=0.0,temp2=0.0;
        double amount = 0.0;


        for (int i=0;i< type.length;i++){
            if (type[i] == currency1){
                temp1 = values[i];
                break;
            }
        }
        for (int i=0;i< type.length;i++){
            if (type[i] == currency2){
                temp2 = values[i];
                break;
            }
        }

        String temp = ed1.getText().toString();
        // double temp =  Double.parseDouble(ed1.getText());

        amount =  (Double.valueOf(temp)*temp1)/temp2;


        txt1.setText(Double.toString(amount));
        //txt1.setText(type);

    }

}
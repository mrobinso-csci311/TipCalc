package com.example.tipcalc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText enterBill;
    private EditText enterTip;
    private EditText showTip;
    private EditText showTotal;
    private RadioButton split;
    private EditText guestTotal;
    private EditText splitTotal;

    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enterBill = findViewById(R.id.enterBill);
        enterTip = findViewById(R.id.enterTip);
        showTip = findViewById(R.id.showTip);
        showTotal = findViewById(R.id.showTotal);
        split = findViewById(R.id.split);
        guestTotal = findViewById(R.id.guestTotal);
        splitTotal = findViewById(R.id.splitTotal);
    }

    public void process(View v) {
        String billInput = enterBill.getText().toString();
        double bill = Double.parseDouble(billInput);
        String tipInput = enterTip.getText().toString();
        double tip = Double.parseDouble(tipInput);
        double tipTotal = bill*(tip/100);
        double billTotal = bill+tipTotal;
        showTip.setText(String.format("%.2f", tipTotal));
        showTotal.setText(String.format("%.2f", billTotal));
        if(split.isChecked()){
            String guestInput = guestTotal.getText().toString();
            if((guestInput.length()>0)){
                double guests = Double.parseDouble(guestInput);
                double calcSplit = billTotal / guests;
                splitTotal.setText(String.format("%.2f", calcSplit));
            }else{
                Toast.makeText(this,"No guest total entered.", Toast.LENGTH_SHORT).show();
            }
        }else{
            guestTotal.setText("1");
            splitTotal.setText(String.format("%.2f", billTotal));
        }
    }
}

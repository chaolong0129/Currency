package com.rff.currency2;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.math.BigDecimal;

public class MainActivity extends AppCompatActivity {

    private EditText ntd;
    private double US_EXT_RATE = 30.9;
    private TextView lblUSMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findviews();
        setInitValue();
    }

    private void setInitValue()
    {
        lblUSMsg.setText(""+US_EXT_RATE);
    }
    private void findviews() {
        ntd = findViewById(R.id.edntd);
        lblUSMsg = findViewById(R.id.tvUSMsg);
    }

    public void CalCurrency(View view)
    {
        if (ntd.length() == 0)
            ShowDialogWarning();
        else
            ShowDialogResult();
    }

    private void ShowDialogResult() {
        int amount = Integer.parseInt(ntd.getText().toString());
        BigDecimal result_us = BigDecimal.valueOf(amount / US_EXT_RATE);

        new AlertDialog.Builder(this)
                .setTitle("Result")
                .setMessage("USD is " + String.format("%.4f", result_us))
                .setPositiveButton("OK", null)
                .show();
    }

    private void ShowDialogWarning() {
        new AlertDialog.Builder(this)
                .setTitle("Problem")
                .setMessage("Please enter you NTD amount")
                .setPositiveButton("OK", null)
                .show();
    }
}

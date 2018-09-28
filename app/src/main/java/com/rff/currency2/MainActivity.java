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
        findViews();
        setInitValue();
    }

    private void setInitValue()
    {
        lblUSMsg.setText(""+US_EXT_RATE);
    }
    private void findViews() {
        ntd = findViewById(R.id.edntd);
        lblUSMsg = findViewById(R.id.tvUSMsg);
    }

    public void calCurrency(View view)
    {
        if (ntd.length() == 0)
            showDialogWarning();
        else
            showDialogResult();
    }

    private void showDialogResult() {
        int amount = Integer.parseInt(ntd.getText().toString());
        BigDecimal result_us = BigDecimal.valueOf(amount / US_EXT_RATE);

        new AlertDialog.Builder(this)
                .setTitle(R.string.result)
                .setMessage(getString(R.string.usd_is) + String.format("%.4f", result_us))
                .setPositiveButton(R.string.ok, null)
                .show();
    }

    private void showDialogWarning() {
        new AlertDialog.Builder(this)
                .setTitle(R.string.problem)
                .setMessage(R.string.enter_your_ntd_amount)
                .setPositiveButton(R.string.ok, null)
                .show();
    }
}

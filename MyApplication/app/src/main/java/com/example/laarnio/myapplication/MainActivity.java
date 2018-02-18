package com.example.laarnio.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText firstNumber;
    private EditText secondNumber;
    private TextView additionResult;

    private EditText firstNumberSub;
    private EditText secondNumberSub;
    private TextView substractionResult;

    private EditText firstNumberMp;
    private EditText secondNumberMp;
    private TextView multiplicationResult;

    private EditText firstNumberDiv;
    private EditText secondNumberDiv;
    private TextView divisionResult;

    private List<String> calcLog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstNumber = findViewById(R.id.first_add_number);
        secondNumber = findViewById(R.id.second_add_number);
        additionResult = findViewById(R.id.addition_result);

        firstNumberSub = findViewById(R.id.first_subtract_number);
        secondNumberSub = findViewById(R.id.second_subtract_number);
        substractionResult = findViewById(R.id.subtraction_result);

        firstNumberMp = findViewById(R.id.first_mp_number);
        secondNumberMp = findViewById(R.id.second_mp_number);
        multiplicationResult = findViewById(R.id.multiplier_result);

        firstNumberDiv = findViewById(R.id.first_div_number);
        secondNumberDiv = findViewById(R.id.second_div_number);
        divisionResult = findViewById(R.id.division_result);
        calcLog = new ArrayList<String>();
    }

    public void calculateAddition(View view) {

        String firstNumberText = firstNumber.getText().toString();
        String secondNumberText = secondNumber.getText().toString();
        if(firstNumberText.isEmpty() || secondNumberText.isEmpty()) {
            Toast.makeText(getBaseContext(), "Täytä kentät", Toast.LENGTH_SHORT).show();
        }
        else {
            Integer resultNumber = Integer.parseInt(firstNumberText) + Integer.parseInt(secondNumberText);
            additionResult.setText(resultNumber.toString());
            String newLog = firstNumberText + "+" + secondNumberText + "=" + resultNumber.toString();
            calcLog.add(newLog);
        }

    }

    public void calculateSubtraction(View view) {
        String firstNumberText = firstNumberSub.getText().toString();
        String secondNumberText = secondNumberSub.getText().toString();
        if(firstNumberText.isEmpty() || secondNumberText.isEmpty()) {
            Toast.makeText(getBaseContext(), "Täytä kentät", Toast.LENGTH_SHORT).show();
        }
        else {
            Integer resultNumber = Integer.parseInt(firstNumberText) - Integer.parseInt(secondNumberText);
            substractionResult.setText(resultNumber.toString());
            String newLog = firstNumberText + "-" + secondNumberText + "=" + resultNumber.toString();
            calcLog.add(newLog);
        }
    }

    public void calculateMultiplication(View view) {
        String firstNumberText = firstNumberMp.getText().toString();
        String secondNumberText = secondNumberMp.getText().toString();
        if(firstNumberText.isEmpty() || secondNumberText.isEmpty()) {
            Toast.makeText(getBaseContext(), "Täytä kentät", Toast.LENGTH_SHORT).show();
        }
        else {
            Integer resultNumber = Integer.parseInt(firstNumberText) * Integer.parseInt(secondNumberText);
            multiplicationResult.setText(resultNumber.toString());
            String newLog = firstNumberText + "*" + secondNumberText + "=" + resultNumber.toString();
            calcLog.add(newLog);
        }
    }

    public void calculateDivision(View view) {
        String firstNumberText = firstNumberDiv.getText().toString();
        String secondNumberText = secondNumberDiv.getText().toString();
        if(firstNumberText.isEmpty() || secondNumberText.isEmpty()) {
            Toast.makeText(getBaseContext(), "Täytä kentät", Toast.LENGTH_SHORT).show();
        }
        else {
            Double resultNumber = Double.parseDouble(firstNumberText) / Double.parseDouble(secondNumberText);
            if (resultNumber.isInfinite()) {
                Toast.makeText(getBaseContext(), "Ei voida jakaa nollalla", Toast.LENGTH_SHORT).show();
                firstNumberDiv.setText("");
                secondNumberDiv.setText("");
                divisionResult.setText("0");
            } else {
                divisionResult.setText(resultNumber.toString());
                String newLog = firstNumberText + "/" + secondNumberText + "=" + resultNumber.toString();
                calcLog.add(newLog);
            }
        }
    }

    public void clearAll(View view) {

        firstNumber.setText("0");
        secondNumber.setText("0");
        additionResult.setText("0");

        firstNumberSub.setText("0");
        secondNumberSub.setText("0");
        substractionResult.setText("0");

        firstNumberMp.setText("0");
        secondNumberMp.setText("0");
        multiplicationResult.setText("0");

        firstNumberDiv.setText("0");
        secondNumberDiv.setText("0");
        divisionResult.setText("0");

    }

    public void showLog(View view) {
        Intent intent = new Intent(this, LogActivity.class);
        intent.putStringArrayListExtra("laskut", (ArrayList<String>) calcLog);
        startActivity(intent);
    }

}

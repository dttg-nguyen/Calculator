package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button num0, num1, num2, num3, num4, num5, num6, num7, num8, num9;
    Button plus, minus,multiply, divide;
    Button equal;
    Button clear;

    Button calculatorMode;
    Button modulus, power, max, min;
    LinearLayout advanceLayout;
    TextView output;
    String calculationString = " ";

    Calculator calculator = new Calculator();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num0 = findViewById(R.id.zero);
        num1 = findViewById(R.id.one);
        num2 = findViewById(R.id.two);
        num3 = findViewById(R.id.three);
        num4 = findViewById(R.id.four);
        num5 = findViewById(R.id.five);
        num6 = findViewById(R.id.six);
        num7 = findViewById(R.id.seven);
        num8 = findViewById(R.id.eight);
        num9 = findViewById(R.id.nine);

        plus = findViewById(R.id.plus);
        minus = findViewById(R.id.minus);
        multiply = findViewById(R.id.multiply);
        divide = findViewById(R.id.divide);
        equal = findViewById(R.id.equal);

        clear = findViewById(R.id.clear);
        output = findViewById(R.id.output);

        calculatorMode = findViewById(R.id.calculator_mode);
        modulus = findViewById(R.id.modulus);
        power = findViewById(R.id.power);
        max = findViewById(R.id.max);
        min = findViewById(R.id.min);

        advanceLayout = findViewById(R.id.advance_buttons_layout);
        // Set the mode at the start
        calculatorMode.setText("ADVANCE - SCIENTIFIC");
        advanceLayout.setVisibility(View.INVISIBLE);

        num0.setOnClickListener(this);
        num1.setOnClickListener(this);
        num2.setOnClickListener(this);
        num3.setOnClickListener(this);
        num4.setOnClickListener(this);
        num5.setOnClickListener(this);
        num6.setOnClickListener(this);
        num7.setOnClickListener(this);
        num8.setOnClickListener(this);
        num9.setOnClickListener(this);
        plus.setOnClickListener(this);
        minus.setOnClickListener(this);
        multiply.setOnClickListener(this);
        divide.setOnClickListener(this);
        equal.setOnClickListener(this);
        clear.setOnClickListener(this);

        calculatorMode.setOnClickListener(this);
        modulus.setOnClickListener(this);
        power.setOnClickListener(this);
        max.setOnClickListener(this);
        min.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        Button v = (Button) view;

        if (id == R.id.zero) {
            calculationString += v.getText().toString();
            output.setText(calculationString);

            calculator.push(v.getText().toString());
        }
        if (id == R.id.one) {
            calculationString += v.getText().toString();
            output.setText(calculationString);

            calculator.push(v.getText().toString());
        }
        if (id == R.id.two) {
            calculationString += v.getText().toString();
            output.setText(calculationString);

            calculator.push(v.getText().toString());
        }
        if (id == R.id.three) {
            calculationString += v.getText().toString();
            output.setText(calculationString);

            calculator.push(v.getText().toString());
        }
        if (id == R.id.four) {
            calculationString += v.getText().toString();
            output.setText(calculationString);

            calculator.push(v.getText().toString());
        }
        if (id == R.id.five) {
            calculationString += v.getText().toString();
            output.setText(calculationString);

            calculator.push(v.getText().toString());
        }
        if (id == R.id.six) {
            calculationString += v.getText().toString();
            output.setText(calculationString);

            calculator.push(v.getText().toString());
        }
        if (id == R.id.seven) {
            calculationString += v.getText().toString();
            output.setText(calculationString);

            calculator.push(v.getText().toString());
        }
        if (id == R.id.eight) {
            calculationString += v.getText().toString();
            output.setText(calculationString);

            calculator.push(v.getText().toString());
        }
        if (id == R.id.nine) {
            calculationString += v.getText().toString();
            output.setText(calculationString);

            calculator.push(v.getText().toString());
        }
        if (id == R.id.plus) {
            calculationString += v.getText().toString();
            output.setText(calculationString);

            calculator.push(v.getText().toString());
        }
        if (id == R.id.minus) {
            calculationString += v.getText().toString();
            output.setText(calculationString);

            calculator.push(v.getText().toString());
        }
        if (id == R.id.multiply) {
            calculationString += v.getText().toString();
            output.setText(calculationString);

            calculator.push(v.getText().toString());
        }
        if (id == R.id.divide) {
            calculationString += v.getText().toString();
            output.setText(calculationString);

            calculator.push(v.getText().toString());
        }

        if (id == R.id.equal) {
            calculationString += v.getText().toString();
            output.setText(calculationString);
            int result = calculator.calculate();
            if(result == Calculator.ERROR_VALUE){
                calculationString += "Not an Operator";
            } else{
                calculationString += result;
            }
            output.setText(calculationString);
        }

        if (id == R.id.clear) {
            calculationString = "";
            output.setText(calculationString);
            calculator.clearCalculator();
        }

        // Part 2
        if(id == R.id.modulus || id == R.id.power || id == R.id.max || id == R.id.min){
            calculationString += v.getText().toString();
            output.setText(calculationString);

            calculator.push(v.getText().toString());
        }

        if(id == R.id.calculator_mode){
            if(v.getText().toString() == "STANDARD"){
                v.setText("ADVANCE - SCIENTIFIC");
                advanceLayout.setVisibility(View.INVISIBLE);
            } else{
                v.setText("STANDARD");
                advanceLayout.setVisibility(View.VISIBLE);
            }
        }
    }
}
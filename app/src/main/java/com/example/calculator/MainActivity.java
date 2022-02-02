package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final int STANDARD_MODE = 1;
    private static final int ADVANCE_MODE = 2;

    private LinearLayout advanceButtonLayout;
    private TextView output;
    private String resultString = "";

    private Calculator calculator = new Calculator();
    private int mode = STANDARD_MODE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button num0 = findViewById(R.id.zero);
        Button num1 = findViewById(R.id.one);
        Button num2 = findViewById(R.id.two);
        Button num3 = findViewById(R.id.three);
        Button num4 = findViewById(R.id.four);
        Button num5 = findViewById(R.id.five);
        Button num6 = findViewById(R.id.six);
        Button num7 = findViewById(R.id.seven);
        Button num8 = findViewById(R.id.eight);
        Button num9 = findViewById(R.id.nine);

        Button plus = findViewById(R.id.plus);
        Button minus = findViewById(R.id.minus);
        Button multiply = findViewById(R.id.multiply);
        Button divide = findViewById(R.id.divide);
        Button equal = findViewById(R.id.equal);

        Button clear = findViewById(R.id.clear);
        output = findViewById(R.id.output);

        Button calculatorMode = findViewById(R.id.calculator_mode);
        Button modulus = findViewById(R.id.modulus);
        Button power = findViewById(R.id.power);
        Button max = findViewById(R.id.max);
        Button min = findViewById(R.id.min);

        advanceButtonLayout = findViewById(R.id.advance_buttons_layout);
        advanceButtonLayout.setVisibility(View.INVISIBLE);

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
        Button button = (Button) view;

        // Concatenate the string into the result string
        // Set the result string to the output for display
        // Add the string to the list of values of the calculator
        if (id == R.id.zero || id == R.id.one || id == R.id.two || id == R.id.three || id == R.id.four
                || id == R.id.five || id == R.id.six || id == R.id.seven || id == R.id.eight || id == R.id.nine
                || id == R.id.plus || id == R.id.minus || id == R.id.multiply || id == R.id.divide
                || id == R.id.modulus || id == R.id.power || id == R.id.max || id == R.id.min) {
            String buttonText = button.getText().toString();
            resultString += " " + buttonText;
            output.setText(resultString);

            calculator.push(buttonText);
        }

        if (id == R.id.equal) {
            resultString += " " + button.getText().toString();
            output.setText(resultString);

            int result = calculator.calculate();
            if (result == Calculator.ERROR_VALUE) {
                resultString += " " + getString(R.string.not_an_operator);
            } else {
                resultString += " " + result;
            }
            output.setText(resultString);
        }

        if (id == R.id.clear) {
            resultString = "";
            output.setText(resultString);
            calculator.clearCalculator();
        }

        if (id == R.id.calculator_mode) {
            if (mode == STANDARD_MODE) {
                button.setText(R.string.standard_mode);
                switchCalculatorMode();
                advanceButtonLayout.setVisibility(View.VISIBLE);
            } else {
                button.setText(R.string.advance_mode);
                switchCalculatorMode();
                advanceButtonLayout.setVisibility(View.INVISIBLE);
            }
        }
    }

    private void switchCalculatorMode() {
        mode = mode == STANDARD_MODE ? ADVANCE_MODE : STANDARD_MODE;
    }
}
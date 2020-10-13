package com.maximopol.mycalc;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.maximopol.mycalc.logic.Parser;

public class MainActivity extends AppCompatActivity {
    private TextView textView, oldTextView;
    private boolean isInputOperator, isInputNumber, isInputPIorE, isInputDot;
    private int countHooks;
    private Parser parser = new Parser();

    @SuppressLint("SetTextI18n")
    private void doPIE(String pie) {
        if (isInputPIorE) {
            textView.setText(textView.getText() + "*" + pie);
        } else {
            textView.setText(textView.getText() + pie);
            isInputPIorE = true;
        }
    }

    @SuppressLint("SetTextI18n")
    private void doFunction(String function) {
        textView.setText(textView.getText() + function);
        countHooks++;
        isInputDot = false;
        isInputOperator = true;
        isInputNumber = false;
    }

    @SuppressLint("SetTextI18n")
    private void doOperator(String operator) {
        if (!isInputOperator) {
            textView.setText(textView.getText() + operator);
            isInputPIorE = false;
            isInputOperator = true;
            isInputDot = false;
            isInputNumber = true;
        }
    }

    @SuppressLint("SetTextI18n")
    private void doNumber(String number) {
        if (isInputPIorE & (!isInputNumber)) {
            textView.setText(textView.getText() + "*" + number);
        } else {
            textView.setText(textView.getText() + number);
        }
        isInputNumber = true;
        isInputPIorE = true;
        isInputOperator = false;
    }


    private void initVariables() {
        isInputPIorE = false;
        isInputOperator = false;
        isInputNumber = false;
        isInputDot = false;
        countHooks = 0;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initVariables();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println("Start");

        textView = findViewById(R.id.textViewCurrentAction);
        oldTextView = findViewById(R.id.textViewPreviousAction);

        View.OnClickListener listener = new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.button0: {
                        if (isInputPIorE) {
                            textView.setText(textView.getText() + "*0");
                        } else {
                            textView.setText(textView.getText() + "0");
                        }
                        isInputNumber = true;
                        break;
                    }
                    case R.id.button1: {
                        doNumber("1");
                        break;
                    }
                    case R.id.button2: {
                        doNumber("2");
                        break;
                    }
                    case R.id.button3: {
                        doNumber("3");
                        break;
                    }
                    case R.id.button4: {
                        doNumber("4");
                        break;
                    }
                    case R.id.button5: {
                        doNumber("5");
                        break;
                    }
                    case R.id.button6: {
                        doNumber("6");
                        break;
                    }
                    case R.id.button7: {
                        doNumber("7");
                        break;
                    }
                    case R.id.button8: {
                        doNumber("8");
                        break;
                    }
                    case R.id.button9: {
                        doNumber("9");
                        break;
                    }
                    case R.id.buttonLG: {
                        doFunction("ln(");

                        break;
                    }
                    case R.id.buttonLN: {
                        doFunction("lg(");
                        break;
                    }
                    case R.id.buttonTan: {
                        doFunction("tan(");
                        break;
                    }
                    case R.id.buttonCos: {
                        doFunction("cos(");
                        break;
                    }
                    case R.id.buttonSin: {
                        doFunction("sin(");
                        break;
                    }
                    case R.id.buttonCA: {
                        textView.setText("");
                        isInputNumber = false;
                        isInputOperator = false;
                        isInputPIorE = false;
                        countHooks = 0;
                        break;
                    }
                    case R.id.buttonC: {
                        String s = textView.getText().toString();

                        textView.setText(s.length() == 0
                                ? null
                                : s.substring(0, s.length() - 1));
                        break;
                    }
                    case R.id.buttonSquareRoot: {
                        textView.setText(textView.getText() + "√");
                        break;
                    }
                    case R.id.buttonHooks: {

                        if (textView.getText().equals("")) {
                            textView.setText("(");
                            countHooks++;

                        } else if (isInputOperator) {
                            textView.setText(textView.getText() + "(");
                            countHooks++;
                        } else if (isInputNumber) {
                            if (countHooks > 0) {
                                textView.setText(textView.getText() + ")");
                                countHooks--;
                            } else {
                                textView.setText(textView.getText() + "*(");
                                countHooks++;
                            }
                        }
                        break;
                    }
                    case R.id.buttonSquared2: {
                        textView.setText(textView.getText() + "^(2)");
                        break;
                    }

                    case R.id.buttonPercent: {
                        textView.setText(textView.getText() + "%");
                        break;
                    }
                    case R.id.buttonSquaredByY: {
                        textView.setText(textView.getText() + "^(");
                        countHooks++;
                        break;
                    }
                    case R.id.buttonPI: {
                        doPIE("π");
                        break;
                    }
                    case R.id.buttonE: {
                        doPIE("e");
                        break;
                    }
                    case R.id.buttonDot: {
                        if (!isInputDot) {
                            if (isInputNumber) {
                                textView.setText(textView.getText() + ".");
                            } else {
                                textView.setText(textView.getText() + "0.");
                            }
                            isInputDot = true;
                        }
                        break;
                    }
                    case R.id.buttonDivide: {
                        doOperator("/");
                        break;
                    }
                    case R.id.buttonMultiply: {
                        doOperator("*");
                        break;
                    }
                    case R.id.buttonPlus: {
                        doOperator("+");
                        break;
                    }
                    case R.id.buttonSubtract: {
                        if (!isInputOperator) {
                            textView.setText(textView.getText() + "-");
                            isInputPIorE = false;
                            isInputOperator = true;
                        }
                        break;
                    }
                    case R.id.buttonEqual: {
                        oldTextView.setText(textView.getText());
                        textView.setText(parser.getExpression(Parser.prepareStr(textView.getText().toString())));

                        initVariables();
                        isInputDot = true;
                        break;
                    }
                }
            }
        };

        Button button0 = findViewById(R.id.button0);
        button0.setOnClickListener(listener);

        Button button1 = findViewById(R.id.button1);
        button1.setOnClickListener(listener);

        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(listener);

        Button button3 = findViewById(R.id.button3);
        button3.setOnClickListener(listener);

        Button button4 = findViewById(R.id.button4);
        button4.setOnClickListener(listener);

        Button button5 = findViewById(R.id.button5);
        button5.setOnClickListener(listener);

        Button button6 = findViewById(R.id.button6);
        button6.setOnClickListener(listener);

        Button button7 = findViewById(R.id.button7);
        button7.setOnClickListener(listener);

        Button button8 = findViewById(R.id.button8);
        button8.setOnClickListener(listener);

        Button button9 = findViewById(R.id.button9);
        button9.setOnClickListener(listener);

        Button buttonLG = findViewById(R.id.buttonLG);
        buttonLG.setOnClickListener(listener);

        Button buttonLN = findViewById(R.id.buttonLN);
        buttonLN.setOnClickListener(listener);

        Button buttonTan = findViewById(R.id.buttonTan);
        buttonTan.setOnClickListener(listener);

        Button buttonCos = findViewById(R.id.buttonCos);
        buttonCos.setOnClickListener(listener);

        Button buttonSin = findViewById(R.id.buttonSin);
        buttonSin.setOnClickListener(listener);

        Button buttonCA = findViewById(R.id.buttonCA);
        buttonCA.setOnClickListener(listener);

        Button buttonC = findViewById(R.id.buttonC);
        buttonC.setOnClickListener(listener);

        Button buttonSquareRoot = findViewById(R.id.buttonSquareRoot);
        buttonSquareRoot.setOnClickListener(listener);

        Button buttonHooks = findViewById(R.id.buttonHooks);
        buttonHooks.setOnClickListener(listener);

        Button buttonSquared2 = findViewById(R.id.buttonSquared2);
        buttonSquared2.setOnClickListener(listener);

        Button buttonPercent = findViewById(R.id.buttonPercent);
        buttonPercent.setOnClickListener(listener);

        Button buttonSquaredByY = findViewById(R.id.buttonSquaredByY);
        buttonSquaredByY.setOnClickListener(listener);

        Button buttonPI = findViewById(R.id.buttonPI);
        buttonPI.setOnClickListener(listener);

        Button buttonDivide = findViewById(R.id.buttonDivide);
        buttonDivide.setOnClickListener(listener);

        Button buttonE = findViewById(R.id.buttonE);
        buttonE.setOnClickListener(listener);

        Button buttonDot = findViewById(R.id.buttonDot);
        buttonDot.setOnClickListener(listener);

        Button buttonMultiply = findViewById(R.id.buttonMultiply);
        buttonMultiply.setOnClickListener(listener);

        Button buttonSubtract = findViewById(R.id.buttonSubtract);
        buttonSubtract.setOnClickListener(listener);

        Button buttonPlus = findViewById(R.id.buttonPlus);
        buttonPlus.setOnClickListener(listener);

        Button buttonEqual = findViewById(R.id.buttonEqual);
        buttonEqual.setOnClickListener(listener);
    }
}
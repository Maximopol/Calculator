package com.maximopol.mycalc;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.maximopol.mycalc.logic.Operation;
import com.maximopol.mycalc.logic.Parser;

public class MainActivity extends AppCompatActivity {
    private TextView textView, oldTextView;
    private boolean isInputOperator;
    private boolean isInputNumber;
    private boolean isInputPIorE;
    private boolean isInputDot;
    private int countHooks;
    private Parser parser = new Parser();


    @SuppressLint("SetTextI18n")
    private void doPIE(String pie) {
        if ((isInputPIorE | isInputNumber) & !isInputOperator) {
            textView.setText(textView.getText() + "*" + pie);
        } else {
            textView.setText(textView.getText() + pie);

        }
        isInputPIorE = true;
        isInputNumber = false;
        isInputDot = false;
        isInputOperator = false;
    }

    @SuppressLint("SetTextI18n")
    private void doFunction(String function) {
        if ((isInputPIorE | isInputNumber) & !isInputOperator) {
            textView.setText(textView.getText() + "*" + function);
        } else {
            textView.setText(textView.getText() + function);
        }
        countHooks++;
        isInputDot = false;
        isInputOperator = true;
        isInputNumber = false;
        isInputPIorE = false;
    }

    @SuppressLint("SetTextI18n")
    private void doOperator(String operator) {
        if (!isInputOperator) {
            textView.setText(textView.getText() + operator);
            isInputPIorE = false;
            isInputOperator = true;
            isInputDot = false;
            isInputNumber = true;
        } else {
            String s = textView.getText().toString();
            if (s.equals("") | s.equals("-")) {
                return;
            }
            String kek = textView.getText().toString();

            switch (kek.substring(kek.length() - 1)) {
                case "-":
                case "+":
                case "/":
                case "*":
                    textView.setText(s.substring(0, s.length() - 1) + operator);
                    isInputPIorE = false;
                    isInputOperator = true;
                    isInputDot = false;
                    isInputNumber = true;
                    break;
            }
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
        isInputOperator = true;
        isInputNumber = false;
        isInputDot = false;
        countHooks = 0;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initVariables();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textViewCurrentAction);
        oldTextView = findViewById(R.id.textViewPreviousAction);

        View.OnClickListener listener = new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.button0: {
                        doNumber("0");
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
                        doFunction("lg(");
                        break;
                    }
                    case R.id.buttonLN: {
                        doFunction("ln(");
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
                        initVariables();
                        break;
                    }
                    case R.id.buttonC: {
                        String s = textView.getText().toString();

                        if (!s.equals("")) {
                            String kek = textView.getText().toString();
                            switch (kek.substring(kek.length() - 1)) {
                                case "0":
                                case "1":
                                case "2":
                                case "3":
                                case "4":
                                case "5":
                                case "6":
                                case "7":
                                case "8":
                                case "9": {
                                    if (s.length() > 1) {
                                        textView.setText(s.substring(0, s.length() - 1));
                                        switch (kek.charAt(kek.length() - 2)) {
                                            case '+':
                                            case '-':
                                            case '*':
                                            case '/':
                                            case '(': {
                                                textView.setText(s.substring(0, s.length() - 1));
                                                isInputNumber = false;
                                                isInputOperator = true;
                                                break;
                                            }
                                            default: {
                                                textView.setText(s.substring(0, s.length() - 1));
                                                break;
                                            }
                                        }
                                    } else if (s.length() == 1) {
                                        textView.setText("");
                                        initVariables();
                                        isInputOperator=true;
                                    }
                                    break;
                                }

                                case "-": {
                                    if (s.length() == 1) {
                                        textView.setText(s.substring(0, s.length() - 1));
                                    } else if (kek.substring(kek.length() - 2).equals("(-")) {

                                        textView.setText(s.substring(0, s.length() - 1));
                                    } else {
                                        isInputOperator = false;
                                        textView.setText(s.substring(0, s.length() - 1));
                                    }
                                    break;
                                }
                                case "+":
                                case "/":
                                case "*": {
                                    isInputOperator = false;
                                    textView.setText(s.substring(0, s.length() - 1));
                                    break;
                                }
                                case "!": {
                                    textView.setText(s.substring(0, s.length() - 1));
                                    break;
                                }
                                case "π":
                                case "e": {
                                    textView.setText(s.substring(0, s.length() - 1));
                                    isInputPIorE = false;
                                    isInputOperator = true;
                                    break;
                                }
                                case ".": {
                                    textView.setText(s.substring(0, s.length() - 1));
                                    isInputDot = false;
                                    break;
                                }
                                case ")": {
                                    textView.setText(s.substring(0, s.length() - 1));
                                    countHooks++;
                                    break;
                                }
                                case "(": {
                                    if (kek.length() == 1) {
                                        textView.setText(s.substring(0, s.length() - 1));
                                        countHooks--;
                                    } else {
                                        switch (kek.substring(kek.length() - 2)) {
                                            case "^(":
                                            case "√(": {
                                                textView.setText(s.substring(0, s.length() - 2));
                                                countHooks--;
                                                break;
                                            }

                                            case "n(": {
                                                textView.setText(s.substring(0, s.length()
                                                        - (kek.substring(kek.length() - 3).equals("ln(")
                                                        ? 3 : 4)));
                                                countHooks--;
                                                break;
                                            }

                                            case "s(": {
                                                textView.setText(s.substring(0, s.length() - 4));
                                                countHooks--;
                                                break;
                                            }
                                            case "g(": {
                                                textView.setText(s.substring(0, s.length() - 3));
                                                countHooks--;
                                                break;
                                            }
                                            default: {
                                                textView.setText(s.substring(0, s.length() - 1));
                                                countHooks--;
                                                break;
                                            }
                                        }
                                    }
                                    break;
                                }
                            }
                        }
                        break;
                    }

                    case R.id.buttonSquareRoot: {
                        doFunction("√(");
                        break;
                    }
                    case R.id.buttonHooks: {
                        if ((isInputPIorE | isInputNumber) & !isInputOperator) {
                            if (countHooks == 0) {
                                textView.setText(textView.getText() + "*(");
                                isInputOperator = true;
                                countHooks++;
                            } else if (countHooks > 0) {
                                textView.setText(textView.getText() + ")");
                                countHooks--;
                            }
                        } else if (isInputOperator) {
                            textView.setText(textView.getText() + "(");
                            countHooks++;
                        }
                        break;
                    }
                    case R.id.buttonSquared2: {
                        textView.setText(textView.getText() + "^(2)");
                        break;
                    }

                    case R.id.buttonFactorial: {
                        textView.setText(textView.getText() + "!");
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
                            } else if (isInputPIorE) {
                                textView.setText(textView.getText() + "*0.");
                            } else {
                                textView.setText(textView.getText() + "0.");
                            }
                            isInputDot = true;
                            isInputPIorE = false;
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
                        if (textView.getText().equals("")) {
                            textView.setText("-");
                        } else if ((textView.getText().charAt(textView.getText().length() - 1)) == '(') {
                            textView.setText(textView.getText() + "-");
                        } else {
                            doOperator("-");
                        }
                        break;
                    }
                    case R.id.buttonEqual: {
                        oldTextView.setText(textView.getText());
                        String result = "Error";
                        try {
                            result = parser.getExpression(Parser.prepareStr(textView.getText().toString()));

                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        initVariables();
                        if (Operation.isDouble(result)) {
                            isInputNumber = true;
                            isInputDot = true;
                            isInputOperator = false;
                        }

                        textView.setText(result);
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

        Button buttonPercent = findViewById(R.id.buttonFactorial);
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
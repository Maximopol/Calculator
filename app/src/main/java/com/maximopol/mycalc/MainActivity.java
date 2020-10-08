package com.maximopol.mycalc;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView,oldTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println("Start");

        textView = (TextView) findViewById(R.id.textViewCurrentAction);
        oldTextView= (TextView)findViewById(R.id.textViewPreviousAction);

        View.OnClickListener listener = new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.button0: {
                        textView.setText(textView.getText() + "0");
                        break;
                    }
                    case R.id.button1: {
                        textView.setText(textView.getText() + "1");
                        break;
                    }
                    case R.id.button2: {
                        textView.setText(textView.getText() + "2");
                        break;
                    }
                    case R.id.button3: {
                        textView.setText(textView.getText() + "3");
                        break;
                    }
                    case R.id.button4: {
                        textView.setText(textView.getText() + "4");
                        break;
                    }
                    case R.id.button5: {
                        textView.setText(textView.getText() + "5");
                        break;
                    }
                    case R.id.button6: {
                        textView.setText(textView.getText() + "6");
                        break;
                    }
                    case R.id.button7: {
                        textView.setText(textView.getText() + "7");
                        break;
                    }
                    case R.id.button8: {
                        textView.setText(textView.getText() + "8");
                        break;
                    }
                    case R.id.button9: {
                        textView.setText(textView.getText() + "9");
                        break;
                    }
                    //=============================================
                    case R.id.buttonLG: {
                        textView.setText(textView.getText() + "ln(");
                        break;
                    }
                    case R.id.buttonLN: {
                        textView.setText(textView.getText() + "lg(");
                        break;
                    }
                    case R.id.buttonTan: {
                        textView.setText(textView.getText() + "tan(");
                        break;
                    }
                    case R.id.buttonCos: {
                        textView.setText(textView.getText() + "cos(");
                        break;
                    }
                    case R.id.buttonSin: {
                        textView.setText(textView.getText() + "sin(");
                        break;
                    }
                    case R.id.buttonCA: {
                        textView.setText("");
                        break;
                    }
                    case R.id.buttonC: {
                        String s = textView.getText().toString();

                        textView.setText((s == null || s.length() == 0)
                                ? null
                                : (s.substring(0, s.length() - 1)));
                        break;
                    }
                    case R.id.buttonSquareRoot: {
                        textView.setText(textView.getText() + "√");
                        break;
                    }
                    case R.id.buttonHooks: {
                        textView.setText(textView.getText() + "(");
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
                        break;
                    }
                    case R.id.buttonPI: {
                        textView.setText(textView.getText() + "π");
                        break;
                    }
                    case R.id.buttonDot: {
                        textView.setText(textView.getText() + "(");
                        break;
                    }
                    case R.id.buttonE: {
                        textView.setText(textView.getText() + "e");
                        break;
                    }
                    case R.id.buttonDivide: {
                        textView.setText(textView.getText() + "/");
                        break;
                    }
                    case R.id.buttonMultiply: {
                        textView.setText(textView.getText() + "*");
                        break;
                    }
                    case R.id.buttonSubtract: {
                        textView.setText(textView.getText() + "-");
                        break;
                    }
                    case R.id.buttonPlus: {
                        textView.setText(textView.getText() + "+");
                        break;
                    }


                    case R.id.buttonEqual: {

                        oldTextView.setText(textView.getText());
                        // textView.setText(textView.getText() + "8");
                        break;
                    }
                }
            }
        };

        Button button0 = (Button) findViewById(R.id.button0);
        button0.setOnClickListener(listener);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(listener);

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(listener);

        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(listener);

        Button button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(listener);

        Button button5 = (Button) findViewById(R.id.button5);
        button5.setOnClickListener(listener);

        Button button6 = (Button) findViewById(R.id.button6);
        button6.setOnClickListener(listener);

        Button button7 = (Button) findViewById(R.id.button7);
        button7.setOnClickListener(listener);

        Button button8 = (Button) findViewById(R.id.button8);
        button8.setOnClickListener(listener);

        Button button9 = (Button) findViewById(R.id.button9);
        button9.setOnClickListener(listener);

        Button buttonLG = (Button) findViewById(R.id.buttonLG);
        buttonLG.setOnClickListener(listener);

        Button buttonLN = (Button) findViewById(R.id.buttonLN);
        buttonLN.setOnClickListener(listener);

        Button buttonTan = (Button) findViewById(R.id.buttonTan);
        buttonTan.setOnClickListener(listener);

        Button buttonCos = (Button) findViewById(R.id.buttonCos);
        buttonCos.setOnClickListener(listener);

        Button buttonSin = (Button) findViewById(R.id.buttonSin);
        buttonSin.setOnClickListener(listener);

        Button buttonCA = (Button) findViewById(R.id.buttonCA);
        buttonCA.setOnClickListener(listener);

        Button buttonC = (Button) findViewById(R.id.buttonC);
        buttonC.setOnClickListener(listener);

        Button buttonSquareRoot = (Button) findViewById(R.id.buttonSquareRoot);
        buttonSquareRoot.setOnClickListener(listener);

        Button buttonHooks = (Button) findViewById(R.id.buttonHooks);
        buttonHooks.setOnClickListener(listener);

        Button buttonSquared2 = (Button) findViewById(R.id.buttonSquared2);
        buttonSquared2.setOnClickListener(listener);

        Button buttonPercent = (Button) findViewById(R.id.buttonPercent);
        buttonPercent.setOnClickListener(listener);

        Button buttonSquaredByY = (Button) findViewById(R.id.buttonSquaredByY);
        buttonSquaredByY.setOnClickListener(listener);

        Button buttonPI = (Button) findViewById(R.id.buttonPI);
        buttonPI.setOnClickListener(listener);

        Button buttonDivide = (Button) findViewById(R.id.buttonDivide);
        buttonDivide.setOnClickListener(listener);

        Button buttonE = (Button) findViewById(R.id.buttonE);
        buttonE.setOnClickListener(listener);

        Button buttonDot = (Button) findViewById(R.id.buttonDot);
        buttonDot.setOnClickListener(listener);

        Button buttonMultiply = (Button) findViewById(R.id.buttonMultiply);
        buttonMultiply.setOnClickListener(listener);

        Button buttonSubtract = (Button) findViewById(R.id.buttonSubtract);
        buttonSubtract.setOnClickListener(listener);

        Button buttonPlus = (Button) findViewById(R.id.buttonPlus);
        buttonPlus.setOnClickListener(listener);

        Button buttonEqual = (Button) findViewById(R.id.buttonEqual);
        buttonEqual.setOnClickListener(listener);
    }
}
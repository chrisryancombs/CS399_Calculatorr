package com.example.ryan.cs399_calculatorr;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Button;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    int x = 2;

    String firstNum;
    String secondNum;
    String currentOperator;

    TextView ans;
    TextView op;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstNum = "0";
        secondNum = "0";
        currentOperator = "=";

        ans = (TextView) findViewById(R.id.answer);
        ans.setText("0");

        op = (TextView) findViewById(R.id.operator);
        op.setText("=");

    }

    public void numBtnClk(View view) {
        Button current = (Button) view;
        String numChar = current.getText().toString();

        if (currentOperator.equals("=")) {
            if (firstNum.contains(".") && numChar.equals(".")) { return; }
            if (firstNum.equals("0")) { firstNum = numChar; }
            else { firstNum += numChar; }
            ans.setText(firstNum);

        }
        else {
            if (secondNum.contains(".") && numChar.equals(".")) { return; }
            if (secondNum.equals("0")) { secondNum = numChar; }
            else { secondNum += numChar; }
            ans.setText(secondNum);
        }
    }

    public void opBtnClk(View view) {
        Button current = (Button) view;

        currentOperator = current.getText().toString();
        op.setText(currentOperator);
    }

    public void delBtnClk(View view) {
        String currentAns = ans.getText().toString();

        if (!currentAns.equals("")) {
            String newAns = currentAns.substring(0, currentAns.length() - 1);

            if (currentOperator.equals("=")) {
                firstNum = newAns;
            }
            else {
                secondNum = newAns;
            }

            ans.setText(newAns);
        }

    }

    public void clrBtnClk(View view) {
        firstNum = "0";
        secondNum = "0";
        currentOperator = "=";

        op.setText(currentOperator);
        ans.setText(firstNum);

    }

    public void eqBtnClk(View view) {
        double firstVal = Double.parseDouble(firstNum);
        double secondVal = Double.parseDouble(secondNum);
        double finalAnswer;

        if (currentOperator.equals("+")) {
            finalAnswer = firstVal + secondVal;
        }
        else if (currentOperator.equals("-")) {
            finalAnswer = firstVal - secondVal;
        }
        else if (currentOperator.equals("x")) {
            finalAnswer = firstVal * secondVal;
        }
        else if (currentOperator.equals("/")) {
            if (secondVal == 0.0) {
                firstNum = "0";
                secondNum = "0";
                op.setText("=");
                ans.setText("pls no... 0");
                return;
            }
            finalAnswer = firstVal / secondVal;
        }
        else {
            finalAnswer = 666.666;
        }

        firstNum = Double.toString(finalAnswer);
        secondNum = "0";

        op.setText("=");
        ans.setText(Double.toString(finalAnswer));
    }
}

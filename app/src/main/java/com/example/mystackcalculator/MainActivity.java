package com.example.mystackcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private TextView editText;
    private Button clrBtn, delBtn, equalsBtn;
    private Button zeroBtn, oneBtn, twoBtn, threeBtn, fourBtn, fiveBtn, sixBtn, sevenBtn, eightBtn, nineBtn;
    private Button openParBtn, closeParBtn;
    private Button pointBtn, plusBtn, minusBtn, multiplyBtn, divideBtn, powerBtn;
    private InfixExpressionEvaluator<String> s = new InfixExpressionEvaluator<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (TextView) findViewById(R.id.editText);

        clrBtn = (Button) findViewById(R.id.clrBtn);
        delBtn = (Button) findViewById(R.id.delBtn);
        equalsBtn = (Button) findViewById(R.id.equalsBtn);

        pointBtn = (Button) findViewById(R.id.pointBtn);
        plusBtn = (Button) findViewById(R.id.plusBtn);
        minusBtn = (Button) findViewById(R.id.minusBtn);
        multiplyBtn = (Button) findViewById(R.id.multiplyBtn);
        divideBtn = (Button) findViewById(R.id.divideBtn);
        powerBtn = (Button) findViewById(R.id.powerBtn);

        openParBtn = (Button) findViewById(R.id.openParBtn);
        closeParBtn = (Button) findViewById(R.id.closeParBtn);

        zeroBtn = (Button) findViewById(R.id.zeroBtn);
        oneBtn = (Button) findViewById(R.id.oneBtn);
        twoBtn = (Button) findViewById(R.id.twoBtn);
        threeBtn = (Button) findViewById(R.id.threeBtn);
        fourBtn = (Button) findViewById(R.id.fourBtn);
        fiveBtn = (Button) findViewById(R.id.fiveBtn);
        sixBtn = (Button) findViewById(R.id.sixBtn);
        sevenBtn = (Button) findViewById(R.id.sevenBtn);
        eightBtn = (Button) findViewById(R.id.eightBtn);
        nineBtn = (Button) findViewById(R.id.nineBtn);
    }

    public void onOperator(View view){
         if (view.getId() == R.id.openParBtn)
             editText.append(" ( ");
        else if (view.getId() == R.id.closeParBtn)
             editText.append(" ) ");
        else if (view.getId() == R.id.plusBtn)
             editText.append(" + ");
        else if (view.getId() == R.id.minusBtn)
             editText.append(" - ");
        else if (view.getId() == R.id.multiplyBtn)
             editText.append(" * ");
        else if (view.getId() == R.id.divideBtn)
             editText.append(" / ");
        else if (view.getId() == R.id.powerBtn)
             editText.append(" ^ ");
    }

    public void onNumber(View view){
        if (view.getId() == R.id.zeroBtn)
            editText.append("0");
        else if (view.getId() == R.id.oneBtn)
            editText.append("1");
        else if (view.getId() == R.id.twoBtn)
            editText.append("2");
        else if (view.getId() == R.id.threeBtn)
            editText.append("3");
        else if (view.getId() == R.id.fourBtn)
            editText.append("4");
        else if (view.getId() == R.id.fiveBtn)
            editText.append("5");
        else if (view.getId() == R.id.sixBtn)
            editText.append("6");
        else if (view.getId() == R.id.sevenBtn)
            editText.append("7");
        else if (view.getId() == R.id.eightBtn)
            editText.append("8");
        else if (view.getId() == R.id.nineBtn)
            editText.append("9");
        else if (view.getId() == R.id.pointBtn)
            editText.append(".");

    }

    public void onEquals(View v){
            String currStr = editText.getText().toString();
            editText.setText(s.evaluateInfix(currStr));
    }

    public void onDel(View v) {
        if (v.getId() == R.id.clrBtn) {
            editText.setText("");
        }
        else{
            //if there are characters to delete
            if (editText.length() > 0) {
                String currStr = editText.getText().toString();
                    //if last char is not a ' ' then it's a number
                    //deleting a number i.e + 5 or + 25
                    if(currStr.charAt(currStr.length() - 1) != ' ')
                        currStr = currStr.substring(0, currStr.length() - 1);
                    else{
                        currStr = currStr.substring(0, currStr.length() - 3);
                    }

                editText.setText(currStr);
            }
            else {
                editText.setText("");
            }
        }
    }

}
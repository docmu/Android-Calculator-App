package com.example.mystackcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private Button clrBtn, delBtn, equalsBtn;
    private Button zeroBtn, oneBtn, twoBtn, threeBtn, fourBtn, fiveBtn, sixBtn, sevenBtn, eightBtn, nineBtn;
    private Button openParBtn, closeParBtn;
    private Button pointBtn, plusBtn, minusBtn, multiplyBtn, divideBtn, powerBtn;
    private InfixExpressionEvaluator<String> s = new InfixExpressionEvaluator<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);

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
            editText.setText(editText.getText() + " ( ");
        else if (view.getId() == R.id.closeParBtn)
            editText.setText(editText.getText() + " ) ");
        else if (view.getId() == R.id.plusBtn)
            editText.setText(editText.getText() + " + ");
        else if (view.getId() == R.id.minusBtn)
            editText.setText(editText.getText() + " - ");
        else if (view.getId() == R.id.multiplyBtn)
            editText.setText(editText.getText() + " * ");
        else if (view.getId() == R.id.divideBtn)
            editText.setText(editText.getText() + " / ");
        else if (view.getId() == R.id.powerBtn)
            editText.setText(editText.getText() + " ^ ");
    }

    public void onNumber(View view){
        if (view.getId() == R.id.zeroBtn)
            editText.setText(editText.getText() + "0");
        else if (view.getId() == R.id.oneBtn)
            editText.setText(editText.getText() + "1");
        else if (view.getId() == R.id.twoBtn)
            editText.setText(editText.getText() + "2");
        else if (view.getId() == R.id.threeBtn)
            editText.setText(editText.getText() + "3");
        else if (view.getId() == R.id.fourBtn)
            editText.setText(editText.getText() + "4");
        else if (view.getId() == R.id.fiveBtn)
            editText.setText(editText.getText() + "5");
        else if (view.getId() == R.id.sixBtn)
            editText.setText(editText.getText() + "6");
        else if (view.getId() == R.id.sevenBtn)
            editText.setText(editText.getText() + "7");
        else if (view.getId() == R.id.eightBtn)
            editText.setText(editText.getText() + "8");
        else if (view.getId() == R.id.nineBtn)
            editText.setText(editText.getText() + "9");
        else if (view.getId() == R.id.pointBtn)
            editText.setText(editText.getText() + ".");
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
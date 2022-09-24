package com.example.calculator.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.button.MaterialButton;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
MaterialButton btnAc,btnPersentage,btnDivition,btn7,btn8,btn9,btn4,btn5,btn6,btn1,btn2,btn3,btnDot,btn0,btn00,btnEqual,btnMultiply,btnMinus,btnPlus;
MaterialButton clear;
TextView InputTv,OutputTv;
ImageButton aboutBtn;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InputTv=findViewById(R.id.txt_inputText);
        OutputTv=findViewById(R.id.txt_solutionText);
        aboutBtn = findViewById(R.id.info);
        aboutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,AboutActivity.class);
                startActivity(i);
                finish();
            }
        });
        assignId(clear,R.id.c);
        assignId(btnAc,R.id.btn_AC);
        assignId(btnPersentage,R.id.btn_persent);
        assignId(btnDivition,R.id.btn_devide);
        assignId(btn1,R.id.btn_1);
        assignId(btn2,R.id.btn_2);
        assignId(btn3,R.id.btn_3);
        assignId(btn4,R.id.btn_4);
        assignId(btn5,R.id.btn_5);
        assignId(btn6,R.id.btn_6);
        assignId(btn7,R.id.btn_7);
        assignId(btn8,R.id.btn_8);
        assignId(btn9,R.id.btn_9);
        assignId(btn0,R.id.btn_0);
        assignId(btn00,R.id.btn_00);
        assignId(btnEqual,R.id.btn_equal);
        assignId(btnPlus,R.id.btn_plus);
        assignId(btnMinus,R.id.btn_minus);
        assignId(btnMultiply,R.id.btn_multiply);
        assignId(btnDot,R.id.btn_dot);
    }

    public void assignId(MaterialButton btn,int id){
        btn = findViewById(id);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        MaterialButton button =(MaterialButton) view;
        String buttonText = button.getText().toString();
        String dataToCalculate = InputTv.getText().toString();
        if(buttonText.equals("ac")){
            InputTv.setText("");
            OutputTv.setText("0");
            return;
        }else if(buttonText.equals("c")){
            if(InputTv.getText().toString().isEmpty()){
                Toast.makeText(this, "No Value to Erase", Toast.LENGTH_SHORT).show();
            }
            else{
            dataToCalculate = dataToCalculate.substring(0,dataToCalculate.length()-1);
            }
        }else if(buttonText.equals("=")){
            InputTv.setText(OutputTv.getText());
            return;
        }else if(buttonText.equals("%")){
            Toast.makeText(this, "Coming Soon..", Toast.LENGTH_SHORT).show();
        }
        else {
            dataToCalculate = dataToCalculate + buttonText;
        }
        InputTv.setText(dataToCalculate);
        String finalResult = getResult(dataToCalculate);

        if(!finalResult.equals("Err")){
            OutputTv.setText(finalResult);
        }
    }


    String getResult(String data){
        try{
            Context context  = Context.enter();
            context.setOptimizationLevel(-1);
            Scriptable scriptable = context.initStandardObjects();
            String finalResult =  context.evaluateString(scriptable,data,"Javascript",1,null).toString();
            if(finalResult.endsWith(".0")){
                finalResult = finalResult.replace(".0","");
            }
            return finalResult;
        }catch (Exception e){
            return "Err";
        }
    }

}
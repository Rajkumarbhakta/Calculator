package com.example.calculator.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.text.DecimalFormat;


public class MainActivity extends AppCompatActivity {
    Button add, subtract, multiply, divied;
    TextView ans;
    EditText firstValue, secondValue;
    DecimalFormat df=new DecimalFormat("0.000");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firstValue = findViewById(R.id.editFirstValue);
        secondValue = findViewById(R.id.editSecondValue);
        ans = findViewById(R.id.Answer);
        add = findViewById(R.id.btPlus);
        subtract = findViewById(R.id.btMinus);
        multiply = findViewById(R.id.btMultiplication);
        divied = findViewById(R.id.btdivition);

        Toast.makeText(this, "To use calculator enter the First value then Second value and press the operation button", Toast.LENGTH_LONG).show();

        add.setOnClickListener(new View.OnClickListener() {
                                   @SuppressLint("DefaultLocale")
                                   @Override
                                   public void onClick(View view) {
                                       double first, second, Ans;
                                       first = Double.parseDouble(firstValue.getText().toString());
                                       second = Double.parseDouble(secondValue.getText().toString());
                                       Ans = first + second;
                                       String result;
                                       result= Double.toString(Ans);
                                       if(result.endsWith(".0")){
                                           result=result.replace(".0","");
                                       }
                                       ans.setText(result);
                                   }
                               }
        );
        subtract.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            double first, second, Ans;
                                            if (firstValue.getText().toString().isEmpty()|| secondValue.getText().toString().isEmpty()) {
                                                Toast.makeText(MainActivity.this, "Enter first and Second value", Toast.LENGTH_SHORT).show();
                                            } else {
                                                first = Double.parseDouble(firstValue.getText().toString());
                                                second = Double.parseDouble(secondValue.getText().toString());
                                                Ans = first - second;
                                                String result ;
                                                result= Double.toString(Ans);
                                                if(result.endsWith(".0")){
                                                    result=result.replace(".0","");
                                                }
                                                ans.setText(result);
                                            }
                                        }
                                    }
        );
        multiply.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            double first, second, Ans;
                                            if (firstValue.getText().toString().isEmpty()|| secondValue.getText().toString().isEmpty()) {
                                                Toast.makeText(MainActivity.this, "Enter first and Second value", Toast.LENGTH_SHORT).show();
                                            } else {
                                                first = Double.parseDouble(firstValue.getText().toString());
                                                second = Double.parseDouble(secondValue.getText().toString());
                                                Ans = first * second;
                                                String result;
                                                result= Double.toString(Ans);
                                                if(result.endsWith(".0")){
                                                    result=result.replace(".0","");
                                                }
                                                ans.setText(result);
                                            }
                                        }
                                    }
        );
        divied.setOnClickListener(new View.OnClickListener() {
                                      @SuppressLint("DefaultLocale")
                                      @Override
                                      public void onClick(View view) {
                                          double first, second, Ans;
                                          if (firstValue.getText().toString().isEmpty()|| secondValue.getText().toString().isEmpty()) {
                                              Toast.makeText(MainActivity.this, "Enter first and Second value", Toast.LENGTH_SHORT).show();
                                          } else {
                                              first = Double.parseDouble(firstValue.getText().toString());
                                              second = Double.parseDouble(secondValue.getText().toString());
                                              Ans = first / second;
                                              String result ;
                                              result= Double.toString(Ans);
                                              if(result.endsWith(".0")){
                                                  result=result.replace(".0","");
                                              }
                                              ans.setText(result);
                                          }
                                      }
                                  }
        );
    }
}
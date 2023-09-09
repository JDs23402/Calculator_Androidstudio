package com.example.calc3;


import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText txtvalue;
    Button clear;
    String operatorvalue;
    boolean isNewOperation=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtvalue=findViewById(R.id.calculator_txt_valuetext);
        clear=findViewById(R.id.calculator_btn_clear);
        txtvalue.setShowSoftInputOnFocus(false);
        txtvalue.setSingleLine(false);

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtvalue.setText("");
            }
        });
    }
    public void numberClick(View view)
    {
        String value=txtvalue.getText().toString();
        if(isNewOperation)
        {
            isNewOperation=false;
            txtvalue.setText("");
        }
        switch(view.getId())
        {
            case R.id.calculator_btn_zero:
                value+="0";
                break;
            case R.id.calculator_btn_One:
                value+="1";
                break;
            case R.id.calculator_btn_Two:
                value+="2";
                break;
            case R.id.calculator_btn_Three:
                value+="3";
                break;
            case R.id.calculator_btn_four:
                value+="4";
                break;
            case R.id.calculator_btn_five:
                value+="5";
                break;
            case R.id.calculator_btn_six:
                value+="6";
                break;
            case R.id.calculator_btn_seven:
                value+="7";
                break;
            case R.id.calculator_btn_eight:
                value+="8";
                break;
            case R.id.calculator_btn_nine:
                value+="9";
                break;
            case R.id.calculator_btn_dot:
                value+=".";
                break;
        }
        txtvalue.setText(value);
    }

    public void operatorClick(View view)
    {
        String value=txtvalue.getText().toString();
        switch(view.getId())
        {
            case R.id.calculator_btn_add:
                value+="+";
                operatorvalue="+";
                break;
            case R.id.calculator_btn_subtract:
                value+="-";
                operatorvalue="-";
                break;
            case R.id.calculator_btn_multiple:
                value+="*";
                operatorvalue="*";
                break;
            case R.id.calculator_btn_divide:
                value+="/";
                operatorvalue="/";
                break;
        }
        txtvalue.setText(value);
    }

    public void equalsClick(View view)
    {
        String value=txtvalue.getText().toString();
        double cal=0.0;
        String[] seperated;

        switch (operatorvalue)
        {
            case "+":
                seperated=value.split("\\+");
                cal=Double.parseDouble(seperated[0])+Double.parseDouble(seperated[1]);
                break;
            case "-":
                seperated=value.split("-");
                cal=Double.parseDouble(seperated[0])-Double.parseDouble(seperated[1]);
                break;
            case "*":
                seperated=value.split("\\*");
                cal=Double.parseDouble(seperated[0])*Double.parseDouble(seperated[1]);
                break;
            case "/":
                seperated=value.split("/");
                cal=Double.parseDouble(seperated[0])/Double.parseDouble(seperated[1]);
                break;
        }
        String finalvalue=String.format("%.2f",cal);
        txtvalue.setText(value+"\n"+finalvalue);
        isNewOperation=true;
    }
}
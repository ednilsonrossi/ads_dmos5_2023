package com.ednilsonrossi.app1_conversormoeda;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private final double DOLLAR_VALUE = 5.8;

    private EditText valueEditText;
    private Button converterbButton;
    private TextView convertedValueTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        valueEditText = findViewById(R.id.edittext_value);
        convertedValueTextView = findViewById(R.id.textview_value_converted);

        converterbButton = findViewById(R.id.button_converter);
        converterbButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view == converterbButton){
            getConvertion();
        }
    }

    private void getConvertion(){
        double value;
        String valueString;

        valueString = valueEditText.getText().toString();

        try {
            value = Double.valueOf(valueString);
        }catch (NumberFormatException e){
            Toast.makeText(this, "Valor digitado é inválido.", Toast.LENGTH_SHORT).show();
            value = 0;
        }

        value = value / DOLLAR_VALUE;

        convertedValueTextView.setText(String.valueOf(value));
    }
}
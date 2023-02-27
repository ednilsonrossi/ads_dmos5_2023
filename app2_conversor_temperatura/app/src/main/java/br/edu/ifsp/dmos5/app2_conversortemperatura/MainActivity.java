package br.edu.ifsp.dmos5.app2_conversortemperatura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import br.edu.ifsp.dmos5.app2_conversortemperatura.model.CelciusStrategy;
import br.edu.ifsp.dmos5.app2_conversortemperatura.model.ConversorTemperatura;
import br.edu.ifsp.dmos5.app2_conversortemperatura.model.FahrenheitStrategy;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText inputEditText;
    private TextView outputTextView;
    private Button toCelsiusButton;
    private Button toFahrenheitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputEditText = findViewById(R.id.edittext_input);
        outputTextView = findViewById(R.id.textview_output);
        toCelsiusButton = findViewById(R.id.button_to_celsius);
        toFahrenheitButton = findViewById(R.id.button_to_fahrenheit);
        toCelsiusButton.setOnClickListener(this);
        toFahrenheitButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button_to_celsius:
                process(FahrenheitStrategy.getInstance());
                break;

            case R.id.button_to_fahrenheit:
                process(CelciusStrategy.getInstance());
                break;
        }
    }

    private void process(ConversorTemperatura strategy){
        double value;
        String s = inputEditText.getText().toString();
        try{
            value = Double.valueOf(s);
        } catch (NumberFormatException nfException){
            value = 0;
            Toast.makeText(this, getString(R.string.invalid_temp_message), Toast.LENGTH_SHORT).show();
        }
        value = strategy.getConvertion(value);
        outputTextView.setText(String.format("%.2f %s", value, strategy.getDegres()));
    }
}
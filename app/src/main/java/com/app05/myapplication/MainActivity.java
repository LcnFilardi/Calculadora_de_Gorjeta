package com.app05.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private SeekBar seekBarGorjeta;
    private TextView textGorjeta;
    private TextView textTotal;
    private TextView textPorcentagem;
    private EditText editValor;

    private double porcentagem=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBarGorjeta  = findViewById(R.id.seekBarGorjeta);
        textGorjeta     = findViewById(R.id.textGorjeta);
        textTotal       = findViewById(R.id.textTotal);
        textPorcentagem = findViewById(R.id.textPorcentagem);
        editValor       = findViewById(R.id.editValor);

        // adicionar listener seekbar
        seekBarGorjeta.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    porcentagem = progress;
                    textPorcentagem.setText( Math.round(porcentagem) + "%");
                    calcular();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    public void calcular(){
        String valorRecuperado = editValor.getText().toString();
        if(valorRecuperado == null || valorRecuperado.equals("")){

            Toast.makeText(
                    getApplicationContext(),
                    "Digite um valor primeiro!",
                    Toast.LENGTH_LONG
            ).show();

        }else {
            //Converter string para double
            double valorDigitado = Double.parseDouble(valorRecuperado);

            //Calcula a gorjeta total
            double gorjeta = valorDigitado * ( porcentagem/100 );
            double total = gorjeta + valorDigitado;

            //Exibe a gorjeta e o total
            //textGorjeta.setText("R$" + Math.round(gorjeta));
            textGorjeta.setText("R$" + gorjeta);
            textTotal.setText("R$" + total);
        }
    }
}

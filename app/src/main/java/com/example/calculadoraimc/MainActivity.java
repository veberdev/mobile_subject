package com.example.calculadoraimc;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    EditText pesoEditText;
    EditText alturaEditText;
    TextView resultadoTextView;
    @SuppressLint("DefaultLocale")
    public void calcularButtonOnClick(View v) {
        //condicional solicitando os dois valores?
        EditText pesoEditText = findViewById(R.id.pesoEditText);
        String aux_peso = pesoEditText.getText().toString();

        EditText alturaEditText = findViewById(R.id.alturaEditText);
        String aux_altura = alturaEditText.getText().toString();

        TextView resultadoTextView = findViewById(R.id.resultadoTextView);

        if (aux_peso.isEmpty() || aux_altura.isEmpty()) {
            mostrarMensagemRequerCampos();
        } else {
            double peso = Double.parseDouble(aux_peso);
            double altura = Double.parseDouble(aux_altura) / 100.0;
            double resultado = peso / (altura * altura);

            mostrarMensagemCalculado();
            resultadoTextView.setText(String.format("%.2f", resultado));
        }

    };

    private void mostrarMensagemRequerCampos() {
        Toast.makeText(
                MainActivity.this,
                "É necessário preencher peso e altura!",
                Toast.LENGTH_LONG
        ).show();
    }

    private void mostrarMensagemCalculado() {
        Toast.makeText(
                MainActivity.this,
                "Calculado!",
                Toast.LENGTH_LONG
        ).show();
    }
}
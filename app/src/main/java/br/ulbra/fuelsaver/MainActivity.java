package br.ulbra.fuelsaver;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    TextView txtResultadoLitros, txtCusto;
    EditText edtNomeVeiculo, edtPlacaVeiculo, edtDistanciaPercorrida, edtConsumoMedVeiculo, edtPrecoLitro;
    Button btnCalcular;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        txtResultadoLitros = findViewById(R.id.txtResultadoLitros);
        txtCusto = findViewById(R.id.txtCusto);
        edtNomeVeiculo = findViewById(R.id.edtNomeVeiculo);
        edtPlacaVeiculo = findViewById(R.id.edtPlacaVeiculo);
        edtDistanciaPercorrida = findViewById(R.id.edtDistanciaPercorrida);
        edtConsumoMedVeiculo = findViewById(R.id.edtConsumoMedVeiculo);
        edtPrecoLitro = findViewById(R.id.edtPrecoLitro);
        btnCalcular = findViewById(R.id.btnCalcular);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double distancia, consumo, combustivel, precogas, resultado1,resultado2;
                try {
                    distancia = Double.parseDouble(edtDistanciaPercorrida.getText().toString());
                    consumo = Double.parseDouble(edtConsumoMedVeiculo.getText().toString());
                    precogas = Double.parseDouble(edtPrecoLitro.getText().toString());
                    resultado1 = distancia / consumo;
                    resultado2 = resultado1 * precogas;
                    txtResultadoLitros.setText("Litros necessários "+ resultado1 +" Litros");
                    txtCusto.setText("Custo da viagem $" +resultado2);

                } catch (NumberFormatException e) {
                    //Trata o erro caso algum campo esteja vazio ou tenha um valor inválido
                    Toast.makeText(view.getContext(), "Por favor, preencha ambos os campos com númros válidos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
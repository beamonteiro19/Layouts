package com.example.layouts;


import android.os.Bundle;
import android.view.View;

import android.widget.EditText;


import androidx.appcompat.app.AppCompatActivity;


import com.google.android.material.card.MaterialCardView;

public class BalaiodeLenha extends AppCompatActivity {

    private EditText edtConsumoTotal, edtCouvert, edtDividirConta, edtTotal, edtValorPessoa, edtTaxa;
    private MaterialCardView btnCalcular, valorCard, taxaCard, contaCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_balaiode_lenha);


        edtConsumoTotal = findViewById(R.id.edtConsumoTotal);
        edtCouvert = findViewById(R.id.edtCouvert);
        edtDividirConta = findViewById(R.id.edtDividirConta);
        edtTotal = findViewById(R.id.edtTotal);
        edtValorPessoa = findViewById(R.id.edtValorPessoa);
        edtTaxa = findViewById(R.id.edtTaxa);
        btnCalcular = findViewById(R.id.btnCalcular);
        valorCard = findViewById(R.id.valorCard);
        taxaCard = findViewById(R.id.taxaCard);
        contaCard = findViewById(R.id.contaCard);



        edtTaxa.setEnabled(false);
        edtTotal.setEnabled(false);
        edtValorPessoa.setEnabled(false);

        valorCard.setVisibility(View.GONE);
        taxaCard.setVisibility(View.GONE);
        contaCard.setVisibility(View.GONE);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                double consumoTotal = Double.parseDouble(edtConsumoTotal.getText().toString());
                double couvert = Double.parseDouble(edtCouvert.getText().toString());
                int dividirConta = Integer.parseInt(edtDividirConta.getText().toString());

                double totalConta = consumoTotal + couvert;

                double taxa = 0.1 * consumoTotal;

                totalConta += taxa;

                double valorPorPessoa = totalConta / dividirConta;

                edtTotal.setText(String.format("%.2f", totalConta));
                edtValorPessoa.setText(String.format("%.2f", valorPorPessoa));
                edtTaxa.setText(String.format("%.2f", taxa));

                //pra fazer aparecer depois do click
                valorCard.setVisibility(View.VISIBLE);
                taxaCard.setVisibility(View.VISIBLE);
                contaCard.setVisibility(View.VISIBLE);

            }
        });

    }
}

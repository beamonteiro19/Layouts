package com.example.layouts;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Pizza extends AppCompatActivity {

    private EditText edtPizza1, edtPizza2, edtPizza3, edtPizza4;


    private Button btnBuyPizza;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza);

        edtPizza1 = findViewById(R.id.edtPizza1);
        edtPizza2 = findViewById(R.id.edtPizza2);
        edtPizza3 = findViewById(R.id.edtPizza3);
        edtPizza4 = findViewById(R.id.edtPizza4);
        btnBuyPizza = findViewById(R.id.btnBuyPizza);


        btnBuyPizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                double totalPrice = calcTotal();

                dialogPrice(totalPrice);
            }
        });
    }

    private double calcTotal() {

        double pricePizza1 = 49.50;
        double pricePizza2 = 79.50;
        double pricePizza3 = 59.50;
        double pricePizza4 = 49.50;

        int quantPizza1 = Integer.parseInt(edtPizza1.getText().toString());
        int quantPizza2 = Integer.parseInt(edtPizza2.getText().toString());
        int quantPizza3 = Integer.parseInt(edtPizza3.getText().toString());
        int quantPizza4 = Integer.parseInt(edtPizza4.getText().toString());

        double totalPrice = (pricePizza1 * quantPizza1) +
                (pricePizza2 * quantPizza2) +
                (pricePizza3 * quantPizza3) +
                (pricePizza4 * quantPizza4);

        return totalPrice;
    }

    private void dialogPrice(double totalPrice) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Preço total: $" + String.format("%.2f", totalPrice))
                .setPositiveButton("OK", null)
                .show();
    }


}
package com.example.app_pde;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class TerceiraActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intrucoes);

        Button myButton = findViewById(R.id.continue_instrucao);

        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Criar um Intent para iniciar a SegundaActivity
                Intent intent = new Intent(TerceiraActivity.this, SegundaActivity.class);

                // Iniciar a SegundaActivity
                startActivity(intent);
            }
        });
    }
}

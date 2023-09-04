package com.example.app_pde;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class SegundaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        final Button botao1 = findViewById(R.id.botao1);
        final Button botao2 = findViewById(R.id.botao2);
        final Button botao3 = findViewById(R.id.botao3);
        final Button botao4 = findViewById(R.id.botao4);

        final Animation scaleAnimation = AnimationUtils.loadAnimation(this, R.anim.scale_animation);

        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Aplica a animação ao botão clicado
                view.startAnimation(scaleAnimation);
            }
        };

        botao1.setOnClickListener(clickListener);
        botao2.setOnClickListener(clickListener);
        botao3.setOnClickListener(clickListener);
        botao4.setOnClickListener(clickListener);
    }
}

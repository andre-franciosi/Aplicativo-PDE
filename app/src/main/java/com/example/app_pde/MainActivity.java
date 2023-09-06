package com.example.app_pde;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final Animation scaleAnimation = AnimationUtils.loadAnimation(this, R.anim.scale_animation);

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Aplica a animação ao botão clicado
                botao.startAnimation(scaleAnimation);

                // Define um AnimationListener para executar a ação após a animação
                scaleAnimation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        // Ação a ser executada quando a animação começa (opcional)
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        // Ação a ser executada após o término da animação
                        iniciarSegundaActivity(); // Função para iniciar a próxima atividade
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {
                        // Ação a ser executada quando a animação se repete (opcional)
                    }
                });
            }
        });
    }

    private void iniciarSegundaActivity() {
        // Criar uma Intent para iniciar a segunda atividade
        Intent intent = new Intent(MainActivity.this, SegundaActivity.class);
        startActivity(intent);
    }
}


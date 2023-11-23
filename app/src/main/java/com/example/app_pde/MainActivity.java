package com.example.app_pde;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cria uma animação de fade para a ImageView
                Animation fadeOut = new AlphaAnimation(1.0f, 0.0f);
                fadeOut.setDuration(1000); // Define a duração da animação em milissegundos

                // Aplica a animação à ImageView
                imageView.startAnimation(fadeOut);

                // Define um AnimationListener para executar a ação após a animação
                fadeOut.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        // Ação a ser executada quando a animação começa (opcional)
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        // Ação a ser executada após o término da animação
                        iniciarSegundaActivity(); // Navega para a SegundaActivity
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
        Intent intent = new Intent(MainActivity.this, TerceiraActivity.class);
        startActivity(intent);
    }
}

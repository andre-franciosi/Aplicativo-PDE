package com.example.app_pde;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import org.eclipse.paho.client.mqttv3.IMqttMessageListener;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class SegundaActivity extends AppCompatActivity {

    private Button botao1;
    private Animation scaleAnimation;
    private MqttManager mqttManager;
    private boolean buttonState = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        botao1 = findViewById(R.id.botao1);
        scaleAnimation = AnimationUtils.loadAnimation(this, R.anim.scale_animation);

        mqttManager = new MqttManager("192.168.238.185", "teste", "esp", "1234", 1883);

        botao1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(scaleAnimation);
                toggleButtonState();
                sendMessageToMQTT("APP_PDE", buttonState ? "1" : "0");
            }
        });

        setupMqttListener();
    }

    private void toggleButtonState() {
        buttonState = !buttonState;
        if (buttonState) {
            botao1.setText("On");
            botao1.setBackgroundResource(R.drawable.botao_redondo_on); // Altera o background para "On"
        } else {
            botao1.setText("Off");
            botao1.setBackgroundResource(R.drawable.botao_redondo_off); // Altera o background para "Off"
        }
    }


    private void sendMessageToMQTT(String topic, String message) {
        mqttManager.publishMessage(topic, message);
        showToast("Mensagem MQTT enviada com sucesso");
    }

    private void setupMqttListener() {
        mqttManager.subscribeToTopic("APP_PDE", new IMqttMessageListener() {
            @Override
            public void messageArrived(String topic, MqttMessage message) throws Exception {
                String mensagem = new String(message.getPayload());
                showToast("Mensagem MQTT Recebida: " + mensagem);
            }
        });
    }

    private void showToast(String message) {
        runOnUiThread(() -> {
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        });
    }
}

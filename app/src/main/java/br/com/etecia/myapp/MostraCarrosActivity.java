package br.com.etecia.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MostraCarrosActivity extends AppCompatActivity {
    TextView titMostraCarro;
    ImageView imgMostraCarro, idVoltar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.mostra_carros_layout);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        titMostraCarro = findViewById(R.id.titMostraCarros);
        imgMostraCarro = findViewById(R.id.imgMostraCarros);
        idVoltar = findViewById(R.id.idVoltar);

        Intent intent = getIntent();
        String titulo;
        int imagem;

        titulo = intent.getExtras().getString("Nome");
        imagem = intent.getExtras().getInt("Imagem");

        titMostraCarro.setText(titulo);
        imgMostraCarro.setImageResource(imagem);

        idVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();

            }
        });
    }
}
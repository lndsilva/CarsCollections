package br.com.etecia.myapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView idRecCarro;
    List<Carros> lstCarros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        idRecCarro = findViewById(R.id.idRecCarros);

        lstCarros = new ArrayList<>();
        lstCarros.add(new Carros("Antigo", R.drawable.antigoama));
        lstCarros.add(new Carros("Audi", R.drawable.audi));
        lstCarros.add(new Carros("Corrida", R.drawable.carrocorrida));
        lstCarros.add(new Carros("Old Car", R.drawable.carroold));
        lstCarros.add(new Carros("Ranger Car", R.drawable.carroranger));
        lstCarros.add(new Carros("Car Black", R.drawable.carrop));
        lstCarros.add(new Carros("Old Car Blue", R.drawable.carrovelhoazul));
        lstCarros.add(new Carros("Ferrari", R.drawable.ferrariama));
        lstCarros.add(new Carros("Fiat Red", R.drawable.fiatv));
        lstCarros.add(new Carros("Ford Colletion", R.drawable.ford));
        lstCarros.add(new Carros("Car Old Red", R.drawable.carrovelhoverm));
        lstCarros.add(new Carros("Lamborghini", R.drawable.lamborguine));
        lstCarros.add(new Carros("Fusca Blue", R.drawable.fuscaz));
        lstCarros.add(new Carros("Mercedes", R.drawable.mercedes));

        Adaptador adaptador = new Adaptador(getApplicationContext(), lstCarros);

        idRecCarro.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));

        idRecCarro.hasFixedSize();

        idRecCarro.setAdapter(adaptador);
    }
}
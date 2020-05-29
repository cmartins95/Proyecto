package com.example.rutapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.rutapp.adapter.AdapterRuta;
import com.example.rutapp.asynctask.AsyncTaskGetRutes;
import com.example.rutapp.model.Ruta;
import com.example.rutapp.util.UniversalImageLoader;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterRuta.IRutaListener{

    private AdapterRuta adapterRuta;
    private Spinner spnCategories;
    private RecyclerView rcvRutes;
    private AsyncTaskGetRutes atgr;
    private Button btnRefresh;

    private static String ALL_RUTES = "Totes les rutes";
    public static List<String> categories;
    public static List<Ruta> rutes;

    private void MontarRutes(){
        atgr = new AsyncTaskGetRutes(this);
        rutes = atgr.doInBackground();
        categories = new ArrayList<String>();
        categories.add(ALL_RUTES);
        for(Ruta r : rutes){
            if(!categories.contains(r.getCatNom())){
                categories.add(r.getCatNom());
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UniversalImageLoader uil = new UniversalImageLoader(this);
        uil.Inicializar();
        MontarRutes();

        spnCategories = findViewById(R.id.spnCategories);
        rcvRutes = findViewById(R.id.rcvRutes);
        btnRefresh = findViewById(R.id.btnRefresh);
        btnRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spnCategories.setSelection(0); //TOTES LES RUTES
                Filtrar();
            }
        });
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.spinner_categories,categories);
        adapter.setDropDownViewResource(R.layout.spinner_categories);
        spnCategories.setAdapter(adapter);
        spnCategories.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Filtrar();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) { }
        });
        rcvRutes.setHasFixedSize(true);
        rcvRutes.setLayoutManager(new LinearLayoutManager(this));
        rcvRutes.setAdapter(adapterRuta);
        Filtrar();
    }

    private void Filtrar() {
        String catSeleccionada = (String)spnCategories.getSelectedItem();
        List<Ruta> rutasFiltradas = new ArrayList<Ruta>();
        for(Ruta r : rutes){
            if(catSeleccionada.equals(ALL_RUTES)){
                rutasFiltradas.add(r);
            }else if(r.getCatNom().equals(catSeleccionada)){
                rutasFiltradas.add(r);
            }
        }
        adapterRuta = new AdapterRuta(this,rutasFiltradas,this);
        rcvRutes.setAdapter(adapterRuta);
    }

    @Override
    public void onRutaSelected(int position, Ruta ruta) {
        Intent i = new Intent(this,RutaActivity.class);
        i.putExtra(RutaActivity.POSITION_RUTA,position);
        startActivity(i);
    }

}

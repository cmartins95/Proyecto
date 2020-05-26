package com.example.rutapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Object categoriaSeleccionada;
    private List<Object> rutes;
    private AdapterRuta adapterRuta;

    private Spinner spnCategories;
    private RecyclerView rcvRutes;

    //Sustituir cuando se recuperen los datos de verdad
    private List<String> getCategories(){
        return null;
    }

    private List<String> getRutes(){
        return null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //CATEGORIES
        spnCategories = findViewById(R.id.spnCategories);
        rcvRutes = findViewById(R.id.rcvRutes);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.spinner_categories,getCategories());
        adapter.setDropDownViewResource(R.layout.spinner_categories);
        spnCategories.setAdapter(adapter);

        //RUTES
        rcvRutes.setHasFixedSize(true);
        rcvRutes.setLayoutManager(new LinearLayoutManager(this));
        if(getRutes()!=null && getRutes().size()!=0 && spnCategories.getSelectedItemPosition()!=-1){
            categoriaSeleccionada = spnCategories.getSelectedItem();
            rutes = null;
        }
        adapterRuta = new AdapterRuta(this,rutes);
        rcvRutes.setAdapter(adapterRuta);
    }
}

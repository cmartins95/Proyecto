package com.example.rutapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.rutapp.adapter.AdapterPunt;
import com.example.rutapp.asynctask.AsyncTaskGetPunts;
import com.example.rutapp.model.Punt;

import java.util.ArrayList;
import java.util.List;

import static com.example.rutapp.MainActivity.rutes;
import static com.example.rutapp.RutaActivity.POSITION_RUTA;

public class PuntsActivity extends AppCompatActivity {

    private List<Punt> punts;
    private AsyncTaskGetPunts atgp;
    private int pos;

    private AdapterPunt adapter;
    private RecyclerView rcvPunts;

    private void MontarPunts(){
        atgp = new AsyncTaskGetPunts(this,rutes.get(pos).getId());
        punts = atgp.doInBackground();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_punts);

        pos = getIntent().getIntExtra(POSITION_RUTA,-1);
        MontarPunts();

        rcvPunts = findViewById(R.id.rcvPunts);

        rcvPunts.setHasFixedSize(true);
        rcvPunts.setLayoutManager(new LinearLayoutManager(this));
        adapter = new AdapterPunt(this,punts);
        rcvPunts.setAdapter(adapter);
    }
}

package com.example.rutapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rutapp.R;
import com.example.rutapp.model.Punt;
import com.example.rutapp.model.Ruta;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

public class AdapterPunt extends RecyclerView.Adapter<AdapterPunt.MyViewHolder>{

    private Context context;
    private List<Punt> punts;
    private ImageLoader imgLoader;
    private int pos;

    public AdapterPunt(Context context, List<Punt> punts){
        this.context = context;
        this.punts = punts;
        this.imgLoader = ImageLoader.getInstance();
        this.pos = -1;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.punt,parent,false);
        view.setSelected(true);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tvwPuntNom.setText(punts.get(position).getNumero()+". "+punts.get(position).getNom());
        imgLoader.displayImage(punts.get(position).getFotUrl(),holder.ivwPuntImatge);
        if(punts.get(position).getHoraLong()!=null){
            holder.tvwPuntTemps.setText("Temps: "+punts.get(position).getHoraString());
        }else{
            holder.tvwPuntTemps.setText("Temps: -");
        }
        if(punts.get(position).getElevacio()!=null){
            holder.tvwPuntElevacio.setText("Elevació: "+punts.get(position).getElevacio());
        }else{
            holder.tvwPuntElevacio.setText("Elevació: -");
        }
        if(punts.get(position).getLongitud()!=null){
            holder.tvwPuntLongitud.setText("Longitud: "+punts.get(position).getLongitud());
        }else{
            holder.tvwPuntLongitud.setText("Longitud: -");
        }
        if(punts.get(position).getLatitud()!=null){
            holder.tvwPuntLatitud.setText("Latitud: "+punts.get(position).getLatitud());
        }else{
            holder.tvwPuntLatitud.setText("Latitud: -");
        }
        holder.tvwPuntDescripcio.setText(punts.get(position).getDescripcio());
    }

    @Override
    public int getItemCount() {
        return punts.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private CardView cvwPlantillaPunt;
        private TextView tvwPuntNom;
        private ImageView ivwPuntImatge;
        private TextView tvwPuntTemps;
        private TextView tvwPuntLatitud;
        private TextView tvwPuntLongitud;
        private TextView tvwPuntElevacio;
        private TextView tvwPuntDescripcio;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            cvwPlantillaPunt = itemView.findViewById(R.id.cvwPlantillaPunt);
            tvwPuntNom = itemView.findViewById(R.id.tvwPuntNom);
            ivwPuntImatge = itemView.findViewById(R.id.imvPuntImatge);
            tvwPuntTemps = itemView.findViewById(R.id.tvwPuntTemps);
            tvwPuntLatitud = itemView.findViewById(R.id.tvwPuntLatitud);
            tvwPuntLongitud = itemView.findViewById(R.id.tvwPuntLongitud);
            tvwPuntElevacio = itemView.findViewById(R.id.tvwPuntElevacio);
            tvwPuntDescripcio = itemView.findViewById(R.id.tvwPuntDescripcio);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            //Nada
        }
    }

}

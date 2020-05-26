package com.example.rutapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

public class AdapterRuta extends RecyclerView.Adapter<AdapterRuta.MyViewHolder> {

    private Context context;
    private List<Object> rutes;
    private ImageLoader imgLoader;
    private int pos;

    public AdapterRuta(Context context, List<Object> rutes) {
        this.context = context;
        this.rutes = rutes;
        this.imgLoader = ImageLoader.getInstance();
        this.pos = -1;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ruta,null,false);
        view.setSelected(true);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return rutes.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private ImageView ivwImatgeRuta;
        private TextView tvwNomRuta;
        private TextView tvwDesnivellRuta;
        private TextView tvwAlcMinRuta;
        private TextView tvwAlcMaxRuta;
        private TextView tvwDistanciaRuta;
        private TextView tvwTempsRuta;
        private TextView tvwCircularRuta;

        public MyViewHolder(View itemView){
            super(itemView);
            ivwImatgeRuta = itemView.findViewById(R.id.ivwImatgeRuta);
            tvwNomRuta = itemView.findViewById(R.id.tvwNomRuta);
            tvwDesnivellRuta = itemView.findViewById(R.id.tvwDesnivellRuta);
            tvwAlcMinRuta = itemView.findViewById(R.id.tvwAlcMinRuta);
            tvwAlcMaxRuta = itemView.findViewById(R.id.tvwAlcMaxRuta);
            tvwDistanciaRuta = itemView.findViewById(R.id.tvwDistanciaRuta);
            tvwTempsRuta = itemView.findViewById(R.id.tvwTempsRuta);
            tvwCircularRuta = itemView.findViewById(R.id.tvwCircularRuta);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(getAdapterPosition()!=pos){
                pos = getAdapterPosition();
                notifyItemChanged(pos);
                Intent i = new Intent(context,R.id.DetallRutaActivity);
            }
        }

    }

}

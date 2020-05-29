package com.example.rutapp.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rutapp.R;
import com.example.rutapp.model.Ruta;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

public class AdapterRuta extends RecyclerView.Adapter<AdapterRuta.MyViewHolder> {

    private Context context;
    private List<Ruta> rutes;
    private ImageLoader imgLoader;
    private int pos;
    private IRutaListener listener;

    public AdapterRuta(Context context, List<Ruta> rutes, IRutaListener listener) {
        this.context = context;
        this.rutes = rutes;
        this.imgLoader = ImageLoader.getInstance();
        this.listener = listener;
        this.pos = -1;
    }

    public interface IRutaListener{
        void onRutaSelected(int position, Ruta ruta);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ruta,parent,false);
        view.setSelected(true);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        if(position == pos){
            holder.cvwPlantillaRuta.setBackgroundColor(Color.rgb(255,206,0));
        }else{
            holder.cvwPlantillaRuta.setBackgroundColor(Color.TRANSPARENT);
        }
        imgLoader.displayImage(rutes.get(position).getFotUrl(),holder.ivwImatgeRuta);
        holder.tvwNomRuta.setText(rutes.get(position).getTitol());
        holder.tvwDesnivellRuta.setText("Desnivell: "+String.valueOf(rutes.get(position).getDesnivell()));
        holder.tvwAlcMinRuta.setText("Alçada Min: "+String.valueOf(rutes.get(position).getAlcadaMin()));
        holder.tvwAlcMaxRuta.setText("Alçada Max: "+String.valueOf(rutes.get(position).getAlcadaMax()));
        holder.tvwDistanciaRuta.setText("Km: "+String.valueOf(rutes.get(position).getDistanciaKm()));
        holder.tvwTempsRuta.setText("Temps: "+rutes.get(position).getTempsAproxString());
        if(rutes.get(position).getCircular()){
            holder.tvwCircularRuta.setText("Circular: Si");
        }else{
            holder.tvwCircularRuta.setText("Circular: No");
        }
    }

    @Override
    public int getItemCount() {
        return rutes.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private CardView cvwPlantillaRuta;
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
            cvwPlantillaRuta = itemView.findViewById(R.id.cvwPlantillaRuta);
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
            int aux = pos;
            if(getAdapterPosition()!=pos){
                pos = getAdapterPosition();
                notifyItemChanged(pos);
            }
            notifyItemChanged(aux);
            if(listener!=null){
                listener.onRutaSelected(pos,rutes.get(pos));
            }
        }

    }

}

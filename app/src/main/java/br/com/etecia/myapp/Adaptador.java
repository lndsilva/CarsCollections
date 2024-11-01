package br.com.etecia.myapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adaptador extends RecyclerView.Adapter<Adaptador.ViewHolder> {
    private Context context;
    private List<Carros> lstCarros;

    public Adaptador(Context context, List<Carros> lstCarros) {
        this.context = context;
        this.lstCarros = lstCarros;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.modelo_carro, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.titCarro.setText(lstCarros.get(position).getNome());
        holder.imgCarro.setImageResource(lstCarros.get(position).getImagem());

        holder.idCardCarros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, MostraCarrosActivity.class);

                intent.putExtra("Nome", lstCarros.get(position).getNome());
                intent.putExtra("Imagem", lstCarros.get(position).getImagem());

                context.startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));

            }
        });
    }

    @Override
    public int getItemCount() {
        return lstCarros.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView titCarro;
        ImageView imgCarro;
        CardView idCardCarros;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titCarro = itemView.findViewById(R.id.tituloModeloCarro);
            imgCarro = itemView.findViewById(R.id.imgModeloCarro);
            idCardCarros = itemView.findViewById(R.id.idCardCarros);

        }
    }
}

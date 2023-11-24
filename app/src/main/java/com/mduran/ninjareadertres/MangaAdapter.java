package com.mduran.ninjareadertres;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class MangaAdapter extends RecyclerView.Adapter<MangaAdapter.ViewHolderServicios> {

    // Genero la lista de ServicioVo
    ArrayList<MangaModel> listaMangas;

    // Constructor de lista servicios para llamarla más adelante
    public MangaAdapter(ArrayList<MangaModel> listaMangas) {
        this.listaMangas = listaMangas;
    }
    @NonNull
    @Override
    public ViewHolderServicios onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_manga_card, parent, false); // Llamo al layout item_list_view
        return new ViewHolderServicios(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderServicios holder, int position) {
        holder.txtTitulo.setText(listaMangas.get(position).getNombreManga());
        holder.rating.setRating(listaMangas.get(position).getRatingCurso());
        holder.foto.setImageResource(listaMangas.get(position).getImagenCurso());

    }

    @Override
    public int getItemCount() {
        return listaMangas.size();
    }

    public class ViewHolderServicios extends RecyclerView.ViewHolder {
        // Variables
        TextView txtTitulo;
        RatingBar rating;
        ImageView foto;
        public ViewHolderServicios(@NonNull View itemView) {
            super(itemView);
            txtTitulo = itemView.findViewById(R.id.nombreCurso);
            rating = itemView.findViewById(R.id.ratingCurso);
            foto = itemView.findViewById(R.id.imgCurso);
        }
    }
}
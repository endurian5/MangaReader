package com.mduran.ninjareadertres;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class InicioFragment extends Fragment {
    // Declaración de variables
    ArrayList<MangaModel> listaMangas;
    RecyclerView recyclerMangas;

    public InicioFragment(){
        // require a empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_inicio, container, false);

        listaMangas = new ArrayList<>();
        recyclerMangas = view.findViewById(R.id.rvLista); // Asegúrate de tener un RecyclerView en tu fragmento con el id correcto
        recyclerMangas.setLayoutManager(new LinearLayoutManager(getActivity()));

        llenarMangas(); // Llenar la lista de servicios
        MangaAdapter adaptador = new MangaAdapter(listaMangas);
        recyclerMangas.setAdapter(adaptador);

        return view;
    }

    private void llenarMangas() {
        // Agrega tus servicios a la lista
        listaMangas.add(new MangaModel("Naruto Shippuden", 2, R.drawable.narutomangauno));
        listaMangas.add(new MangaModel("One Piece", 4, R.drawable.onepiecemangados));
        listaMangas.add(new MangaModel("Haikyuu", 5, R.drawable.haikyuumangatres));
        listaMangas.add(new MangaModel("My Hero Academia", 5, R.drawable.bnhmangacuatro));
        listaMangas.add(new MangaModel("Given", 5, R.drawable.givenmangacinco));
    }
}

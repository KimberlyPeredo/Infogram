package com.kimberly.infogram.view.fragment;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kimberly.infogram.R;
import com.kimberly.infogram.adapter.CardViewAdapter;
import com.kimberly.infogram.model.Image;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_home, container, false);

        //toolbar
        showToolBar(getString(R.string.title_home_fragment),false,view);

        //recycler view
        RecyclerView recyclerView=view.findViewById(R.id.recycler_view);

        //layout manager
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(linearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        //el adapter
        CardViewAdapter cardViewAdapter=new CardViewAdapter(buidImages(),R.layout.cardview_image, getActivity());
        recyclerView.setAdapter(cardViewAdapter);

        return view;
    }
    public void showToolBar(String titulo, boolean botonSubir,View view) {
        Toolbar toolbar= view.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);

        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(titulo);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(botonSubir);
    }

    //creamos la lista de imagenes
    public ArrayList<Image> buidImages(){
        ArrayList<Image> images=new ArrayList<>();

        images.add(new Image("https://i0.wp.com/elcalderoviajero.com/wp-content/uploads/2018/04/bolivia-cochabamba-incachaca-13.jpg?resize=750%2C500&ssl=1", "Carlos Valdivia", " 2 dias", "1 me gusta"));
        images.add(new Image("https://www.civitatis.com/f/bolivia/cochabamba/big/tour-cochabamba-cristo-concordia.jpg", "Luis Perez", " 3 dias", "5 me gusta"));
        images.add(new Image("https://whc.unesco.org/uploads/thumbs/site_0883_0010-594-0-20151104160341.jpg", "Fernando Torrico", " 6 dias", "4 me gusta"));
        images.add(new Image("https://www.ine.gob.bo/wp-content/uploads/2019/07/Coroico5.png", "Laura Flores", " 5 dias", "6 me gusta"));
        images.add(new Image("https://media.tacdn.com/media/attractions-splice-spp-674x446/06/6f/60/ca.jpg", "Rolando Morales", " 7 dias", "2 me gusta"));
        images.add(new Image("https://www.infodiez.com/wp-content/uploads/2024/09/teleferico-infodiez.jpg", "Lorena Rivera", " 2 dias", "5 me gusta"));
        images.add(new Image("https://www.dejarlotodoparaviajar.com/wp-content/uploads/2018/03/Copacabana-Bolivia-Playa.jpg", "Carlos Valdivia", " 3 dias", "3 me gusta"));
        images.add(new Image("https://faculty.ucr.edu/~legneref/biados/PuertaDelSol/jpg3/historia1-1.jpg", "Maria Caceres", " 9 dias", "8 me gusta"));
        images.add(new Image("https://ichef.bbci.co.uk/ace/ws/304/amz/worldservice/live/assets/images/2013/02/01/130201162058_virgin_of_the_socavon_statue_bolivia_304x171_reuters.jpg.webp", "Marcelo Rojas", " 4 dias", "3 me gusta"));
        images.add(new Image("https://www.yaya.com.bo/wp-content/uploads/2020/01/Glorieta_Sucre_Bolivia.jpg", "William Jaimes", " 8 dias", "1 me gusta"));

        return images;
    }
}
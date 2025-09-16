package com.kimberly.infogram.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import com.kimberly.infogram.R;
import com.kimberly.infogram.adapter.CardViewAdapter;
import com.kimberly.infogram.model.Image;
import java.util.ArrayList;
import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        showToolBar("", false, view);

        // RecyclerView
        RecyclerView recyclerView = view.findViewById(R.id.recycler_profile);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new CardViewAdapter(buildImages(), R.layout.cardview_image, getActivity()));

        // Animación foto y nombre
        final CircleImageView profileImage = view.findViewById(R.id.profile_image);
        final TextView usernameProfile = view.findViewById(R.id.username_profile);
        final TextView usernameAppbar = view.findViewById(R.id.username_appbar_profile);
        AppBarLayout appBarLayout = view.findViewById(R.id.appbar_profile);

        // Tamaños inicial y final de la foto
        final int startSize = getResources().getDimensionPixelSize(R.dimen.size_circle_image_profile_start);
        final int endSize = getResources().getDimensionPixelSize(R.dimen.size_circle_image_profile_end);

        // Coordenadas iniciales (centro)
        final float startXProfile = (appBarLayout.getWidth() - startSize) / 2f;
        final float startYProfile = profileImage.getTop();

        // Coordenadas finales (esquina superior izquierda)
        final float endXProfile = getResources().getDimensionPixelSize(R.dimen.marginLeft_profile_end);
        final float endYProfile = getResources().getDimensionPixelSize(R.dimen.marginTop_profile_end);

        // Coordenadas del nombre al lado de la foto
        final float startXName = usernameProfile.getLeft();
        final float startYName = usernameProfile.getTop();
        final float endXName = endXProfile + endSize + getResources().getDimensionPixelSize(R.dimen.marginLeft_username_appbar_profile);
        final float endYName = endYProfile + getResources().getDimensionPixelSize(R.dimen.marginTop_username_image_profile);

        appBarLayout.addOnOffsetChangedListener((appBarLayout1, verticalOffset) -> {
            float ratio = (float) -verticalOffset / appBarLayout1.getTotalScrollRange();

            // Animar la foto
            profileImage.setTranslationX((endXProfile - startXProfile) * ratio);
            profileImage.setTranslationY((endYProfile - startYProfile) * ratio);
            profileImage.getLayoutParams().width = startSize - (int)((startSize - endSize) * ratio);
            profileImage.getLayoutParams().height = startSize - (int)((startSize - endSize) * ratio);
            profileImage.requestLayout();

            // Animar nombre al lado de la foto
            usernameAppbar.setTranslationX((endXName - startXName) * ratio);
            usernameAppbar.setTranslationY((endYName - startYName) * ratio);
            usernameAppbar.setAlpha(ratio);

            // Nombre principal debajo de la foto desaparece
            usernameProfile.setAlpha(1 - ratio);
        });

        return view;
    }

    private void showToolBar(String title, boolean upButton, View view) {
        Toolbar toolbar = view.findViewById(R.id.toolbar_profile);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(title);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }

    public ArrayList<Image> buildImages(){
        ArrayList<Image> images = new ArrayList<>();
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

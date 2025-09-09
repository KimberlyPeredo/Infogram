package com.kimberly.infogram.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kimberly.infogram.R;
import com.kimberly.infogram.model.Image;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CardViewAdapter extends RecyclerView.Adapter<CardViewAdapter.CardViewHolder> {
 //Lista de imagenes
    private ArrayList<Image> images;
    private int resource;
    private Activity activity;

    public CardViewAdapter(ArrayList<Image> images, int resource, Activity activity) {
        this.images = images;
        this.resource = resource;
        this.activity = activity;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(resource,parent,false);

        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        Image image=images.get(position);
        //image

        holder.usernameCardView.setText(image.getUsername());
        holder.cantidadDiasCardView.setText(image.getCantidadDias());
        holder.cantidadMeGustaCardView.setText(image.getCantidadMeGusta());

    }

    @Override
    public int getItemCount() {

        return images.size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageCardView;
        private TextView usernameCardView;
        private TextView cantidadDiasCardView;
        private TextView cantidadMeGustaCardView;
         public CardViewHolder(@NonNull View itemView){
             super(itemView);

             imageCardView=itemView.findViewById(R.id.imageCardView);
             usernameCardView= itemView.findViewById(R.id.usernameCardView);
             cantidadDiasCardView= itemView.findViewById(R.id.cantidadDiasCardView);
             cantidadMeGustaCardView= itemView.findViewById(R.id.cantidadMeGustaCardView);
         }
    }
}

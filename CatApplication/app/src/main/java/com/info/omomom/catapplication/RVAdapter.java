package com.info.omomom.catapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.CardViewDesignObjectHolder>{
    private Context mContext;
    private List<ImageView> comingCatImageList;
    private List<String> comingCatBreedNameList;
    private List<ImageView> comingFavouriteBreedList;

    public RVAdapter(Context mContext, List<ImageView> comingCatImage, List<String> comingCatBreedName, List<ImageView> comingFavouriteBreed) {
        this.mContext = mContext;
        this.comingCatImageList = comingCatImage;
        this.comingCatBreedNameList = comingCatBreedName;
        this.comingFavouriteBreedList = comingFavouriteBreed;
    }

    //cardView deki nesneleri adapter a bağlıyoruz
    public class CardViewDesignObjectHolder extends RecyclerView.ViewHolder{
        public ImageView imageViewCatImage,imageViewStar;
        public TextView textViewCatBreedName;
        public CardView rowCardView;

        public CardViewDesignObjectHolder(@NonNull View view) {
            super(view);
            imageViewCatImage=view.findViewById(R.id.imageViewCatImage);
            imageViewStar=view.findViewById(R.id.imageViewStar);
            textViewCatBreedName=view.findViewById(R.id.imageViewCatImage);
            rowCardView=view.findViewById(R.id.rowCardView);
        }
    }

    //tasarımı buraya inflate ediyoruz
    @NonNull
    @Override
    public CardViewDesignObjectHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_design,parent,false);

        return new CardViewDesignObjectHolder(itemView);
    }

    //holder ile nesnelere,position ile de indekslerine ulaşıyoruz,kaç tane kartın oluşacağını da belirler
    @Override
    public void onBindViewHolder(@NonNull CardViewDesignObjectHolder holder, int position) {
        ImageView catImage=comingCatImageList.get(position);
        String catBreedName=comingCatBreedNameList.get(position);
        ImageView catFavourite=comingFavouriteBreedList.get(position);

        //!!!!image ler için de yapmam gerek ama yapamadım ekle sonradan!!!!
        holder.textViewCatBreedName.setText(catBreedName);

        //listelenen cardView lerde tıklanma için,tıklamadan sonra detaylı olan başka bir sayfaya yönlendirilecek
        holder.rowCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //geçici olarak toast mesaj bırakıyoruz
                Toast.makeText(mContext,"Your chosen cat :"+ catBreedName,Toast.LENGTH_SHORT).show();
            }
        });
    }

    //alınan verilerin boyutuna göre kaç kez döndereceğini belirler
    @Override
    public int getItemCount() {
        return comingCatBreedNameList.size();
    }



}

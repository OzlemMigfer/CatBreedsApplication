package com.info.omomom.catapplication;

import android.content.Context;
import android.content.Intent;
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
    private List<CatBreeds> catBreedsList;

    public RVAdapter(Context mContext, List<CatBreeds> catBreedsList) {
        this.mContext = mContext;
        this.catBreedsList = catBreedsList;
    }

    //cardView deki nesneleri adapter a bağlıyoruz
    public class CardViewDesignObjectHolder extends RecyclerView.ViewHolder{
        public ImageView imageViewCatImage,imageViewStar;
        public TextView textViewCatBreedName;
        public CardView rowCardView;

        public CardViewDesignObjectHolder(@NonNull View itemview) {
            super(itemview);
            imageViewCatImage=itemview.findViewById(R.id.imageViewCatImage);
            imageViewStar=itemview.findViewById(R.id.imageViewStar);
            textViewCatBreedName=itemview.findViewById(R.id.textViewCatBreedName);
            rowCardView=itemview.findViewById(R.id.rowCardView);
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
        final CatBreeds catBreeds=catBreedsList.get(position);

        holder.textViewCatBreedName.setText(catBreeds.getCatbreed_name());
        holder.imageViewStar.setImageResource(R.drawable.star);

        holder.imageViewCatImage.setImageResource(mContext.getResources()
                .getIdentifier(catBreeds.getCat_image(),"drawable",mContext.getPackageName()));

        //listelenen cardView lerde tıklanma için,tıklamadan sonra detaylı olan başka bir sayfaya yönlendirilecek
        holder.rowCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //geçici olarak toast mesaj bırakıyoruz
                //Toast.makeText(mContext,"Your chosen cat :"+ catBreeds.getCatbreed_name(),Toast.LENGTH_SHORT).show();

                //cardView e tıklanınca detay sayfasına geçmesini istiyorum
                Intent intent=new Intent(mContext,CatBreedDetail.class);

                //hangi nesne dönecek
                intent.putExtra("object",catBreeds);
                mContext.startActivity(intent);
            }
        });

        holder.imageViewStar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, "Your choosen favourite cat breed :"+catBreeds.getCatbreed_name(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    //alınan verilerin boyutuna göre kaç kez döndereceğini belirler
    @Override
    public int getItemCount() {
        return catBreedsList.size();
    }



}

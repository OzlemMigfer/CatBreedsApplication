package com.info.omomom.catapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    //api için
    private Retrofit retrofit;
    private CatApi catApi;
    private String baseUrl ="https://docs.thecatapi.com/api-reference/breeds/breeds-list/";
    private Call<RetrofitCat> retrofitCatCall;
    private RetrofitCat retrofitCat;
    private CatBreeds catBreeds;

    private Toolbar toolbar;
    private RecyclerView rv;
    private ArrayList<CatBreeds> catBreedsArrayList;
    private RVAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar=findViewById(R.id.toolbar);
        rv=findViewById(R.id.rv);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL));

        CatBreeds c1=new CatBreeds(1,"Abyssinian","abyssinian");
        CatBreeds c2=new CatBreeds(2,"Aegean","aegean");
        CatBreeds c3=new CatBreeds(3,"Bengal","bengal");
        CatBreeds c4=new CatBreeds(4,"Birman","birman");
        CatBreeds c5=new CatBreeds(5,"Chartreux","chartreux");

        catBreedsArrayList=new ArrayList<>();
        catBreedsArrayList.add(c1);
        catBreedsArrayList.add(c2);
        catBreedsArrayList.add(c3);
        catBreedsArrayList.add(c4);
        catBreedsArrayList.add(c5);

        adapter=new RVAdapter(this,catBreedsArrayList);
        rv.setAdapter(adapter);

        toolbar.setTitle("Search");
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        //Arama çubuğu için kodlamalar
        getMenuInflater().inflate(R.menu.toolbar_menu,menu);

        MenuItem item= menu.findItem(R.id.action_search);

        SearchView searchView=(SearchView) item.getActionView();

        searchView.setOnQueryTextListener(this);

        return super.onCreateOptionsMenu(menu);
    }

    //arama çubuğuna veriyi girdiniz ara butonuna bastıktan sonra veriler gelir
    @Override
    public boolean onQueryTextSubmit(String query) {
        Log.e("Sent Call",query);
        return false;
    }

    //arama çubuğuna harf girip sildiğinizde vs verileri getirir--sürekli arama işlemi
    @Override
    public boolean onQueryTextChange(String newText) {
        Log.e("As You Enter Letters",newText);
        return false;
    }

    //api için
    private void setRetrofitSettings(){
        retrofit=new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        catApi=retrofit.create(CatApi.class);
        retrofitCatCall.enqueue(new Callback<RetrofitCat>() {
            //veriler inmiş mi diye kontrol ediliyor
            @Override
            public void onResponse(Call<RetrofitCat> call, Response<RetrofitCat> response) {
                if(response.isSuccessful()){
                    retrofitCat=response.body();
                    if(retrofitCat!=null){
                        catBreeds.setCatbreed_name(retrofitCat.getWidth());
                    }
                }
            }

            @Override
            public void onFailure(Call<RetrofitCat> call, Throwable t) {
                System.out.println(t.toString());
            }
        });
    }
}
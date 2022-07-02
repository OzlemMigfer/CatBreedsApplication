package com.info.omomom.catapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    private Toolbar toolbar;
    private RecyclerView rv;
    private ArrayList<String> catBreedsNameList;
    private ArrayList<ImageView> catImageList;
    private ArrayList<ImageView> catFavouriteList;
    private RVAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar=findViewById(R.id.toolbar);
        rv=findViewById(R.id.rv);

        rv.setHasFixedSize(true);//dışardan gelecek olan listenin boyutunu fixlemek için yazıyoruz

        //recyclerview in tasarımına karar veriyoruz,nasıl gözükücek diye
        rv.setLayoutManager(new LinearLayoutManager(this));

        //veri kümesini oluşturuyoruz
        catBreedsNameList= new ArrayList<>();
        catImageList=new ArrayList<>();
        catFavouriteList=new ArrayList<>();

        catBreedsNameList.add("American WireHair");
        catBreedsNameList.add("Aegean");
        catBreedsNameList.add("Cheetoh");
        catBreedsNameList.add("Himalayan");
        catBreedsNameList.add("Manx");

        adapter=new RVAdapter(this,catImageList,catBreedsNameList,catFavouriteList);

        //adapter ı recyclervew içerisine aktarmamız gerek
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
}
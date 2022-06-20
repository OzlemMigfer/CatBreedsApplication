package com.info.omomom.catapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    private Toolbar toolbar;
    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar=findViewById(R.id.toolbar);
        rv=findViewById(R.id.rv);

        toolbar.setTitle("Search");
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.toolbar_menu,menu);

        MenuItem item= menu.findItem(R.id.action_search);

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
package com.info.omomom.catapplication;

import android.widget.ImageView;

import java.io.Serializable;

public class CatBreeds implements Serializable {
    private int cat_id;
    private String catbreed_name;
    private String cat_image;

    public CatBreeds() {
    }

    public CatBreeds(int cat_id, String catbreed_name, String cat_image) {
        this.cat_id = cat_id;
        this.catbreed_name = catbreed_name;
        this.cat_image = cat_image;
    }

    public int getCat_id() {
        return cat_id;
    }

    public void setCat_id(int cat_id) {
        this.cat_id = cat_id;
    }

    public String getCatbreed_name() {
        return catbreed_name;
    }

    public void setCatbreed_name(String catbreed_name) {
        this.catbreed_name = catbreed_name;
    }

    public String getCat_image() {
        return cat_image;
    }

    public void setCat_image(String cat_image) {
        this.cat_image = cat_image;
    }
}

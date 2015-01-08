package com.example.twopaneapplication.Controllers;

import com.example.twopaneapplication.Fragments.CategoriesFragment;
import com.example.twopaneapplication.Models.Category;
import com.example.twopaneapplication.Networking.FeedzillaService;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Amaury Esparza on 14/12/2014.
 */
public class CategoryController {

    private FeedzillaService apiService = null;
    private static CategoriesFragment categoriesFragment = null;
    public CategoryController(CategoriesFragment categoriesFragment){
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("http://api.feedzilla.com")
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();
        apiService = restAdapter.create(FeedzillaService.class);
        this.categoriesFragment = categoriesFragment;
    }

    public void getCategoriesList(){
        apiService.getCategories("v1", new Callback<List<Category>>() {
            @Override
            public void success(List<Category> categories, Response response) {
                categoriesFragment.responseListener(categories, response);
            }

            @Override
            public void failure(RetrofitError error) {
                categoriesFragment.responseListener(null, null);
            }
        });
    }
}

package com.example.twopaneapplication.Controllers;

import android.util.Log;

import com.example.twopaneapplication.Models.Country;
import com.example.twopaneapplication.Networking.FeedzillaService;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Amaury Esparza on 14/12/2014.
 */
public class CountryController {


    List<Country> countriesList;
    public void getCountries() {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("http://api.feedzilla.com")
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();
        FeedzillaService apiService = restAdapter.create(FeedzillaService.class);
        apiService.getCountries("v1", new Callback<List<Country>>() {
            @Override
            public void success(List<Country> countries, Response response) {
                countriesList = countries;
                Log.d("Retrofit Request success", countries.toString());
            }
            @Override
            public void failure(RetrofitError error) {
                countriesList = null;
                Log.d("Retrofit Request failure", error.toString());
            }

        });


    }

    public String[] getList(){
        getCountries();
        if(countriesList != null) {
            String[] countriesName = null;
            int i = 0;
            for (Country c : countriesList) {
                countriesName[i] = c.getDisplayCultureName();
                i++;
            }
            return countriesName;
        }
        else{
            return null;
        }
    }
}

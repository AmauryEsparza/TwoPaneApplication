package com.example.twopaneapplication.Networking;

import android.util.Log;

import com.example.twopaneapplication.Interfaces.BaseHttpCommunicator;
import com.example.twopaneapplication.Models.Country;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by Amaury Esparza on 16/12/2014.
 */
public interface FeedzillaService{
        @GET("/{version}/cultures.json")
        void getCountries(@Path("version") String version, Callback<List<Country>> listCountries);

        @GET("/{version}/cultures.json")
        List<Country> getCountriesSync(@Path("version") String version);
}

package com.example.twopaneapplication.Interfaces;

import android.os.AsyncTask;
import android.util.Log;

import com.example.twopaneapplication.Models.Country;

import org.apache.http.client.methods.HttpPost;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by Amaury Esparza on 14/12/2014.
 */
public abstract class BaseHttpCommunicator {

    public abstract void createRequest(String params);

    //RETROFIT INTERFACE HTTP METHODS
    public interface FeedzillaService{
        @GET("/{version}/cultures.json")
        void getCountries(@Path("version") String version, Callback<List<Country>> listCountries);
    }
}

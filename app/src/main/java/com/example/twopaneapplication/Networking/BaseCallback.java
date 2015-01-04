package com.example.twopaneapplication.Networking;

import com.example.twopaneapplication.Models.Country;
import com.squareup.okhttp.Call;

import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Amaury Esparza on 26/12/2014.
 */
public interface BaseCallback{

    public Response responseHandler(List<Country> listCountry) ;
}

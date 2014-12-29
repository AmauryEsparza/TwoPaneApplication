package com.example.twopaneapplication.Networking;

import com.squareup.okhttp.Call;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Amaury Esparza on 26/12/2014.
 */
public class BaseCallback<T> implements Callback{

    T genericObject;
    public BaseCallback(T genericObject){
        this.genericObject = genericObject;
    }
    @Override
    public void success(Object o, Response response) {

    }

    @Override
    public void failure(RetrofitError error) {

    }
}

package com.example.twopaneapplication.Controllers;

import com.example.twopaneapplication.Fragments.HeadlinesFragment;
import com.example.twopaneapplication.Models.ArticleDescription;
import com.example.twopaneapplication.Networking.FeedzillaService;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Amaury Esparza on 07/12/2014.
 */
public class HeadlinesController {

    private FeedzillaService apiService = null;
    private static HeadlinesFragment headlinesFragment = null;

    public HeadlinesController(HeadlinesFragment headlinesFragment){
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("http://api.feedzilla.com")
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();
        apiService = restAdapter.create(FeedzillaService.class);
        this.headlinesFragment = headlinesFragment;
    }

    public void getHeadlinesList(int categoryId){
        apiService.getHeadlinesArticles(categoryId, new Callback<ArticleDescription>() {
            @Override
            public void success(ArticleDescription articleDescription, Response response) {
                headlinesFragment.responseListener(articleDescription, response);
            }

            @Override
            public void failure(RetrofitError error) {
                headlinesFragment.responseListener(null, null);
            }
        });
    }
}

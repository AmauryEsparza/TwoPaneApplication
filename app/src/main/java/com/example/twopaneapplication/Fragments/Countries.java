package com.example.twopaneapplication.Fragments;

import android.app.Activity;
import android.app.ListFragment;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.twopaneapplication.Controllers.CountryController;
import com.example.twopaneapplication.Models.Country;

import java.util.List;

import retrofit.client.Response;

/**
 * Created by Amaury Esparza on 20/12/2014.
 */
public class Countries extends ListFragment{

    private ArrayAdapter<String> arrayCountryAdapter;
    private Countries.OnFragmentInteractionListener mCallback;
    private String[] countriesName = {};

    public Countries(){
        //Public Constructor
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        CountryController countryController = new CountryController(this);
        countryController.getCountriesList();
        arrayCountryAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, countriesName);
        setListAdapter(arrayCountryAdapter);
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id){
        //Notify the parent Activity of selected item
        Toast.makeText(getActivity(), "Click on the Element", Toast.LENGTH_LONG).show();
        mCallback.onArticleSelected(position);
        //Set the item as checked
        getListView().setItemChecked(position, true);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mCallback = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mCallback = null;
    }

    public interface OnFragmentInteractionListener {
        public void onArticleSelected(int position);

    }

    public void responseListener(List<Country> countriesList, Response response){
        Log.d("Countries$responseListener", countriesList.get(0).getLanguageCode());
        Log.d("Countries$responseListener", response.getStatus()+"");
        //Update the ArrayList content
        if(countriesList != null) {
            arrayCountryAdapter.clear();
            countriesName = new String[countriesList.size()];
            int i = 0;
            for(Country country : countriesList){
                arrayCountryAdapter.insert(country.getEnglishCultureName(), i);
                i++;
            }
            arrayCountryAdapter.notifyDataSetChanged();
        }
        else{
            //If the list are null
            setEmptyText("Server Error, try again later");
        }

    }
}

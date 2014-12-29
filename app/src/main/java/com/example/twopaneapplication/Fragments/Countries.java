package com.example.twopaneapplication.Fragments;

import android.app.Activity;
import android.app.ListFragment;
import android.os.Bundle;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.twopaneapplication.Controllers.CountryController;

/**
 * Created by Amaury Esparza on 20/12/2014.
 */
public class Countries extends ListFragment{

    private ArrayAdapter<String> arrayCountryAdapter;
    private Countries.OnFragmentInteractionListener mCallback;

    public Countries(){
        //Public Constructor
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        CountryController countryController = new CountryController();
        String[] countries = countryController.getList();
        if(countries != null) {

            arrayCountryAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, countries);
            setListAdapter(arrayCountryAdapter);
        }
        else{
            //If the list are null
            setEmptyText("Server Error, try again later");
        }
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
}

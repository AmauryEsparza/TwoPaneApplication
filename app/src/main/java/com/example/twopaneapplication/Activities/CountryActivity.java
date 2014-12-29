package com.example.twopaneapplication.Activities;

import android.app.Activity;
import android.os.Bundle;
import com.example.twopaneapplication.Fragments.Countries;
import com.example.twopaneapplication.R;

/**
 * Created by Amaury Esparza on 14/12/2014.
 */
public class CountryActivity extends Activity implements Countries.OnFragmentInteractionListener{

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country);
    }

    public void onArticleSelected(int position){
        //Make an Intent for call the other activity
    }
}

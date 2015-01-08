package com.example.twopaneapplication.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.example.twopaneapplication.Interfaces.BaseListFragmentCommunicator;
import com.example.twopaneapplication.Models.Category;
import com.example.twopaneapplication.R;

/**
 * Created by Amaury Esparza on 14/12/2014.
 */
public class CategoriesActivity extends Activity implements BaseListFragmentCommunicator<Category>{

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country);
    }

    @Override
    public void onSelectedListItem(Category objectT) {
        Intent intent = new Intent(this, NewsActivity.class);
        intent.putExtra("category_id", objectT.getCategoryId());
        startActivity(intent);
    }
}

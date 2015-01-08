package com.example.twopaneapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.example.twopaneapplication.Activities.CategoriesActivity;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }*/

    /*@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }*/

    //Fragment Method implementation
    public void onArticleSelected(int position){
        Intent intent = new Intent(this, CategoriesActivity.class);
        startActivity(intent);
        /*
        Article articleFragment = (Article) getFragmentManager().findFragmentById(R.id.article);
        if(articleFragment != null){
            //If article frag is available, we're in two-pane layout
            //Update the Article Fragment Item selected
            articleFragment.updateArticleView(position);
        }
        else{

        }*/

    }
}

package com.example.twopaneapplication.Activities;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;

import com.example.twopaneapplication.Fragments.ArticleFragment;
import com.example.twopaneapplication.Fragments.HeadlinesFragment;
import com.example.twopaneapplication.Interfaces.BaseListFragmentCommunicator;
import com.example.twopaneapplication.Models.Article;
import com.example.twopaneapplication.Models.ArticleDescription;
import com.example.twopaneapplication.R;

/**
 * Created by Amaury Esparza on 03/01/2015.
 */
public class NewsActivity extends Activity implements BaseListFragmentCommunicator<Article> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        // Check whether the activity is using the layout version with
        // the fragment_container FrameLayout. If so, we must add the first fragment
        if(findViewById(R.id.fragment_container) != null){
            // However, if we're being restored from a previous state,
            // then we don't need to do anything and should return or else
            // we could end up with overlapping fragments.
            if (savedInstanceState != null) {
                return;
            }

            // Create an instance of ExampleFragment
            HeadlinesFragment firstFragment = new HeadlinesFragment();

            // In case this activity was started with special instructions from an Intent,
            // pass the Intent's extras to the fragment as arguments
            firstFragment.setArguments(getIntent().getExtras());

            // Add the fragment to the 'fragment_container' FrameLayout
            getFragmentManager().beginTransaction().add(R.id.fragment_container, firstFragment).commit();
        }

    }

    @Override
    public void onSelectedListItem(Article objectT){
        ArticleFragment articleFragment = (ArticleFragment) getFragmentManager().findFragmentById(R.id.article);
        if (articleFragment != null) {
            // If article frag is available, we're in two-pane layout...
            // Call a method in the ArticleFragment to update its content
            articleFragment.updateArticleView(objectT.getSummary(), objectT.getUrl());
        } else {
            // Otherwise, we're in the one-pane layout and must swap frags...
            // Create fragment and give it an argument for the selected article
            ArticleFragment newFragment = new ArticleFragment();
            Bundle args = new Bundle();
            args.putString("DESCRIPTION", objectT.getSummary());
            args.putString("URI", objectT.getUrl());
            newFragment.setArguments(args);

            FragmentTransaction transaction = getFragmentManager().beginTransaction();

            // Replace whatever is in the fragment_container view with this fragment,
            // and add the transaction to the back stack so the user can navigate back
            transaction.replace(R.id.fragment_container, newFragment);
            transaction.addToBackStack(null);

            // Commit the transaction
            transaction.commit();
        }
    }
}

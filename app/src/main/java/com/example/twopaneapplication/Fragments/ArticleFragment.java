package com.example.twopaneapplication.Fragments;

import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.twopaneapplication.R;

public class ArticleFragment extends Fragment {

    TextView textArticle;
    public ArticleFragment() {
        // Required empty public constructor
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        Bundle bundle = getArguments();
        if(bundle != null){
            textArticle = (TextView) getActivity().findViewById(R.id.textView);
            textArticle.setText(bundle.getString("DESCRIPTION"));
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        return inflater.inflate(R.layout.fragment_article, container, false);
    }

    public void updateArticleView(String summary){
        textArticle = (TextView) getActivity().findViewById(R.id.textView);
        textArticle.setText(summary);
    }
}

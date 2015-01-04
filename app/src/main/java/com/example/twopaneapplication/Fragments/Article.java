package com.example.twopaneapplication.Fragments;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.twopaneapplication.Controllers.ArticleController;
import com.example.twopaneapplication.R;

public class Article extends Fragment {

    public Article() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        return inflater.inflate(R.layout.fragment_article, container, false);
    }

    public void updateArticleView(int position){
        ArticleController articleController = new ArticleController();
        TextView textArticle = (TextView) getActivity().findViewById(R.id.textView);
        textArticle.setText(articleController.getArticles(position));
    }
}

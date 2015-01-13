package com.example.twopaneapplication.Fragments;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.twopaneapplication.R;

public class ArticleFragment extends Fragment implements View.OnClickListener {

    private TextView textArticle;
    private Button buttonMore;
    private Bundle bundle;
    private String uri;
    public ArticleFragment() {
        // Required empty public constructor
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        bundle = getArguments();
        if(bundle != null){
            textArticle = (TextView) getActivity().findViewById(R.id.textView);
            textArticle.setText(bundle.getString("DESCRIPTION"));
            uri = bundle.getString("URI");
        }
        buttonMore = (Button) getActivity().findViewById(R.id.buttonLoadMore);
        buttonMore.setOnClickListener(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        return inflater.inflate(R.layout.fragment_article, container, false);
    }

    public void updateArticleView(String summary, String uri){
        textArticle = (TextView) getActivity().findViewById(R.id.textView);
        textArticle.setText(summary);
        buttonMore.setEnabled(true);
        this.uri = uri;
    }

    @Override
    public void onClick(View v) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
        startActivity(browserIntent);
    }
}

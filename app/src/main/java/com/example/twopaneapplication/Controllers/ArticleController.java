package com.example.twopaneapplication.Controllers;

import com.example.twopaneapplication.Interfaces.IArticle;

/**
 * Created by Amaury Esparza on 07/12/2014.
 */
public class ArticleController implements IArticle{

    @Override
    public String getArticles(int position){
        String[] descriptions = {"Description 1", "Description 2", "Description 3", "Description 4", "Description 5"};
        return descriptions[position];
    }
}

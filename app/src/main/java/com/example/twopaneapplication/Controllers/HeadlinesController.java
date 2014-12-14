package com.example.twopaneapplication.Controllers;

import com.example.twopaneapplication.Interfaces.IHeadlines;

/**
 * Created by Amaury Esparza on 07/12/2014.
 */
public class HeadlinesController implements IHeadlines {
    @Override
    public String[] getHeadlines(){
        return new String[]{"Headline 1", "Headline 2", "Headline 3", "Headline 4", "Headline 5"};
    }
}

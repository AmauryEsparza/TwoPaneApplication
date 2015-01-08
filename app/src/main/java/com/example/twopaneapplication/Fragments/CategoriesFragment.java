package com.example.twopaneapplication.Fragments;

import android.app.Activity;
import android.app.ListFragment;
import android.os.Bundle;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.twopaneapplication.Controllers.CategoryController;
import com.example.twopaneapplication.Interfaces.BaseListFragmentCommunicator;
import com.example.twopaneapplication.Models.Category;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit.client.Response;

/**
 * Created by Amaury Esparza on 20/12/2014.
 */
public class CategoriesFragment extends ListFragment{

    private ArrayAdapter<String> arrayAdapterCategory;
    ArrayList<String> arrayListCategories;
    //private CategoriesFragment.OnFragmentInteractionListener mCallback;
    private BaseListFragmentCommunicator mCallback;
    private String[] categoriesName = {"No data"};
    private List<Category> listCategories;

    public CategoriesFragment(){
        //Public Constructor
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        CategoryController categoryController = new CategoryController(this);
        categoryController.getCategoriesList();
        arrayListCategories = new ArrayList<>();
        arrayListCategories.addAll(Arrays.asList(categoriesName));
        arrayAdapterCategory = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, arrayListCategories);
        setListAdapter(arrayAdapterCategory);
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id){
        //Notify the parent Activity of selected item
        if(listCategories != null) {
            //mCallback.onArticleSelected(position, listCategories.get(position).getCategoryId());
            mCallback.onSelectedListItem(listCategories.get(position));
            //Set the item as checked
            getListView().setItemChecked(position, true);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            //mCallback = (OnFragmentInteractionListener) activity;
            mCallback = (BaseListFragmentCommunicator) activity;
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
        public void onArticleSelected(int position, int categoryId);
    }

    public void responseListener(List<Category> listCategories, Response response){
        //Update the ArrayList content
        if(listCategories != null) {
            this.listCategories = listCategories;
            arrayAdapterCategory.clear();
            int i = 0;
            categoriesName = new String[listCategories.size()];
            for(Category category : listCategories){
                categoriesName[i] = category.getEnglishCategoryName();
                i++;
            }
            arrayAdapterCategory.addAll(categoriesName);
            arrayAdapterCategory.notifyDataSetChanged();
        }
        else{
            //If the list are null
            setEmptyText("Server Error, try again later");
        }

    }
}

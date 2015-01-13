package com.example.twopaneapplication.Fragments;

import android.app.Activity;
import android.app.ListFragment;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.app.Fragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.example.twopaneapplication.Controllers.HeadlinesController;
import com.example.twopaneapplication.Interfaces.BaseListFragmentCommunicator;
import com.example.twopaneapplication.Models.Article;
import com.example.twopaneapplication.Models.ArticleDescription;

import java.util.ArrayList;
import java.util.Arrays;

import retrofit.client.Response;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link HeadlinesFragment.OnHeadlinesFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link HeadlinesFragment#newInstance} factory method to
 * create an instance of this fragment.
 *
 */
public class HeadlinesFragment extends ListFragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    //Adapter for load data
    private ArrayAdapter<String> arrayAdapterHeadlines;

    //***************************
    private ProgressDialog progressDialog;
    private HeadlinesController headlinesController;
    //Callback object
    //private HeadlinesFragment.OnHeadlinesFragmentInteractionListener mCallback;
    private BaseListFragmentCommunicator mCallback;
    private int categoryId;
    private ArrayList<String> arrayListHeadlines;
    private String[] arrayStringHeadlines = {"No data"};
    private ArticleDescription articleDescription;

    //*****************************
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment headlines.
     */
    // TODO: Rename and change types and number of parameters
    public static HeadlinesFragment newInstance(String param1, String param2) {
        HeadlinesFragment fragment = new HeadlinesFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    public HeadlinesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        headlinesController = new HeadlinesController(this);
        headlinesController.getHeadlinesList(categoryId);
        arrayListHeadlines = new ArrayList<>();
        arrayListHeadlines.addAll(Arrays.asList(arrayStringHeadlines));
        arrayAdapterHeadlines = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, arrayListHeadlines);
        setListAdapter(arrayAdapterHeadlines);
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        //Here we can put compatibility with another Android API
    }
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        categoryId = activity.getIntent().getExtras().getInt("category_id");
        try {
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

    @Override
    public void onListItemClick(ListView l, View v, int position, long id){
        if(articleDescription != null) {
            //Notify the parent Activity of selected item
            mCallback.onSelectedListItem(articleDescription.getArticles().get(position));
            //Set the item as checked
            getListView().setItemChecked(position, true);
        }
    }
    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */

    public void responseListener(ArticleDescription articleDescription, Response response) {
        if (articleDescription != null) {
            this.articleDescription = articleDescription;
            arrayAdapterHeadlines.clear();
            int i = 0;
            arrayStringHeadlines = new String[articleDescription.getArticles().size()];
            for (Article article : articleDescription.getArticles()) {
                arrayStringHeadlines[i] = article.getTitle();
                i++;
            }
            arrayAdapterHeadlines.addAll(arrayStringHeadlines);
            arrayAdapterHeadlines.notifyDataSetChanged();
        }
    }
}

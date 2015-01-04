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


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Headlines.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Headlines#newInstance} factory method to
 * create an instance of this fragment.
 *
 */
public class Headlines extends ListFragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    //Adapter for load data
    private ArrayAdapter<String> arrayAdapter;

    //***************************
    private ProgressDialog progressDialog;
    private HeadlinesController headlinesController;
    //Callback object
    private OnFragmentInteractionListener mCallback;

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
    public static Headlines newInstance(String param1, String param2) {
        Headlines fragment = new Headlines();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    public Headlines() {
        // Required empty public constructor
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    /*
    //This is in case we need to personalize the list
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_headlines, container, false);
    }*/

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        //Here we can put compatibility with another Android API

        //ProgressDialog
        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("Loading Data...");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setIndeterminate(true);
        progressDialog.show();

        //This its bad use thread.post for modify UI elements.
        headlinesController = new HeadlinesController();
        new Thread(new Runnable() {
            @Override
            public void run() {
                String[] headlines = headlinesController.getHeadlines();
                arrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, headlines);
                setListAdapter(arrayAdapter);
            }
        }).start();
        progressDialog.dismiss();
    }
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mCallback = (OnFragmentInteractionListener) activity;
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
        //Notify the parent Activity of selected item
        mCallback.onArticleSelected(position);
        //Set the item as checked
        getListView().setItemChecked(position, true);
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
    public interface OnFragmentInteractionListener {
        public void onArticleSelected(int position);

    }

}

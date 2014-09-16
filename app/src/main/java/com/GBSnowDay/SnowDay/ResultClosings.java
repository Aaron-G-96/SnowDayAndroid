package com.GBSnowDay.SnowDay;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ResultClosings.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ResultClosings#newInstance} factory method to
 * create an instance of this fragment.
 *
 */
public class ResultClosings extends Fragment {
    //Declare all views
    TextView txtGB;
    TextView txtCarman;
    TextView txtAtherton;
    TextView txtBendle;
    TextView txtFlint;
    TextView txtGoodrich;
    TextView txtBeecher;
    TextView txtClio;
    TextView txtDavison;
    TextView txtFenton;
    TextView txtFlushing;
    TextView txtGenesee;
    TextView txtKearsley;
    TextView txtLKFenton;
    TextView txtLinden;
    TextView txtMontrose;
    TextView txtMorris;
    TextView txtSzCreek;
    TextView txtDurand;
    TextView txtHolly;
    TextView txtLapeer;
    TextView txtOwosso;
    TextView txtGBAcademy;
    TextView txtGISD;
    TextView txtHolyFamily;
    TextView txtWPAcademy;

    TextView txtTier1;
    TextView txtTier2;
    TextView txtTier3;
    TextView txtTier4;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ResultClosings.
     */
    // TODO: Rename and change types and number of parameters
    public static ResultClosings newInstance(String param1, String param2) {
        ResultClosings fragment = new ResultClosings();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    public ResultClosings() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        //Declare views
        txtGB = (TextView) getActivity().findViewById(R.id.txtGB);
        txtCarman = (TextView) getActivity().findViewById(R.id.txtCarman);
        txtAtherton = (TextView) getActivity().findViewById(R.id.txtAtherton);
        txtBendle = (TextView) getActivity().findViewById(R.id.txtBendle);
        txtFlint = (TextView) getActivity().findViewById(R.id.txtFlint);
        txtGoodrich = (TextView) getActivity().findViewById(R.id.txtGoodrich);
        txtBeecher = (TextView) getActivity().findViewById(R.id.txtBeecher);
        txtClio = (TextView) getActivity().findViewById(R.id.txtClio);
        txtDavison = (TextView) getActivity().findViewById(R.id.txtDavison);
        txtFenton = (TextView) getActivity().findViewById(R.id.txtFenton);
        txtFlushing = (TextView) getActivity().findViewById(R.id.txtFlushing);
        txtGenesee = (TextView) getActivity().findViewById(R.id.txtGenesee);
        txtKearsley = (TextView) getActivity().findViewById(R.id.txtKearsley);
        txtLKFenton = (TextView) getActivity().findViewById(R.id.txtLKFenton);
        txtLinden = (TextView) getActivity().findViewById(R.id.txtLinden);
        txtMontrose = (TextView) getActivity().findViewById(R.id.txtMontrose);
        txtMorris = (TextView) getActivity().findViewById(R.id.txtMorris);
        txtSzCreek = (TextView) getActivity().findViewById(R.id.txtSzCreek);
        txtDurand = (TextView) getActivity().findViewById(R.id.txtDurand);
        txtHolly = (TextView) getActivity().findViewById(R.id.txtHolly);
        txtLapeer = (TextView) getActivity().findViewById(R.id.txtLapeer);
        txtOwosso = (TextView) getActivity().findViewById(R.id.txtOwosso);
        txtGBAcademy = (TextView) getActivity().findViewById(R.id.txtGBAcademy);
        txtGISD = (TextView) getActivity().findViewById(R.id.txtGISD);
        txtHolyFamily = (TextView) getActivity().findViewById(R.id.txtHolyFamily);
        txtWPAcademy = (TextView) getActivity().findViewById(R.id.txtWPAcademy);

        txtTier1 = (TextView) getActivity().findViewById(R.id.txtTier1);
        txtTier2 = (TextView) getActivity().findViewById(R.id.txtTier2);
        txtTier3 = (TextView) getActivity().findViewById(R.id.txtTier3);
        txtTier4 = (TextView) getActivity().findViewById(R.id.txtTier4);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.result_closings, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
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
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

}

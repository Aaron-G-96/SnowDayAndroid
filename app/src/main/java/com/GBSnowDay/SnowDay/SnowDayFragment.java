<<<<<<< HEAD
package com.GBSnowDay.SnowDay;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SnowDayFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SnowDayFragment#newInstance} factory method to
 * create an instance of this fragment.
 *
 */
public class SnowDayFragment extends Fragment {
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
     * @return A new instance of fragment SnowDayFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SnowDayFragment newInstance(String param1, String param2) {
        SnowDayFragment fragment = new SnowDayFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    public SnowDayFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_snow_day, container, false);
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
=======
package com.GBSnowDay.SnowDay;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SnowDayFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SnowDayFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SnowDayFragment extends Fragment {
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
     * @return A new instance of fragment SnowDayFragment.
     */
    // TODO: Rename and change types and number of parameters

    //Declare all views
    RadioButton optToday;
    RadioButton optTomorrow;
    TextView txtInfo;
    Spinner lstDays;
    Button btnCalculate;


    //Declare variables
    public String today;
    public String tomorrow;
    public Date date;
    public Format formatter;

    public String[] orgNameLine;
    public String[] statusLine;

    public int days;
    public int dayrun;

    //Figure out what tomorrow is
    //Saturday = 0, Sunday = 1

    Calendar calendar = Calendar.getInstance();
    int weekday = calendar.get(Calendar.DAY_OF_WEEK);
    int month = calendar.get(Calendar.MONTH);


    public static SnowDayFragment newInstance(String param1, String param2) {
        SnowDayFragment fragment = new SnowDayFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public SnowDayFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setContentView(R.layout.activity_snow_day);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_snow_day, container, false);
    }

    public void Calculate() {
        /**
         * This method will predict the possibility of a snow day for Grand Blanc Community Schools.
         * Created by Corey Rowe, July 2014 - port of original Swing GUI.
         * Factors:
         * Predicted snowfall and time of arrival (not yet implemented)
         * Predicted ice accumulation (not yet implemented)
         * Predicted wind chill (below -20F?) (not yet implemented)
         * Number of snow days accrued (more = smaller chance) (not yet implemented)
         * Schools currently closed (data from WJRT) (not yet implemented)
         * Schools in higher tiers (5 is highest) will increase the snow day chance.
         * Obviously return 100% if GB is already closed.
         */
        System.out.println("Calculation has started");
        //Call a reset to clear any previous data
        Reset();

        //Date setup
        System.out.println("Checking selected day");
        if (optToday.isChecked()) {
            dayrun = 0;
            System.out.println("dayrun set to 0 (Today)");
        } else if (optTomorrow.isChecked()) {
            System.out.println("dayrun set to 1 (Tomorrow)");
            dayrun = 1;
        }

        System.out.println("Determining date");
        date = calendar.getTime();
        formatter = new SimpleDateFormat("MMM dd yyyy");
        today = formatter.format(date);
        calendar.add(Calendar.DATE, 1);
        date = calendar.getTime();
        formatter = new SimpleDateFormat("MMM dd yyyy");
        tomorrow = formatter.format(date);

        //Set calculation to today or tomorrow
        if (dayrun == 0) {
            txtInfo.setText(txtInfo.getText() + "\n" + this.getString(R.string.DayRun) + " " + this.getString(R.string.today));
            System.out.println("Today is " + today);
        } else if (dayrun == 1) {
            txtInfo.setText(txtInfo.getText() + "\n" + this.getString(R.string.DayRun) + " " + this.getString(R.string.tomorrow));
            System.out.println("Tomorrow is " + tomorrow);
        }

        //Have the user input past snow days
        days = lstDays.getSelectedItemPosition() - 1;
        System.out.println("User says " + days + " snow days have occurred.");
    }

    public void onStart() {
        super.onStart();
        //Declare views
        optToday = (RadioButton) getView().findViewById(R.id.optToday);
        optTomorrow = (RadioButton) getView().findViewById(R.id.optTomorrow);
        txtInfo = (TextView) getView().findViewById(R.id.txtInfo);
        lstDays = (Spinner) getView().findViewById(R.id.lstDays);
        btnCalculate = (Button) getView().findViewById(R.id.btnCalculate);


        //Make sure the user doesn't try to run the program on the weekend or during school hours
        checkWeekend();
        checkTime();
        //Listen for optToday or optTomorrow changes
        optToday.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                System.out.println("optToday checked");
                if (lstDays.getSelectedItemId() != 0) {
                    btnCalculate.setEnabled(true);
                }
            }
        });
        optTomorrow.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                System.out.println("optTomorrow checked");
                if (lstDays.getSelectedItemId() != 0) {
                    btnCalculate.setEnabled(true);

                }
            }
        });

        //Listen for lstDays changes
        lstDays.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                if (lstDays.getSelectedItemId() == 0) {
                    btnCalculate.setEnabled(false);
                } else if (!optToday.isChecked() && !optTomorrow.isChecked()) {
                    btnCalculate.setEnabled(false);
                } else {
                    btnCalculate.setEnabled(true);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        //Listen for button click
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                System.out.println("btnCalculate clicked");
                btnCalculate.setEnabled(false);
                //btnCalculate.setBackgroundColor(Color.rgb(2, 154, 204));
                Calculate();
                //Switch to SnowDayResult activity
                //Pass value of 'days' to new activity

                Intent result = new Intent(getActivity().getApplicationContext(), SnowDayResult.class);
                result.putExtra("dayrun", dayrun);
                result.putExtra("days", days);
                System.out.println("Switching to activity_snow_day_result");
                startActivity(result);
            }
        });
    }

    private void Reset() {
        System.out.println("Resetting SnowDay variables");
        //Reset variables
        today = "";
        tomorrow = "";
        txtInfo.setText("");
    }

    private void checkWeekend() {
        System.out.println("Checking the Weekend...");
        //Friday is 6
        //Saturday is 7
        //Sunday is 1

        if (weekday == 6) {
            System.out.println("Today is Friday (6).");
            txtInfo.setText(R.string.SaturdayTomorrow);
            optTomorrow.setEnabled(false);
            optToday.setChecked(true);
        } else if (weekday == 7) {
            System.out.println("Today is Saturday (7).");
            txtInfo.setText(R.string.SaturdayToday);
            optToday.setEnabled(false);
            optTomorrow.setEnabled(false);
            lstDays.setEnabled(false);
        } else if (weekday == 1) {
            System.out.println("Today is Sunday (1).");
            txtInfo.setText(R.string.SundayToday);
            optToday.setEnabled(false);
            optTomorrow.setChecked(true);
        }
    }

    private void checkTime() {
        System.out.println("Checking the time...");
        if (calendar.get(Calendar.HOUR_OF_DAY) >= 7 && calendar.get(Calendar.HOUR_OF_DAY) < 16 && weekday != 7 && weekday != 1) {
            System.out.println("Time is between 7AM and 4PM.");
            System.out.println("The school's already open.");
            optToday.setEnabled(false);
            //txtGB.setText("Grand Blanc: OPEN");
            txtInfo.setText(txtInfo.getText() + this.getString(R.string.SchoolOpen));
            dayrun = 1;
        } else if (calendar.get(Calendar.HOUR_OF_DAY) >= 16 && weekday != 7 && weekday != 1) {
            //txtGB.setText("Grand Blanc: Dismissed");
            //txtGB.setBackgroundColor(Color.YELLOW);
            optToday.setEnabled(false);
            System.out.println("Time is after 4PM");
            System.out.println("School's already out for today!");
            txtInfo.setText(txtInfo.getText() + this.getString(R.string.GBDismissed));
            dayrun = 1;
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
        System.out.println("SnowDayFragment attached!");

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
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }



}
>>>>>>> master

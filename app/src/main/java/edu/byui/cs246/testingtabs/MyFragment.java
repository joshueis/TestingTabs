package edu.byui.cs246.testingtabs;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by israelcarvajal on 11/15/15.
 */
public class MyFragment extends Fragment{
    public static MyFragment newInstance() {
        MyFragment fragment = new MyFragment();
        return fragment;
    }
    public MyFragment() {
    }
    Button ClickMe;
    TextView tv;
    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             final Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.my_fragment, container, false);
        ClickMe = (Button) rootView.findViewById(R.id.button);
        tv = (TextView) rootView.findViewById(R.id.textView2);
        ClickMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv.setText("Hello wold from my Fragment");
                View v = view.getRootView();
                v = inflater.inflate(R.layout.fragment_main, container, false);
//                PlaceholderFragment testing = new PlaceholderFragment().newInstance(3);
//                FragmentTransaction ft = getFragmentManager().beginTransaction();
//                //ft.replace(,testing);
//
//                ft.add(testing,"my_attempt");
//                ft.addToBackStack(null);
//                ft.commit();
            }
        });
        return rootView;
    }
} // This is the end of our MyFragments Class


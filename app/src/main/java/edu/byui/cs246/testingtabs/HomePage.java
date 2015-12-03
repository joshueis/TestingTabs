package edu.byui.cs246.testingtabs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class HomePage extends Fragment {

    public static HomePage newInstance(){
        HomePage homePage = new HomePage();
        return homePage;
    }
    public HomePage(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.content_home_page, container, false);

        TextView textElement = (TextView) rootView.findViewById(R.id.contactInfo);
        textElement.setText("Contact us\n" + "208.416.6500\n" + "THEREXBURG@GMAIL.COM");

        return rootView;
    }
}

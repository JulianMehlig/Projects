package com.julianmehlig.navdrawer;

/**
 * Created by Julian on 07.08.2018.
 */

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * Created by Belal on 18/09/16.
 */


public class Menu3 extends Fragment
{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_menu_3, container, false);
        //returning our layout file
        //change R.layout.yourlayoutfilename for each of your fragments
        String [] menuItems = {"Netflix", "AmazonPrime", "Handyvertrag", "Wohnung", "Fitnessstudio", "Garage", "Parkplatzmiete", "Spotify", "Strom", "Wasser", "Heizung", "Gas", "Benzin", "TV", "Zeitungsabo", "GitHub", "VersicherungHandy", "Autoversicherung", "Reperaturkosten", "Auto"};

        /*ArrayList<String>  list = new ArrayList<>();
        list.add("12");
        list.add("12");*/
        Global.list.clear();

        for (String p:menuItems)
        {
            Global.list.add(p);
        }

        MyCustomAdapter tryout = new MyCustomAdapter(Global.list, view.getContext());

        ListView sublist = view.findViewById(R.id.allsubs);

        ArrayAdapter<String> listViewAdapter = new ArrayAdapter<String>(
          getActivity(), android.R.layout.simple_list_item_1, menuItems
        );

        sublist.setAdapter(tryout);
        return view;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("Abos verwalten");
    }
}
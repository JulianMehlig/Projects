package com.julianmehlig.navdrawer;

/**
 * Created by Julian on 07.08.2018.
 * Activity mss in Fragment laufen!!!! DB muss erstellt und ausgelesen werden! List muss erstell werden und in die Datenbank gespeichert werden / oder in TextDatei.. 
 */

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;
import java.util.TreeSet;

/**
 * Created by Belal on 18/09/16.
 */


public class Menu1 extends Fragment
{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        //returning our layout file
        //change R.layout.yourlayoutfilename for each of your fragments
        return inflater.inflate(R.layout.fragment_menu_1, container, false);
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("Überblick");

        TextView monthlycosts = (TextView) view.findViewById(R.id.monthlycost);
        TextView highestcost = (TextView) view.findViewById(R.id.highestcost);


        DBHelper db = new DBHelper(view.getContext());
        List<Subscription> sublist =  db.getAllBooks();
        Double costs = new Double(0);
        Subscription mostexp = new Subscription("Teuerstes", 0.00);

        for (Subscription s : sublist)
        {
            if (s.getCost() > mostexp.getCost())
            {
                mostexp.setName(s.getName());
                mostexp.setCost(s.getCost());
            }
            costs+=s.getCost();
        }

        if (costs<=0)
        {
            monthlycosts.setText("Keine Ausgaben");
        }
        if (sublist.isEmpty())
        {
            highestcost.setText("Keine Ausgaben");
        }

        else {
            monthlycosts.setText(String.valueOf(Math.round(costs*100.0)/100.0));
            highestcost.setText(mostexp.getName() + "\n" + String.valueOf(Math.round(mostexp.getCost()*100.0)/100.0));
        }
    }
}
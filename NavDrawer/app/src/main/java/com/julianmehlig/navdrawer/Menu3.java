package com.julianmehlig.navdrawer;

/**
 * Created by Julian on 07.08.2018.
 */

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

/**
 * Created by JM
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
        Global.list.clear();

        DBHelper db = new DBHelper(getContext());

        MyCustomAdapter tryout = new MyCustomAdapter(db.getAllBooks(), view.getContext());

        ListView sublist = view.findViewById(R.id.allsubs);

        sublist.setAdapter(tryout);
        return view;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("Abos verwalten");
    }
}
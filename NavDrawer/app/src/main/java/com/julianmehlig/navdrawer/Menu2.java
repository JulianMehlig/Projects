package com.julianmehlig.navdrawer;

/**
 * Created by Julian on 07.08.2018.
 */

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by Belal on 18/09/16.
 */

public class Menu2 extends Fragment
{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.fragment_menu_2, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Neues Abo hinzufügen");

        final EditText name = (EditText) getView().findViewById(R.id.name);
        final EditText monthcost = (EditText) getView().findViewById(R.id.cost);
        final ImageButton bt = (ImageButton) getView().findViewById(R.id.addsub);


        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String check2 = monthcost.getText().toString();
                String check = name.getText().toString();
                if (!check.isEmpty() && !check2.isEmpty())
                {
                    DBHelper db = new DBHelper(getContext());
                    Subscription s = new Subscription();

                    String ss = new String(name.getText().toString());
                    Double d = new Double(monthcost.getText().toString()).doubleValue();

                    s.setName(ss);
                    s.setCost(d);
                    db.addBook(s);

                    name.setText(null);
                    monthcost.setText(null);
                }
                    else
                    {
                        View coordinatorLayout = v;
                        Snackbar snackbar = Snackbar
                                .make(coordinatorLayout, "Felder nicht korrekt befüllt!", Snackbar.LENGTH_LONG);

                        snackbar.show();
                    }
            }
    });


    }
}
package com.julianmehlig.mysubs;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.DecimalFormat;

import static com.julianmehlig.mysubs.R.id.newsubname;

public class NewSub extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_sub);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.save);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                EditText name = (EditText) findViewById(R.id.newsubname);
                EditText monthlyfee = (EditText) findViewById(R.id.monthlyfee);

                Globals.subs.add(new Subscription(name.getText().toString(), "Stil1", Double.parseDouble(monthlyfee.getText().toString())));



                Snackbar.make(view, "Eine neue Ausgabe hinzufügen", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                Intent inte = new Intent(NewSub.this, Navigator.class);
                startActivity(inte);
                finish();
            }
        });


    }

    @Override
    public void onBackPressed()
    {
        Intent inte = new Intent(NewSub.this, Navigator.class);
        startActivity(inte);
        finish();
    }

}


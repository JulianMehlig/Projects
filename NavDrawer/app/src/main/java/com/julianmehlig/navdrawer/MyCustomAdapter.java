package com.julianmehlig.navdrawer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MyCustomAdapter extends BaseAdapter implements ListAdapter
{
    private List<Subscription> list = new ArrayList<>();
    private Context context;



    public MyCustomAdapter(List<Subscription> list, Context context)
    {
        this.list =list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Subscription getItem(int pos) {
        return list.get(pos);
    }

    @Override
    public long getItemId(int pos)
    {
        return 0;
        //just return 0 if your list items do not have an Id variable.
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent)
    {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.customlistitem, null);
        }

        //Handle TextView and display string from your list
        TextView listItemText = (TextView)view.findViewById(R.id.list_item_string);
        TextView listItemCost = (TextView)view.findViewById(R.id.second_text_view);
        listItemText.setText(list.get(position).toString());
        listItemCost.setText(String.valueOf(Math.round(list.get(position).getCost()*100.0)/100.0) + "€");

        //Handle buttons and add onClickListeners
        Button deleteBtn = (Button)view.findViewById(R.id.delete_btn);

        deleteBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //do something
                DBHelper db = new DBHelper(v.getContext());
                db.deleteBook(getItem(position));
                list.remove(position); //or some other task
                notifyDataSetChanged();
            }
        });


        return view;
    }
}
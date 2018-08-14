package com.julianmehlig.navdrawer;

import android.provider.BaseColumns;

public class Subscriptions
{
    private Subscriptions(){}

    public static class SubEntry implements BaseColumns
    {
        public static final String TABLE_NAME="subscription";
        public static final String COLUMN_NAME_NAME = "name";
        public static final String COLUMN_NAME_COST = "cost";
    }
}

package com.julianmehlig.navdrawer;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SubscriptionHelper extends SQLiteOpenHelper
{
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Subscriptions.db";

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + Subscriptions.SubEntry.TABLE_NAME + " (" +
                    Subscriptions.SubEntry._ID + " INTEGER PRIMARY KEY," +
                    Subscriptions.SubEntry.COLUMN_NAME_NAME + " TEXT," +
                    Subscriptions.SubEntry.COLUMN_NAME_COST + " DOUBLE)";

    @Override
    public SQLiteDatabase getReadableDatabase()
    {
        return super.getReadableDatabase();
    }

    @Override
    public SQLiteDatabase getWritableDatabase()
    {
        return super.getWritableDatabase();
    }

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + Subscriptions.SubEntry.TABLE_NAME;

    public SubscriptionHelper(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {
        sqLiteDatabase.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1)
    {
        sqLiteDatabase.execSQL(SQL_DELETE_ENTRIES);
        onCreate(sqLiteDatabase);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        onDowngrade(db, oldVersion, newVersion);
    }
}

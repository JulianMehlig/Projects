package com.julianmehlig.navdrawer;

import java.util.LinkedList;
import java.util.List;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.view.SurfaceView;

public class DBHelper extends SQLiteOpenHelper
{
    // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "SubscriptionsDB";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // SQL statement to create book table
        String CREATE_BOOK_TABLE = "CREATE TABLE subscriptions ( " +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name TEXT, "+
                "cost DOUBLE )";

        // create books table
        db.execSQL(CREATE_BOOK_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older books table if existed
        db.execSQL("DROP TABLE IF EXISTS subscription");

        // create fresh books table
        this.onCreate(db);
    }
    //---------------------------------------------------------------------

    /**
     * CRUD operations (create "add", read "get", update, delete) book + get all books + delete all books
     */

    // Books table name
    private static final String TABLE_BOOKS = "subscriptions";

    // Books Table Columns namess
    private static final String KEY_ID = "id";
    private static final String KEY_TITLE = "name";
    private static final String KEY_COST = "cost";

    private static final String[] COLUMNS = {KEY_ID,KEY_TITLE,KEY_COST};

    public void addBook(Subscription subscription)
    {
        Log.d("addBook", subscription.toString());
        // 1. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();

        // 2. create ContentValues to add key "column"/value
        ContentValues values = new ContentValues();
        values.put(KEY_TITLE, subscription.getName()); // get title
        values.put(KEY_COST, subscription.getCost()); // get author

        // 3. insert
        db.insert(TABLE_BOOKS, // table
                null, //nullColumnHack
                values); // key/value -> keys = column names/ values = column values

        // 4. close
        db.close();
    }

    public Subscription getSubscription(int id)
    {
        // 1. get reference to readable DB
        SQLiteDatabase db = this.getReadableDatabase();

        // 2. build query
        Cursor cursor =
                db.query(TABLE_BOOKS, // a. table
                        COLUMNS, // b. column names
                        " id = ?", // c. selections
                        new String[] { String.valueOf(id) }, // d. selections args
                        null, // e. group by
                        null, // f. having
                        null, // g. order by
                        null); // h. limit

        // 3. if we got results get the first one
        if (cursor != null)
            cursor.moveToFirst();

        // 4. build book object
        Subscription subscription = new Subscription();
        subscription.setId(Integer.parseInt(cursor.getString(0)));
        subscription.setName(cursor.getString(1));
        subscription.setCost(cursor.getDouble(2));

        Log.d("getBook("+id+")", subscription.toString());

        // 5. return book
        return subscription;
    }

    // Get All Books
    public List<Subscription> getAllBooks() {
        List<Subscription> subscriptions = new LinkedList<Subscription>();

        // 1. build the query
        String query = "SELECT  * FROM " + TABLE_BOOKS;

        // 2. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        // 3. go over each row, build book and add it to list
        Subscription subscription = null;
        if (cursor.moveToFirst()) {
            do {
                subscription = new Subscription();
                subscription.setId(Integer.parseInt(cursor.getString(0)));
                subscription.setName(cursor.getString(1));
                subscription.setCost(cursor.getDouble(2));

                // Add book to books
                subscriptions.add(subscription);
            } while (cursor.moveToNext());
        }

        Log.d("getAllBooks()", subscriptions.toString());

        // return books
        return subscriptions;
    }

    // Updating single book
    public int updateBook(Subscription subscription) {

        // 1. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();

        // 2. create ContentValues to add key "column"/value
        ContentValues values = new ContentValues();
        values.put("name", subscription.getName()); // get title
        values.put("cost", subscription.getCost()); // get author

        // 3. updating row
        int i = db.update(TABLE_BOOKS, //table
                values, // column/value
                KEY_ID+" = ?", // selections
                new String[] { String.valueOf(subscription.getId()) }); //selection args

        // 4. close
        db.close();

        return i;

    }

    // Deleting single book
    public void deleteBook(Subscription subscription) {

        // 1. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();

        // 2. delete
        db.delete(TABLE_BOOKS,
                KEY_ID+" = ?",
                new String[] { String.valueOf(subscription.getId()) });

        // 3. close
        db.close();

        Log.d("deleteBook", subscription.toString());

    }
}
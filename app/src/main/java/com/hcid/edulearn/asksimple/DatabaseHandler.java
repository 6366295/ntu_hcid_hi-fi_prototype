package com.hcid.edulearn.asksimple;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;;

/**
 * Created by mike on 12/27/16.
 *
 * Based on: http://www.androidhive.info/2011/11/android-sqlite-database-tutorial/
 */

public class DatabaseHandler extends SQLiteOpenHelper {
    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "databaseAskSimple";

    // Users table name
    private static final String TABLE_USERS = "users";

    // Users Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_USER= "user_id";
    private static final String KEY_PASS = "password";
    private static final String KEY_TYPE = "type";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_USERS_TABLE = "CREATE TABLE " + TABLE_USERS + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
                + KEY_USER + " TEXT UNIQUE," + KEY_PASS + " TEXT," + KEY_TYPE + " TEXT" + ")";
        db.execSQL(CREATE_USERS_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);

        // Create tables again
        onCreate(db);
    }

    void addUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, user.getName());
        values.put(KEY_USER, user.getUserID());
        values.put(KEY_PASS, user.getPassword());
        values.put(KEY_TYPE, user.getType());


        // Inserting Row
        db.insert(TABLE_USERS, null, values);
        db.close(); // Closing database connection
    }

    User getUser(String user_id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_USERS, new String[] { KEY_ID, KEY_NAME,
                        KEY_USER, KEY_PASS, KEY_TYPE }, KEY_USER + "=?",
                new String[] { user_id }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        User user;

        if (cursor == null) {
            user = new User(Integer.parseInt(cursor.getString(0)),
                    cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4));
        } else {
            user = new User();
        }

        // return contact
        return user;
    }
}

package com.example.gymapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {


    public static final String CLIENT_TABLE = "CLIENT_TABLE";
    public static final String COLUMN_NAME = "Name";
    public static final String COLUMN_EMAIL = "Email";
    public static final String COLUMN_LOCATION = "location";
    public static final String COLUMN_PASSWORD = "Password";
    public static final String COLUMN_REPEATPASSWORD = "RepeatPassword";
    public static final String COLUMN_ID = "ID";

    public DatabaseHelper(@Nullable Context context) {
        super(context, "client.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String createTableStatement = "CREATE TABLE " + CLIENT_TABLE + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAME + " TEXT," +
                COLUMN_EMAIL + " TEXT," +
                COLUMN_LOCATION + " TEXT," +
                COLUMN_PASSWORD + " TEXT," +
                COLUMN_REPEATPASSWORD + " TEXT)";

        db.execSQL(createTableStatement);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean addOne(ClientModel clientModel){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_NAME, clientModel.getName());
        cv.put(COLUMN_EMAIL, clientModel.getEmail());
        cv.put(COLUMN_LOCATION, clientModel.getLocation());
        cv.put(COLUMN_PASSWORD, clientModel.getPassword());
        cv.put(COLUMN_REPEATPASSWORD, clientModel.getRepeatpassword());

        return true;
    }
}

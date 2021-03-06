package com.example.android.pets.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.android.pets.data.MomContract.MomEntry;

/**
 * Database helper for Pets app. Manages database creation and version management.
 */
public class MomDbHelper extends SQLiteOpenHelper {

    public static final String LOG_TAG = MomDbHelper.class.getSimpleName();

    /**
     * Name of the database file
     */
    private static final String DATABASE_NAME = "mom.db";

    /**
     * Database version. If you change the database schema, you must increment the database version.
     */
    private static final int DATABASE_VERSION = 1;

    /**
     * Constructs a new instance of {@link MomDbHelper}.
     *
     * @param context of the app
     */
    public MomDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * This is called when the database is created for the first time.
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create a String that contains the SQL statement to create the pets table
        String SQL_CREATE_MOM_TABLE = "CREATE TABLE " + MomEntry.TABLE_NAME + " ("
                + MomEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + MomEntry.COLUMN_MOM_NAME + " TEXT NOT NULL, "
                + MomEntry.COLUMN_MOM_BREED + " TEXT, "
                + MomEntry.COLUMN_MOM_GENDER + " INTEGER NOT NULL, "
                + MomEntry.COLUMN_MOM_WEIGHT + " INTEGER NOT NULL DEFAULT 0,"
                + MomEntry.COLUMN_MOM_HEIGHT + " INTEGER NOT NULL DEFAULT 0);";


        // Execute the SQL statement
        db.execSQL(SQL_CREATE_MOM_TABLE);
    }

    /**
     * This is called when the database needs to be upgraded.
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // The database is still at version 1, so there's nothing to do be done here.
    }
}
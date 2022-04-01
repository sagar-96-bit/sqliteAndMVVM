package com.example.sqliteandmvvm;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SqliteDB extends SQLiteOpenHelper {
    private final String TAG=this.getClass().getSimpleName();
    private static final String DBName="mydb.db";
    private static final int DBversion=1;
    private static final String tableName="emp_table";
    private static final String Column1="emp_id";
    private static final String Column2="emp_name";
    private static final String Column3="emp_age";
    private static final String Column4="emp_salary";
    private static final String Column5="emp_address";
    private static String CREATE_TABLE="create table "+tableName+"("+Column1+" INTEGER PRIMARY KEY AUTOINCREMENT, "+Column2+" TEXT NOT NULL, "+Column3+" TEXT NOT NULL,"+Column4+" TEXT NOT NULL, "+Column5+" TEXT NOT NULL)";


    public SqliteDB( Context context) {
        super(context, DBName, null, DBversion);
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
                 sqLiteDatabase.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}

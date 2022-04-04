package com.example.sqliteandmvvm;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

class SqliteDBAdapter {
       private Context context;

      private static SqliteDBAdapter sqliteDBAdapter;
 private SQLiteDatabase sqLiteDatabase;
    private final String TAG=this.getClass().getSimpleName();
    private static final String DBName="mydb.db";
    private static final int DBversion=1;
    private static final String tableName="emp_table";
    private static final String Column1="emp_id";
    private static final String Column2="emp_name";
    private static final String Column3="emp_age";
    private static final String Column4="emp_salary";
    private static final String Column5="emp_address";
    private static String CREATE_TABLE="create table "+tableName+"("+Column1+" Integer PRIMARY KEY, "+Column2+" TEXT NOT NULL, "+Column3+" TEXT NOT NULL,"+Column4+" TEXT NOT NULL,"+Column5+" TEXT NOT NULL)";

    private SqliteDBAdapter(Context context)
     {
         this.context=context;
         sqLiteDatabase=new MySqliteDatabaseHelper(this.context,DBName,null,DBversion).getWritableDatabase();
     }



    public static SqliteDBAdapter getSqliteAdapterInstnce(Context context)
     {
             if(sqliteDBAdapter==null)
             {
                 sqliteDBAdapter=new SqliteDBAdapter(context);

             }
             return sqliteDBAdapter;
}


public int TotalData()
{
    int totalSize=0;
    Cursor cursor=sqLiteDatabase.query(tableName,null,null,null,null,null,null);
    if(cursor!=null&&cursor.getCount()>=0)
    {
        while(cursor.moveToNext())
        {
            //empdata e=new empdata(cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4));
              totalSize++;
        }

    }
      return totalSize;
}

    public boolean insertEmployee(String name,String age,String salary,String address)
    {
        ContentValues cv=new ContentValues();
        cv.put(Column2,name);
        cv.put(Column3,age);
        cv.put(Column4,salary);
        cv.put(Column5,address);
        long l=sqLiteDatabase.insert(tableName,null,cv);
         if(l>-1)
             return true;
         else
             return false;

    }

    public boolean removeData(int pos)
    {

        int res=sqLiteDatabase.delete(tableName, Column1+"="+pos,null);
         if(res>0)
         {
              return true;
         }
           else
               return false;
    }



//    public boolean updateData(empdata emp)
//    {
//
//           sqLiteDatabase.update(tableName,)
//    }

    public List<empdata> getAllData()
    {
         ArrayList<empdata> emp=new ArrayList<>();
        Cursor cursor=sqLiteDatabase.rawQuery("select * from "+tableName,null);
        if(cursor!=null&&cursor.getCount()>=0)
        {
               while(cursor.moveToNext())
               {
                    empdata e=new empdata(cursor.getInt(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4));

                    emp.add(e);
               }

        }
        return emp;
    }



    private static class MySqliteDatabaseHelper extends SQLiteOpenHelper
    {

        public MySqliteDatabaseHelper(Context context,String name,SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
             sqLiteDatabase.execSQL(CREATE_TABLE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        }

        @Override
        public void onConfigure(SQLiteDatabase db) {
            super.onConfigure(db);
            db.setForeignKeyConstraintsEnabled(true);
        }
    }

}

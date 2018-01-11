package com.example.regis.MyData;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/*
 * Created by Regis on 09-01-2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
   public static final String database_Name="MyUsers.db";
    String table_Name="User";
    String userName="UserName";
    String password="password";
    String query=" DROP TABLE IF EXISTS " +table_Name;
    String sqlQuery="CREATE TABLE  " + table_Name + "(\n" +
            "\t`UserId`\tINTEGER PRIMARY KEY AUTOINCREMENT,\n" +
            "\t" + userName + "\tTEXT NOT NULL,\n" +
            "\t" + password + "\tTEXT NOT NULL\n" +
            ");";

    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, database_Name, factory, version);
    }
public long registerUser(UserReg reg){
    SQLiteDatabase database=getWritableDatabase();
    ContentValues contentValues=new ContentValues();
    contentValues.put(userName,reg.getUserName());
    contentValues.put(password,reg.getPassword());
    long val =database.insert(table_Name,null,contentValues);
    Log.v("Message ","value "+val);

return val;


}
public String checUser(String user,String pass){
    String status="failure";
    SQLiteDatabase database=getReadableDatabase();

    Cursor cursor=database.rawQuery("select * from " + table_Name + " where " + userName + " =  '"+user+"' and   " + password+
            "= '"+pass+"'",null);
if(cursor.moveToFirst()){
  //  status=cursor.getString(1);
    status="sucess";
}



    return status;


}
    @Override
    public void onCreate(SQLiteDatabase db) {
      db.execSQL(sqlQuery);
        Log.v("Message","OnCraete");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(query);
        onCreate(db);
        Log.v("Message","OnUpgrade");
    }
}

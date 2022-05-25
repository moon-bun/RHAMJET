package com.RHAMJET.rhamscan;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseAccess {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase db;
    private static DatabaseAccess instance;
    Cursor c = null;

    private DatabaseAccess(Context context){
        this.openHelper = new DatabaseOpenHelper(context);
    }

    public static DatabaseAccess getInstance(Context context) {
        if(instance==null){
            instance=new DatabaseAccess(context);
        }
        return instance;
    }

    //to open the database
    public void open() {
        this.db = openHelper.getWritableDatabase();
    }

    public void close() {
        if(db!=null) {
            this.db.close();
        }
    }
    //Query
    public String getAddress(String msg) {
        //String msg = getIntent().getStringExtra("Key");
        c=db.rawQuery("SELECT artName, artDescription FROM artTable WHERE artID= '" +msg+"'",new String[]{});
        StringBuffer buffer = new StringBuffer();
        while (c.moveToNext()) {
            String address = c.getString(0);
            buffer.append("" + address);
        }
        return buffer.toString();
    }

    private Intent getIntent() {
        return null;
    }


}

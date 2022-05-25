package com.RHAMJET.rhamscan;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.HashMap;
import java.util.Map;

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
    public Map<String,String> getAddress(String msg) {
        //String msg = getIntent().getStringExtra("Key");
        c=db.rawQuery("SELECT artName, artDescription FROM artTable WHERE artID= '" +msg+"'",new String[]{});
        System.out.println();
        //StringBuffer buffer = new StringBuffer();
        Map result=new HashMap<String,String>();
        while (c.moveToNext()) {
            @SuppressLint("Range") String address = c.getString(c.getColumnIndex("artName"));
            @SuppressLint("Range") String description=c.getString(c.getColumnIndex("artDescription"));
            result.put("ArtName",address);
            result.put("Description",description);
            //buffer.append("" + address);
        }
        return result;
    }

    private Intent getIntent() {
        return null;
    }


}

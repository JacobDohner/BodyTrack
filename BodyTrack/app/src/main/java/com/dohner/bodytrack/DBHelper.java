package com.dohner.bodytrack; /**
 * Created by Dohner on 2/7/2017.
 */
import java.util.ArrayList;
import java.util.HashMap;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "BodyTrack.db";
    public static final String WEIGHTS_TABLE_NAME = "weights";
    public static final String WEIGHTS_COLUMN_AMOUNT = "weightAmount";
    public static final String WEIGHTS_COLUMN_DATE = "name";
    public static final String WEIGHTS_COLUMN_ID = "id";
    private HashMap hp;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME , null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        db.execSQL(
                "create table weights " +
                        "(id integer primary key, weight text,date text)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS weights");
        onCreate(db);
    }

    public boolean insertContact (String weight, String date) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("weight", weight);
        contentValues.put("date", date);
        db.insert("weights", null, contentValues);
        return true;
    }

    //changing everything over to weight and different values :(

    public Cursor getData(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from weights where id="+id+"", null );
        return res;
    }

    public int numberOfRows(){
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, WEIGHTS_TABLE_NAME);
        return numRows;
    }

    public boolean updateContact (Integer id, String weight, String date) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("weight", weight);
        contentValues.put("date", date);
        db.update("weights", contentValues, "id = ? ", new String[] { Integer.toString(id) } );
        return true;
    }

    public Integer deleteContact (Integer id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("weights",
                "id = ? ",
                new String[] { Integer.toString(id) });
    }

    public ArrayList<String> getAllWeights() {
        ArrayList<String> array_list = new ArrayList<String>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from weights", null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            array_list.add(res.getString(res.getColumnIndex(WEIGHTS_COLUMN_AMOUNT)));
            res.moveToNext();
        }
        return array_list;
    }
}

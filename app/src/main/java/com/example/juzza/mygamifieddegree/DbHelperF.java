package com.example.juzza.mygamifieddegree;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DbHelperF extends SQLiteOpenHelper {

    private Context mContext;

    //DB version, table and database name
    private static final int DB_VERSION = 30;
    private static final String DB_NAME = "FriendDb";
    private static final String DB_TABLE = "Friends";

    //table column names
    private static final String FriendName = "friendname";
    private static final String IsFriend = "isfriend";
    private static final String CourseCompleted = "coursecompleted";



    private SQLiteDatabase dbase;
    private int rowCount = 0;

    //Constructor for a DatabaseHelper.
    public DbHelperF(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        dbase = db;
        //First table
        String sqlQuery = String.format("CREATE TABLE IF NOT EXISTS %s (%s TEXT, %s TEXT, %s TEXT)", DB_TABLE, FriendName, IsFriend, CourseCompleted);
        db.execSQL(sqlQuery);
        //debugging log only
        Log.d("TaskDBHelper", "Query to form table" + sqlQuery);

        addFriends();
    }

    private void addFriends() {
        Friend f1 = new Friend("John Smith",0,5);
        this.addFriendToDB(f1);
        Friend f2 = new Friend("Scott Morrison",0,15);
        this.addFriendToDB(f2);
        Friend f3 = new Friend("Bill Shorten",0,21);
        this.addFriendToDB(f3);
    }


    public void addFriendToDB(Friend f) {
        ContentValues values = new ContentValues();
        values.put(FriendName, f.getFriendName());
        values.put(IsFriend, f.getIsFriend());
        values.put(CourseCompleted, f.getCourseCompleted());


        dbase.insert(DB_TABLE, null, values);

    }
    public List<Friend> getAllFriends() {
        List<Friend> friendList = new ArrayList<Friend>();

        dbase = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM " + DB_TABLE + " WHERE isFriend = 0";
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        rowCount = cursor.getCount();

        if (cursor.moveToFirst()) {
            do {
                Friend f = new Friend();
                f.setFriendName(cursor.getString(0));
                f.setIsFriend(cursor.getInt(1));
                f.setCourseCompleted(cursor.getInt(2));
                friendList.add(f);

            } while (cursor.moveToNext());
        }
        return friendList;
    }

    public List<Friend> getAllFriendsAdded() {
        List<Friend> friendList = new ArrayList<Friend>();

        dbase = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM " + DB_TABLE + " WHERE isFriend = 1";
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        rowCount = cursor.getCount();

        if (cursor.moveToFirst()) {
            do {
                Friend f = new Friend();
                f.setFriendName(cursor.getString(0));
                f.setIsFriend(cursor.getInt(1));
                f.setCourseCompleted(cursor.getInt(2));
                friendList.add(f);

            } while (cursor.moveToNext());
        }
        return friendList;
    }


    public void updateIsFriend(String friendName) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "UPDATE " + DB_TABLE + " SET " + IsFriend +
                " = '" + 1 + "' WHERE " + FriendName + " = '" + friendName + "'";
        db.execSQL(query);
    }
    /*

    public void updateEnable(List<String> course) {

        String[] courseStrings = new String[course.size()];
        courseStrings = course.toArray(courseStrings);
        SQLiteDatabase db = this.getWritableDatabase();
        for (String title : courseStrings) {
            String query = "UPDATE " + DB_TABLE + " SET " + IsEnabled +
                    " = '" + 1 + "' WHERE " + CourseTitle + " = '" + title + "'";
            db.execSQL(query);
        }

    }


    public int getIsEnabled(String course) {
        dbase = this.getReadableDatabase();
        int isComplete;
        String selectQuery = "SELECT enabled FROM " + DB_TABLE + " WHERE " + CourseTitle + "='" + course + "'";
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            isComplete = cursor.getInt(cursor.getColumnIndex("enabled"));
        } else {
            isComplete = 2;
        }
        //int isComplete = cursor.getInt(cursor.getColumnIndex("completed"));
        return isComplete;
    }

*/
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DB_TABLE);
        onCreate(db);
    }

    public int getRowCount() {
        return rowCount;
    }}

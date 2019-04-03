package com.example.juzza.mygamifieddegree;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DbHelper extends SQLiteOpenHelper {

    private Context mContext;

    //DB version, table and database name
    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "CoursesDb";
    private static final String DB_TABLE = "Courses";

    //table column names
    private static final String CourseTitle = "title";
    private static final String CourseFaculty = "faculty";
    private static final String CourseDescription = "description";
    private static final String CourseType = "type";
    private static final String IsEnabled = "enabled";
    private static final String IsCompleted = "completed";
    private static final String courseImage = "image";


    private SQLiteDatabase dbase;
    private int rowCount = 0;

    //Constructor for a DatabaseHelper.
    public DbHelper(Context context){
        super(context,DB_NAME,null,DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        dbase = db;
        //First table
        String sqlQuery = String.format("CREATE TABLE IF NOT EXISTS %s ( %s TEXT, %s TEXT, %s TEXT, %s TEXT, %s INT, %s INT, %s BLOB )", DB_TABLE, CourseTitle, CourseFaculty, CourseDescription, CourseType, IsEnabled, IsCompleted, courseImage);
        db.execSQL(sqlQuery);
        //debugging log only
        Log.d("TaskDBHelper", "Query to form table" + sqlQuery);

        addCourses();
    }

    private void addCourses() {
        Course c1 = new Course("INFS1602","Information Systems","Digital Transformation in Business","Core",1,0);
        this.addCourseToDB(c1);
        Course c2 = new Course("INFS1603","Information Systems","Introduction to Business Databases","Core",1,0);
        this.addCourseToDB(c2);
        Course c3 = new Course("INFS1609","Information Systems","Fundamentals of Business Programming","Core",1,0);
        this.addCourseToDB(c3);
        Course c4 = new Course("INFS2605","Information Systems","Intermediate Business Programming","Core",0,0);
        this.addCourseToDB(c4);
        Course c5 = new Course("INFS2631","Information Systems","Innovation and Technology Management","Elective",0,0);
        this.addCourseToDB(c5);
        Course c6 = new Course("INFS2603","Information Systems","Business Analysis \nThis course utilizes methodologies and approaches such as Agile Scrum, Design Thinking and Object-Orientation to analyse and design business information systems","Core",1,0);
        this.addCourseToDB(c6);
        Course c7 = new Course("INFS3020","Information Systems","International Information Systems and Technology Practicum","Elective",0,0);
        this.addCourseToDB(c7);
        Course c8 = new Course("INFS3632","Information Systems","Service and Quality Management","Elective",0,0);
        this.addCourseToDB(c8);
        Course c9 = new Course("INFS3830","Information Systems","Social Media Analytics","Elective",0,0);
        this.addCourseToDB(c9);
        Course c10 = new Course("INFS3873","Information Systems","Business Analytics Method","Elective",0,0);
        this.addCourseToDB(c10);
        Course c11 = new Course("ARTS1010","Arts","The Life of Words","General Education",1,0);
        this.addCourseToDB(c11);
        Course c12 = new Course("ARTS1091","Arts","Media, Society, Politics","General Education",1,0);
        this.addCourseToDB(c12);
        Course c13 = new Course("BIOS1101","Science","Evolutionary and Functional Biology","General Education",1,0);
        this.addCourseToDB(c13);
        Course c14 = new Course("BIOS1301","Science","Ecology, Sustainability and Environmental Science","General Education",1,0);
        this.addCourseToDB(c14);


    }


    public void addCourseToDB(Course c){
        ContentValues values = new ContentValues();
        values.put(CourseTitle, c.getCourseTitle());
        values.put(CourseFaculty, c.getCourseFaculty());
        values.put(CourseDescription,c.getCourseDescription());
        values.put(CourseType,c.getCourseType());
        values.put(IsCompleted,c.getIsCompleted());
        values.put(IsEnabled,c.getIsEnabled());
        dbase.insert(DB_TABLE, null, values);
    }

    public List <Course> getAllCoreCourses(){
        List <Course> courseList = new ArrayList<Course>();

        dbase = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM "+DB_TABLE+" WHERE type = 'Core'";
        Cursor cursor = dbase.rawQuery(selectQuery,null);
        rowCount = cursor.getCount();

        if(cursor.moveToFirst()){
            do{
                Course c = new Course();
                c.setCourseTitle(cursor.getString(0));
                c.setCourseFaculty(cursor.getString(1));
                c.setCourseDescription(cursor.getString(2));
                c.setCourseType(cursor.getString(3));
                c.setIsEnabled(cursor.getInt(4));
                c.setIsCompleted(cursor.getInt(5));
                courseList.add(c);

            }while (cursor.moveToNext());
        }
        return courseList;
    }

    public List <Course> getArtsCourses(){
        List <Course> courseList = new ArrayList<Course>();

        dbase = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM "+DB_TABLE+" WHERE faculty = 'Arts' AND type='General Education'";
        Cursor cursor = dbase.rawQuery(selectQuery,null);
        rowCount = cursor.getCount();

        if(cursor.moveToFirst()){
            do{
                Course c = new Course();
                c.setCourseTitle(cursor.getString(0));
                c.setCourseFaculty(cursor.getString(1));
                c.setCourseDescription(cursor.getString(2));
                c.setCourseType(cursor.getString(3));
                c.setIsEnabled(cursor.getInt(4));
                c.setIsCompleted(cursor.getInt(5));
                courseList.add(c);

            }while (cursor.moveToNext());
        }
        return courseList;
    }

    public List <Course> getScienceCourses(){
        List <Course> courseList = new ArrayList<Course>();

        dbase = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM "+DB_TABLE+" WHERE faculty = 'Science' AND type='General Education'";
        Cursor cursor = dbase.rawQuery(selectQuery,null);
        rowCount = cursor.getCount();

        if(cursor.moveToFirst()){
            do{
                Course c = new Course();
                c.setCourseTitle(cursor.getString(0));
                c.setCourseFaculty(cursor.getString(1));
                c.setCourseDescription(cursor.getString(2));
                c.setCourseType(cursor.getString(3));
                c.setIsEnabled(cursor.getInt(4));
                c.setIsCompleted(cursor.getInt(5));
                courseList.add(c);

            }while (cursor.moveToNext());
        }
        return courseList;
    }

    public List <Course> getAllElectiveCourses(){
        List <Course> courseList = new ArrayList<Course>();

        dbase = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM "+DB_TABLE+" WHERE type = 'Elective'";
        Cursor cursor = dbase.rawQuery(selectQuery,null);
        rowCount = cursor.getCount();

        if(cursor.moveToFirst()){
            do{
                Course c = new Course();
                c.setCourseTitle(cursor.getString(0));
                c.setCourseFaculty(cursor.getString(1));
                c.setCourseDescription(cursor.getString(2));
                c.setCourseType(cursor.getString(3));
                c.setIsEnabled(cursor.getInt(4));
                c.setIsCompleted(cursor.getInt(5));
                courseList.add(c);

            }while (cursor.moveToNext());
        }
        return courseList;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+DB_TABLE);
        onCreate(db);
    }

    public int getRowCount(){
        return rowCount;
    }
}
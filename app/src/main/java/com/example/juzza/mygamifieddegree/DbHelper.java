package com.example.juzza.mygamifieddegree;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

public class DbHelper extends SQLiteOpenHelper {

    private Context mContext;

    //DB version, table and database name
    private static final int DB_VERSION = 3;
    private static final String DB_NAME = "CoursesDb";
    private static final String DB_TABLE = "Courses";

    //table column names
    private static final String CourseTitle = "title";
    private static final String CourseFaculty = "faculty";
    private static final String CourseDescription = "description";
    private static final String AssessmentStructure = "assessment";
    private static final String CourseType = "type";
    private static final String IsEnabled = "enabled";
    private static final String IsCompleted = "completed";
    private static final String courseError = "error";
    private static final String term = "term";


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
        String sqlQuery = String.format("CREATE TABLE IF NOT EXISTS %s (%s TEXT, %s TEXT, %s TEXT, %s TEXT, %s TEXT, %s INT, %s INT, %s TEXT, %s TEXT)", DB_TABLE, CourseTitle, CourseFaculty, CourseDescription, AssessmentStructure, CourseType, IsEnabled, IsCompleted, courseError, term);
        db.execSQL(sqlQuery);
        //debugging log only
        Log.d("TaskDBHelper", "Query to form table" + sqlQuery);

        addCourses();
    }

    private void addCourses() {
        Course c1 = new Course("INFS1602","Information Systems","Digital Transformation in Business \n\nStudents will learn to appreciate existing and emerging technologies affecting businesses, business relationships and their products and services. \n\nThe topics that are covered include: understanding the relationship between IS, Organisations & Strategy, dominant Business Models enabled by the Internet & Web 2.0 technology.","Assessment Structure: \n- Workshop Participation: 20% \n- Midsession Quiz: 15% \n- Team Project: 15% \n- Final Exam: 50%","Core",1,0,"","");
        this.addCourseToDB(c1);
        Course c2 = new Course("INFS1603","Information Systems","Introduction to Business Databases","","Core",1,0, "This course is only offered in T1 & T2","");
        this.addCourseToDB(c2);
        Course c3 = new Course("INFS1609","Information Systems","Fundamentals of Business Programming","","Core",1,0,"This course is only offered in T1 & T3","");
        this.addCourseToDB(c3);
        Course c4 = new Course("INFS2603","Information Systems","Business Analysis","","Core",0,0,"This course is only offered in T3 \n\nPlease ensure you have completed the following prerequisites: INFS1602 and INFS1603","");
        this.addCourseToDB(c4);
        Course c5 = new Course("INFS2605","Information Systems","Intermediate Business Programming","","Core",0,0, "This course is only offered in T1 & T3 \n\nPlease ensure you have completed the following prerequisites: INFS1603 and INFS1609","");
        this.addCourseToDB(c5);
        Course c6 = new Course("INFS2608","Information Systems","Database Management & Big Data Infrastructures","","Core",0,0,"This course is only offered in T1 \n\nPlease ensure you have completed the following prerequisites: INFS1603","");
        this.addCourseToDB(c6);
        Course c7 = new Course("INFS2621","Information Systems","Enterprise Systems","","Core",0,0,"This course is only offered in T2 \n\nPlease ensure you have completed the following prerequisites: INFS1602","");
        this.addCourseToDB(c7);
        Course c8 = new Course("INFS3603","Information Systems","Introduction to Business Analytics","","Core",0,0,"This course is only offered in T1 & T2 \n\nPlease ensure you have completed the following prerequisites: INFS1602","");
        this.addCourseToDB(c8);
        Course c9 = new Course("INFS3604","Information Systems","Business Process Management","","Core",0,0,"This course is only offered in T3 \n\nPlease ensure you have completed the following prerequisites: INFS2603","");
        this.addCourseToDB(c9);
        Course c10 = new Course("INFS3605","Information Systems","Information Systems Innovation & Transformation","","Core",0,0, "This course is only offered in T1 & T2 \n\nPlease ensure you have completed the following prerequisites: INFS3634","");
        this.addCourseToDB(c10);
        Course c11 = new Course("INFS3617","Information Systems","Networking & Cyber Security","","Core",0,0,"This course is only offered in T1 \n\nPlease ensure you have completed the following prerequisites: INFS1602","");
        this.addCourseToDB(c11);
        Course c12 = new Course("INFS3634","Information Systems","Mobile Applications Development","","Core",0,0,"This course is only offered in T1 & T3 \n\nPlease ensure you have completed the following prerequisites: INFS2605","");
        this.addCourseToDB(c12);
        Course c13 = new Course("ACCT1501","Accounting","Accounting & Financial Management 1A","","Core",1,0,"","");
        this.addCourseToDB(c13);
        Course c14 = new Course("MGMT1001","Management","Managing Organisations & People","","Core",1,0,"","");
        this.addCourseToDB(c14);
        Course c15 = new Course("ECON1203","Economics","Business & Economic Statistics","","Core",1,0,"","");
        this.addCourseToDB(c15);
        Course c16 = new Course("MATH1041","Mathematics & Statistics","Statistics for Life & Social Sciences","","Core",1,0,"","");
        this.addCourseToDB(c16);
        Course c17 = new Course("ACCT1511","Accounting","Accounting & Financial Management 1B","","Core",1,0,"This course is only offered in T1 & T2","");
        this.addCourseToDB(c17);
        Course c18 = new Course("ECON1101","Economics","Microeconomics 1","","Core",1,0,"","");
        this.addCourseToDB(c18);
        Course c19 = new Course("INFS2631","Information Systems","Innovation and Technology Management \n\nThis course will analyse how small and large firms innovate, commercial and compete in competitive markets through the development and management of technology. The course emphasises the role of crowdsourcing, social media and social networks.\n\n","Assessment Structure: \n- Participation: 10% \n- Pre-class Quizzes: 15% \n- Group Assignment: 25% \n- Final Exam: 50%","Elective",0,0,"This course is only offered in T1 \n\nPlease ensure you have completed the following prerequisites: INFS1602","");
        this.addCourseToDB(c19);
        Course c20 = new Course("INFS3020","Information Systems","International Information Systems and Technology Practicum","","Elective",0,0,"This course is only offered in T2","");
        this.addCourseToDB(c20);
        Course c21 = new Course("INFS3632","Information Systems","Service and Quality Management","","Elective",0,0, "This course is only offered in T2 \n\nPlease ensure you have completed the following prerequisites: INFS1602","");
        this.addCourseToDB(c21);
        Course c22 = new Course("INFS3830","Information Systems","Social Media Analytics","","Elective",0,0,"This course is only offered in T1 \n\nPlease ensure you have completed the following prerequisites: INFS3603","");
        this.addCourseToDB(c22);
        Course c23 = new Course("INFS3873","Information Systems","Business Analytics Method","","Elective",0,0,"This course is only offered in T3 \n\nPlease ensure you have completed the following prerequisites: INFS3603","");
        this.addCourseToDB(c23);
        Course c24 = new Course("ARTS1010","Arts","The Life of Words","","General Education",1,0,"This course is only offered in T1","");
        this.addCourseToDB(c24);
        Course c25 = new Course("ARTS1091","Arts","Media, Society, Politics","","General Education",1,0,"This course is only offered in T3","");
        this.addCourseToDB(c25);
        Course c26 = new Course("BIOS1101","Science","Evolutionary and Functional Biology","","General Education",1,0,"This course is only offered in T2","");
        this.addCourseToDB(c26);
        Course c27 = new Course("BIOS1301","Science","Ecology, Sustainability and Environmental Science","","General Education",1,0,"This course is only offered in T1","");
        this.addCourseToDB(c27);

    }


    public void addCourseToDB(Course c){
        ContentValues values = new ContentValues();
        values.put(CourseTitle, c.getCourseTitle());
        values.put(CourseFaculty, c.getCourseFaculty());
        values.put(CourseDescription,c.getCourseDescription());
        values.put(AssessmentStructure,c.getAssessmentStructure());
        values.put(CourseType,c.getCourseType());
        values.put(IsEnabled,c.getIsEnabled());
        values.put(IsCompleted,c.getIsCompleted());
        values.put(courseError,c.getCourseError());
        values.put(term,c.getTerm());

        dbase.insert(DB_TABLE, null, values);
    }

    public List <Course> getAllCoreCourses(){
        List <Course> courseList = new ArrayList<Course>();

        dbase = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM "+DB_TABLE+" WHERE type = 'Core' AND completed = 0";
        Cursor cursor = dbase.rawQuery(selectQuery,null);
        rowCount = cursor.getCount();

        if(cursor.moveToFirst()){
            do{
                Course c = new Course();
                c.setCourseTitle(cursor.getString(0));
                c.setCourseFaculty(cursor.getString(1));
                c.setCourseDescription(cursor.getString(2));
                c.setAssessmentStructure(cursor.getString(3));
                c.setCourseType(cursor.getString(4));
                c.setIsEnabled(cursor.getInt(5));
                c.setIsCompleted(cursor.getInt(6));
                c.setCourseError(cursor.getString(7));
                c.setTerm(cursor.getString(8));
                courseList.add(c);

            }while (cursor.moveToNext());
        }
        return courseList;
    }

    public List <Course> getArtsCourses(){
        List <Course> courseList = new ArrayList<Course>();

        dbase = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM "+DB_TABLE+" WHERE faculty = 'Arts' AND type ='General Education' AND completed = 0";
        Cursor cursor = dbase.rawQuery(selectQuery,null);
        rowCount = cursor.getCount();

        if(cursor.moveToFirst()){
            do{
                Course c = new Course();
                c.setCourseTitle(cursor.getString(0));
                c.setCourseFaculty(cursor.getString(1));
                c.setCourseDescription(cursor.getString(2));
                c.setAssessmentStructure(cursor.getString(3));
                c.setCourseType(cursor.getString(4));
                c.setIsEnabled(cursor.getInt(5));
                c.setIsCompleted(cursor.getInt(6));
                c.setCourseError(cursor.getString(7));
                c.setTerm(cursor.getString(8));
                courseList.add(c);


            }while (cursor.moveToNext());
        }
        return courseList;
    }

    public List <Course> getScienceCourses(){
        List <Course> courseList = new ArrayList<Course>();

        dbase = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM "+DB_TABLE+" WHERE faculty = 'Science' AND type ='General Education' AND completed =0";
        Cursor cursor = dbase.rawQuery(selectQuery,null);
        rowCount = cursor.getCount();

        if(cursor.moveToFirst()){
            do{
                Course c = new Course();
                c.setCourseTitle(cursor.getString(0));
                c.setCourseFaculty(cursor.getString(1));
                c.setCourseDescription(cursor.getString(2));
                c.setAssessmentStructure(cursor.getString(3));
                c.setCourseType(cursor.getString(4));
                c.setIsEnabled(cursor.getInt(5));
                c.setIsCompleted(cursor.getInt(6));
                c.setCourseError(cursor.getString(7));
                c.setTerm(cursor.getString(8));
                courseList.add(c);


            }while (cursor.moveToNext());
        }
        return courseList;
    }

    public List <Course> getAllElectiveCourses(){
        List <Course> courseList = new ArrayList<Course>();

        dbase = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM "+DB_TABLE+" WHERE type = 'Elective' AND completed = 0";
        Cursor cursor = dbase.rawQuery(selectQuery,null);
        rowCount = cursor.getCount();

        if(cursor.moveToFirst()){
            do{
                Course c = new Course();
                c.setCourseTitle(cursor.getString(0));
                c.setCourseFaculty(cursor.getString(1));
                c.setCourseDescription(cursor.getString(2));
                c.setAssessmentStructure(cursor.getString(3));
                c.setCourseType(cursor.getString(4));
                c.setIsEnabled(cursor.getInt(5));
                c.setIsCompleted(cursor.getInt(6));
                c.setCourseError(cursor.getString(7));
                c.setTerm(cursor.getString(8));
                courseList.add(c);


            }while (cursor.moveToNext());
        }
        return courseList;
    }

    public void updateIsCompleted(String course){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "UPDATE " + DB_TABLE + " SET " + IsCompleted +
                " = '" + 1 + "' WHERE " + CourseTitle + " = '" + course + "'";
        db.execSQL(query);
    }

    public void updateTerm(String course, String termSelected){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "UPDATE " + DB_TABLE + " SET " + term +
                " = '" + termSelected + "' WHERE " + CourseTitle + " = '" + course + "'";
        db.execSQL(query);
    }

    public List <Course> getAllT1Courses(){
        List <Course> courseList = new ArrayList<Course>();

        dbase = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM "+DB_TABLE+" WHERE term = 'T1' AND completed = 1";
        Cursor cursor = dbase.rawQuery(selectQuery,null);
        rowCount = cursor.getCount();

        if(cursor.moveToFirst()){
            do{
                Course c = new Course();
                c.setCourseTitle(cursor.getString(0));
                c.setCourseFaculty(cursor.getString(1));
                c.setCourseDescription(cursor.getString(2));
                c.setAssessmentStructure(cursor.getString(3));
                c.setCourseType(cursor.getString(4));
                c.setIsEnabled(cursor.getInt(5));
                c.setIsCompleted(cursor.getInt(6));
                c.setCourseError(cursor.getString(7));
                c.setTerm(cursor.getString(8));
                courseList.add(c);


            }while (cursor.moveToNext());
        }
        return courseList;
    }

    public List <Course> getAllT2Courses(){
        List <Course> courseList = new ArrayList<Course>();

        dbase = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM "+DB_TABLE+" WHERE term = 'T2' AND completed = 1";
        Cursor cursor = dbase.rawQuery(selectQuery,null);
        rowCount = cursor.getCount();

        if(cursor.moveToFirst()){
            do{
                Course c = new Course();
                c.setCourseTitle(cursor.getString(0));
                c.setCourseFaculty(cursor.getString(1));
                c.setCourseDescription(cursor.getString(2));
                c.setAssessmentStructure(cursor.getString(3));
                c.setCourseType(cursor.getString(4));
                c.setIsEnabled(cursor.getInt(5));
                c.setIsCompleted(cursor.getInt(6));
                c.setCourseError(cursor.getString(7));
                c.setTerm(cursor.getString(8));
                courseList.add(c);


            }while (cursor.moveToNext());
        }
        return courseList;
    }

    public List <Course> getAllT3Courses(){
        List <Course> courseList = new ArrayList<Course>();

        dbase = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM "+DB_TABLE+" WHERE term = 'T3' AND completed = 1";
        Cursor cursor = dbase.rawQuery(selectQuery,null);
        rowCount = cursor.getCount();

        if(cursor.moveToFirst()){
            do{
                Course c = new Course();
                c.setCourseTitle(cursor.getString(0));
                c.setCourseFaculty(cursor.getString(1));
                c.setCourseDescription(cursor.getString(2));
                c.setAssessmentStructure(cursor.getString(3));
                c.setCourseType(cursor.getString(4));
                c.setIsEnabled(cursor.getInt(5));
                c.setIsCompleted(cursor.getInt(6));
                c.setCourseError(cursor.getString(7));
                c.setTerm(cursor.getString(8));
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
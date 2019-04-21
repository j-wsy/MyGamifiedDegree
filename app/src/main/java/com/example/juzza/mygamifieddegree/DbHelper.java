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
    private static final int DB_VERSION = 6;
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
    private static final String t1 = "term1";
    private static final String t2 = "term2";
    private static final String t3 = "term3";
    private static final String prereq = "prereq";


    private SQLiteDatabase dbase;
    private int rowCount = 0;

    //Constructor for a DatabaseHelper.
    public DbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        dbase = db;
        //First table
        String sqlQuery = String.format("CREATE TABLE IF NOT EXISTS %s (%s TEXT, %s TEXT, %s TEXT, %s TEXT, %s TEXT, %s INT, %s INT, %s TEXT, %s TEXT, %s INT, %s INT, %s INT, %s INT )", DB_TABLE, CourseTitle, CourseFaculty, CourseDescription, AssessmentStructure, CourseType, IsEnabled, IsCompleted, courseError, term, t1, t2, t3, prereq);
        db.execSQL(sqlQuery);
        //debugging log only
        Log.d("TaskDBHelper", "Query to form table" + sqlQuery);

        addCourses();
    }

    private void addCourses() {
        Course c1 = new Course("INFS1602", "Information Systems", "Digital Transformation in Business \n\nStudents will learn to appreciate existing and emerging technologies affecting businesses, business relationships and their products and services. \n\nThe topics that are covered include: understanding the relationship between IS, Organisations & Strategy, dominant Business Models enabled by the Internet & Web 2.0 technology.", "Assessment Structure: \n- Workshop Participation: 20% \n- Midsession Quiz: 15% \n- Team Project: 15% \n- Final Exam: 50%", "Core", 1, 0, "", "", 1, 1, 1, 1);
        this.addCourseToDB(c1);
        Course c2 = new Course("INFS1603", "Information Systems", "Introduction to Business Databases", "", "Core", 1, 0, "This course is only offered in T1 & T2", "", 1, 1, 0, 1);
        this.addCourseToDB(c2);
        Course c3 = new Course("INFS1609", "Information Systems", "Fundamentals of Business Programming", "", "Core", 1, 0, "This course is only offered in T1 & T3", "", 1, 0, 1, 1);
        this.addCourseToDB(c3);
        Course c4 = new Course("INFS2603", "Information Systems", "Business Analysis", "", "Core", 0, 0, "This course is only offered in T3 \n\nPlease ensure you have completed the following prerequisites: INFS1602 and INFS1603", "", 0, 0, 1, 0);
        this.addCourseToDB(c4);
        Course c5 = new Course("INFS2605", "Information Systems", "Intermediate Business Programming", "", "Core", 0, 0, "This course is only offered in T1 & T3 \n\nPlease ensure you have completed the following prerequisites: INFS1603 and INFS1609", "", 1, 0, 1, 0);
        this.addCourseToDB(c5);
        Course c6 = new Course("INFS2608", "Information Systems", "Database Management & Big Data Infrastructures", "", "Core", 0, 0, "This course is only offered in T1 \n\nPlease ensure you have completed the following prerequisites: INFS1603", "", 1, 0, 0, 0);
        this.addCourseToDB(c6);
        Course c7 = new Course("INFS2621", "Information Systems", "Enterprise Systems", "", "Core", 0, 0, "This course is only offered in T2 \n\nPlease ensure you have completed the following prerequisites: INFS1602", "", 0, 1, 0, 0);
        this.addCourseToDB(c7);
        Course c8 = new Course("INFS3603", "Information Systems", "Introduction to Business Analytics", "", "Core", 0, 0, "This course is only offered in T1 & T2 \n\nPlease ensure you have completed the following prerequisites: INFS1602", "", 1, 1, 0, 0);
        this.addCourseToDB(c8);
        Course c9 = new Course("INFS3604", "Information Systems", "Business Process Management", "", "Core", 0, 0, "This course is only offered in T3 \n\nPlease ensure you have completed the following prerequisites: INFS2603", "", 0, 0, 1, 0);
        this.addCourseToDB(c9);
        Course c10 = new Course("INFS3605", "Information Systems", "Information Systems Innovation & Transformation", "", "Core", 0, 0, "This course is only offered in T1 & T2 \n\nPlease ensure you have completed the following prerequisites: INFS3634", "", 1, 1, 0, 0);
        this.addCourseToDB(c10);
        Course c11 = new Course("INFS3617", "Information Systems", "Networking & Cyber Security", "", "Core", 0, 0, "This course is only offered in T1 \n\nPlease ensure you have completed the following prerequisites: INFS1602", "", 1, 0, 0, 0);
        this.addCourseToDB(c11);
        Course c12 = new Course("INFS3634", "Information Systems", "Mobile Applications Development", "", "Core", 0, 0, "This course is only offered in T1 & T3 \n\nPlease ensure you have completed the following prerequisites: INFS2605", "", 1, 0, 1, 0);
        this.addCourseToDB(c12);
        Course c13 = new Course("ACCT1501", "Accounting", "Accounting & Financial Management 1A", "", "Core", 1, 0, "", "", 1, 1, 1, 1);
        this.addCourseToDB(c13);
        Course c14 = new Course("MGMT1001", "Management", "Managing Organisations & People", "", "Core", 1, 0, "", "", 1, 1, 1, 1);
        this.addCourseToDB(c14);
        Course c15 = new Course("ECON1203", "Economics", "Business & Economic Statistics", "", "Core", 1, 0, "", "", 1, 1, 1, 1);
        this.addCourseToDB(c15);
        Course c16 = new Course("MATH1041", "Mathematics & Statistics", "Statistics for Life & Social Sciences", "", "Core", 1, 0, "", "", 1, 1, 1, 1);
        this.addCourseToDB(c16);
        Course c17 = new Course("ACCT1511", "Accounting", "Accounting & Financial Management 1B", "", "Core", 1, 0, "This course is only offered in T1 & T2", "", 1, 1, 0, 1);
        this.addCourseToDB(c17);
        Course c18 = new Course("ECON1101", "Economics", "Microeconomics 1", "", "Core", 1, 0, "", "", 1, 1, 1, 1);
        this.addCourseToDB(c18);
        Course c19 = new Course("INFS2631", "Information Systems", "Innovation and Technology Management \n\nThis course will analyse how small and large firms innovate, commercial and compete in competitive markets through the development and management of technology. The course emphasises the role of crowdsourcing, social media and social networks.\n\n", "Assessment Structure: \n- Participation: 10% \n- Pre-class Quizzes: 15% \n- Group Assignment: 25% \n- Final Exam: 50%", "Elective", 0, 0, "This course is only offered in T1 \n\nPlease ensure you have completed the following prerequisites: INFS1602", "", 1, 0, 0, 0);
        this.addCourseToDB(c19);
        Course c20 = new Course("INFS3020", "Information Systems", "International Information Systems and Technology Practicum", "", "Elective", 0, 0, "This course is only offered in T2", "", 0, 1, 0, 1);
        this.addCourseToDB(c20);
        Course c21 = new Course("INFS3632", "Information Systems", "Service and Quality Management", "", "Elective", 0, 0, "This course is only offered in T2 \n\nPlease ensure you have completed the following prerequisites: INFS1602", "", 0, 1, 0, 0);
        this.addCourseToDB(c21);
        Course c22 = new Course("INFS3830", "Information Systems", "Social Media Analytics", "", "Elective", 0, 0, "This course is only offered in T1 \n\nPlease ensure you have completed the following prerequisites: INFS3603", "", 1, 0, 0, 0);
        this.addCourseToDB(c22);
        Course c23 = new Course("INFS3873", "Information Systems", "Business Analytics Method", "", "Elective", 0, 0, "This course is only offered in T3 \n\nPlease ensure you have completed the following prerequisites: INFS3603", "", 0, 0, 1, 0);
        this.addCourseToDB(c23);
        Course c24 = new Course("ARTS1010", "Arts", "The Life of Words", "", "General Education", 1, 0, "This course is only offered in T1", "", 1, 0, 0, 1);
        this.addCourseToDB(c24);
        Course c25 = new Course("ARTS1091", "Arts", "Media, Society, Politics", "", "General Education", 1, 0, "This course is only offered in T3", "", 0, 0, 1, 1);
        this.addCourseToDB(c25);
        Course c26 = new Course("BIOS1101", "Science", "Evolutionary and Functional Biology", "", "General Education", 1, 0, "This course is only offered in T2", "", 0, 1, 0, 1);
        this.addCourseToDB(c26);
        Course c27 = new Course("BIOS1301", "Science", "Ecology, Sustainability and Environmental Science", "", "General Education", 1, 0, "This course is only offered in T1", "", 1, 0, 0, 1);
        this.addCourseToDB(c27);
        Course c28 = new Course("PSYC1025", "Psychology", "Psychology of Work", "", "Elective", 1, 0, "This course is only offered in T1 and T3", "", 1, 0, 1, 1);
        this.addCourseToDB(c28);
        Course c29 = new Course("ARTS1060", "Arts", "Introduction to Film Studies", "", "Elective", 1, 0, "This course is only offered in T1", "", 1, 0, 0, 1);
        this.addCourseToDB(c29);
        Course c30 = new Course("DATA1001", "Mathematics", "Introduction to Data Science and Decisions", "", "Elective", 0, 0, "This course is only offered in T2", "", 0, 1, 0, 1);
        this.addCourseToDB(c30);
    }


    public void addCourseToDB(Course c) {
        ContentValues values = new ContentValues();
        values.put(CourseTitle, c.getCourseTitle());
        values.put(CourseFaculty, c.getCourseFaculty());
        values.put(CourseDescription, c.getCourseDescription());
        values.put(AssessmentStructure, c.getAssessmentStructure());
        values.put(CourseType, c.getCourseType());
        values.put(IsEnabled, c.getIsEnabled());
        values.put(IsCompleted, c.getIsCompleted());
        values.put(courseError, c.getCourseError());
        values.put(term, c.getTerm());
        values.put(t1, c.getT1());
        values.put(t2, c.getT2());
        values.put(t3, c.getT3());
        values.put(prereq, c.getPrereq());

        dbase.insert(DB_TABLE, null, values);

    }

    public List<Course> getAllCoreCourses() {
        List<Course> courseList = new ArrayList<Course>();

        dbase = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM " + DB_TABLE + " WHERE type = 'Core' AND completed = 0";
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        rowCount = cursor.getCount();

        if (cursor.moveToFirst()) {
            do {
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
                c.setT1(cursor.getInt(9));
                c.setT2(cursor.getInt(10));
                c.setT3(cursor.getInt(11));
                c.setPrereq(cursor.getInt(12));
                courseList.add(c);

            } while (cursor.moveToNext());
        }
        return courseList;
    }

    public List<Course> getArtsCourses() {
        List<Course> courseList = new ArrayList<Course>();

        dbase = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM " + DB_TABLE + " WHERE faculty = 'Arts' AND type ='General Education' AND completed = 0";
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        rowCount = cursor.getCount();

        if (cursor.moveToFirst()) {
            do {
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
                c.setT1(cursor.getInt(9));
                c.setT2(cursor.getInt(10));
                c.setT3(cursor.getInt(11));
                c.setPrereq(cursor.getInt(12));
                courseList.add(c);


            } while (cursor.moveToNext());
        }

        return courseList;
    }

    public List<Course> getScienceCourses() {
        List<Course> courseList = new ArrayList<Course>();

        dbase = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM " + DB_TABLE + " WHERE faculty = 'Science' AND type ='General Education' AND completed =0";
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        rowCount = cursor.getCount();

        if (cursor.moveToFirst()) {
            do {
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
                c.setT1(cursor.getInt(9));
                c.setT2(cursor.getInt(10));
                c.setT3(cursor.getInt(11));
                c.setPrereq(cursor.getInt(12));
                courseList.add(c);


            } while (cursor.moveToNext());
        }

        return courseList;
    }

    public List<Course> getAllElectiveCourses() {
        List<Course> courseList = new ArrayList<Course>();

        dbase = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM " + DB_TABLE + " WHERE type = 'Elective' AND completed = 0";
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        rowCount = cursor.getCount();

        if (cursor.moveToFirst()) {
            do {
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
                c.setT1(cursor.getInt(9));
                c.setT2(cursor.getInt(10));
                c.setT3(cursor.getInt(11));
                c.setPrereq(cursor.getInt(12));
                courseList.add(c);


            } while (cursor.moveToNext());
        }

        return courseList;
    }

    public void updateIsCompleted(String course) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "UPDATE " + DB_TABLE + " SET " + IsCompleted +
                " = '" + 1 + "' WHERE " + CourseTitle + " = '" + course + "'";
        db.execSQL(query);
    }

    public void updatePrereq(String course) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "UPDATE " + DB_TABLE + " SET " + prereq +
                " = '" + 1 + "' WHERE " + CourseTitle + " = '" + course + "'";
        db.execSQL(query);
    }

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

    public void updateEnable2(List<Course> course) {

        SQLiteDatabase db = this.getWritableDatabase();
        //db.rawQuery("SELECT enabled FROM courses WHERE title = ?", course);
        for (int i = 0; i < course.size(); i++) {
            String query = "UPDATE " + DB_TABLE + " SET " + IsEnabled +
                    " = '" + 1 + "' WHERE " + CourseTitle + " = '" + course + "'";
            //String query = "UPDATE " + DB_TABLE + " SET " + IsEnabled +
            //" = '" + 1 + "' WHERE " + CourseTitle + " IN (" + course+ ")";
            db.execSQL(query);
        }

    }

    public int getIsCompleted(String course) {
        dbase = this.getReadableDatabase();
        int isComplete;
        String selectQuery = "SELECT completed FROM " + DB_TABLE + " WHERE " + CourseTitle + "='" + course + "'";
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            isComplete = cursor.getInt(cursor.getColumnIndex("completed"));
        } else {
            isComplete = 2;
        }
        //int isComplete = cursor.getInt(cursor.getColumnIndex("completed"));
        return isComplete;
    }

    public int getPrereq(String course) {
        dbase = this.getReadableDatabase();
        int prereq;
        String selectQuery = "SELECT prereq FROM " + DB_TABLE + " WHERE " + CourseTitle + "='" + course + "'";
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            prereq = cursor.getInt(cursor.getColumnIndex("prereq"));
        } else {
            prereq = 2;
        }
        //int isComplete = cursor.getInt(cursor.getColumnIndex("completed"));
        return prereq;
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


    public void updateDisable(List<String> course) {

        String[] courseStrings = new String[course.size()];
        courseStrings = course.toArray(courseStrings);

        SQLiteDatabase db = this.getWritableDatabase();
        for (String title : courseStrings) {
            String query = "UPDATE " + DB_TABLE + " SET " + IsEnabled +
                    " = '" + 0 + "' WHERE " + CourseTitle + " = '" + title + "'";
            db.execSQL(query);
        }

    }

    //wip

    public void updateDisable3(List<String> course) {

        String[] courseStrings = new String[course.size()];
        courseStrings = course.toArray(courseStrings);

        SQLiteDatabase db = this.getWritableDatabase();
        for (String title : courseStrings) {
            db.execSQL(String.format("UPDATE courses SET enabled = 0 WHERE title = ?", title));
        }

        //db.rawQuery("UPDATE courses SET enabled = 0 WHERE title =?", courseStrings);
        /*SQLiteDatabase db = this.getWritableDatabase();
            String query = "UPDATE " + DB_TABLE + " SET " + IsEnabled +
                    " = '" + 0 + "' WHERE " + CourseTitle + " = '" + course + "'";
            db.execSQL(query);*/

    }

    public List<String> getDisable() {
        List<String> array = new ArrayList<String>();
        dbase = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM " + DB_TABLE + " WHERE enabled = 0 AND term2 = 0";
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        rowCount = cursor.getCount();

        while (cursor.moveToNext()) {
            String uname = cursor.getString(cursor.getColumnIndex("title"));
            array.add(uname);
        }

        return array;
    }


    public void updateDisable2(List<Course> course) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "UPDATE " + DB_TABLE + " SET " + IsEnabled +
                " = '" + 0 + "' WHERE " + CourseTitle + " = '" + course + "'";
        db.execSQL(query);
    }


    public void updateTerm(String course, String termSelected) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "UPDATE " + DB_TABLE + " SET " + term +
                " = '" + termSelected + "' WHERE " + CourseTitle + " = '" + course + "'";
        db.execSQL(query);

    }

    public List<Course> getAllT1Courses() {
        List<Course> courseList = new ArrayList<Course>();

        dbase = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM " + DB_TABLE + " WHERE term = 'T1' AND completed = 1";
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        rowCount = cursor.getCount();

        if (cursor.moveToFirst()) {
            do {
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
                c.setT1(cursor.getInt(9));
                c.setT2(cursor.getInt(10));
                c.setT3(cursor.getInt(11));
                c.setPrereq(cursor.getInt(12));
                courseList.add(c);


            } while (cursor.moveToNext());
        }
        return courseList;
    }

    public List<Course> getAllT2Courses() {
        List<Course> courseList = new ArrayList<Course>();

        dbase = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM " + DB_TABLE + " WHERE term = 'T2' AND completed = 1";
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        rowCount = cursor.getCount();

        if (cursor.moveToFirst()) {
            do {
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
                c.setT1(cursor.getInt(9));
                c.setT2(cursor.getInt(10));
                c.setT3(cursor.getInt(11));
                c.setPrereq(cursor.getInt(12));
                courseList.add(c);


            } while (cursor.moveToNext());
        }

        return courseList;
    }

    public List<Course> getAllT3Courses() {
        List<Course> courseList = new ArrayList<Course>();

        dbase = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM " + DB_TABLE + " WHERE term = 'T3' AND completed = 1";
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        rowCount = cursor.getCount();

        if (cursor.moveToFirst()) {
            do {
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
                c.setT1(cursor.getInt(9));
                c.setT2(cursor.getInt(10));
                c.setT3(cursor.getInt(11));
                c.setPrereq(cursor.getInt(12));
                courseList.add(c);


            } while (cursor.moveToNext());
        }

        return courseList;
    }

    public List<Course> getAllT1Y2Courses() {
        List<Course> courseList = new ArrayList<Course>();

        dbase = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM " + DB_TABLE + " WHERE term = 'T1Y2' AND completed = 1";
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        rowCount = cursor.getCount();

        if (cursor.moveToFirst()) {
            do {
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
                c.setT1(cursor.getInt(9));
                c.setT2(cursor.getInt(10));
                c.setT3(cursor.getInt(11));
                c.setPrereq(cursor.getInt(12));
                courseList.add(c);


            } while (cursor.moveToNext());
        }
        return courseList;
    }

    public List<Course> getAllT2Y2Courses() {
        List<Course> courseList = new ArrayList<Course>();

        dbase = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM " + DB_TABLE + " WHERE term = 'T2Y2' AND completed = 1";
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        rowCount = cursor.getCount();

        if (cursor.moveToFirst()) {
            do {
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
                c.setT1(cursor.getInt(9));
                c.setT2(cursor.getInt(10));
                c.setT3(cursor.getInt(11));
                c.setPrereq(cursor.getInt(12));
                courseList.add(c);


            } while (cursor.moveToNext());
        }

        return courseList;
    }

    public List<Course> getAllT3Y2Courses() {
        List<Course> courseList = new ArrayList<Course>();

        dbase = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM " + DB_TABLE + " WHERE term = 'T3Y2' AND completed = 1";
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        rowCount = cursor.getCount();

        if (cursor.moveToFirst()) {
            do {
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
                c.setT1(cursor.getInt(9));
                c.setT2(cursor.getInt(10));
                c.setT3(cursor.getInt(11));
                c.setPrereq(cursor.getInt(12));
                courseList.add(c);


            } while (cursor.moveToNext());
        }

        return courseList;
    }

    public int getRemainingCoreCourses() {
        int coreRequirement = 16;
        List<Course> courseList = new ArrayList<Course>();

        dbase = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM " + DB_TABLE + " WHERE type = 'Core' AND completed = 1";
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        rowCount = cursor.getCount();

        if (cursor.moveToFirst()) {
            do {
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
                c.setT1(cursor.getInt(9));
                c.setT2(cursor.getInt(10));
                c.setT3(cursor.getInt(11));
                c.setPrereq(cursor.getInt(12));
                courseList.add(c);


            } while (cursor.moveToNext());
        }
        int completedCore = courseList.size();
        int remainingCore = coreRequirement - completedCore;

        return remainingCore;

    }

    public int getRemainingElectiveCourses() {
        int electiveRequirement = 6;
        List<Course> courseList = new ArrayList<Course>();

        dbase = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM " + DB_TABLE + " WHERE type = 'Elective' AND completed = 1";
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        rowCount = cursor.getCount();

        if (cursor.moveToFirst()) {
            do {
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
                c.setT1(cursor.getInt(9));
                c.setT2(cursor.getInt(10));
                c.setT3(cursor.getInt(11));
                c.setPrereq(cursor.getInt(12));
                courseList.add(c);


            } while (cursor.moveToNext());
        }
        int completedElective = courseList.size();
        int remainingElective = electiveRequirement - completedElective;

        return remainingElective;
    }

    public int getRemainingGeneralCourses() {
        int generalRequirement = 2;
        List<Course> courseList = new ArrayList<Course>();

        dbase = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM " + DB_TABLE + " WHERE type = 'General Education' AND completed = 1";
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        rowCount = cursor.getCount();

        if (cursor.moveToFirst()) {
            do {
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
                c.setT1(cursor.getInt(9));
                c.setT2(cursor.getInt(10));
                c.setT3(cursor.getInt(11));
                c.setPrereq(cursor.getInt(12));
                courseList.add(c);


            } while (cursor.moveToNext());
        }
        int completedGeneral = courseList.size();
        int remainingGeneral = generalRequirement - completedGeneral;

        return remainingGeneral;
    }

    public List<String> getT1RemAvail() {
        List<String> array = new ArrayList<String>();
        dbase = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM " + DB_TABLE + " WHERE completed = 0 AND term1 = 1 AND prereq = 1";
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        rowCount = cursor.getCount();

        while (cursor.moveToNext()) {
            String uname = cursor.getString(cursor.getColumnIndex("title"));
            array.add(uname);
        }


        return array;
    }

    public List<String> getT1RemUnavail() {
        List<String> array = new ArrayList<String>();

        dbase = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM " + DB_TABLE + " WHERE completed = 0 AND term1 = 0";
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        rowCount = cursor.getCount();

        while (cursor.moveToNext()) {
            String uname = cursor.getString(cursor.getColumnIndex("title"));
            array.add(uname);
        }


        return array;
    }

    public List<String> getT2RemAvail() {
        List<String> array = new ArrayList<String>();
        dbase = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM " + DB_TABLE + " WHERE completed = 0 AND term2 = 1 AND prereq = 1";
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        rowCount = cursor.getCount();

        while (cursor.moveToNext()) {
            String uname = cursor.getString(cursor.getColumnIndex("title"));
            array.add(uname);
        }


        return array;
    }

    public List<String> getT2RemUnavail() {
        List<String> array = new ArrayList<String>();

        dbase = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM " + DB_TABLE + " WHERE completed = 0 AND term2 = 0";
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        rowCount = cursor.getCount();

        while (cursor.moveToNext()) {
            String uname = cursor.getString(cursor.getColumnIndex("title"));
            array.add(uname);
        }

        return array;
    }

    public List<String> getT3RemAvail() {
        List<String> array = new ArrayList<String>();
        dbase = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM " + DB_TABLE + " WHERE completed = 0 AND term3 = 1 AND prereq = 1";
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        rowCount = cursor.getCount();

        while (cursor.moveToNext()) {
            String uname = cursor.getString(cursor.getColumnIndex("title"));
            array.add(uname);
        }

        return array;
    }

    public List<String> getT3RemUnavail() {
        List<String> array = new ArrayList<String>();

        dbase = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM " + DB_TABLE + " WHERE completed = 0 AND term3 = 0";
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        rowCount = cursor.getCount();

        while (cursor.moveToNext()) {
            String uname = cursor.getString(cursor.getColumnIndex("title"));
            array.add(uname);
        }

        return array;
    }


    //Original Code (did not work). Here as reference.

    public List<Course> getT2RemAvail2() {
        List<Course> courseList = new ArrayList<Course>();

        dbase = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM " + DB_TABLE + " WHERE completed = 0 AND term2 = 1 AND prereq = 1";
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        rowCount = cursor.getCount();

        if (cursor.moveToFirst()) {
            do {
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
                c.setT1(cursor.getInt(9));
                c.setT2(cursor.getInt(10));
                c.setT3(cursor.getInt(11));
                c.setPrereq(cursor.getInt(12));
                courseList.add(c);


            } while (cursor.moveToNext());
        }

        return courseList;
    }

    public List<Course> getT2RemUnavail2() {
        List<Course> courseList = new ArrayList<Course>();

        dbase = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM " + DB_TABLE + " WHERE completed = 0 AND term2 = 0";
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        rowCount = cursor.getCount();

        if (cursor.moveToFirst()) {
            do {
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
                c.setT1(cursor.getInt(9));
                c.setT2(cursor.getInt(10));
                c.setT3(cursor.getInt(11));
                c.setPrereq(cursor.getInt(12));
                courseList.add(c);


            } while (cursor.moveToNext());
        }
        return courseList;
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DB_TABLE);
        onCreate(db);
    }

    public int getRowCount() {
        return rowCount;
    }
}
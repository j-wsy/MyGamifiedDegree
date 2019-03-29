package com.example.juzza.mygamifieddegree;

public class Course {

    private String courseNumber;
    private int thumbnail;

    public Course() {

    }


    public Course(String courseNumber, int thumbnail) {
        this.courseNumber = courseNumber;
        this.thumbnail = thumbnail;
    }

    public String getCourseNumber() {
        return courseNumber;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setCourseNumber(String courseNumber) {
        this.courseNumber = courseNumber;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }
}

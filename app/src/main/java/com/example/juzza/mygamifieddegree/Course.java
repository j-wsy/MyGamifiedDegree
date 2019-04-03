package com.example.juzza.mygamifieddegree;


public class Course {

    private String courseTitle;
    private String courseFaculty;
    private String courseDescription;
    private String courseType;
    private int isEnabled;
    private int isCompleted;

    public Course() {

    }

    public Course(String courseTitle, String courseFaculty, String courseDescription, String courseType, int isEnabled, int isCompleted) {
        this.courseTitle = courseTitle;
        this.courseFaculty = courseFaculty;
        this.courseDescription = courseDescription;
        this.courseType = courseType;
        this.isCompleted = isCompleted;
        this.isEnabled = isEnabled;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public String getCourseFaculty() {
        return courseFaculty;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public String getCourseType() {
        return courseType;
    }

    public int getIsEnabled() {
        return isEnabled;
    }

    public int getIsCompleted() {
        return isCompleted;
    }

    public void setCourseTitle(String courseNumber) {
        this.courseTitle = courseNumber;
    }

    public void setCourseFaculty(String courseFaculty) {
        this.courseFaculty = courseFaculty;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }

    public void setIsEnabled(int isEnabled) {
        this.isEnabled = isEnabled;
    }

    public void setIsCompleted(int isCompleted) {
        this.isCompleted = isCompleted;
    }


}

package com.example.juzza.mygamifieddegree;


public class Course {

    private String courseTitle;
    private String courseFaculty;
    private String courseDescription;
    private String assessmentStructure;
    private String courseType;
    private int isEnabled;
    private int isCompleted;
    private String courseError;
    private String term;
    private int t1;
    private int t2;
    private int t3;
    private int prereq;

    public Course() {

    }

    public Course(String courseTitle, String courseFaculty, String courseDescription, String assessmentStructure, String courseType, int isEnabled, int isCompleted, String courseError, String term, int t1, int t2, int t3, int prereq) {
        this.courseTitle = courseTitle;
        this.courseFaculty = courseFaculty;
        this.courseDescription = courseDescription;
        this.assessmentStructure = assessmentStructure;
        this.courseType = courseType;
        this.isCompleted = isCompleted;
        this.isEnabled = isEnabled;
        this.courseError = courseError;
        this.term = term;
        this.t1 = t1;
        this.t2 = t2;
        this.t3 = t3;
        this.prereq = prereq;
    }

    //Get Constructors

    public String getCourseTitle() {
        return courseTitle;
    }

    public String getCourseFaculty() {
        return courseFaculty;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public String getAssessmentStructure() {
        return assessmentStructure;
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

    public String getCourseError() {
        return courseError;
    }

    public String getTerm() {
        return term;
    }

    public int getT1() {
        return t1;
    }

    public int getT2() {
        return t2;
    }

    public int getT3() {
        return t3;
    }

    public int getPrereq() {
        return prereq;
    }

    //Set Constructors

    public void setCourseTitle(String courseNumber) {
        this.courseTitle = courseNumber;
    }

    public void setCourseFaculty(String courseFaculty) {
        this.courseFaculty = courseFaculty;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public void setAssessmentStructure(String assessmentStructure) {
        this.assessmentStructure = assessmentStructure;
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

    public void setCourseError(String courseError) {
        this.courseError = courseError;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public void setT1(int t1) {
        this.t1 = t1;
    }

    public void setT2(int t2) {
        this.t2 = t2;
    }

    public void setT3(int t3) {
        this.t3 = t3;
    }

    public void setPrereq(int prereq) {
        this.prereq = prereq;
    }


}

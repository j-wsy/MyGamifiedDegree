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

    public Course() {

    }

    public Course(String courseTitle, String courseFaculty, String courseDescription, String assessmentStructure,String courseType, int isEnabled, int isCompleted, String courseError, String term) {
        this.courseTitle = courseTitle;
        this.courseFaculty = courseFaculty;
        this.courseDescription = courseDescription;
        this.assessmentStructure = assessmentStructure;
        this.courseType = courseType;
        this.isCompleted = isCompleted;
        this.isEnabled = isEnabled;
        this.courseError = courseError;
        this.term = term;
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


}

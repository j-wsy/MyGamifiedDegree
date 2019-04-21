package com.example.juzza.mygamifieddegree;

public class Friend {
    private String friendName;
    private int isFriend;
    private int courseCompleted;

    public Friend() {

    }

    public Friend(String friendName, int isFriend, int courseCompleted) {
        this.friendName = friendName;
        this.isFriend = isFriend;
        this.courseCompleted = courseCompleted;

    }

    //Get Constructors

    public String getFriendName() {
        return friendName;
    }

    public int getIsFriend() {
        return isFriend;
    }

    public int getCourseCompleted() {
        return courseCompleted;
    }


    //Set Constructors

    public void setFriendName(String friendName) {
        this.friendName = friendName;
    }

    public void setIsFriend(int isFriend) {
        this.isFriend = isFriend;
    }

    public void setCourseCompleted(int courseCompleted) {
        this.courseCompleted = courseCompleted;
    }



}

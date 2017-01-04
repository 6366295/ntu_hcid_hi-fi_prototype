package com.hcid.edulearn.asksimple;

import java.util.Date;

public class Course {

    private int id;
    private String name;
    private String schedule;
    private String instructor;
    private Date startDate;

    private boolean sessionActive;

    public Course(int id, String name, String schedule, String instructor, Date startDate, boolean sessionActive) {
        this.id = id;
        this.name = name;
        this.schedule = schedule;
        this.instructor = instructor;
        this.startDate = startDate;
        this.sessionActive = sessionActive;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getSchedule() { return schedule; }
    public String getInstructor() { return instructor; }
    public Date getStartDate() { return startDate; }
    public boolean getSessionActive() { return sessionActive; }

    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setSchedule(String schedule) { this.schedule = schedule; }
    public void setInstructor(String instructor) { this.instructor = instructor; }
    public void setStartDate(Date startDate) { this.startDate = startDate; }
    public void setSessionActive(boolean sessionActive) { this.sessionActive = sessionActive; }

}

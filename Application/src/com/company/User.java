package com.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.sql.Timestamp;
import java.util.GregorianCalendar;

public class User {

    String firstname;
    String lastname;
    int age;
    String email;
    String status; // ACTIVE, INACTIVE, BLOCKED, NEW
    Timestamp timestamp;
    Date date;

    // Default constructor
    public User() { }

    // Constructor with runtime timestamp
    public User(String firstname, String lastname, int age, String email, String status) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.email = email;
        this.status = status;
        // creating the timestamp at runtime
        date = new Date();
        long time = date.getTime();
        this.timestamp = new Timestamp(time);
    }

    // Constructor with all parameter and custom timestamp
    public User(String firstname, String lastname, int age, String email, String status, String timestamp) throws ParseException {
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.email = email;
        this.status = status;
        // convert String to Timestamp class
        SimpleDateFormat datetimeFormatter1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        date = datetimeFormatter1.parse(timestamp);
        this.timestamp = new Timestamp(date.getTime());
    }

    // Setters:
    public void setFirstname(String name) {
        this.firstname = name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setStatus(String st) {
        this.status = st;
    }

    public void setTimestamp() {
        date = new Date();
        long time = date.getTime();
        this.timestamp = new Timestamp(time);
    }

    // Getters:
    public String getFirstname() {
        return this.firstname;
    }

    public String getLastname() {
        return this.lastname;
    }

    public String getEmail() {
        return this.email;
    }

    public int getAge() {
        return this.age;
    }

    public String getStatus() {
        return this.status;
    }

    public Date getTimestamp() {
        return this.timestamp;
    }

    @Override
    public String toString() {
        return ("User Name: " + this.firstname + " " + this.lastname + "\n" +
                "User Email: " + this.email + "\n" +
                "User Age: " + this.age + "\n" +
                "User TimeStamp: " + this.timestamp + "\n" +
                "User Status: " + this.status + "\n\n");
    }

    // function to check if the user was registered more than 24 hours ago
    public boolean isOlderThanYesterday() {

        // current date-time timestamp
        date = new Date();
        long currentTime = date.getTime();
        Timestamp current = new Timestamp(currentTime); // current timestamp

        long oneDay = 24 * 3600000l; // 1 hour = 3600000 ms;

        try {
            // difference in milliseconds between current date-time and user date-time
            long differenceMilliseconds = current.getTime() - this.timestamp.getTime();

            // if difference is bigger than number of milliseconds in one day then return true
            if (differenceMilliseconds > oneDay) {
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        // if the difference is less then 1 day return false
        return false;
    }

    // function to check if the user was registered more then 1 month ago
    public boolean isOlderThanOneMonth() {

        // user register month
        Calendar userMonth;
        userMonth = new GregorianCalendar();
        userMonth.setTime(this.date); // make the GregorianCalendar for the user from the timestamp

        // for tests set a specific month:
//        userMonth = new GregorianCalendar(2020, Calendar.SEPTEMBER, 1);

        // currentMonth
        Calendar currentMonth = new GregorianCalendar();

        // check the case when the difference is more then 1 year
        int yearsDifference = currentMonth.get(Calendar.YEAR)  - userMonth.get(Calendar.YEAR);
        // if the difference is > 1 year return and change status
        if (yearsDifference >= 1) {
            return true;
        }
        // check if the dates are for different months
        int monthsDifference = currentMonth.get(Calendar.MONTH) - userMonth.get(Calendar.MONTH);
        if (monthsDifference >= 1) {
            // check if the current day is greater or equal to the date of the registration
            // if so, then the period between registration day and current day is greater or equal
            // to one month, for a better approximation we can check that the currentTime >= registration time
            // the approximation is less then one hour
            if (currentMonth.get(Calendar.DAY_OF_MONTH) >= userMonth.get(Calendar.DAY_OF_MONTH) && userMonth.get(Calendar.HOUR_OF_DAY) >= currentMonth.get(Calendar.HOUR_OF_DAY)) {
                return true;
            }
        }
        return false;
    }
}

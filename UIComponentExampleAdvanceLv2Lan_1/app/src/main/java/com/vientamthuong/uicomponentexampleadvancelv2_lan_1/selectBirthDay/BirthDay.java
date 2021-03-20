package com.vientamthuong.uicomponentexampleadvancelv2_lan_1.selectBirthDay;

public class BirthDay {

    // Khởi tạo các biến
    private int day;
    private int month;
    private int year;

    public BirthDay(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public String toString() {
        String stringDate = day + "";
        String stringMonth = month + "";
        String stringYear = year + "";
        if (stringDate.length() == 1) {
            stringDate = "0" + stringDate;
        }
        if (stringMonth.length() == 1) {
            stringMonth = "0" + stringMonth;
        }
        return "D: "+stringDate + ", M: " + stringMonth + ", Y:" + stringYear;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}

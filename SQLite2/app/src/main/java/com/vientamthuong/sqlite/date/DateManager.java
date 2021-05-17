package com.vientamthuong.sqlite.date;

import java.util.Date;

public class DateManager {

    private static DateManager dateManager;

    private DateManager() {
    }

    public static DateManager getInstance() {
        if (dateManager == null) {
            dateManager = new DateManager();
        }
        return dateManager;
    }

    public String coverLongToString(long time) {
        Date date = new Date(time);
        int house = date.getHours() - 1;
        String sHouse = "";
        if (house - 12 >= 0) {
            house -= 12;
            sHouse = fillZeroSortString(house + "") + ":" +
                    fillZeroSortString(date.getMinutes() + "") +
                    ":" +
                    fillZeroSortString(date.getSeconds() + "") + " AM";
        } else {
            sHouse = fillZeroSortString(house + "") + ":" +
                    fillZeroSortString(date.getMinutes() + "") +
                    ":" +
                    fillZeroSortString(date.getSeconds() + "") + " PM";
        }
        return date.getDate() +
                " " +
                getMonth(date.getMonth() + 1) +
                ", " +
                (date.getYear() + 1900) +
                "_ " +
                sHouse;
    }

    private String fillZeroSortString(String s) {
        if (s.length() == 1) {
            s = "0" + s;
        }
        return s;
    }

    private String getMonth(int month) {
        String result = null;
        switch (month) {
            case 1:
                result = "Tháng Một";
                break;
            case 2:
                result = "Tháng Hai";
                break;
            case 3:
                result = "Tháng Ba";
                break;
            case 4:
                result = "Tháng Bốn";
                break;
            case 5:
                result = "Tháng Năm";
                break;
            case 6:
                result = "Tháng Sáu";
                break;
            case 7:
                result = "Tháng Bảy";
                break;
            case 8:
                result = "Tháng Tám";
                break;
            case 9:
                result = "Tháng Chín";
                break;
            case 10:
                result = "Tháng Mười";
                break;
            case 11:
                result = "Tháng Mười Một";
                break;
            case 12:
                result = "Tháng Mười Hai";
                break;
        }
        return result;
    }

}

package com.example.freebieticket.User;

public class UpcomingModel {
    private int upcomingmoreeventimg,upcomingimg;
    private String  numberofday,day,month,upcomingtitle,upcomingsubtitle;

    public UpcomingModel(int upcomingmoreeventimg, int upcomingimg, String numberofday, String day, String month, String upcomingtitle, String upcomingsubtitle) {
        this.upcomingmoreeventimg = upcomingmoreeventimg;
        this.upcomingimg = upcomingimg;
        this.numberofday = numberofday;
        this.day = day;
        this.month = month;
        this.upcomingtitle = upcomingtitle;
        this.upcomingsubtitle = upcomingsubtitle;
    }

    public int getUpcomingmoreeventimg() {
        return upcomingmoreeventimg;
    }

    public int getUpcomingimg() {
        return upcomingimg;
    }

    public String getNumberofday() {
        return numberofday;
    }

    public String getDay() {
        return day;
    }

    public String getMonth() {
        return month;
    }

    public String getUpcomingtitle() {
        return upcomingtitle;
    }

    public String getUpcomingsubtitle() {
        return upcomingsubtitle;
    }
}

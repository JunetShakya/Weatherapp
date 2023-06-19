package com.example.myweather;

public class WeatherModel {
    private String dt;

    private String time;
    private String temp;
    private String imageUrl;

    public WeatherModel(String dt, String time, String temp,String imageUrl) {
        this.dt = dt;
        this.time = time;
        this.temp = temp;
        this.imageUrl = imageUrl;
    }

    public String getDt() {
        return dt;
    }

    public String getTime() {
        return time;
    }

    public String getTemp() {
        return temp;
    }

    public String getImageUrl() {
        return imageUrl;
    }

}

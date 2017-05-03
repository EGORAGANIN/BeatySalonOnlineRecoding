package com.yclients.n63033.beatysalon.RestAPI.Responce;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SeanceTimesForBooking {

    @SerializedName("time")
    @Expose
    private String time;
    @SerializedName("seance_length")
    @Expose
    private int seanceLength;
    @SerializedName("datetime")
    @Expose
    private String datetime;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getSeanceLength() {
        return seanceLength;
    }

    public void setSeanceLength(int seanceLength) {
        this.seanceLength = seanceLength;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

}
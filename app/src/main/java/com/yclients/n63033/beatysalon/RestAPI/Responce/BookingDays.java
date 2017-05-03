package com.yclients.n63033.beatysalon.RestAPI.Responce;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BookingDays {

    @SerializedName("4")
    @Expose
    private List<Integer> _4 = null;
    @SerializedName("5")
    @Expose
    private List<Integer> _5 = null;
    @SerializedName("6")
    @Expose
    private List<Integer> _6 = null;

    public List<Integer> get4() {
        return _4;
    }

    public void set4(List<Integer> _4) {
        this._4 = _4;
    }

    public List<Integer> get5() {
        return _5;
    }

    public void set5(List<Integer> _5) {
        this._5 = _5;
    }

    public List<Integer> get6() {
        return _6;
    }

    public void set6(List<Integer> _6) {
        this._6 = _6;
    }

}
package com.yclients.n63033.beatysalon.RestAPI.Responce;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DatesForBooking {

    @SerializedName("booking_days")
    @Expose
    private BookingDays bookingDays;
    @SerializedName("booking_dates")
    @Expose
    private List<String> bookingDates = null;
    @SerializedName("working_days")
    @Expose
    private WorkingDays workingDays;
    @SerializedName("working_dates")
    @Expose
    private List<String> workingDates = null;

    public BookingDays getBookingDays() {
        return bookingDays;
    }

    public void setBookingDays(BookingDays bookingDays) {
        this.bookingDays = bookingDays;
    }

    public List<String> getBookingDates() {
        return bookingDates;
    }

    public void setBookingDates(List<String> bookingDates) {
        this.bookingDates = bookingDates;
    }

    public WorkingDays getWorkingDays() {
        return workingDays;
    }

    public void setWorkingDays(WorkingDays workingDays) {
        this.workingDays = workingDays;
    }

    public List<String> getWorkingDates() {
        return workingDates;
    }

    public void setWorkingDates(List<String> workingDates) {
        this.workingDates = workingDates;
    }

}
package com.yclients.n63033.beatysalon.RestAPI.Responce;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StaffForBooking {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("bookable")
    @Expose
    private boolean bookable;
    @SerializedName("specialization")
    @Expose
    private String specialization;
    @SerializedName("show_rating")
    @Expose
    private String showRating;
    @SerializedName("rating")
    @Expose
    private String rating;
    @SerializedName("votes_count")
    @Expose
    private String votesCount;
    @SerializedName("avatar")
    @Expose
    private String avatar;
    @SerializedName("comments_count")
    @Expose
    private String commentsCount;
    @SerializedName("weight")
    @Expose
    private String weight;
    @SerializedName("information")
    @Expose
    private String information;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isBookable() {
        return bookable;
    }

    public void setBookable(boolean bookable) {
        this.bookable = bookable;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getShowRating() {
        return showRating;
    }

    public void setShowRating(String showRating) {
        this.showRating = showRating;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getVotesCount() {
        return votesCount;
    }

    public void setVotesCount(String votesCount) {
        this.votesCount = votesCount;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getCommentsCount() {
        return commentsCount;
    }

    public void setCommentsCount(String commentsCount) {
        this.commentsCount = commentsCount;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

}
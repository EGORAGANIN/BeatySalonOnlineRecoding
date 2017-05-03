package com.yclients.n63033.beatysalon.RestAPI.Responce;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Service {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("category_id")
    @Expose
    private Integer categoryId;
    @SerializedName("price_min")
    @Expose
    private Integer priceMin;
    @SerializedName("price_max")
    @Expose
    private Integer priceMax;
    @SerializedName("discount")
    @Expose
    private Integer discount;
    @SerializedName("comment")
    @Expose
    private String comment;
    @SerializedName("weight")
    @Expose
    private Integer weight;
    @SerializedName("active")
    @Expose
    private Integer active;
    @SerializedName("sex")
    @Expose
    private Integer sex;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("seance_length")
    @Expose
    private Integer seanceLength;

    private boolean statesCheckbox = false;

    public boolean isStatesCheckbox() {
        return statesCheckbox;
    }

    public void setStatesCheckbox(boolean statesCheckbox) {
        this.statesCheckbox = statesCheckbox;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getPriceMin() {
        return priceMin;
    }

    public void setPriceMin(Integer priceMin) {
        this.priceMin = priceMin;
    }

    public Integer getPriceMax() {
        return priceMax;
    }

    public void setPriceMax(Integer priceMax) {
        this.priceMax = priceMax;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getSeanceLength() {
        return seanceLength;
    }

    public void setSeanceLength(Integer seanceLength) {
        this.seanceLength = seanceLength;
    }

}
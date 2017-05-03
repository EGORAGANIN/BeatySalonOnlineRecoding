package com.yclients.n63033.beatysalon.RestAPI.Responce;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.yclients.n63033.beatysalon.RestAPI.Responce.Category;
import com.yclients.n63033.beatysalon.RestAPI.Responce.Service;

public class ServicesForBooking {

    @SerializedName("services")
    @Expose
    private List<Service> services = null;
    @SerializedName("category")
    @Expose
    private List<Category> category = null;

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    public List<Category> getCategory() {
        return category;
    }

    public void setCategory(List<Category> category) {
        this.category = category;
    }

}
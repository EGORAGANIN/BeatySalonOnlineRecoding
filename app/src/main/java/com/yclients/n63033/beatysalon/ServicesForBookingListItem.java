package com.yclients.n63033.beatysalon;

import com.bignerdranch.expandablerecyclerview.Model.ParentListItem;
import com.yclients.n63033.beatysalon.RestAPI.Responce.Category;
import com.yclients.n63033.beatysalon.RestAPI.Responce.Service;

import java.util.ArrayList;
import java.util.List;

public class ServicesForBookingListItem implements ParentListItem {
    public Category category;
    public int category_id;
    public List<Service> serviceList = new ArrayList<>();

    public ServicesForBookingListItem(Category category, List<Service> serviceList) {
        this.category = category;
        this.category_id = category.getId();

        for (int i = 0; i<serviceList.size(); i++){
            Service service = serviceList.get(i);
            if (service.getCategoryId()==category_id){
                this.serviceList.add(service);
            }
        }

    }

    @Override
    public List<Service> getChildItemList() {
        return serviceList;
    }

    @Override
    public boolean isInitiallyExpanded() {
        return false;
    }
}

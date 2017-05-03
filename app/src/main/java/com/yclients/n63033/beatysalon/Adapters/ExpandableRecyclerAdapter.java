package com.yclients.n63033.beatysalon.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;

import com.bignerdranch.expandablerecyclerview.Model.ParentListItem;
import com.yclients.n63033.beatysalon.R;
import com.yclients.n63033.beatysalon.RestAPI.Responce.Service;
import com.yclients.n63033.beatysalon.ServicesForBookingListItem;
import com.yclients.n63033.beatysalon.ViewHolders.CategoryViewHolder;
import com.yclients.n63033.beatysalon.ViewHolders.ServicesViewHolder;


import java.util.List;

public class ExpandableRecyclerAdapter extends com.bignerdranch.expandablerecyclerview.Adapter.ExpandableRecyclerAdapter<CategoryViewHolder, ServicesViewHolder> {

    private LayoutInflater inflater;
    private OnCheckBoxListener listener;

    public ExpandableRecyclerAdapter(Context context, @NonNull List<ServicesForBookingListItem> parentItemList,
                                     OnCheckBoxListener listener) {
        super(parentItemList);
        inflater = LayoutInflater.from(context);
        this.listener = listener;
    }

    @Override
    public CategoryViewHolder onCreateParentViewHolder(ViewGroup parentViewGroup) {
        View view = inflater.inflate(R.layout.list_category, parentViewGroup, false);
        return new CategoryViewHolder(view);
    }

    @Override
    public ServicesViewHolder onCreateChildViewHolder(ViewGroup childViewGroup) {
        View view = inflater.inflate(R.layout.list_services, childViewGroup, false);
        return new ServicesViewHolder(view, listener);
    }


    @Override
    public void onBindParentViewHolder(final CategoryViewHolder parentViewHolder, final int position, ParentListItem parentListItem) {
        ServicesForBookingListItem item = (ServicesForBookingListItem) parentListItem;
        parentViewHolder.bindTo(item);

    }


    @Override
    public void onBindChildViewHolder(final ServicesViewHolder childViewHolder, final int position, Object childListItem) {
        final Service item = (Service) childListItem;
        childViewHolder.bindTo(item);
    }

    public interface OnCheckBoxListener {
        void onCheckedChanged(boolean b, Service item);
    }
}

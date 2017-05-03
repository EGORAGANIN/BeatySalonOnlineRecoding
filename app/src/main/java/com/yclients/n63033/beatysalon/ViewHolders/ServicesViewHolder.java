package com.yclients.n63033.beatysalon.ViewHolders;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.ViewHolder.ChildViewHolder;
import com.yclients.n63033.beatysalon.Adapters.ExpandableRecyclerAdapter;
import com.yclients.n63033.beatysalon.R;
import com.yclients.n63033.beatysalon.RestAPI.Responce.Service;


public class ServicesViewHolder extends ChildViewHolder {

    private TextView childTitle;
    private TextView price;
    private CheckBox select;
    private ColorStateList defaultColorText;
    private ExpandableRecyclerAdapter.OnCheckBoxListener listener;

    public ServicesViewHolder(View itemView, ExpandableRecyclerAdapter.OnCheckBoxListener listener) {
        super(itemView);
        this.listener = listener;
        childTitle = (TextView) itemView.findViewById(R.id.childTitle2);
        price = (TextView) itemView.findViewById(R.id.price);
        select = (CheckBox) itemView.findViewById(R.id.select);
        defaultColorText = childTitle.getTextColors();

    }

    public void bindTo(final Service item) {
        childTitle.setText(item.getTitle());
        price.setText(item.getPriceMin().toString());
        select.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                listener.onCheckedChanged(b, item);
                setTextColor(b);
                item.setStatesCheckbox(b);
            }
        });
        select.setChecked(item.isStatesCheckbox());
    }

    private void setTextColor(boolean b) {
        if (b) {
            childTitle.setTextColor(Color.BLACK);
            price.setTextColor(Color.BLACK);
        } else {
            childTitle.setTextColor(defaultColorText.getDefaultColor());
            price.setTextColor(defaultColorText.getDefaultColor());
        }

    }
}

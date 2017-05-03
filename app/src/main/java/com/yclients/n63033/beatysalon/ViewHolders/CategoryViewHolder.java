package com.yclients.n63033.beatysalon.ViewHolders;

import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.ViewHolder.ParentViewHolder;
import com.yclients.n63033.beatysalon.R;
import com.yclients.n63033.beatysalon.RestAPI.Responce.Category;
import com.yclients.n63033.beatysalon.RestAPI.Responce.Service;
import com.yclients.n63033.beatysalon.ServicesForBookingListItem;

/**
 * Created by Егор on 27.04.2017.
 */

public class CategoryViewHolder extends ParentViewHolder {

    private TextView parentTitle;
    private ImageButton expandArrow;
    private LinearLayout categoryLinearLayout;


    public CategoryViewHolder(View itemView) {
        super(itemView);
        parentTitle = (TextView) itemView.findViewById(R.id.parentTitle);
        expandArrow = (ImageButton) itemView.findViewById(R.id.expandArrow);
        categoryLinearLayout = (LinearLayout) itemView.findViewById(R.id.category_linear_layout);
    }

    public void bindTo(final ServicesForBookingListItem item) {
        parentTitle.setText(item.category.getTitle());
        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float deg = expandArrow.getRotation() + 180F;
                if (isExpanded()) {
                    collapseView();
                    expandArrow.animate().setDuration(0).rotation(deg).setInterpolator(new AccelerateDecelerateInterpolator());
                } else {
                    expandView();
                    expandArrow.animate().setDuration(0).rotation(deg).setInterpolator(new AccelerateDecelerateInterpolator());
                }
            }
        };
        expandArrow.setOnClickListener(clickListener);
        categoryLinearLayout.setOnClickListener(clickListener);
    }

    @Override
    public boolean shouldItemViewClickToggleExpansion() {
        return false;
    }
}

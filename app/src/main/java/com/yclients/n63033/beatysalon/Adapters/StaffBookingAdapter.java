package com.yclients.n63033.beatysalon.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.yclients.n63033.beatysalon.R;
import com.yclients.n63033.beatysalon.RestAPI.Responce.StaffForBooking;

import java.util.List;

public class StaffBookingAdapter extends RecyclerView.Adapter<StaffBookingAdapter.ViewHolder> {

    private final List<StaffForBooking> collectionStaff;
    private final OnStaffClickListener listener;

    public StaffBookingAdapter(List<StaffForBooking> collectionStaff, OnStaffClickListener listener) {
        this.collectionStaff = collectionStaff;
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.view_staff_booking_item, parent, false);
        return new ViewHolder(itemView, listener);
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        StaffForBooking staff = collectionStaff.get(position);
        holder.bindTo(staff);
    }

    @Override
    public int getItemCount() {
        return collectionStaff.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView nameStaff;
        final TextView postStaff;
        final ImageView avatar;

        StaffForBooking staff;

        public ViewHolder(View itemView, final OnStaffClickListener listener) {
            super(itemView);
            nameStaff = (TextView) itemView.findViewById(R.id.nameStaff);
            postStaff = (TextView) itemView.findViewById(R.id.postStaff);
            avatar = (ImageView) itemView.findViewById(R.id.avatar);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.OnClick(staff);
                }
            });
        }

        private void bindTo(StaffForBooking staff) {
            this.staff = staff;

            nameStaff.setText(staff.getName());
            postStaff.setText(staff.getSpecialization());
            Glide.with(avatar.getContext()).load(staff.getAvatar()).error(R.drawable.ic_error_black_24dp).into(avatar);

        }
    }

    public interface OnStaffClickListener {
        void OnClick(StaffForBooking staff);
    }
}

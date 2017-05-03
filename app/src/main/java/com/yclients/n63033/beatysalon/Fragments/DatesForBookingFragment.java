package com.yclients.n63033.beatysalon.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.yclients.n63033.beatysalon.CalendarView;
import com.yclients.n63033.beatysalon.RestAPI.Responce.DatesForBooking;
import com.yclients.n63033.beatysalon.ParametersRecord;
import com.yclients.n63033.beatysalon.R;
import com.yclients.n63033.beatysalon.RestAPI.RestApi;

import java.text.ParseException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DatesForBookingFragment extends Fragment {

    private static final String TAG = DatesForBookingFragment.class.getSimpleName();

    public DatesForBookingFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_dates_booking, container, false);
        return inflate;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        loadDates();
    }

    private void loadDates() {
        Callback<DatesForBooking> callback = new Callback<DatesForBooking>() {
            @Override
            public void onResponse(Call<DatesForBooking> call, Response<DatesForBooking> response) {
                if (response.isSuccessful()) {
                    try {
                        CalendarView calendar = new CalendarView(getView(), getFragmentManager());
                        calendar.fillingCalendar(response);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<DatesForBooking> call, Throwable t) {
                Log.d(TAG, "Failed to load Dates");
                Toast.makeText(getContext(), "Failed to load Dates", Toast.LENGTH_LONG).show();
            }
        };

        RestApi restApi = new RestApi();
        restApi.getCollectionDatesAvailableForBooking(callback, ParametersRecord.getServicesIds(), ParametersRecord.getStaffId());
    }
}

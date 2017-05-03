package com.yclients.n63033.beatysalon.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.yclients.n63033.beatysalon.Decorator.DividerItemDecoration;
import com.yclients.n63033.beatysalon.ParametersRecord;
import com.yclients.n63033.beatysalon.R;
import com.yclients.n63033.beatysalon.RestAPI.RestApi;
import com.yclients.n63033.beatysalon.Adapters.StaffBookingAdapter;
import com.yclients.n63033.beatysalon.RestAPI.Responce.StaffForBooking;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StaffBookingFragment extends Fragment {

    public RecyclerView recyclerView;

    private static final String TAG = StaffBookingFragment.class.getSimpleName();

    public StaffBookingFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_staff_booking, container, false);
        return inflate;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        recyclerView = (RecyclerView) view.findViewById(R.id.recycle_view_list_staff_booking);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.addItemDecoration(new DividerItemDecoration(
                getContext()
        ));
        loadStaff();

    }

    private void loadStaff() {
        Callback<List<StaffForBooking>> callback = new Callback<List<StaffForBooking>>() {
            @Override
            public void onResponse(Call<List<StaffForBooking>> call, Response<List<StaffForBooking>> response) {
                if (response.isSuccessful()) {
                    StaffBookingAdapter adapter = new StaffBookingAdapter(response.body(), createClickListener());
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<StaffForBooking>> call, Throwable t) {
                Log.d(TAG, "Failed to load Staff");
                Toast.makeText(getContext(), "Failed to load Staff", Toast.LENGTH_LONG).show();
            }
        };

        RestApi restApi = new RestApi();
        restApi.getCollectionStaffAvailableForBooking(callback);

    }

    private StaffBookingAdapter.OnStaffClickListener createClickListener() {
        StaffBookingAdapter.OnStaffClickListener clickListener = new StaffBookingAdapter.OnStaffClickListener() {
            @Override
            public void OnClick(StaffForBooking staff) {

                Toast.makeText(getContext(), staff.getName() + " " + staff.getId(), Toast.LENGTH_LONG).show();
                ParametersRecord.setStaffId(staff.getId());
                addServicesBookingFragment();
            }
        };
        return clickListener;
    }

    private void addServicesBookingFragment() {
        ServicesBookingFragment fragment = new ServicesBookingFragment(ParametersRecord.getStaffId());

        android.support.v4.app.FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.frameLayout, fragment);
        transaction.commit();
    }
}

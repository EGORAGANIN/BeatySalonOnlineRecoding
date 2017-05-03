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
import android.widget.Button;
import android.widget.Toast;

import com.yclients.n63033.beatysalon.Adapters.ExpandableRecyclerAdapter;
import com.yclients.n63033.beatysalon.ServicesForBookingListItem;
import com.yclients.n63033.beatysalon.ParametersRecord;
import com.yclients.n63033.beatysalon.R;
import com.yclients.n63033.beatysalon.RestAPI.RestApi;
import com.yclients.n63033.beatysalon.RestAPI.Responce.Service;
import com.yclients.n63033.beatysalon.RestAPI.Responce.ServicesForBooking;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ServicesBookingFragment extends Fragment {

    private RecyclerView recyclerView;
    private int staffId;
    private Button selectServices;

    private static final String TAG = ServicesBookingFragment.class.getSimpleName();

    public ServicesBookingFragment(int staffId) {
        this.staffId = staffId;
    }

    public ServicesBookingFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_services_booking, container, false);
        return inflate;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        recyclerView = (RecyclerView) view.findViewById(R.id.recycle_view_list_services_booking);
        selectServices = (Button) view.findViewById(R.id.selectServices);

        selectServices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addDatesForBookingFragment();
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        loadServices();
    }

    private void loadServices() {
        Callback<ServicesForBooking> callback = new Callback<ServicesForBooking>() {
            @Override
            public void onResponse(Call<ServicesForBooking> call, Response<ServicesForBooking> response) {
                if (response.isSuccessful()) {
                    List<ServicesForBookingListItem> listItems =
                            new ArrayList<>();
                    int sizeCategory = response.body().getCategory().size();
                    int sizeServices = response.body().getServices().size();

                    for (int i = 0; i < sizeCategory; i++) {
                        for (int j = 0; j < sizeServices; j++) {
                            if (response.body().getCategory().get(i).getId().
                                    equals(response.body().getServices().get(j).getCategoryId())) {

                                listItems.add(new ServicesForBookingListItem(response.body().getCategory().get(i),
                                        response.body().getServices()));

                                break;
                            }
                        }
                    }

                    com.bignerdranch.expandablerecyclerview.Adapter.ExpandableRecyclerAdapter adapter =
                            new ExpandableRecyclerAdapter(getContext(), listItems, createCheckBoxListener());

                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<ServicesForBooking> call, Throwable t) {
                Log.d(TAG, "Failed to load Services");
                Toast.makeText(getContext(), "Failed to load Services", Toast.LENGTH_LONG).show();
            }
        };

        RestApi restApi = new RestApi();
        restApi.getCollectionServicesAvailableForBooking(callback, staffId);
    }

    private void addDatesForBookingFragment(){
        DatesForBookingFragment fragment = new DatesForBookingFragment();

        android.support.v4.app.FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.frameLayout,fragment);
        transaction.commit();
    }

    private ExpandableRecyclerAdapter.OnCheckBoxListener createCheckBoxListener(){
        ExpandableRecyclerAdapter.OnCheckBoxListener listener = new ExpandableRecyclerAdapter.OnCheckBoxListener() {
            @Override
            public void onCheckedChanged(boolean b, Service item) {
                if (b){
                    ParametersRecord.getServicesIds().add(item.getId());
                }else {
                    ParametersRecord.getServicesIds().remove(item.getId());
                }
            }
        };
        return listener;
    }
}

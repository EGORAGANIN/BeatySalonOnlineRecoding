package com.yclients.n63033.beatysalon.RestAPI;

import com.yclients.n63033.beatysalon.RestAPI.Responce.DatesForBooking;
import com.yclients.n63033.beatysalon.RestAPI.Request.AvailableDates;
import com.yclients.n63033.beatysalon.RestAPI.Request.AvailableServices;
import com.yclients.n63033.beatysalon.RestAPI.Request.AvailableStaff;
import com.yclients.n63033.beatysalon.RestAPI.Responce.ServicesForBooking;
import com.yclients.n63033.beatysalon.RestAPI.Responce.StaffForBooking;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Егор on 22.04.2017.
 */

public class RestApi {
    private static final String BASE_URL = "http://api.yclients.com/api/v1/";
    private static final int company_id = 79658;

    private static Retrofit createRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }


    public static AvailableStaff createAvailableForBooking() {
        return createRetrofit().create(AvailableStaff.class);
    }

    public void getCollectionStaffAvailableForBooking(Callback<List<StaffForBooking>> callback) {
        Call<List<StaffForBooking>> listCall = createAvailableForBooking().groupList(company_id, false);
        listCall.enqueue(callback);
    }

    public static AvailableServices createAvailableServices() {
        return createRetrofit().create(AvailableServices.class);
    }

    public void getCollectionServicesAvailableForBooking(Callback<ServicesForBooking> callback, int staffId) {
        Call<ServicesForBooking> listCall = createAvailableServices().groupList(company_id, staffId);
        listCall.enqueue(callback);
    }

    public static AvailableDates createAvailableDates() {
        return createRetrofit().create(AvailableDates.class);
    }

    public void getCollectionDatesAvailableForBooking(Callback<DatesForBooking> callback, List<Integer> servicesIds, int staffId) {
        Call<DatesForBooking> listCall = createAvailableDates().groupList(company_id, servicesIds, staffId);
        listCall.enqueue(callback);
    }
}

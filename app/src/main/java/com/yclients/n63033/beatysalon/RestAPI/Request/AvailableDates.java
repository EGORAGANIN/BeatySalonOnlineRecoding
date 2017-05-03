package com.yclients.n63033.beatysalon.RestAPI.Request;

import com.yclients.n63033.beatysalon.RestAPI.Responce.DatesForBooking;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface AvailableDates {
    @Headers({"Content-Type: application/json",
            "Authorization: ebxbsb5d6dx2e4tpm7r8"
    })
    @GET("book_dates/{company_id}")
    Call<DatesForBooking> groupList(@Path("company_id") int companyId,
                                    @Query("service_ids[]") List<Integer> serviceIds,
                                    @Query("staff_id") int staffId);
}

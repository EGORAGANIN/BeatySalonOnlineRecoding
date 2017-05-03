package com.yclients.n63033.beatysalon.RestAPI.Request;

import com.yclients.n63033.beatysalon.RestAPI.Responce.SeanceTimesForBooking;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface AvailableSeanceTimes {
    @Headers({"Content-Type: application/json",
            "Authorization: ebxbsb5d6dx2e4tpm7r8"
    })
    @GET("book_times/{company_id}/{staff_id}/{date}?service_ids[]=")
    Call<SeanceTimesForBooking> groupList(@Path("company_id") int companyId,
                                          @Path("staff_id") int staffId,
                                          @Path("date") String date,
                                          @Query("service_ids[]") List<Integer> serviceIds);
}

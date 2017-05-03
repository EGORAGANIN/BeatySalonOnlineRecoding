package com.yclients.n63033.beatysalon.RestAPI.Request;

import com.yclients.n63033.beatysalon.RestAPI.Responce.StaffForBooking;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Интерфейс обращается к API Yclients
 * Использовал пункт "Получить список сотрудников доступных для бронирования"
 * Отключил выдачу ближайших свободных сеансов черз параметр without_seances, для ускорения получение данных.
 * Документация API доступна по URL http://docs.yclients.apiary.io
 */

public interface AvailableStaff {
    @Headers({"Content-Type: application/json",
            "Authorization: ebxbsb5d6dx2e4tpm7r8"
    })
    @GET("book_staff/{company_id}")
    Call<List<StaffForBooking>> groupList(@Path("company_id") int companyId,
                                          @Query("without_seances") boolean lol);
}

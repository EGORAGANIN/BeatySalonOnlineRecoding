package com.yclients.n63033.beatysalon;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.view.View;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;
import com.yclients.n63033.beatysalon.Decorator.EventDecorator;
import com.yclients.n63033.beatysalon.Fragments.SeanceTimesFragment;
import com.yclients.n63033.beatysalon.RestAPI.Responce.DatesForBooking;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import retrofit2.Response;

public class CalendarView {

    View view;
    FragmentManager fragmentManager;

    public CalendarView(View view, FragmentManager fragmentManager) {
        this.view = view;
        this.fragmentManager = fragmentManager;
    }

    public void fillingCalendar(Response<DatesForBooking> response) throws ParseException {
        MaterialCalendarView calendarView = (MaterialCalendarView) view.findViewById(R.id.calendarView);

        int sizeWorking = response.body().getWorkingDates().size();
        int sizeBooking = response.body().getBookingDates().size();

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date minDate = format.parse(response.body().getWorkingDates().get(0));
        Date maxDate = format.parse(response.body().getWorkingDates().get(sizeWorking - 1));

        calendarView.state().edit()
                .setFirstDayOfWeek(Calendar.MONDAY)
                .setMinimumDate(minDate)
                .setMaximumDate(maxDate)
                .commit();

        HashSet<CalendarDay> calendarDaysWorking = new HashSet<CalendarDay>();
        for (int i = 0; i < sizeWorking; i++) {
            calendarDaysWorking.add(CalendarDay.from(format.parse(response.body().getWorkingDates().get(i))));
        }

        HashSet<CalendarDay> calendarDaysBooking = new HashSet<CalendarDay>();
        for (int i = 0; i < sizeBooking; i++) {
            calendarDaysBooking.add(CalendarDay.from(format.parse(response.body().getBookingDates().get(i))));
        }

        long diff = maxDate.getTime() - minDate.getTime();
        long days = java.util.concurrent.TimeUnit.MILLISECONDS.toDays(diff);
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(minDate);

        HashSet<CalendarDay> allDates = new HashSet<CalendarDay>();
        for (int i = 0; i < days; i++) {
            allDates.add(CalendarDay.from(calendar));
            calendar.add(Calendar.DAY_OF_YEAR, 1);
        }

        calendarView.addDecorators(new EventDecorator(Color.GRAY, allDates));
        calendarView.addDecorators(new EventDecorator(Color.BLACK, calendarDaysWorking));
        calendarView.addDecorators(new EventDecorator(Color.parseColor("#03A9F4"), calendarDaysBooking));

        calendarView.setOnDateChangedListener(new OnDateSelectedListener() {
            @Override
            public void onDateSelected(@NonNull MaterialCalendarView widget, @NonNull CalendarDay date, boolean selected) {
                if (selected){
                    addSeanceTimesFragment();
                }
            }
        });
    }

    private void addSeanceTimesFragment(){
        SeanceTimesFragment fragment = new SeanceTimesFragment();

        android.support.v4.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frameLayout,fragment);
        transaction.commit();
    }

}

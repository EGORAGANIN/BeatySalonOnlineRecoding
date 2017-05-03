package com.yclients.n63033.beatysalon.Decorator;

import android.graphics.Color;
import android.text.style.ForegroundColorSpan;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.DayViewDecorator;
import com.prolificinteractive.materialcalendarview.DayViewFacade;

import java.util.HashSet;


public class EventDecorator implements DayViewDecorator {

    private final int color;
    private final HashSet<CalendarDay> dates;


    public EventDecorator(int color, HashSet<CalendarDay> dates) {
        this.color = color;
        this.dates = new HashSet<>(dates);
    }

    @Override
    public boolean shouldDecorate(CalendarDay day) {
        return dates.contains(day);
    }


    @Override
    public void decorate(DayViewFacade view) {
        if (color == Color.BLACK) {
            view.setDaysDisabled(true);
            view.addSpan(new ForegroundColorSpan(color));
        } else if (color == Color.GRAY) {
            view.setDaysDisabled(true);
        } else {
            view.setDaysDisabled(false);
            view.addSpan(new ForegroundColorSpan(color));
        }
    }
}
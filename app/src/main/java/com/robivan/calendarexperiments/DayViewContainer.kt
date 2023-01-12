package com.robivan.calendarexperiments

import android.view.View
import com.kizitonwose.calendar.view.ViewContainer
import com.robivan.calendarexperiments.databinding.CalendarDayLayoutBinding

class DayViewContainer(view: View) : ViewContainer(view) {
    val textView = CalendarDayLayoutBinding.bind(view).calendarDayText
}
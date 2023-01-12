package com.robivan.calendarexperiments

import com.applandeo.materialcalendarview.EventDay
import java.util.*
import kotlin.collections.ArrayList

object CalendarEventsBuilder {

    private val events = mutableListOf<EventDay>()

    fun setFullEntryDays(arrayList: ArrayList<Int>): CalendarEventsBuilder {
        setCustomDrawableToEvents(arrayList, R.drawable.calendar_event_full_entry)
        return this
    }

    fun setFreeEntryDays(arrayList: ArrayList<Int>): CalendarEventsBuilder {
        setCustomDrawableToEvents(arrayList, R.drawable.calendar_event_free_entry)
        return this
    }

    fun setEntryDays(arrayList: ArrayList<Int>): CalendarEventsBuilder {
        setCustomDrawableToEvents(arrayList, R.drawable.calendar_event_entry_day)
        return this
    }

    private fun setCustomDrawableToEvents(arrayList: ArrayList<Int>, drawable: Int) {
        arrayList.forEach {
            val calendar = Calendar.getInstance()
            calendar.add(Calendar.DAY_OF_MONTH, it)
            events.add(EventDay(calendar, drawable))
        }
    }

    fun build(): List<EventDay> = events
}
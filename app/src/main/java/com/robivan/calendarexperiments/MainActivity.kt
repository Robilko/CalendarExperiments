package com.robivan.calendarexperiments

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.applandeo.materialcalendarview.EventDay
import com.applandeo.materialcalendarview.listeners.OnDayClickListener
import com.robivan.calendarexperiments.databinding.ActivityMainBinding
import com.applandeo.materialcalendarview.utils.*
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initCalendar()
    }

    private fun initCalendar() = with(binding) {
        calendarView.apply {
            setCalendarDayLayout(R.layout.calendar_cell_item)
            setSelectionBackground(R.drawable.calendar_custom_selector)
            setMinimumDate(
                Calendar.getInstance().apply { add(Calendar.DAY_OF_MONTH, MIN_DAYS_BEFORE_TODAY) })
            setMaximumDate(
                Calendar.getInstance().apply { add(Calendar.DAY_OF_MONTH, MAX_DAYS_AFTER_TODAY) })
            setEvents(getEvents())
            setDisabledDays(getDisabledDays())
            setOnDayClickListener(object : OnDayClickListener {
                override fun onDayClick(eventDay: EventDay) {
                    //TODO something
                }
            })
        }
    }

    private fun getDisabledDays(): List<Calendar> {
        val disabledCalendars = mutableListOf<Calendar>()
        val daysBeforeToday = MIN_DAYS_BEFORE_TODAY..YESTERDAY
        val daysTwoWeekAfterToday = TWO_WEEKS..MAX_DAYS_AFTER_TODAY
        val rangeOfDaysToDisable = daysBeforeToday + daysTwoWeekAfterToday

        rangeOfDaysToDisable.forEach {
            val calendar = midnightCalendar
            calendar.add(Calendar.DAY_OF_MONTH, it)
            disabledCalendars.add(calendar)
        }
        return disabledCalendars
    }

    //TODO переделать метод. На вход давать даты и одним методом их добавлять в список ивентов
    private fun getEvents(): List<EventDay> {
        // mocks
        val fullEntries = arrayListOf(4, 5, 7)
        val freeEntries = arrayListOf(3, 6, 8, 9)
        val entryDays = arrayListOf(2, 10)
        //
        return CalendarEventsBuilder
            .setFullEntryDays(fullEntries)
            .setFreeEntryDays(freeEntries)
            .setEntryDays(entryDays)
            .build()
    }

    companion object {
        private const val MIN_DAYS_BEFORE_TODAY = -100
        private const val MAX_DAYS_AFTER_TODAY = 100
        private const val YESTERDAY = -1
        private const val TWO_WEEKS = 14
    }
}
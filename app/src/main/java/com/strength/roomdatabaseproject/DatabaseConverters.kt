package com.strength.roomdatabaseproject

import androidx.room.TypeConverter
import java.util.Date

class DatabaseConverters {
    @TypeConverter
    fun fromDateToLong(date: Date) : Long {
        return date.time
    }

    @TypeConverter
    fun fromLongToDate(value : Long) : Date {
        return Date(value)
    }
}
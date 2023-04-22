package com.mr_17.khabresh.db

import androidx.room.TypeConverter
import com.mr_17.khabresh.models.Source

class Converters {

    @TypeConverter
    fun fromSource(source: Source): String {
        return source.name
    }

    @TypeConverter
    fun toSource(name: String): Source {
        return Source(name, name)
    }
}
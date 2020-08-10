package com.davevarga.latestnews.utils

import androidx.room.TypeConverter
import com.davevarga.latestnews.models.Source

class Converters {

    @TypeConverter
    fun fromSource(source: Source): String? {
        return source.sourceName
    }

    @TypeConverter
    fun toSource(name: String): Source {
        return Source(name, name)
    }

}
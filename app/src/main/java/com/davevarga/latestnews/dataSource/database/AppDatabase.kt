package com.davevarga.latestnews.dataSource.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.davevarga.latestnews.dataSource.NewsDao
import com.davevarga.latestnews.utils.Converters
import com.davevarga.latestnews.models.NewsPost

@Database(entities = arrayOf(NewsPost::class), version = 8, exportSchema = false)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun newsDao(): NewsDao

    companion object {
        @Volatile
        private var instance: AppDatabase? = null

        fun getInstance(
            context: Context
        ): AppDatabase = instance
            ?: synchronized(this) {
            instance
                ?: buildDatabase(
                    context
                )
                    .also { instance = it }
        }

        private fun buildDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(
                context,
                AppDatabase::class.java,
                "newsDB"
            ).fallbackToDestructiveMigration().build()
        }
    }
}
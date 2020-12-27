package com.github.clem10101998.androidkotlin4a.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.github.clem10101998.androidkotlin4a.data.local.models.UserLocal


@Database(entities = [UserLocal::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun databaseDao(): DatabaseDao
}
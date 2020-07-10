package com.mvk.database.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mvk.database.db.entity.DummyEntity
import com.mvk.database.db.dao.DummyDao
import javax.inject.Singleton

@Singleton
@Database(
    entities = [
        DummyEntity::class
    ],
    exportSchema = false,
    version = 1
)
abstract class DatabaseService : RoomDatabase() {

    abstract fun dummyDao(): DummyDao
}
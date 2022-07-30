package com.example.ders23;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

@Database(entities = {Kitap.class}, version = 1)
public abstract class veritabanim extends RoomDatabase {

    public abstract myDao myDao();


}

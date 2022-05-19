package com.sample.mad.fifth;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Topic.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract TopicDAO topicDao();
    private volatile static AppDatabase INSTANCE = null;
    public static synchronized AppDatabase getInstance(Context context) {
        if (INSTANCE != null) return INSTANCE;
        AppDatabase instance = Room.databaseBuilder(context, AppDatabase.class, "AppDatabase.db")
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build();
        INSTANCE =  instance;
        return instance;
    }
}

package com.example.wfootball.data.local;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.wfootball.domain.News;

@Database(entities = {News.class}, version = 1)
public abstract class WFootballDb extends RoomDatabase {
    public abstract NewsDao newsDao();
}

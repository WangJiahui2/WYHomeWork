package com.wangyi.wyhomework.cacheN;

import androidx.room.Database;
import androidx.room.RoomDatabase;


@Database(entities = {WeiBoCacheN.class},version = 2,exportSchema = false)
public abstract class AppDatabaseN extends RoomDatabase {
    public abstract WeiBoDaoN weiBoDaoN();
}

package com.wangyi.wyhomework.cacheN;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;


@Dao
public interface WeiBoDaoN {
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertWeiBo(WeiBoCacheN weiBoCache);
    
    @Update
    int updateWeiBo(WeiBoCacheN weiBoCache);
    
    @Delete
    void deleteWeibo(WeiBoCacheN weiBoCache);


    @Query("SELECT * FROM weibon")
    WeiBoCacheN getAll();
    
    
}

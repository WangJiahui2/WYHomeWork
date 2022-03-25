package com.wangyi.wyhomework.cache;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface WeiBoDao {
    
    @Insert
    void insertWeiBo(WeiBoCache weiBoCache);
    
    @Update
    int updateWeiBo(WeiBoCache weiBoCache);
    
    @Delete
    void deleteWeibo(WeiBoCache weiBoCache);


    @Query("SELECT * FROM weibo")
    WeiBoCache getAll();
    
    
}

package com.wangyi.wyhomework.cacheN;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import lombok.Data;

@Data
@Entity(tableName = "weibon")
public class WeiBoCacheN {
    
    @PrimaryKey(autoGenerate = true)
    public long uid;
    
    public String test;
    public WeiBoCacheN() {
    }
    
    @Ignore
    public WeiBoCacheN(long uid, String test) {
        this.uid = uid;
        this.test = test;
    }
}

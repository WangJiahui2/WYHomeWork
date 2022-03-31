package com.wangyi.wyhomework.cache;



import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;


import java.util.List;

import lombok.Data;

@Data
@Entity(tableName = "weibo")
public class WeiBoCache {

    @PrimaryKey(autoGenerate = true)
    public long uid;
    @TypeConverters(ContentTypeConverter.class)
    public List<Content> contents;


    public static class Content {
        public String createdAt;
        public String id;
        public String text;
        public String source;

        public List<PicUrls> picUrls;
 
        public User user;

        public Retweeted retweetedStatus;


        public static class PicUrls {
            public String thumbnailPic;
        }

        public static class User {
            public String id;
            public String name;
            public String description;
            public String profileImageUrl;
        }

        //转发的微博内容
        public static class Retweeted {
            public String createdAt;
            public String id;
            public String text;
            public String source;
            public List<PicUrls> picUrls;
            public User user;
        }
    }

    public WeiBoCache() {
    }
}

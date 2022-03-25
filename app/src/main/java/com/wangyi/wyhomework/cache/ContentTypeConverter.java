package com.wangyi.wyhomework.cache;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

public class ContentTypeConverter {

    Gson gson = new Gson();

    @TypeConverter
    public List<WeiBoCache.Content> stringToSomeObjectList(String data) {
        if (data == null) {
            return Collections.emptyList();
        }

        Type listType = new TypeToken<List<WeiBoCache.Content>>() {}.getType();

        return gson.fromJson(data, listType);
    }

    @TypeConverter
    public String someObjectListToString(List<WeiBoCache.Content> someObjects) {
        return gson.toJson(someObjects);
    }

}

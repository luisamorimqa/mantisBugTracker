package com.mantis.api.utils;

import java.util.HashMap;
import java.util.Map;

public class SharedData {

    private static final Map<String, Object> dataMap = new HashMap<>();

    public static <T> void put(String key, T object) {
        dataMap.put(key, object);
    }

    public static <T> T get(String key){
        return (T) dataMap.get(key);
    }

    public static void clear() {
        dataMap.clear();
    }
}
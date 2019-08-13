package com.hualala.api.utils;

import java.util.*;

public class TLinxMapUtils {
    public Map map = new HashMap();
    public Set keySet = map.keySet();
    public Object get(String key) {
        return map.get(key);
    }
    public void put(String key, Object value) {
        map.put(key, value);
    }
    public void sort() {
        List list = new ArrayList(map.keySet());
        this.keySet = new TreeSet(list);
    }
}

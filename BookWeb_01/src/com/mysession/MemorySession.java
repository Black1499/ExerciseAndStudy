package com.mysession;

import java.util.HashMap;
import java.util.Map;

public class MemorySession implements MySession {
    private Map<String, Object> map = new HashMap<String, Object>();

    private String id;

    public MemorySession() {
    }

    public MemorySession(String id) {
        this.id = id;
    }

    //获得session的id
    @Override
    public String id() {
        return this.id;
    }
    //获得session内容
    @Override
    public Object get(String key) {
        return map.get(key);
    }
    //添加新的session
    @Override
    public void set(String key, Object o) {
        map.put(key, o);
    }
}

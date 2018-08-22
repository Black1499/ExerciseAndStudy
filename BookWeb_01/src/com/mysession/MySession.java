package com.mysession;

public interface MySession {
    String id();
    Object get(String key);
    void set(String key,Object o);
}

package com.hualala.api.config.db;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by yefei on 2018/8/1.
 */
@Slf4j
public class DatabaseContextHolder {
    private static final ThreadLocal<DatabaseType> contextHolder = new ThreadLocal<>();

     public static void setDatabaseType(DatabaseType type){
         contextHolder.set(type);
     }

    public static DatabaseType getDatabaseType(){
         return contextHolder.get();
     }
}

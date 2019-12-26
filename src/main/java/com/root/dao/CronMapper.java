package com.root.dao;

import java.util.List;

import com.root.entity.Cron;
 
 
public interface CronMapper {
    int insert(Cron record);
 
    List<Cron> selectAll();
}

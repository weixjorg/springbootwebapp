package com.root.dao;

import java.util.List;

import com.root.entity.ConfigInfo;


public interface ConfigInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ConfigInfo record);

    int insertSelective(ConfigInfo record);

    ConfigInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ConfigInfo record);

    int updateByPrimaryKey(ConfigInfo record);
    
    ConfigInfo getByChannelid(String channelid);
    
    List<ConfigInfo> getAll();
}
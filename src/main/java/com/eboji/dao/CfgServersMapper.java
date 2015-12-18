package com.eboji.dao;

import com.eboji.pojo.CfgServers;
import com.eboji.pojo.CfgServersExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface CfgServersMapper {
    int countByExample(CfgServersExample example);

    int deleteByExample(CfgServersExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CfgServers record);

    int insertSelective(CfgServers record);

    List<CfgServers> selectByExample(CfgServersExample example);

    CfgServers selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CfgServers record, @Param("example") CfgServersExample example);

    int updateByExample(@Param("record") CfgServers record, @Param("example") CfgServersExample example);

    int updateByPrimaryKeySelective(CfgServers record);

    int updateByPrimaryKey(CfgServers record);
}
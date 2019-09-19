package com.hroa.dao;

import com.hroa.model.Jobinfo;
import com.hroa.model.JobinfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JobinfoDao {
    int countByExample(JobinfoExample example);

    int deleteByExample(JobinfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Jobinfo record);

    int insertSelective(Jobinfo record);

    List<Jobinfo> selectByExampleWithBLOBs(JobinfoExample example);

    List<Jobinfo> selectByExample(JobinfoExample example);

    Jobinfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Jobinfo record, @Param("example") JobinfoExample example);

    int updateByExampleWithBLOBs(@Param("record") Jobinfo record, @Param("example") JobinfoExample example);

    int updateByExample(@Param("record") Jobinfo record, @Param("example") JobinfoExample example);

    int updateByPrimaryKeySelective(Jobinfo record);

    int updateByPrimaryKeyWithBLOBs(Jobinfo record);

    int updateByPrimaryKey(Jobinfo record);
}
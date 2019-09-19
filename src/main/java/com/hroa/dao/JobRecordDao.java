package com.hroa.dao;

import com.hroa.model.JobRecord;
import com.hroa.model.JobRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JobRecordDao {
    int countByExample(JobRecordExample example);

    int deleteByExample(JobRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(JobRecord record);

    int insertSelective(JobRecord record);

    List<JobRecord> selectByExampleWithBLOBs(JobRecordExample example);

    List<JobRecord> selectByExample(JobRecordExample example);

    JobRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") JobRecord record, @Param("example") JobRecordExample example);

    int updateByExampleWithBLOBs(@Param("record") JobRecord record, @Param("example") JobRecordExample example);

    int updateByExample(@Param("record") JobRecord record, @Param("example") JobRecordExample example);

    int updateByPrimaryKeySelective(JobRecord record);

    int updateByPrimaryKeyWithBLOBs(JobRecord record);

    int updateByPrimaryKey(JobRecord record);
}
package com.hualala.qa.k8s.op.dao.common;

import com.hualala.qa.mockserver.model.gen.pojo.TblMappingJob;

import java.util.List;

/**
 * @author: yefei
 * @date: 2018/10/4 22:15
 */
public interface IMappingJobDao {
    int insertMappingJob(TblMappingJob tblMappingJob);

    int deleteMappingJob(int jobID);

    List<TblMappingJob> queryTblMappingJobList(int requestID, String protocol);

    long countMappingJob(int requestID, String protocol);

    int updateMappingJob(TblMappingJob tblMappingJob);
}

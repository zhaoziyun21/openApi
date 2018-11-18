package com.hualala.qa.k8s.op.dao.common;

import com.hualala.qa.mockserver.model.gen.pojo.TblMappingTask;

import java.util.List;

/**
 * @author: yefei
 * @date: 2018/10/4 22:16
 */
public interface IMappingTaskDao {
    int insertMappingTask(TblMappingTask tblMappingTask);

    int deleteMappingTask(int taskID);

    int updateMappingTask(TblMappingTask tblMappingTask);

    List<TblMappingTask> queryMappingTaskList(int jobID);

    long countMappingTask(int jobID);
}

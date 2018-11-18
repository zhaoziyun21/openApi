package com.hualala.qa.k8s.op.dao.common;

import com.hualala.qa.mockserver.model.gen.pojo.TblSystemConfig;

import java.util.List;

/**
 * @author: yefei
 * @date: 2018/10/4 22:14
 */
public interface ISystemConfigDao {
    int insertSystemConfig(TblSystemConfig tblSystemConfig);

    List<TblSystemConfig> queryTblSystemConfigList(int configType);

    long countTblSystemConfig(int configType);

    int deleteSystemConfig(int configID);

    int updateSystemConfig(TblSystemConfig tblSystemConfig);
}

package com.hualala.qa.k8s.op.model.gen.dao;

import com.hualala.qa.k8s.op.model.gen.pojo.TblPreServiceStatus;
import com.hualala.qa.k8s.op.model.gen.pojo.TblPreServiceStatusExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TblPreServiceStatusMapper {
    List<TblPreServiceStatus> queryAllService(TblPreServiceStatusExample example);

    List<TblPreServiceStatus> queryApmService(TblPreServiceStatusExample example);

    List<TblPreServiceStatus> queryK8sService(TblPreServiceStatusExample example);


}
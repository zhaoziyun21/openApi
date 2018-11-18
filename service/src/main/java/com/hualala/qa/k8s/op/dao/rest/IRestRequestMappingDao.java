package com.hualala.qa.k8s.op.dao.rest;

import com.hualala.qa.mockserver.model.gen.pojo.TblRestRequestMapping;

import java.util.List;

/**
 * @author: yefei
 * @date: 2018/10/4 22:06
 */
public interface IRestRequestMappingDao {
    int insertRestRequestMapping(TblRestRequestMapping tblRestRequestMapping);

    int deleteRestRequestMaster(int requestID);

    int updateRestRequestMapping(TblRestRequestMapping tblRestRequestMapping);

    List<TblRestRequestMapping> queryRestRequestMappingList(int groupID);

    long countRestRequestMapping(int groupID);

    int updateGroupCode(int groupID, String groupCode);

    TblRestRequestMapping getMapping(int requestID);
}

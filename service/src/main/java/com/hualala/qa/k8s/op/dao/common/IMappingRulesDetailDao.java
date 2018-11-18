package com.hualala.qa.k8s.op.dao.common;

import com.hualala.qa.mockserver.model.gen.pojo.TblMappingRulesDetail;

import java.util.List;

/**
 * @author: yefei
 * @date: 2018/10/4 22:08
 */
public interface IMappingRulesDetailDao {
    int insertMappingRulesDetail(TblMappingRulesDetail tblMappingRulesDetail);

    int deleteMappingRulesDetail(int rulesDetailID);

    List<TblMappingRulesDetail> queryMappingRulesDetail(int requestID, String protocol);

    long countMappingRulesDetail(int requestID, String protocol);

    int updateMappingRulesDetail(TblMappingRulesDetail tblMappingRulesDetail);
}

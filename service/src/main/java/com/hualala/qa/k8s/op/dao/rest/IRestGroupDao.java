package com.hualala.qa.k8s.op.dao.rest;

import com.hualala.qa.mockserver.model.gen.pojo.TblRestRequestGroup;

import java.util.List;

/**
 * @author: yefei
 * @date: 2018/10/4 22:03
 */
public interface IRestGroupDao {
    int insertRestRequestGroup(TblRestRequestGroup tblRestRequestGroup);

    int deleteRestRequestGroup(int groupID);

    int updateRestRequestGroup(TblRestRequestGroup tblRestRequestGroup);

    List<TblRestRequestGroup> queryRestRequestGroupList();

    long countRestRequestGroup();

    List<TblRestRequestGroup> queryRestGroupByCode(String groupCode);

    long countRestGroupByCode(String groupCode);

    TblRestRequestGroup getGroup(int groupID);
}

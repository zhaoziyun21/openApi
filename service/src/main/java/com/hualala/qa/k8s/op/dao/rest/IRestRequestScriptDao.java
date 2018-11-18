package com.hualala.qa.k8s.op.dao.rest;

import com.hualala.qa.mockserver.model.gen.pojo.TblRestRequestScript;

import java.util.List;

/**
 * @author: yefei
 * @date: 2018/10/4 22:11
 */
public interface IRestRequestScriptDao {
    int insertRestScript(TblRestRequestScript tblRestRequestScript);

    int deleteRestScript(int scriptID);

    int updateRestScript(TblRestRequestScript tblRestRequestScript);

    List<TblRestRequestScript> queryScriptList(int groupID, String path);

    long countRestScript(int groupID, String path);

    int updateGroupCode(int groupID, String groupCode);

    int updatePath(int groupID, String newPath, String orgPath);

    TblRestRequestScript getScript(int scriptID);
}

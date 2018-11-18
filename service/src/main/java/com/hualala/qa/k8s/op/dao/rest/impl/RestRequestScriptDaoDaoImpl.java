package com.hualala.qa.k8s.op.dao.rest.impl;

import com.hualala.qa.mockserver.dao.rest.IRestRequestScriptDao;
import com.hualala.qa.mockserver.model.gen.dao.TblRestRequestScriptMapper;
import com.hualala.qa.mockserver.model.gen.pojo.TblRestRequestScript;
import com.hualala.qa.mockserver.model.gen.pojo.TblRestRequestScriptExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: yefei
 * @date: 2018/10/4 22:11
 */
@Service
public class RestRequestScriptDaoDaoImpl implements IRestRequestScriptDao {

    @Autowired
    private TblRestRequestScriptMapper tblRestRequestScriptMapper;


    @Override
    public int insertRestScript(TblRestRequestScript tblRestRequestScript){
        return tblRestRequestScriptMapper.insert(tblRestRequestScript);
    }

    @Override
    public int deleteRestScript(int scriptID){
        return tblRestRequestScriptMapper.deleteByPrimaryKey(scriptID);
    }

    @Override
    public int updateRestScript(TblRestRequestScript tblRestRequestScript){
        return tblRestRequestScriptMapper.updateByPrimaryKeyWithBLOBs(tblRestRequestScript);
    }

    @Override
    public List<TblRestRequestScript> queryScriptList(int groupID, String path){
        TblRestRequestScriptExample example = buildExample(groupID, path);
        return tblRestRequestScriptMapper.selectByExampleWithBLOBs(example);
    }

    @Override
    public long countRestScript(int groupID, String path){
        TblRestRequestScriptExample example = buildExample(groupID, path);
        return tblRestRequestScriptMapper.countByExample(example);
    }

    private TblRestRequestScriptExample buildExample(int groupID, String path){
        TblRestRequestScriptExample example = new TblRestRequestScriptExample();
        TblRestRequestScriptExample.Criteria criteria = example.createCriteria();
        criteria.andGroupIDEqualTo(groupID).andPathEqualTo(path);

        example.setOrderByClause("sortIndex asc, updateTime desc");
        return example;
    }


    @Override
    public int updateGroupCode(int groupID, String groupCode){
        TblRestRequestScript tblRestRequestScript = new TblRestRequestScript();
        tblRestRequestScript.setGroupCode(groupCode);

        TblRestRequestScriptExample example = new TblRestRequestScriptExample();
        TblRestRequestScriptExample.Criteria criteria = example.createCriteria();
        criteria.andGroupIDEqualTo(groupID);

        return tblRestRequestScriptMapper.updateByExampleSelective(tblRestRequestScript, example);
    }

    @Override
    public int updatePath(int groupID, String newPath, String orgPath){
        TblRestRequestScript tblRestRequestScript = new TblRestRequestScript();
        tblRestRequestScript.setPath(newPath);

        TblRestRequestScriptExample example = new TblRestRequestScriptExample();
        TblRestRequestScriptExample.Criteria criteria = example.createCriteria();
        criteria.andGroupIDEqualTo(groupID).andPathEqualTo(orgPath);

        return tblRestRequestScriptMapper.updateByExampleSelective(tblRestRequestScript, example);
    }

    @Override
    public TblRestRequestScript getScript(int scriptID){
        return tblRestRequestScriptMapper.selectByPrimaryKey(scriptID);
    }

}

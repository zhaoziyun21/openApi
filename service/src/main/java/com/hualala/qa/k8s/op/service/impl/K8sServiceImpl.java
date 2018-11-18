package com.hualala.qa.k8s.op.service.impl;

import com.hualala.qa.k8s.op.cmd.K8sCmd;
import com.hualala.qa.k8s.op.dao.IProjectDao;
import com.hualala.qa.k8s.op.model.gen.pojo.TblPreServiceStatus;
import com.hualala.qa.k8s.op.model.gen.pojo.TblPreServiceStatusExample;
import com.hualala.qa.k8s.op.service.IK8sService;
import com.hualala.qa.k8s.op.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author: yefei
 * @date: 2018/11/18 17:35
 */
@Service
public class K8sServiceImpl implements IK8sService{

    @Autowired
    private K8sCmd k8sCmd;

    @Autowired
    private IProjectService projectService;

    @Autowired
    private IProjectDao projectDao;

    @Override
    public void syncK8sStatus(){
        List<TblPreServiceStatus> list = queryNeedDeployService();
        for (TblPreServiceStatus item : list){
            boolean isRunning = k8sCmd.getK8sIsRunning(item.getJenkinsJobName());
            item.setK8sStatus(isRunning);
            item.setApmuUpdateTime(new Date());
            projectDao.updatePreServiceStatus(item);
        }
    }

    @Override
    public String getK8sStatus(String jenkinsJobName){

        return k8sCmd.getK8sStatus(jenkinsJobName);
    }


    @Override
    public void reloadK8s(String jenkinsJobName){

        k8sCmd.k8sReload(jenkinsJobName);
    }


    @Override
    public void reloadK8s(){
        List<TblPreServiceStatus> list = projectService.queryApmFailService();
        list.forEach(item->{
            k8sCmd.k8sReload(item.getJenkinsJobName());
        });

    }




    private List<TblPreServiceStatus> queryNeedDeployService(){
        TblPreServiceStatusExample example = new TblPreServiceStatusExample();
        example.createCriteria().andNeedDeployEqualTo(true);
        return projectDao.queryPreServiceStatusList();
    }



}

package com.hualala.qa.k8s.op.service.impl;

import com.hualala.qa.k8s.op.cmd.JenkinsCmd;
import com.hualala.qa.k8s.op.cmd.K8sCmd;
import com.hualala.qa.k8s.op.dao.IProjectDao;
import com.hualala.qa.k8s.op.model.gen.pojo.TblPreServiceStatus;
import com.hualala.qa.k8s.op.model.gen.pojo.TblPreServiceStatusExample;
import com.hualala.qa.k8s.op.service.IJenkinsService;
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
public class JenkinsServiceImpl implements IJenkinsService{

    @Autowired
    private JenkinsCmd jenkinsCmd;

    @Autowired
    private IProjectService projectService;

    @Autowired
    private IProjectDao projectDao;

    @Override
    public void syncJenkinsStatus(){
        List<TblPreServiceStatus> list = projectService.queryAllService();
        for (TblPreServiceStatus item : list){
            boolean isRunning = jenkinsCmd.jenkinsIsRunning(item.getJenkinsJobName());
            item.setJenkinsStatus(isRunning);
            item.setJenkinsUpdateTime(new Date());
            projectDao.updatePreServiceStatus(item);
        }
    }

    @Override
    public String getJenkinsStatus(String jenkinsJobName){
        JenkinsCmd.JenkinsStatus jenkinsStatus = jenkinsCmd.getJenkinsStatus(jenkinsJobName);

        TblPreServiceStatus service = projectService.getService(jenkinsJobName);
        if (jenkinsStatus != null){
            service.setJenkinsStatus(jenkinsStatus.isRunning());
            service.setJenkinsUpdateTime(new Date());
            projectDao.updatePreServiceStatus(service);
        }
        return jenkinsStatus.getStatus();
    }


    @Override
    public void buildJenkins(String jenkinsJobName){
        jenkinsCmd.buildJenkins(jenkinsJobName);
    }


    @Override
    public void buildJenkins(){
        List<TblPreServiceStatus> list = projectService.queryNeedDeployService();
        list.forEach(item->{
            jenkinsCmd.buildJenkins(item.getJenkinsJobName());
        });

    }



    @Override
    public void rebuildAllJenkins(){

        List<TblPreServiceStatus> list = queryNeedDeployService();
        for (TblPreServiceStatus item : list){
            jenkinsCmd.buildJenkins(item.getJenkinsJobName());
        }
    }



    private List<TblPreServiceStatus> queryNeedDeployService(){
        TblPreServiceStatusExample example = new TblPreServiceStatusExample();
        example.createCriteria().andNeedDeployEqualTo(true);
        return projectDao.queryService(example);
    }



}

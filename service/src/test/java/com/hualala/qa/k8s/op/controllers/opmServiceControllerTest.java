package com.hualala.qa.k8s.op.controllers;

import com.hualala.qa.k8s.op.model.gen.pojo.Agent;
import com.hualala.qa.k8s.op.service.IAgentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author : Wangruiyan
 * @Date : 2018/11/19
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class opmServiceControllerTest{

    @Autowired
    private IAgentService agentService;



    @Test
    public void queryAllServiceStatus() {
        List<Agent> list = agentService.queryAllService();


    }
}
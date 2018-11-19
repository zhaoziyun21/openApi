package com.hualala.qa.k8s.op.controllers;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hualala.qa.k8s.op.config.ResponseAdapter;
import com.hualala.qa.k8s.op.dao.IAgentDao;
import com.hualala.qa.k8s.op.exception.ServerBaseException;
import com.hualala.qa.k8s.op.model.gen.pojo.Agent;
import com.hualala.qa.k8s.op.model.gen.pojo.TblPreServiceStatus;
import com.hualala.qa.k8s.op.service.IAgentService;
import com.hualala.qa.k8s.op.service.IK8sService;
import com.hualala.qa.k8s.op.service.IProjectService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/**
 * @author: yefei
 * @date: 2018/10/7 09:47
 */
@Controller
@RequestMapping("/project/opm")
@Slf4j
public class opmServiceController extends BaseController {

    @Autowired
    private ResponseAdapter responseAdapter;

    @Autowired
    private IAgentService agentService;

    @Autowired
    private ObjectMapper jacksonFormater;

    @RequestMapping(value = "/list.html", method = RequestMethod.GET)
    public ModelAndView queryAllServiceStatus(@RequestParam(value = "method", defaultValue = "queryAllServiceStatusList") String method) throws IOException {

        ModelAndView view = new ModelAndView("project/list");

        HashMap taskTypeAndConfigList = new HashMap();

        view.addObject("method", method);
        view.addObject("taskTypeAndConfigList", jacksonFormater.writeValueAsString(taskTypeAndConfigList));

        this.buildCategory(view, "system");

        return view;

    }

    @RequestMapping("/.ajax")
    @ResponseBody
    public Object queryAllServiceStatusList(HttpServletRequest request, @RequestBody JSONObject params){
        try {

            List<Agent> list = agentService.queryAllService();
            HashMap resp = new HashMap();
            resp.put("list", list);
            resp.put("total", list.size());

            return responseAdapter.success(resp);

        }catch (ServerBaseException e){
            log.error(ExceptionUtils.getStackTrace(e));
            return responseAdapter.failure(e);

        }catch (Exception e){
            log.error(ExceptionUtils.getStackTrace(e));
            return responseAdapter.failure(ExceptionUtils.getStackTrace(e));
        }

    }





}

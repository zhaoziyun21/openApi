package com.hualala.qa.k8s.op.controllers;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hualala.qa.k8s.op.config.BeanScanner;
import com.hualala.qa.k8s.op.config.ResponseAdapter;
import com.hualala.qa.k8s.op.exception.ServerBaseException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author: yefei
 * @date: 2018/10/7 09:47
 */
@Controller
@RequestMapping("/mock_server/mapping/task")
@Slf4j
public class MappingTaskController {

    @Autowired
    private ResponseAdapter responseAdapter;


    @Autowired
    private ObjectMapper jacksonFormater;

    @RequestMapping(value = "/list.html", method = RequestMethod.GET)
    public ModelAndView groupInfo(@RequestParam(value = "jobID", defaultValue = "0" ) int jobID ) throws IOException {

        ModelAndView view = new ModelAndView("common/task_list");

        view.addObject("jobID", jobID);

        HashMap taskTypeAndConfigList = new HashMap();


        view.addObject("taskTypeAndConfigList", jacksonFormater.writeValueAsString(taskTypeAndConfigList));

        return view;

    }

    @RequestMapping("/save.ajax")
    @ResponseBody
    public Object save(HttpServletRequest request, @RequestBody JSONObject params){
        try {
            // TODO

        }catch (ServerBaseException e){
            log.error(ExceptionUtils.getStackTrace(e));
            return responseAdapter.failure(e);

        }catch (Exception e){
            log.error(ExceptionUtils.getStackTrace(e));
            return responseAdapter.failure(ExceptionUtils.getStackTrace(e));
        }

        return null;
    }



}

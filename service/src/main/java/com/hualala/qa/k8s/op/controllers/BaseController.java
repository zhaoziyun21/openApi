package com.hualala.qa.k8s.op.controllers;

import com.alibaba.fastjson.JSONArray;
import com.hualala.qa.k8s.op.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

/**
 * @author: yefei
 * @date: 2018/10/29 14:15
 */
public class BaseController {

    @Autowired
    protected ICategoryService categoryService;

    public void buildCategory(ModelAndView modelAndView, String nav) throws IOException {
        JSONArray category = this.categoryService.getCategory(nav);
        modelAndView.addObject("category", category);

    }
}

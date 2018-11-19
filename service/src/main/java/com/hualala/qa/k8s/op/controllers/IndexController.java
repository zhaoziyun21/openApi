package com.hualala.qa.k8s.op.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

/**
 * @author: yefei
 * @date: 2018/11/19 00:08
 */
@Controller
public class IndexController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView mappingList() throws IOException {

        ModelAndView view = new ModelAndView("project/list.html");
        return view;

    }
}

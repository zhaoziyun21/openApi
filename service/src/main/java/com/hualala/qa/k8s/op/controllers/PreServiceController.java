package com.hualala.qa.k8s.op.controllers;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hualala.qa.k8s.op.config.BeanScanner;
import com.hualala.qa.k8s.op.config.ResponseAdapter;
import com.hualala.qa.k8s.op.exception.ServerBaseException;
import com.hualala.qa.k8s.op.exception.UnknownDataException;
import com.hualala.qa.k8s.op.model.gen.pojo.TblPreServiceStatus;
import com.hualala.qa.k8s.op.service.IAgentService;
import com.hualala.qa.k8s.op.service.IJenkinsService;
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
@RequestMapping("/project")
@Slf4j
public class PreServiceController extends BaseController {

    @Autowired
    private ResponseAdapter responseAdapter;

    @Autowired
    private IProjectService projectService;

    @Autowired
    private IK8sService k8sService;

    @Autowired
    private IAgentService agentService;

    @Autowired
    private ObjectMapper jacksonFormater;

    @Autowired
    private IJenkinsService jenkinsService;

    @Autowired
    private BeanScanner beanScanner;

    private final String nav = "project";

    @RequestMapping(value = "/list.html", method = RequestMethod.GET)
    public ModelAndView queryAllServiceStatus(@RequestParam(value = "method", defaultValue = "queryAllServiceStatusList") String method) throws IOException {

        ModelAndView view = new ModelAndView("project/list");

        HashMap taskTypeAndConfigList = new HashMap();

        view.addObject("method", method);
        view.addObject("taskTypeAndConfigList", jacksonFormater.writeValueAsString(taskTypeAndConfigList));

        this.buildCategory(view, "project");

        return view;

    }

    @RequestMapping("/save.ajax")
    @ResponseBody
    public Object save(@RequestBody JSONObject params){
        try {

            if (projectService.save(params) > 0){
                return responseAdapter.success();
            }else{
                return responseAdapter.failure("保存失败");
            }

        }catch (ServerBaseException e){
            log.error(ExceptionUtils.getStackTrace(e));
            return responseAdapter.failure(e);

        }catch (Exception e){
            log.error(ExceptionUtils.getStackTrace(e));
            return responseAdapter.failure(ExceptionUtils.getStackTrace(e));
        }

    }

    @RequestMapping("/queryAllServiceStatusList.ajax")
    @ResponseBody
    public Object queryAllServiceStatusList() {
        try {

            List<TblPreServiceStatus> list = projectService.queryAllService();
            HashMap resp = new HashMap();
            resp.put("list", list);
            resp.put("total", list.size());

            return responseAdapter.success(resp);

        } catch (ServerBaseException e) {
            log.error(ExceptionUtils.getStackTrace(e));
            return responseAdapter.failure(e);

        } catch (Exception e) {
            log.error(ExceptionUtils.getStackTrace(e));
            return responseAdapter.failure(ExceptionUtils.getStackTrace(e));
        }

    }


    @RequestMapping("/queryNeedDeployServiceList.ajax")
    @ResponseBody
    public Object queryNeedDeployServiceList() {
        try {

            List<TblPreServiceStatus> list = projectService.queryNeedDeployService();
            HashMap resp = new HashMap();
            resp.put("list", list);
            resp.put("total", list.size());

            return responseAdapter.success(resp);

        } catch (ServerBaseException e) {
            log.error(ExceptionUtils.getStackTrace(e));
            return responseAdapter.failure(e);

        } catch (Exception e) {
            log.error(ExceptionUtils.getStackTrace(e));
            return responseAdapter.failure(ExceptionUtils.getStackTrace(e));
        }

    }

    @RequestMapping("/queryUnNeedDeployServiceList.ajax")
    @ResponseBody
    public Object queryUnNeedDeployServiceList() {
        try {

            List<TblPreServiceStatus> list = projectService.queryUnneedDeployService();
            HashMap resp = new HashMap();
            resp.put("list", list);
            resp.put("total", list.size());

            return responseAdapter.success(resp);

        } catch (ServerBaseException e) {
            log.error(ExceptionUtils.getStackTrace(e));
            return responseAdapter.failure(e);

        } catch (Exception e) {
            log.error(ExceptionUtils.getStackTrace(e));
            return responseAdapter.failure(ExceptionUtils.getStackTrace(e));
        }

    }


    @RequestMapping("/queryApmSuccessServiceList.ajax")
    @ResponseBody
    public Object queryApmSuccessServiceList() {
        try {

            List<TblPreServiceStatus> list = projectService.queryApmSuccessService();
            HashMap resp = new HashMap();
            resp.put("list", list);
            resp.put("total", list.size());

            return responseAdapter.success(resp);

        } catch (ServerBaseException e) {
            log.error(ExceptionUtils.getStackTrace(e));
            return responseAdapter.failure(e);

        } catch (Exception e) {
            log.error(ExceptionUtils.getStackTrace(e));
            return responseAdapter.failure(ExceptionUtils.getStackTrace(e));
        }

    }


    @RequestMapping("/queryOPFailServiceList.ajax")
    @ResponseBody
    public Object queryOPFailServiceList() {
        try {

            List<TblPreServiceStatus> list = projectService.queryApmFailService();
            HashMap resp = new HashMap();
            resp.put("list", list);
            resp.put("total", list.size());

            return responseAdapter.success(resp);

        } catch (ServerBaseException e) {
            log.error(ExceptionUtils.getStackTrace(e));
            return responseAdapter.failure(e);

        } catch (Exception e) {
            log.error(ExceptionUtils.getStackTrace(e));
            return responseAdapter.failure(ExceptionUtils.getStackTrace(e));
        }

    }


    @RequestMapping("/queryK8sSuccessServiceList.ajax")
    @ResponseBody
    public Object queryK8sSuccessServiceList(HttpServletRequest request, @RequestBody JSONObject params) {
        try {

            List<TblPreServiceStatus> list = projectService.queryK8sSuccessService();
            HashMap resp = new HashMap();
            resp.put("list", list);
            resp.put("total", list.size());

            return responseAdapter.success(resp);

        } catch (ServerBaseException e) {
            log.error(ExceptionUtils.getStackTrace(e));
            return responseAdapter.failure(e);

        } catch (Exception e) {
            log.error(ExceptionUtils.getStackTrace(e));
            return responseAdapter.failure(ExceptionUtils.getStackTrace(e));
        }

    }


    @RequestMapping("/queryK8sFailServiceList.ajax")
    @ResponseBody
    public Object queryK8sFailServiceList(){
//        public Object queryK8sFailServiceList(HttpServletRequest request, @RequestBody JSONObject params) {
        try {

            List<TblPreServiceStatus> list = projectService.queryK8sFailService();
            HashMap resp = new HashMap();
            resp.put("list", list);
            resp.put("total", list.size());

            return responseAdapter.success(resp);

        } catch (ServerBaseException e) {
            log.error(ExceptionUtils.getStackTrace(e));
            return responseAdapter.failure(e);

        } catch (Exception e) {
            log.error(ExceptionUtils.getStackTrace(e));
            return responseAdapter.failure(ExceptionUtils.getStackTrace(e));
        }

    }



    @RequestMapping("/queryJenkinsSuccessServiceList.ajax")
    @ResponseBody
    public Object queryJenkinsSuccessServiceList(){
        try {

            List<TblPreServiceStatus> list = projectService.queryJenkinsSuccessService();
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



    @RequestMapping("/queryJenkinsFailServiceList.ajax")
    @ResponseBody
    public Object queryJenkinsFailServiceList(HttpServletRequest request, @RequestBody JSONObject params){
        try {

            List<TblPreServiceStatus> list = projectService.queryJenkinsFailService();
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




    @RequestMapping("/syncK8sStatus.ajax")
    @ResponseBody
    public Object syncK8sStatus() {
        try {

            new Thread(new Runnable() {
                @Override
                public void run() {
                    k8sService.syncK8sStatus();
                }
            }).start();
            return responseAdapter.success();

        } catch (ServerBaseException e) {
            log.error(ExceptionUtils.getStackTrace(e));
            return responseAdapter.failure(e);

        } catch (Exception e) {
            log.error(ExceptionUtils.getStackTrace(e));
            return responseAdapter.failure(ExceptionUtils.getStackTrace(e));
        }

    }


    @RequestMapping("/getK8sStatus.ajax")
    @ResponseBody
    public Object getK8sStatus(@RequestBody JSONObject param) {
        try {
            String jenkinsJobName = param.containsKey("jenkinsJobName") ? param.getString("jenkinsJobName") : "";
            String k8sStatus = k8sService.getK8sStatus(jenkinsJobName);

            return responseAdapter.success(k8sStatus);

        } catch (ServerBaseException e) {
            log.error(ExceptionUtils.getStackTrace(e));
            return responseAdapter.failure(e);

        } catch (Exception e) {
            log.error(ExceptionUtils.getStackTrace(e));
            return responseAdapter.failure(ExceptionUtils.getStackTrace(e));
        }
    }


    @RequestMapping("/reloadK8s.ajax")
    @ResponseBody
    public Object reloadK8sService(@RequestBody JSONObject param) {
        try {
            String jenkinsJobName = param.containsKey("jenkinsJobName") ? param.getString("jenkinsJobName") : "";

            if (StringUtils.isBlank(jenkinsJobName)) {
                k8sService.reloadK8s();
            } else {
                k8sService.reloadK8s(jenkinsJobName);
            }

            return responseAdapter.success();

        } catch (ServerBaseException e) {
            log.error(ExceptionUtils.getStackTrace(e));
            return responseAdapter.failure(e);

        } catch (Exception e) {
            log.error(ExceptionUtils.getStackTrace(e));
            return responseAdapter.failure(ExceptionUtils.getStackTrace(e));
        }
    }


    @RequestMapping("/reloadAllK8s.ajax")
    @ResponseBody
    public Object reloadAllK8sService() {
        try {

            k8sService.reloadAllK8s();

            return responseAdapter.success();

        } catch (ServerBaseException e) {
            log.error(ExceptionUtils.getStackTrace(e));
            return responseAdapter.failure(e);

        } catch (Exception e) {
            log.error(ExceptionUtils.getStackTrace(e));
            return responseAdapter.failure(ExceptionUtils.getStackTrace(e));
        }
    }

    @RequestMapping("/syncApmStatus.ajax")
    @ResponseBody
    public Object syncApmStatus() {
        try {

            agentService.syncApnStatus();

            return responseAdapter.success();

        }catch (ServerBaseException e){
            log.error(ExceptionUtils.getStackTrace(e));
            return responseAdapter.failure(e);

        }catch (Exception e){
            log.error(ExceptionUtils.getStackTrace(e));
            return responseAdapter.failure(ExceptionUtils.getStackTrace(e));
        }
    }



    @RequestMapping("/syncJenkinsStatus.ajax")
    @ResponseBody
    public Object syncJenkinsStatus(){
        try {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    jenkinsService.syncJenkinsStatus();
                }
            }).start();



            return responseAdapter.success();

        }catch (ServerBaseException e){
            log.error(ExceptionUtils.getStackTrace(e));
            return responseAdapter.failure(e);

        }catch (Exception e){
            log.error(ExceptionUtils.getStackTrace(e));
            return responseAdapter.failure(ExceptionUtils.getStackTrace(e));
        }
    }



    @RequestMapping("/buildJenkins.ajax")
    @ResponseBody
    public Object buildJenkins(@RequestBody JSONObject params){
        try {


            if (params.containsKey("jenkinsJobName") && StringUtils.isNoneBlank(params.getString("jenkinsJobName"))){
                jenkinsService.buildJenkins(params.getString("jenkinsJobName"));
            }else{
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        jenkinsService.buildJenkins();
                    }
                }).start();

            }

            return responseAdapter.success();

        }catch (ServerBaseException e){
            log.error(ExceptionUtils.getStackTrace(e));
            return responseAdapter.failure(e);

        }catch (Exception e){
            log.error(ExceptionUtils.getStackTrace(e));
            return responseAdapter.failure(ExceptionUtils.getStackTrace(e));
        }
    }



    @RequestMapping("/getJenkinsStatus.ajax")
    @ResponseBody
    public Object getJenkinsStatus(@RequestBody JSONObject params){
        try {

            String jenkinsJobName = params.getString("jenkinsJobName");
            String jenkinsStatus = jenkinsService.getJenkinsStatus(jenkinsJobName);
            jenkinsStatus = jenkinsStatus.replaceAll("\\n", "<br>");

            return responseAdapter.success(jenkinsStatus);

        }catch (ServerBaseException e){
            log.error(ExceptionUtils.getStackTrace(e));
            return responseAdapter.failure(e);

        } catch (Exception e) {
            log.error(ExceptionUtils.getStackTrace(e));
            return responseAdapter.failure(ExceptionUtils.getStackTrace(e));
        }
    }

    @RequestMapping(value = "/edit.html", method = RequestMethod.GET)
    public ModelAndView groupInfo(@RequestParam(value = "ID", defaultValue = "0" ) int ID) throws IOException {

        ModelAndView view = new ModelAndView("project/edit");

        this.buildCategory(view, nav);

        List<BeanScanner.BeanField> fields = getFields();
        view.addObject("fields", fields);

        return view;

    }

    private List<BeanScanner.BeanField> getFields(){
        return beanScanner.getBeanFields("TblPreServiceStatus", "ID","k8sUpdateTime","apmuUpdateTime","jenkinsUpdateTime");
    }

    @RequestMapping("/delete.ajax")
    @ResponseBody
    public Object delete(HttpServletRequest request, @RequestBody JSONObject params){
        try {
            int ID = params.getInteger("ID");

            if (projectService.deleteProjectServer(ID)){
                return responseAdapter.success();
            }else{
                throw new UnknownDataException();
            }


        }catch (ServerBaseException e){
            log.error(ExceptionUtils.getStackTrace(e));
            return responseAdapter.failure(e);

        }catch (Exception e){
            log.error(ExceptionUtils.getStackTrace(e));
            return responseAdapter.failure(ExceptionUtils.getStackTrace(e));
        }

    }

}

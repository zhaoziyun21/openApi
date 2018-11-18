package com.hualala.qa.k8s.op.cmd;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: yefei
 * @date: 2018/11/18 16:16
 */
@Slf4j
@Component
public class K8sCmd {

    private File dir = new File("/Users/yefei/code/hualala/qa/k8s-op");

    public boolean getK8sIsRunning(String jenkinsJobName){

        try {

            String result = exec(String.format("kubectl get pod |egrep '^%s-\\w+-\\w+", jenkinsJobName));
            System.out.println(result);

            if ( result.matches("1/1\\sRunning")){
                return true;
            }

        } catch (Exception e) {
            log.error(ExceptionUtils.getStackTrace(e));
            return false;
        }

        return false;
    }


    public String getK8sStatus(String jenkinsJobName){

        try {

            String result = exec(String.format("kubectl get pod |egrep '^%s-\\w+-\\w+", jenkinsJobName));
            return result;

        } catch (Exception e) {
            log.error(ExceptionUtils.getStackTrace(e));
            return "";
        }
    }


    private String exec(String cmd) throws IOException, InterruptedException {

        Process process = null;
        List<String> processList = new ArrayList<String>();

        List<String> cmds = new ArrayList<String>();
        cmds.add("sh");
        cmds.add("-c");
        cmds.add(cmd);

        ProcessBuilder pb =new ProcessBuilder(cmds);
        pb.directory(dir);

        process = pb.start();

        process.waitFor();
        BufferedReader input = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line = "";
        while ((line = input.readLine()) != null) {
            processList.add(line);
        }
        input.close();
        return String.join("\n", processList);
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        String s = new K8sCmd().exec("ls -l | grep service");
        System.out.println(s);
    }

}

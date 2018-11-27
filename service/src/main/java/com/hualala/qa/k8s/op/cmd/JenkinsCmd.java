package com.hualala.qa.k8s.op.cmd;

import com.hualala.qa.k8s.op.utils.FileUtils;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author: yefei
 * @date: 2018/11/18 16:16
 */
@Slf4j
@Component
@ConfigurationProperties(prefix = "jenkins")
@Data
public class JenkinsCmd {

    private String jenkinsJarPath;
    private String jenkinsHost;

    private long lastJenkinsActionTime = 0;



    @Data
    public class JenkinsStatus {
        String status;
        boolean isRunning;

        public void setStatus(String status){
            this.status = status;
            if (status.endsWith("Finished: SUCCESS")){
                this.isRunning = true;
            }else{
                this.isRunning = false;
            }

        }
    }

    public JenkinsStatus getJenkinsStatus(String jenkinJobName){
        String jenkinsBuildConsole = this.getJenkinsBuildConsole(jenkinJobName);

        JenkinsStatus jenkinsStatus = new JenkinsStatus();
        jenkinsStatus.setStatus(jenkinsBuildConsole);

        return jenkinsStatus;
    }

    private void jenkinsLogin() throws IOException, InterruptedException {
        if (System.currentTimeMillis() - lastJenkinsActionTime > 10000){

            String cmd = String.format("java -jar %s -s %s login", jenkinsJarPath, jenkinsHost);
            log.info("jenkins login: {}", cmd);

            exec(cmd);
            lastJenkinsActionTime = System.currentTimeMillis();
        }
    }

    public void buildJenkins(String jenkinsJobName){
        try {

            jenkinsLogin();

            jenkinsJobName = jenkinsJonRename(jenkinsJobName);

            String cmd = String.format("java -jar %s -s %s build %s", jenkinsJarPath, jenkinsHost, jenkinsJobName);

            log.info("begin build jenkins: {}", cmd);

            String result = exec(cmd);

            lastJenkinsActionTime = System.currentTimeMillis();

        }catch (Exception e){
            log.error(ExceptionUtils.getStackTrace(e));
        }

        log.info("end buil jenkins version: {}", jenkinsJobName);
    }


    private String getJenkinsBuildConsole(String jenkinsJobName){
        try {

            jenkinsLogin();

            jenkinsJobName = jenkinsJonRename(jenkinsJobName);

            String cmd = String.format("java -jar %s  -s %s console %s -f -n 20", jenkinsJarPath, jenkinsHost, jenkinsJobName);

            log.info("begin check jenkins isRunning: {}", jenkinsJobName);

            String result = exec(cmd);

            lastJenkinsActionTime = System.currentTimeMillis();

            return result;

        }catch (Exception e){
            log.error(ExceptionUtils.getStackTrace(e));
        }
        return "";
    }

    public boolean jenkinsIsRunning(String jenkinsJobName){
        try {

            log.info("begin check jenkins isRunning: {}", jenkinsJobName);

            String result = getJenkinsBuildConsole(jenkinsJobName);

            if (result.endsWith("Finished: SUCCESS")){
                return true;
            }

        }catch (Exception e){
            log.error(ExceptionUtils.getStackTrace(e));
        }

        log.info("end check jenkins isRunning: {}", jenkinsJobName);

        return false;
    }


    public String getJenkinsVersion(String jenkinsJobName){
        String version = "";
        try {

            log.info("begin get jenkins version: {}", jenkinsJobName);

            String result = getJenkinsBuildConsole(jenkinsJobName);

            if (result.endsWith("Finished: SUCCESS")){
                // 创建 Pattern 对象
                Pattern r = Pattern.compile("(\\w{6}): digest: sha");

                // 现在创建 matcher 对象
                Matcher m = r.matcher(result);
                if (m.find( )) {

                    version = m.group(1);
                }
            }

        }catch (Exception e){
            log.error(ExceptionUtils.getStackTrace(e));
        }

        log.info("end get jenkins version: {}", version);

        return version;
    }




    private String exec(String cmd) throws IOException, InterruptedException {

        Process process = null;
        List<String> processList = new ArrayList<String>();

        List<String> cmds = new ArrayList<String>();
        cmds.add("sh");
        cmds.add("-c");
        cmds.add(cmd);

        ProcessBuilder pb =new ProcessBuilder(cmds);

        process = pb.start();

        process.waitFor();
        BufferedReader input = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line = "";
        while ((line = input.readLine()) != null) {
            processList.add(line);
        }
        input.close();
        log.debug("执行命令完成：{}", cmd);
        log.debug(String.join("\n", processList));
        return String.join("\n", processList);
    }


    private String jenkinsJonRename(String jenkinsJobName){
        return jenkinsJobName.startsWith("pre-") ? jenkinsJobName : "pre-" +jenkinsJobName;
    }

}

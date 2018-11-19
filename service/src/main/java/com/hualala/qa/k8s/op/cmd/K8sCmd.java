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
@ConfigurationProperties(prefix = "k8s")
@Data
public class K8sCmd {

    private String jenkinsJarPath;
    private String jenkinsHost;

//    final private String yamlDirPath = "/home/pre/";
    private String yamlDirPath;

    private long lastJenkinsActionTime = 0;

    public boolean getK8sIsRunning(String jenkinsJobName){
        String result;
        try {

            result  = exec(String.format("kubectl get pod |egrep '^%s-\\w+-\\w+'", jenkinsJobName));
            log.info("查询k8s是否正常：{} -> {}", jenkinsJobName, result);
//
//            result = "111\n inventory-amount-service-6b9b64b767-ddzqc        1/1       Running             0          2d";

            String pattern = ".*?1/1\\s+Running.*?";
            Pattern p = Pattern.compile(pattern, Pattern.UNIX_LINES);
            Matcher matcher = p.matcher(result);

            if ( matcher.find()){
                log.info("{} k8s 运行正常", jenkinsJobName);
                return true;
            }

        } catch (Exception e) {
            log.error(ExceptionUtils.getStackTrace(e));
            return false;
        }
        log.info("{} k8s 运行异常：{}", jenkinsJobName, result);
        return false;
    }

    @Data
    public class K8sStatus{
        String status;
        boolean isRunning;

        public void setStatus(String status){
            this.status = status;
            String pattern = ".*?1/1\\s+Running.*?";
            Pattern p = Pattern.compile(pattern, Pattern.UNIX_LINES);
            Matcher matcher = p.matcher(status);

            if ( matcher.find()){
                this.isRunning = true;
            }else{
                this.isRunning = false;
            }

        }
    }


    public K8sStatus getK8sStatus(String jenkinsJobName){
        try {

            String result = exec(String.format("kubectl get pod |egrep '^%s-\\w+-\\w+'", jenkinsJobName));
            K8sStatus k8sStatus = new K8sStatus();
            k8sStatus.setStatus(result);
            return k8sStatus;

        } catch (Exception e) {
            log.error(ExceptionUtils.getStackTrace(e));
            return null;
        }
    }


    public boolean k8sReload(String jenkinsJobName){
        jenkinsJobName = jenkinsJonRename(jenkinsJobName);
        String version = getJenkinsVersion(jenkinsJobName);
        if(writeYaml(jenkinsJobName, version)){
            System.out.println(111);
            try {
                String s = exec(String.format("kubectl delete -f %s", jenkinsJobName + ".yaml"));
                log.debug(s);

                String s1 = exec(String.format("kubectl create -f %s", jenkinsJobName + ".yaml"));
                log.debug(s1);

            } catch (Exception e) {
                e.printStackTrace();
            }

        }else{
            System.out.println(222);
        }


        return true;
    }


    private boolean writeYaml(String jenkinsJobName, String version){
        if (StringUtils.isBlank(jenkinsJobName) || StringUtils.isBlank(version)){
            return true;
        }

        jenkinsJobName = jenkinsJonRename(jenkinsJobName);

        try {
            String yamFile = yamlDirPath + jenkinsJobName + ".yaml";
            File f = new File(yamFile);

            String content = FileUtils.getContent(new FileInputStream(f), "utf-8");
            String[] lines = content.split("\n");
            if (lines.length == 35){
                //行数正确的格式
                String imageLine = lines[16];
                log.info("{} yaml文件行数正确", jenkinsJobName);

                if (imageLine.matches(".*?" + jenkinsJobName + ":\\w{6}\\s*$")){
                    log.info("{} yaml文件镜像行格式正确", jenkinsJobName);

                    if(imageLine.matches(".*?" + jenkinsJobName + ":" + version + "s*$")){
                        //版本没有改变
                        log.info("jenkins版本没有变更");
                        return true;
                    }else{
                        //版本已经变更
                        log.info("jenkins版本变更，新版本号：", version);
                        imageLine = imageLine.replaceAll(jenkinsJobName + ":\\w{6}(\\s*)$", jenkinsJobName + ":" + version + "$1");
                        lines[16] = imageLine;
                    }


                }else if (imageLine.matches(".*?" + jenkinsJobName + "\\s*$")){
                    log.info("yaml文件没有写版本号，新添加：{}", version);
                    imageLine = imageLine.replaceAll(jenkinsJobName + "(\\s*)$", jenkinsJobName + ":" + version + "$1");
                    lines[16] = imageLine;
                }

                FileUtils.writeFileData(yamFile, String.join("\n", lines).getBytes());

            }else{
                log.info("{} yaml文件格式不正确", jenkinsJobName);
                return false;
            }


        } catch (FileNotFoundException e) {
            log.error(ExceptionUtils.getStackTrace(e));
            return false;
        }

        return true;
    }

    private void jenkinsLogin() throws IOException, InterruptedException {
        String cmd = String.format("java -jar %s -s %s login", jenkinsJarPath, jenkinsHost);
        log.info("jenkins login: {}", cmd);

        exec(cmd);
        lastJenkinsActionTime = System.currentTimeMillis();

    }

    private String getJenkinsVersion(String jenkinsJobName){
        String version = "";
        try {
            if (System.currentTimeMillis() - lastJenkinsActionTime > 10000){
                jenkinsLogin();
            }

            jenkinsJobName = jenkinsJonRename(jenkinsJobName);

            String cmd = String.format("java -jar %s  -s %s console %s -f -n 20", jenkinsJarPath, jenkinsHost, jenkinsJobName);

            log.info("begin get jenkins version: {}", cmd);

            String result = exec(cmd);

            lastJenkinsActionTime = System.currentTimeMillis();


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
        File dir = new File(yamlDirPath);
        pb.directory(dir);

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

    public static void main(String[] args) throws IOException, InterruptedException {
        String jenkinsJobName = "order-service";
        K8sCmd k8sCmd = new K8sCmd();
//        String s = k8sCmd.exec("ls -l | grep service");
//        System.out.println(s);
//
//        k8sCmd.k8sReload(jenkinsJobName);

        k8sCmd.getK8sIsRunning(jenkinsJobName);
//        String jenkinsVersion = k8sCmd.getJenkinsVersion("order-service");
    }


    private String jenkinsJonRename(String jenkinsJobName){
        return jenkinsJobName.startsWith("pre-") ? jenkinsJobName : "pre-" +jenkinsJobName;
    }

}

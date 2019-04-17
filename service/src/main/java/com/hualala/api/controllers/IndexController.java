package com.hualala.api.controllers;


import com.hualala.api.config.ResponseAdapter;
import com.hualala.api.config.db.DatabaseType;
import com.hualala.api.model.gen.pojo.TblRoom;
import com.hualala.api.service.IRoomService;
import com.hualala.api.config.db.DatabaseContextHolder;
import com.tls.tls_sigature.tls_sigature;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping("/project")
@ConfigurationProperties(prefix = "tencent")
@Data
@Slf4j
public class IndexController{
    @Autowired
    private ResponseAdapter responseAdapter;
    @Autowired
    private IRoomService roomService;

    private String pubstr;
    private String privstr;
    private int skdAppid;
    private int accountType;

    /**
     * 生成token
     * @param userID
     * @return
     * @throws IOException
     */
    @RequestMapping("/genSign.ajax")
    @ResponseBody
    public Object genSign(@RequestParam(name = "userID") String userID)  {
        try {
            // generate signature
            tls_sigature.GenTLSSignatureResult result = tls_sigature.GenTLSSignatureEx(skdAppid, userID, privstr);
            // check signature
            tls_sigature.CheckTLSSignatureResult checkResult = tls_sigature.CheckTLSSignatureEx(result.urlSig, skdAppid, userID, pubstr);
            Map<String,Object> resultMap = new HashMap<>();
            resultMap.put("token",result.urlSig);
            resultMap.put("skdAppid",skdAppid);
            resultMap.put("accountType",accountType);
            return responseAdapter.success(resultMap);
        } catch (Exception e) {
            return responseAdapter.failure(e.getMessage());
        }
    }
    /**
     * 生成token jsonp实现
     * @param userID
     * @return
     * @throws IOException
     */
    @RequestMapping("/genSignUpgrade.ajax")
    @ResponseBody
    public Object genSignForJsonp(@RequestParam(name = "userID") String userID,String callback)  {
        try {
            // generate signature
            tls_sigature.GenTLSSignatureResult result = tls_sigature.GenTLSSignatureEx(skdAppid, userID, privstr);
            // check signature
            tls_sigature.CheckTLSSignatureResult checkResult = tls_sigature.CheckTLSSignatureEx(result.urlSig, skdAppid, userID, pubstr);
            Map<String,Object> resultMap = new HashMap<>();
            resultMap.put("token",result.urlSig);
            resultMap.put("skdAppid",skdAppid);
            resultMap.put("accountType",accountType);
            return callback+"("+responseAdapter.success(resultMap)+")";
        } catch (Exception e) {
            return responseAdapter.failure(e.getMessage());
        }
    }
     /**
      * roomID生成
     * @param userID
     * @return
     * @throws IOException
     */
    @RequestMapping("/genRoomID.ajax")
    @ResponseBody
    public Object genRoomID(@RequestParam(name = "userID") String userID,@RequestParam(name = "meetingID") String meetingID) {
        TblRoom tblRoom = roomService.queryRoomByMeetingID(Long.parseLong(meetingID));
        Long roomID = 0L;
        if(tblRoom == null){
            tblRoom = new TblRoom();
            tblRoom.setOperator(userID);
            tblRoom.setRoomName(userID+"创建的房间");
            tblRoom.setMeetingID(Long.parseLong(meetingID));
            roomID = roomService.insertSelective(tblRoom);
        }else{
            roomID = tblRoom.getId();
        }
        Map<String,Object> result = new HashMap<>();
        result.put("roomID",roomID);
        result.put("skdAppid",skdAppid);
        result.put("groupID",tblRoom.getGroupID());
        return  responseAdapter.success(result);
    }
    /**
     * roomID生成  jsonp实现
     * @param userID
     * @return
     * @throws IOException
     */
    @RequestMapping("/genRoomIDUpgrade.ajax")
    @ResponseBody
    public Object genRoomIDForJsonp(@RequestParam(name = "userID") String userID,@RequestParam(name = "meetingID") String meetingID,String callback) {
        TblRoom tblRoom = roomService.queryRoomByMeetingID(Long.parseLong(meetingID));
        Long roomID = 0L;
        if(tblRoom == null){
            tblRoom = new TblRoom();
            tblRoom.setOperator(userID);
            tblRoom.setRoomName(userID+"创建的房间");
            tblRoom.setMeetingID(Long.parseLong(meetingID));
            roomID = roomService.insertSelective(tblRoom);
        }else{
            roomID = tblRoom.getId();
        }
        Map<String,Object> result = new HashMap<>();
        result.put("roomID",roomID);
        result.put("skdAppid",skdAppid);
        result.put("groupID",tblRoom.getGroupID());
        return callback+"("+responseAdapter.success(result)+")";
    }
    /*
     *
     * @return 获取getSkdAppid
     * @throws IOException
     */
    @RequestMapping("/getSkdAppid.ajax")
    @ResponseBody
    public Object getSkdAppid()  {
        Map<String,Object> result = new HashMap<>();
        result.put("skdAppid",skdAppid);
        return  responseAdapter.success(result);
    }
    /*
    *
    * @return 获取getSkdAppid
    * @throws IOException
    */
    @RequestMapping("/getSkdAppidUpgrade.ajax")
    @ResponseBody
    public Object getSkdAppidForJsonp(String callback)  {
        Map<String,Object> result = new HashMap<>();
        result.put("skdAppid",skdAppid);
        return callback+"("+responseAdapter.success(result)+")";
    }

    /*
    *
    * @return 获取getSkdAppid
    * @throws IOException
    */
    @RequestMapping("/createRoomSuccessCallBackUpgrade.ajax")
    @ResponseBody
    public Object updateCreateFlagForJsonp(@RequestParam(name = "meetingID") String meetingID,@RequestParam(name = "groupID") String groupID,String callback)  {
        boolean b = roomService.updateRoomByMeetingID(Long.parseLong(meetingID),groupID);
        Map<String,Object> result = new HashMap<>();
        if(b){
            return callback+"("+responseAdapter.success(result)+")";
        }else{
            return callback+"("+responseAdapter.failure("更新创建groupID失败")+")";
        }

    }
}




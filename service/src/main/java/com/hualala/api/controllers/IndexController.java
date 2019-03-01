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
@CrossOrigin
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
            e.printStackTrace();
        }
    return  null;
    }
     /**
      * roomID生成
     * @param userID
     * @return
     * @throws IOException
     */
    @RequestMapping("/genRoomID.ajax")
    @ResponseBody
    public Object genRoomID(@RequestParam(name = "userID") String userID,@RequestParam(name = "meetingID") Long meetingID) {
        TblRoom tblRoom = roomService.queryRoomByMeetingID(meetingID);
        Long roomID = 0L;
        if(tblRoom == null){
            tblRoom = new TblRoom();
            tblRoom.setOperator(userID);
            tblRoom.setRoomName(userID+"创建的房间");
            DatabaseContextHolder.setDatabaseType(DatabaseType.tencent_video);
            roomID = roomService.insertSelective(tblRoom);
        }else{
            roomID = tblRoom.getId();
        }
        Map<String,Object> result = new HashMap<>();
        result.put("roomID",roomID);
        result.put("skdAppid",skdAppid);
        return  responseAdapter.success(result);
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
}




package com.hualala.api.service;

import com.hualala.api.model.gen.pojo.TblRoom;

/**
 * @author: yefei
 * @date: 2018/11/18 13:44
 */
public interface IRoomService {
    Long insertSelective(TblRoom room);

    TblRoom queryRoomByMeetingID(Long meetingID);

}

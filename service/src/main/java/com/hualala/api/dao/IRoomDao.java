package com.hualala.api.dao;

import com.hualala.api.model.gen.pojo.TblRoom;

/**
 * Created by zhaoziyun on 2019/2/25.
 */
public interface IRoomDao {

    Long insertSelective(TblRoom room);

    TblRoom queryRoomByMeetingID(Long meetingID);
}

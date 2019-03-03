package com.hualala.api.service.impl;

import com.hualala.api.dao.IRoomDao;
import com.hualala.api.model.gen.pojo.TblRoom;
import com.hualala.api.service.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: yefei
 * @date: 2018/11/18 13:44
 */
@Service
public class RoomServiceImpl implements IRoomService {

    @Autowired
    private IRoomDao roomDao;
    @Override
    public Long insertSelective(TblRoom room) {
        return roomDao.insertSelective(room);
    }

    @Override
    public TblRoom queryRoomByMeetingID(Long meetingID) {
        return roomDao.queryRoomByMeetingID(meetingID);
    }

    @Override
    public boolean updateRoomByMeetingID(Long meetingID,String groupID) {
        return roomDao.updateRoomByMeetingID(meetingID,groupID);
    }
}

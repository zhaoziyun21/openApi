package com.hualala.api.dao.impl;

import com.hualala.api.config.db.DatabaseContextHolder;
import com.hualala.api.config.db.DatabaseType;
import com.hualala.api.dao.IRoomDao;
import com.hualala.api.model.gen.dao.TblRoomMapper;
import com.hualala.api.model.gen.pojo.TblRoom;
import com.hualala.api.model.gen.pojo.TblRoomExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by zhaoziyun on 2019/2/25.
 */
@Component
public class RoomDaoImpl implements IRoomDao {

    @Autowired
    private TblRoomMapper tblRoomMapper;
    @Override
    public Long insertSelective(TblRoom room) {
        DatabaseContextHolder.setDatabaseType(DatabaseType.tencent_video);
        if (tblRoomMapper.insertSelective(room) == 1){
            return room.getId();
        }else{
            return 0L;
        }
    }

    @Override
    public TblRoom queryRoomByMeetingID(Long meetingID) {

        DatabaseContextHolder.setDatabaseType(DatabaseType.tencent_video);

        TblRoomExample tblRoomExample = new TblRoomExample();
        tblRoomExample.createCriteria().andMeetingIDEqualTo(meetingID);

        List<TblRoom> tblRooms = tblRoomMapper.selectByExample(tblRoomExample);
        if(tblRooms.size() == 0 ){
            return null;
        }else{
            return tblRooms.get(0);
        }

    }
}

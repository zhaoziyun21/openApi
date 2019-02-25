package com.hualala.qa.k8s.op.dao.impl;

import com.hualala.qa.k8s.op.dao.IRoomDao;
import com.hualala.qa.k8s.op.model.gen.dao.TblRoomMapper;
import com.hualala.qa.k8s.op.model.gen.pojo.TblRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by zhaoziyun on 2019/2/25.
 */
@Component
public class RoomDaoImpl implements IRoomDao{

    @Autowired
    private TblRoomMapper tblRoomMapper;
    @Override
    public Long insertSelective(TblRoom room) {
        if (tblRoomMapper.insertSelective(room) == 1){
            return room.getId();
        }else{
            return 0L;
        }
    }

    @Override
    public TblRoom queryRoomByID(Long id) {
        return tblRoomMapper.selectByPrimaryKey(id);
    }
}

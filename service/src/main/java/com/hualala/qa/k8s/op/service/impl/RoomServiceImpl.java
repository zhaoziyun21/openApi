package com.hualala.qa.k8s.op.service.impl;

import com.hualala.qa.k8s.op.dao.IRoomDao;
import com.hualala.qa.k8s.op.model.gen.dao.TblRoomMapper;
import com.hualala.qa.k8s.op.model.gen.pojo.TblRoom;
import com.hualala.qa.k8s.op.service.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

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
    public TblRoom queryRoomByID(Long id) {
        return roomDao.queryRoomByID(id);
    }
}

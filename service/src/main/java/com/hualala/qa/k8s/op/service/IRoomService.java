package com.hualala.qa.k8s.op.service;

import com.hualala.qa.k8s.op.model.gen.pojo.TblRoom;

import java.util.List;

/**
 * @author: yefei
 * @date: 2018/11/18 13:44
 */
public interface IRoomService {
    Long insertSelective(TblRoom room);

    TblRoom queryRoomByID(Long id);

}

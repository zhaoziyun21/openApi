package com.hualala.qa.k8s.op.dao;

import com.hualala.qa.k8s.op.model.gen.pojo.TblRoom;
import org.springframework.stereotype.Repository;

/**
 * Created by zhaoziyun on 2019/2/25.
 */
public interface IRoomDao {

    Long insertSelective(TblRoom room);

    TblRoom queryRoomByID(Long id);
}

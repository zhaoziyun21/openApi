package com.hualala.api.model.gen.dao;

import com.hualala.api.model.gen.pojo.TblRoomExample;
import com.hualala.api.model.gen.pojo.TblRoom;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TblRoomMapper {
    long countByExample(TblRoomExample example);

    int deleteByExample(TblRoomExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TblRoom record);

    int insertSelective(TblRoom record);

    List<TblRoom> selectByExample(TblRoomExample example);

    TblRoom selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TblRoom record, @Param("example") TblRoomExample example);

    int updateByExample(@Param("record") TblRoom record, @Param("example") TblRoomExample example);

    int updateByPrimaryKeySelective(TblRoom record);

    int updateByPrimaryKey(TblRoom record);
}
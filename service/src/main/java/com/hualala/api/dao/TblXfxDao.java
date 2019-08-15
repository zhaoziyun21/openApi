package com.hualala.api.dao;

import com.hualala.api.model.TblXfx;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 文件上传Dao
 *
 * @author 赵子云
 * @email 939961241@qq.com
 * @date 2017-03-25 12:13:26
 */
public interface TblXfxDao  {
    int save(TblXfx t);

    List<TblXfx> queryUnDeal();

    TblXfx queryXfxParams(@Param("clientId")String clientId, @Param("mobile")String mobile, @Param("productId")String productId);

    void update(TblXfx tblXfx);

}

package com.hualala.api.service;

import com.hualala.api.model.TblXfx;

import java.util.List;

/**
 * <p>
 * 对接参数表
 * </p>
 *
 * @author zhaoziyun
 * @since 2019-07-12
 */
public interface TblXfxService {


    void save(TblXfx client);
    List<TblXfx> queryUnDeal();
}

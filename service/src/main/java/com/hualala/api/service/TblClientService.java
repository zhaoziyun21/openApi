package com.hualala.api.service;

import com.hualala.api.model.TblClient;

import java.util.List;

/**
 * <p>
 * 客户表 服务类
 * </p>
 *
 * @author zhaoziyun
 * @since 2019-07-12
 */
public interface TblClientService {

    /**
     * 保存客戶
     */
     void save(TblClient client,String clientId,String mobile,String productId);
    /**
     * 保存客戶
     */
     void save(TblClient client);

}

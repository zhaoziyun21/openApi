
package com.hualala.api.service.impl;

import com.hualala.api.config.db.DatabaseContextHolder;
import com.hualala.api.config.db.DatabaseType;
import com.hualala.api.controllers.OpenApiController;
import com.hualala.api.dao.TblClientDao;
import com.hualala.api.dao.TblXfxDao;
import com.hualala.api.model.TblClient;
import com.hualala.api.model.TblXfx;
import com.hualala.api.service.TblClientService;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.beans.Transient;
import java.util.List;

/**
 * <p>
 * 客户表 服务实现类
 * </p>
 *
 * @author zhaoziyun
 * @since 2019-07-12
 */
@Service("tblClientService")
public class TblClientServiceImpl implements TblClientService {
    public static final Logger logger = LoggerFactory.getLogger(OpenApiController.class);
    @Autowired
    private TblClientDao tblClientDao;
    @Autowired
    private TblXfxDao tblXfxDao;

    @Override
    @Transactional(transactionManager = "transactionManager",propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public void save(TblClient client, String clientId, String mobile, String productId) {
            DatabaseContextHolder.setDatabaseType(DatabaseType.platform);
            tblClientDao.save(client);

            TblXfx tblXfx = tblXfxDao.queryXfxParams(clientId, mobile, productId);
            tblXfx.setStatus("1");
            tblXfxDao.update(tblXfx);

    }
    @Override
    @Transactional(transactionManager = "transactionManager",propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public void save(TblClient client) {
            DatabaseContextHolder.setDatabaseType(DatabaseType.platform);
            tblClientDao.save(client);

    }


}

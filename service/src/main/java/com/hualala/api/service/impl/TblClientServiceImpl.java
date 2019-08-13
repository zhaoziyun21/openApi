
package com.hualala.api.service.impl;

import com.hualala.api.config.db.DatabaseContextHolder;
import com.hualala.api.config.db.DatabaseType;
import com.hualala.api.dao.TblClientDao;
import com.hualala.api.model.TblClient;
import com.hualala.api.service.TblClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    @Autowired
    private TblClientDao tblClientDao;

    @Override
    public void save(TblClient client) {
        DatabaseContextHolder.setDatabaseType(DatabaseType.platform);
        tblClientDao.save(client);
    }


}


package com.hualala.api.service.impl;

import com.hualala.api.config.db.DatabaseContextHolder;
import com.hualala.api.config.db.DatabaseType;
import com.hualala.api.dao.TblClientDao;
import com.hualala.api.dao.TblXfxDao;
import com.hualala.api.model.TblXfx;
import com.hualala.api.service.TblXfxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 客户表 服务实现类
 * </p>
 *
 * @author zhaoziyun
 * @since 2019-07-12
 */
@Service("tblXfxService")
public class TblXfxServiceImpl implements TblXfxService {
    @Autowired
    private TblXfxDao tblXfxDao;

    @Override
    public void save(TblXfx tblXfx) {
        DatabaseContextHolder.setDatabaseType(DatabaseType.platform);
        tblXfxDao.save(tblXfx);
    }

}

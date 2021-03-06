/**
 * Copyright (c) 2014 http://www.jieqianhua.com
 */
package com.hualala.api.config.db;

import lombok.Data;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;

import javax.sql.DataSource;
import java.util.HashMap;

/**
 * Created by yefei on 2018/8/2.
 */
@Data
@Configuration
public class DataSourceConfiguration {
    private static final Logger LOGGER = LoggerFactory.getLogger(DataSourceConfiguration.class);


    @Bean(name = "platformDataSource")
    @Autowired
    public DynamicDataSource platformDataSource(@Qualifier("platform") DataSource platformDataSource){
        DynamicDataSource dynamicDataSource =  new DynamicDataSource();
        HashMap<Object, Object> targetDataSources = new HashMap<Object, Object>() {{
            this.put(DatabaseType.platform, platformDataSource);
        }};
        dynamicDataSource.setTargetDataSources(targetDataSources);
        dynamicDataSource.afterPropertiesSet();
        return dynamicDataSource;

    }
    @Primary
    @Bean(name="platformSessionFactoryBean")
    public SqlSessionFactory platformSessionFactoryBean(@Qualifier("platformDataSource") DynamicDataSource dynamicDataSource) throws Exception {

        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dynamicDataSource);
        return sqlSessionFactoryBean.getObject();
    }



}

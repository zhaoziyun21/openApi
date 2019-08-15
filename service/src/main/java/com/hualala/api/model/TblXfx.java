package com.hualala.api.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 * 客户表
 * </p>
 *
 * @author zhaoziyun
 * @since 2019-07-12
 */
@Data
public class TblXfx {

    private static final long serialVersionUID = 1L;

    private Long id;


    private String clientId;


    private String mobile;


    private String productId;

    private String status;

    private Date createTime;

    private Date actionTime;



}

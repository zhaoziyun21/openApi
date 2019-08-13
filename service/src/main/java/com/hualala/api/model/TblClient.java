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
public class TblClient {

    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * 客户姓名
     */
    private String clientName;

    /**
     * 手机号
     */
    private String clientTel;

    /**
     * 客户类型0:默认  1：重点客户  2：放弃客户
     */
    private String clientType;

    /**
     * 客户经理id
     */
    private Long clientManagerId;

    /**
     * 客户经理姓名
     */
    private String clientManagerName;


    /**
     * 是否上门
     */
    private String isVisit;

    /**
     * 是否有社保   0：没有， 1：有
     */
    private BigDecimal isSocialSecurity;

    /**
     * 社保个缴金额
     */
    private BigDecimal socialSecurityPay;

    /**
     * 已交社保年限
     */
    private String socialSecurityYears;

    /**
     * 公积金个缴金额
     */
    private BigDecimal gjjPay;

    /**
     * 公积金已交年限
     */
    private String gjjYears;

    /**
     * 工资类型
     */
    private String salaryType;

    /**
     * 工资类型
     */
    private BigDecimal salaryMoney;

    /**
     * 工资联缴年限
     */
    private Integer salaryYears;


    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date actionTime;
    /**
     * 创建人
     */
    private String createUser;
    /**
     * 更新人
     */
    private String updateUser;
    /**
     * 状态
     */
    private String status;
    /**
     * 跟进时间
     */
    private Date followTime;

    /**
     * 签约状态
     */
    private String signStatus;
    /**
     * 申请平台
     */
    private String applyPlatform;
    /**
     * 申请金额
     */
    private BigDecimal applyAmount;
    /**
     * 申请时间
     */
    private Date applyTime;
    /**
     * 微粒贷  默认没有0      1有
     */
    private int isParticleLoan;
    /**
     * 微粒贷金额
     */
    private BigDecimal particleLoanAmount;
    /**
     * 默认0  1*  ~  5*
     */
    private String clientStar;
    /**
     * 默认0  是否有公积金
     */
    private int isGjj;
    /**
     * 默认0  房子类型 0无  1：全款本地房  2：全款外地方  3：按揭本地房  4：按揭外地房
     */
    private int houseType;
    /**
     * 月供
     */
    private int houseMonthPay;
    /**
     * 月供多少月
     */
    private int houseYears;
    /**
     * 是否北京车牌   0 默认不是
     */
    private int isBjCarNo;
    /**
     * 车的价值
     */
    private BigDecimal carAmount;
    /**
     * 保单年缴
     */
    private BigDecimal insureBillYearPay;
    /**
     * 保单年缴次数
     */
    private int insureBillYearCount;
    /**
     * 保单月缴
     */
    private BigDecimal insureBillMonthPay;
    /**
     * 保单月缴次数
     */
    private int insureBillMonthCount;
    /**
     * 工作单位性质
     */
    private String workPlace;
    /**
     * 备注
     */
    private int remark;
    /**
     * 身份证号
     */
    private String idCard;
    /**
     * 生日
     */
    private String birthdate;
    /**
     * 性别
     */
    private String sex;
    /**
     * 省份
     */
    private String province;
    /**
     * 城市
     */
    private String city;
    /**
     * 年龄
     */
    private int age;
    /**
     * 信用卡
     */
    private String creditCard;
    /**
     * 信用卡
     */
    private String creditCardAmount;
    /**
     * 是否有房 0无,1、有房无贷款，2有房有贷、
     */
    private String haveHouse;
    /**
     * 是否有车 0：无车产，1、有车无贷，2、有车有贷
     */
    private String haveCar;
    /**
     * 是否有保单  默认0没有  1有
     */
    private String haveInsure;

}

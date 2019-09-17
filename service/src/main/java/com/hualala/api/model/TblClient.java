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
    private String clientType = "0";

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
    private String isVisit="0";

    /**
     * 是否有社保   0：没有， 1：有
     */
    private BigDecimal isSocialSecurity=BigDecimal.ZERO;

    /**
     * 社保个缴金额
     */
    private BigDecimal socialSecurityPay=BigDecimal.ZERO;

    /**
     * 已交社保年限
     */
    private String socialSecurityYears ="0";

    /**
     * 公积金个缴金额
     */
    private BigDecimal gjjPay=BigDecimal.ZERO;

    /**
     * 公积金已交年限
     */
    private String gjjYears="0";

    /**
     * 工资类型
     */
    private String salaryType="0";

    /**
     * 工资类型
     */
    private BigDecimal salaryMoney=BigDecimal.ZERO;

    /**
     * 工资联缴年限
     */
    private Integer salaryYears=0;


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
    private String status="0";
    /**
     * 跟进时间
     */
    private Date followTime;

    /**
     * 签约状态
     */
    private String signStatus="0";
    /**
     * 申请平台
     */
    private String applyPlatform;
    /**
     * 申请金额
     */
    private BigDecimal applyAmount=BigDecimal.ZERO;
    /**
     * 申请时间
     */
    private Date applyTime;
    /**
     * 微粒贷  默认没有0      1有
     */
    private int isParticleLoan=0;
    /**
     * 微粒贷金额
     */
    private BigDecimal particleLoanAmount=BigDecimal.ZERO;
    /**
     * 默认0  1*  ~  5*
     */
    private String clientStar="0";
    /**
     * 默认0  是否有公积金
     */
    private int isGjj=0;
    /**
     * 默认0  房子类型 0无  1：全款本地房  2：全款外地方  3：按揭本地房  4：按揭外地房
     */
    private int houseType=0;
    /**
     * 月供
     */
    private int houseMonthPay=0;
    /**
     * 月供多少月
     */
    private int houseYears=0;
    /**
     * 是否北京车牌   0 默认不是
     */
    private int isBjCarNo=0;
    /**
     * 车的价值
     */
    private BigDecimal carAmount=BigDecimal.ZERO;
    /**
     * 保单年缴
     */
    private BigDecimal insureBillYearPay=BigDecimal.ZERO;
    /**
     * 保单年缴次数
     */
    private int insureBillYearCount=0;
    /**
     * 保单月缴
     */
    private BigDecimal insureBillMonthPay=BigDecimal.ZERO;
    /**
     * 保单月缴次数
     */
    private int insureBillMonthCount=0;
    /**
     * 工作单位性质
     */
    private String workPlace="0";
    /**
     * 备注
     */
    private String remark;
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
    private String sex="-1";
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
     * 信用卡额度
     */
    private String creditCardAmount;
    /**
     * 是否有房 0无,1、有房无贷款，2有房有贷、
     */
    private String haveHouse="0";
    /**
     * 是否有车 0：无车产，1、有车无贷，2、有车有贷
     */
    private String haveCar="0";
    /**
     * 是否有保单  默认0没有  1有
     */
    private String haveInsure="0";
    /**
     * 是否异地  默认0本地  1异地
     */
    private int isOtherPlace = 0;
    /**
     *   默认0 1:新分享
     */
    private int clientFrom = 0;
}


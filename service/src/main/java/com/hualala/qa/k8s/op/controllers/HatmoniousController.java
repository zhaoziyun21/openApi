package com.hualala.qa.k8s.op.controllers;


import com.hualala.qa.k8s.op.client.redis.RedisClient;
import com.hualala.qa.k8s.op.config.ResponseAdapter;
import com.hualala.qa.k8s.op.exception.ServerBaseException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Controller
@RequestMapping("/project")
@Slf4j
public class HatmoniousController {

    @Autowired
    private RedisClient redisStockClient;

    @Autowired
    private ResponseAdapter responseAdapter;

    private final String restricFlagRedisKey = "dohko:orderservice:restric:flag";
    private final String restricBlackList = "dohko:orderservice:restric:blacklist";

    private final String nav = "project";

//    public GrpcRestrictHandler(){
//        activeProfile = System.getProperty("spring.profiles.active");
//    }

    @RequestMapping("/saveShopID.ajax")
    @ResponseBody
    public Object saveShopID(@RequestParam(value = "shopID", defaultValue = "" ) String shopID) throws IOException {

        if (shopID != null && !"".equals(shopID)){

            //添加shopID到redis
            redisStockClient.sadd(restricBlackList, shopID);

//            //得到restricBlackList所有的值
//            Set set = redisStockClient.smembers(restricBlackList);
//
//            //验证存储是否生效
//            if(redisStockClient.sismember(restricBlackList, shopID)){
//
//                log.info("店铺ID:{} 被和谐了", shopID);
//
//            }else{
//
//                log.info("店铺未被被和谐");
//
//            }

        }else{

            return responseAdapter.failure("shopID为空");

        }

        return responseAdapter.success("保存店铺ID："+shopID+"成功");

    }

    @RequestMapping("/removeShopID.ajax")
    @ResponseBody
    public Object removeShopID(@RequestParam(value = "shopID", defaultValue = "" ) String shopID) throws IOException{

        if (shopID != null && !"".equals(shopID)){

            redisStockClient.srem(restricBlackList , shopID);

            //得到restricBlackList所有的值
            Set set = redisStockClient.smembers(restricBlackList);

            String shopIDs = "";
            // 获取set集合数据
            for (Iterator iterator = set.iterator(); iterator.hasNext();) {

                shopIDs += (String) iterator.next()+",";

            }

            if(!"".equals(shopIDs)){

                shopIDs = shopIDs.substring(0,shopIDs.length()-1);

            }
            log.info("被和谐的店铺有：{}", shopIDs);
        }

        return true;
    }

    @RequestMapping("/queryShopID.ajax")
    @ResponseBody
    public Object queryShopIDs() throws IOException{
        //得到restricBlackList所有的值
        Set set = redisStockClient.smembers(restricBlackList);

        return responseAdapter.success(set);
    }

}




package com.hualala.api.utils;

import org.apache.commons.codec.binary.Hex;
import org.springframework.web.bind.annotation.RequestParam;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.*;
import java.util.*;
import org.apache.commons.codec.binary.Base64;

public class SignUtils {
    /**
     * //默认的加密算法 字段
     */
    public static final String MODE = "ECB";
    /**
     * //默认的加密算法 字段
     */
    public static final String PADDING = "pkcs5padding";
    public static final String KEY_ALGORITHM = "AES";
    public static final String CIPHER_MODE = KEY_ALGORITHM + "/" + MODE + "/" + PADDING;
    /**
     * //默认的加密算法 编码
     */
    public static final String CHARACTER = "UTF-8";

    public static String getSHA256Str(String str) {
        MessageDigest messageDigest;
        String encdeStr = "";
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] hash = messageDigest.digest(str.getBytes("UTF-8"));
            encdeStr = Hex.encodeHexString(hash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return encdeStr;
    }


    public static String xfxSignMethod(@RequestParam(name = "clientId") String clientId, @RequestParam(name = "productId") String productId) {
        SortedMap<String, String> dataMap = new TreeMap<>();
        dataMap.put("productId", productId);
        dataMap.put("clientId", clientId);
        dataMap.put("dataType", "1");
        dataMap.put("signKey", "");
        String signData = sortData(dataMap);
        String sign = SignUtils.getSHA256Str("");
        return sign;
    }


    public static String sortData(Map<String, String> paramMap) {
        String sort = "";
        TLinxMapUtils signMap = new TLinxMapUtils();
        if (paramMap != null) {
            String key;
            for (Iterator it = paramMap.keySet().iterator(); it.hasNext(); ) {
                key = (String) it.next();
                String value = ((paramMap.get(key) != null) && (!("".equals(paramMap.get(key).toString())))) ? paramMap.get(key).toString() : "";
                signMap.put(key, value);
            }
            signMap.sort();
            for (Iterator it = signMap.keySet.iterator(); it.hasNext(); ) {
                key = (String) it.next();
                sort = sort + key + "=" + signMap.get(key).toString() + "&";
            }
            if ((sort != null) && (!("".equals(sort)))) {
                sort = sort.substring(0, sort.length() - 1);
            }
        }
        return sort;
    }


    /**
     * AES 解密操作
     *
     * @param content
     * @param password
     * @return
     */
    public static String decrypt(String content, String password) {

        try {
            //实例化
            Cipher cipher = Cipher.getInstance(CIPHER_MODE);

            //使用密钥初始化，设置为解密模式
            cipher.init(Cipher.DECRYPT_MODE, getSecretKey(password));

            //执行操作
            byte[] result = cipher.doFinal(Base64.decodeBase64(content));


            return new String(result, CHARACTER);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }

    /**
     * 生成加密秘钥
     *
     * @return
     */
    public static SecretKeySpec getSecretKey(final String password) {
        //返回生成指定算法密钥生成器的 KeyGenerator 对象
        KeyGenerator kg = null;
        try {
            kg = KeyGenerator.getInstance(KEY_ALGORITHM);
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
            random.setSeed(password.getBytes());
            //AES 要求密钥长度为 128
            //kg.init(128, new SecureRandom(password.getBytes()));
            kg.init(128, random);

            //生成一个密钥
            SecretKey secretKey = kg.generateKey();
            // 转换为AES专用密钥
            return new SecretKeySpec(secretKey.getEncoded(), KEY_ALGORITHM);
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }

        return null;
    }

}

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
     *
     * @param encryptContent  密文
     * @param password   密钥
     * @return
     * @throws Exception
     */
    public static String decrypt(String encryptContent, String password) throws Exception {
        try {

            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, getSecretKey(password));
            try {
                byte[] encryptByte = cipher.doFinal(new Base64().decode(encryptContent));
                return Base64.encodeBase64String(encryptByte);
            } catch (Exception e) {
                System.out.println(e.toString());
                return null;
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return null;
        }
    }


    private static SecretKeySpec getSecretKey(final String password) throws NoSuchAlgorithmException {
        //生成指定算法密钥的生成器
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128, new SecureRandom(password.getBytes()));
        //生成密钥
        SecretKey secretKey = keyGenerator.generateKey();
        //转换成AES的密钥
        return new SecretKeySpec(secretKey.getEncoded(), "AES");
    }

}

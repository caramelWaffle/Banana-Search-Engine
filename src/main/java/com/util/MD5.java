package com.util;

import org.apache.commons.codec.digest.DigestUtils;

public class MD5 {
    /**
     * MD5
     * 
     * @param text
     * @param key
     * @return 
     * @throws Exception
     */
    public static String md5(String text) throws Exception {
        String encodeStr=DigestUtils.md5Hex(text);
        return encodeStr;
    }

}
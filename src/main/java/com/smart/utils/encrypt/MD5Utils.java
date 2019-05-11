//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.smart.utils.encrypt;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Utils {
    public MD5Utils() {
    }

    public static String encode(String code) {
        if (code != null && !"".equals(code.trim())) {
            MessageDigest md = null;

            try {
                md = MessageDigest.getInstance("MD5");
                md.update(code.getBytes("utf-8"));
                byte[] bs = md.digest();
                StringBuilder sb = new StringBuilder();
                byte[] var4 = bs;
                int var5 = bs.length;

                for (int var6 = 0; var6 < var5; ++var6) {
                    byte b = var4[var6];
                    int v = b & 255;
                    if (v < 16) {
                        sb.append(0);
                    }

                    sb.append(Integer.toHexString(v));
                }

                return sb.toString();
            } catch (NoSuchAlgorithmException var9) {
                var9.printStackTrace();
            } catch (UnsupportedEncodingException var10) {
                var10.printStackTrace();
            }

            return null;
        } else {
            throw new RuntimeException("the code which will be encoded with 'MD5' must not be null or empty!");
        }
    }

    public static void main(String[] args) {
        System.out.println(encode("123456"));
    }
}

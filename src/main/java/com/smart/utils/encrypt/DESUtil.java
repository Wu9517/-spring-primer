package com.smart.utils.encrypt;

import javax.crypto.*;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

/**
 * @author wzy
 */
public class DESUtil {

    //指定DES加密解密所用的密钥
    private static Key key;
    private static String KEY_STR = "myKey";

    static {
        try {
            KeyGenerator generator = KeyGenerator.getInstance("DES");
            generator.init(new SecureRandom(KEY_STR.getBytes()));
            key = generator.generateKey();
            generator = null;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    //对字符串进行DES加密，返回BASE64编码的加密字符串
    public static String getEncryptString(String str) {
        try {
            byte[] strBytes = str.getBytes("UTF8");
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] encryptStrBytes = cipher.doFinal(strBytes);
            //提示usage of api documented as @since 1.6+Error:java该错误信息时，
            // 更改File-Project Structure-Modules-sources-Language Level与当前jdk版本一致
            return Base64.getEncoder().encodeToString(encryptStrBytes);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        }
        return null;
    }

    //对BASE64编码的加密字符串进行解密，返回解密后的字符串
    public static String getDecryptString(String str) {
        byte[] strBytes = Base64.getDecoder().decode(str);
        try {
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] decryptStrBytes = cipher.doFinal(strBytes);
            return new String(decryptStrBytes, "UTF8");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        //启动时提示： javacTask: source release 1.8 requires target
        //解决方式：setting-java compiler-版本相关信息都改为当前jdk版本
        String encryptRoot = getEncryptString("root");
        System.out.println("root:" + encryptRoot);
        String encryptPwd = getEncryptString("123456");
        System.out.println("123456:" + encryptPwd);
        System.out.println("encryptRoot:" + getDecryptString(encryptRoot));
        System.out.println("encryptPwd:" + getDecryptString(encryptPwd));
    }
}

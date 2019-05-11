package com.smart.config;

import com.smart.utils.encrypt.DESUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

/**
 * 继承PropertyPlaceholderConfigurer定义支持密文版属性的属性配置器
 * 使用自定义属性加载器后，smart-context配置文件里则不能使用context:property-placeholder引用属性文件了了
 *
 * @author wzy
 */
public class EncryptPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {

    private Logger logger = Logger.getLogger(EncryptPropertyPlaceholderConfigurer.class);
    //加密用户名和密码
    private String[] encryptPropNames = {"username", "password"};

    //对特定属性的属性值进行转换
    @Override
    protected String convertProperty(String propertyName, String propertyValue) {
        if (isEncryptProp(propertyName)) {
            String decryptValue = DESUtils.getDecryptString(propertyValue);
            logger.info(decryptValue);
            return decryptValue;
        } else {
            logger.info(propertyValue);
            return propertyValue;
        }
    }

    //判断是否是需要解密的属性
    private boolean isEncryptProp(String propertyName) {
        for (String encryptPropName : encryptPropNames) {
            if (encryptPropName.equals(propertyName)) {
                return true;
            }
        }
        return false;
    }
}

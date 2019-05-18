package com.smart.websocket;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @author wzy
 */
public class WebSocketInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{WebSocketConfig.class};
    }

    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}

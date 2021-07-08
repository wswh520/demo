package com.example.demo.Thread;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class RequestHolder extends HandlerInterceptorAdapter {

    private static ThreadLocal<HttpServletRequest> httpServletRequestHolder =
            new ThreadLocal<HttpServletRequest>();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        httpServletRequestHolder.set(request); // 绑定到当前线程
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception ex)
            throws Exception {
        httpServletRequestHolder.remove(); // 清理资源引用
    }

    public static HttpServletRequest getHttpServletRequest() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        RequestContextHolder.setRequestAttributes(attributes, true);
        return request;
    }

}

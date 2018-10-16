package com.kukuou.springbootfilter.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.thymeleaf.util.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author olx
 * @date 2018/10/16/016
 */
@WebFilter(filterName = "baseFilter" , urlPatterns = "/*")
public class BaseFilter implements Filter {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private static String ajaxHeader = "XMLHttpRequest";
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("拦截器初始化" + "当前类=BaseFilter.init()" + "filterConfig = [" + filterConfig + "]");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String requestURI = request.getRequestURI();
        logger.info("----------------过滤器正在处理-----------------");
        logger.info("该请求为:"+requestURI);

        if (StringUtils.equals(request.getHeader("X-Requested-With"),ajaxHeader)) {
            logger.info("接收到ajax异步请求");
        }
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}

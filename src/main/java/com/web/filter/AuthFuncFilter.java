package com.web.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * 权限过滤器
 * Created by Administrator on 2017/7/24.
 */
public class AuthFuncFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}

package org.denhaw.self.console.server.filter;

import org.denhaw.self.console.server.constant.AuthConstants;
import org.denhaw.self.console.server.util.AuthUtil;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter
public class UserAuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest =(HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse=(HttpServletResponse) servletResponse;
        if(AuthUtil.isAuthUrl(httpRequest.getRequestURL().toString())){

        }
        filterChain.doFilter(httpRequest,httpResponse);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}

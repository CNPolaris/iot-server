package com.polaris.utils;


import cn.hutool.json.JSONUtil;
import com.polaris.entity.RespBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author polaris
 */
@WebFilter(filterName = "jwtFilter", urlPatterns = "/api/*")
public class JwtFilter implements Filter {
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        final HttpServletRequest request = (HttpServletRequest) req;
        final HttpServletResponse response = (HttpServletResponse) res;
        response.setCharacterEncoding("UTF-8");

        String token = request.getHeader("Authorization");
        if("OPTIONS".equals(request.getMethod())){
            response.setStatus(HttpServletResponse.SC_OK);
            chain.doFilter(request, response);
        } else {
            if(token == null){
                response.getWriter().write(JSONUtil.toJsonStr(RespBean.error(Commons.CODE_NO_TOKEN,Commons.ERROR_NO_TOKEN)));
                return;
            }
            else if(jwtTokenUtil.isTokenExpired(token)){
               response.getWriter().write(JSONUtil.toJsonStr(RespBean.error(Commons.CODE_TOKEN_EXPIRED,Commons.ERROR_TOKEN_EXPIRED)));
               return;
            }
            String username = jwtTokenUtil.getUserNameFromToken(token);
            request.setAttribute("username", username);
            request.setAttribute("id", jwtTokenUtil.getUserId(token));
            chain.doFilter(req,res);
        }

    }

    @Override
    public void destroy() {
    }
}

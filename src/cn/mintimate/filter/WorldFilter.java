package cn.mintimate.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * 对评论进行敏感词屏蔽
 */
@WebFilter("/Data")
public class WorldFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String detials = servletRequest.getParameter("details");
        detials=detials.replaceAll("操","*");
        detials=detials.replaceAll("cao","*");
        detials=detials.replaceAll("草","*");
        detials=detials.replaceAll("c","*");
        servletRequest.setAttribute("detials",detials);
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}

package com.hroa.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.hroa.model.AdminModel;

public class RbacFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession session = req.getSession();
        // 获得用户请求的URI
        String path = req.getRequestURI();
        String contextPath = req.getContextPath();
        String url = path.substring(contextPath.length());
        
        /*配置不拦截以.css、.js、woff、.ttf结尾的请求*/
        if(url != null && url.endsWith(".css")||url.endsWith(".png")||url.endsWith(".woff2")||(url != null && url.endsWith(".js"))||(url != null && url.endsWith(".woff"))||(url != null && url.endsWith(".ttf"))) {  
        	chain.doFilter(request,response); 
            return;  
        }
        
        if(path.equals("/HROA/login.jsp")){
          	 System.out.print("允许访问登录页面！");
          	 chain.doFilter(request, response);
             return;
        }else {
        	if(path.equals("/HROA/lg/userlg.html")){
           	 	System.out.print("允许访问此请求！");
           	 	if(request.getParameter("account")!=null||session.getAttribute("adminlgSession")!=null){
           	 		chain.doFilter(request, response);
                    return;
           	 	}else{
           	 		resp.sendRedirect("/HROA/login.jsp");
                    return;
           	 	}
        	}
        	if (session.getAttribute("adminLgSession") == null) {
                resp.sendRedirect("/HROA/login.jsp");
                return;
            }
        	if (session.getAttribute("adminLgSession")!=null) {
           	 	/*if(path.equals("/HROA/")){
           	 		resp.sendRedirect("/HROA/index.jsp");
           	 		return;
           	 	}*/
                chain.doFilter(request, response);
                System.out.print("登录状态，允许访问！");
                return;
            }
        }
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
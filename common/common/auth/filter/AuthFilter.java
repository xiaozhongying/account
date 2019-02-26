package common.auth.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import common.auth.Auth;
import common.auth.AuthUtil;

/**
 * 认证过滤器
 * @author skey
 * , urlPatterns="/manage/*"
 */
@WebFilter(filterName="AuthFilter" , urlPatterns="/manage/*")
public class AuthFilter implements Filter
{
	public void init(FilterConfig config) throws ServletException
	{
		try
		{
		}
		catch(Exception e)
		{
		}
		System.out.println("AuthFilter initialization");
	}

	public void destroy()
	{
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException
	{
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpServletRequestWrapper requestWrapper = new HttpServletRequestWrapper(req);
		HttpServletResponseWrapper responseWraper = new HttpServletResponseWrapper(res);
		try
		{
			// 取得当前用户账号
			String userAccount = dswork.sso.WebFilter.getAccount(req.getSession());
			Auth auth = AuthUtil.getLoginUser(req);
			if(auth != null && !auth.getAccount().equals(userAccount))
			{
				auth = null;
			}
			if(auth == null)
			{
				auth = new Auth();
				auth.setAccount(userAccount);
				try
				{
					dswork.sso.model.IUser m = dswork.sso.AuthFactory.getUser(userAccount);
					if(m!=null){
						auth.setAccount(m.getAccount());
						auth.setName(m.getName());
						auth.setType(m.getType());
					}
					else{//若用户表没有这个用户，返回登录页
						res.sendRedirect(req.getContextPath() + "/logout.jsp");
						return;
					}
					
				}
				catch(Exception xx)
				{
					xx.printStackTrace();
				}
				req.getSession().setAttribute(AuthUtil.SessionName_LoginUser, auth);
			}
			chain.doFilter(requestWrapper, responseWraper);
		}
		catch(Exception e)
		{
		}
	}
}

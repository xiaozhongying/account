package common.auth;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.PageContext;

/**
 * 用户登录类
 * @author skey
 */
public class AuthUtil
{
	public static final String SessionName_LoginUser = "COMMON_LOGIN_USER";
	private HttpServletRequest request;
	
	public AuthUtil(PageContext context)
	{
		this.request = (HttpServletRequest)context.getRequest();
	}

	public static void logout(HttpServletRequest request)
	{
		request.getSession().setAttribute(SessionName_LoginUser, null);
	}

	public void setLoginUser(Auth user)
	{
		request.getSession().setAttribute(SessionName_LoginUser, user);
	}

	public static Auth getLoginUser(HttpServletRequest request)
	{
		Auth user = (Auth) request.getSession().getAttribute(SessionName_LoginUser);
		return user;
	}
}

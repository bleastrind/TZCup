/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.tiaozhanbei.util;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
	import javax.servlet.http.HttpServletRequest;

import net.tiaozhanbei.exception.LogicException;
import net.tiaozhanbei.model.User;
import net.tiaozhanbei.util.RegexUrlPathMatcher;
/**
 *
 * @author buaatw
 */
public class UrlAccessJudger {

	//Singleton
	private UrlAccessJudger(){}
	private static SafeProperties bundle;
	private static UrlAccessJudger judger=new UrlAccessJudger();
	private static RegexUrlPathMatcher urlMatcher= new RegexUrlPathMatcher();
	//设置匹配资源
	public static void setBundle(SafeProperties safeProperties){
		bundle = safeProperties;
	}
	
	public static UrlAccessJudger getInstance() throws LogicException{
		if(bundle != null)
			return judger;
		throw new LogicException("未初始化URL权限资源");
	}
	
    
    @SuppressWarnings("unchecked")
	public boolean accessable(String accessurl,HttpServletRequest request){
        

        String grantedAuthorities = null;
        Enumeration<String> keys = (Enumeration<String>)bundle.propertyNames();
        while (keys.hasMoreElements()) {
			String url = keys.nextElement();
			
			 if(urlMatcher.pathMatchesUrl(url, accessurl)) {
	                grantedAuthorities = bundle.getProperty(url);
	     
	                break;
	            }
		}

        User user=null;
        if(grantedAuthorities != null) {
        	String[] allowStrings = grantedAuthorities.split(",");
        	user = (User)request.getSession().getAttribute("user");
        	List<String> roles = new ArrayList<String>();
        	//匿名支持
        	if(user==null)
        		roles.add("ROLE_ANONYMOUS");
        	else
				roles = user.getRoles();
        	System.out.println(roles.toString());
        	for (int i = 0; i < allowStrings.length; i++) {
                
				if (roles.contains(allowStrings[i])) {
					return true;
				}
			}
        }else
        	return true;

        String userString="匿名";
        if(user!=null)
        	userString=user.getName();
        System.out.println("拒绝用户："+
        		
        		userString+ "访问url："+accessurl);
        return false;
	}
}


package net.tiaozhanbei.action.user;
import net.tiaozhanbei.util.datastruct.UrlTree;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.tiaozhanbei.action.BaseAction;
import net.tiaozhanbei.form.RegisterForm;
import net.tiaozhanbei.model.User;
import net.tiaozhanbei.util.CommonResources;
import net.tiaozhanbei.util.Sha512DigestUtils;
import net.tiaozhanbei.util.UserConst;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.*;

/** 
 * 注册一个新用户，用到UserService中的register方法
 * MyEclipse Struts
 * Creation date: 02-26-2009
 * 
 * XDoclet definition:
 * @@struts.action path="/register" name="registerForm" input="/Web/Register/Register.jsp" scope="request" validate="true"
 * @@struts.action-forward name="success" path="/Web/Register/RegisterSuccess.jsp" redirect="true"
 */
public class RegisterAction extends BaseAction {
	/*
	 * Generated Methods
	 */

	/** 
	 * Method execute
	 * @@param mapping
	 * @@param form
	 * @@param request
	 * @@param response
	 * @@return ActionForward
	 */
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		System.out.println("开始执行action!");
		HttpSession session = request.getSession();
		try{
			request.setCharacterEncoding("GBK");
			System.out.println(new String(request.getParameter("name")));
		//request.setCharacterEncoding("GBK");
		}catch (Exception e) {
			// TODO: handle exception
		}
		RegisterForm regForm = (RegisterForm) form;
		
		String sRand=(String)session.getAttribute("code");
		String validateimage=request.getParameter("validateimage");
		System.out.println("验证码"+sRand);
		System.out.println("输入"+validateimage);
		if(!sRand.equals(validateimage) )
		{
			session.removeAttribute("code");
			return mapping.findForward("error");
		}
		
		
		
		
		User user = new User();
		System.out.println(regForm.getName());
	
		try{
			String password=regForm.getPassword();
			BeanUtils.copyProperties(user,regForm);
			user.setPassword(Sha512DigestUtils.shaHex(password));//将密码加密
			user.setScore(100);
			System.out.println(user.getName());
		}catch (Exception e) {
			//System.out.println(user.getName());
			System.out.println(e);
			return mapping.findForward("error");
		}
		int type=user.getType();
		System.out.println(type);
		if(getUserService().register(user))
		{	
			System.out.println("ID:"+user.getId());
			
			session.setAttribute("user",user);
			if (type==UserConst.Type.AUTHOR) {
				System.out.println("去作者注册");
				UrlTree tree = UrlTree.load("projectCatagory", CommonResources.getProjectCatagoryBundle());
				request.setAttribute("catagoryTree", tree);
				return mapping.findForward("authorReg");
				
			} else if(type==UserConst.Type.COMPANY) {
				System.out.println("企业注册");
				return mapping.findForward("companyReg");

			} else if (type==UserConst.Type.JUDGER) {
				System.out.println("评委注册");
				return mapping.findForward("judgerReg");
				
			}else {
				
				System.out.println("普通用户去主页");
				return mapping.findForward("index");
			}
		}
		else
			return mapping.findForward("error");
	}
}




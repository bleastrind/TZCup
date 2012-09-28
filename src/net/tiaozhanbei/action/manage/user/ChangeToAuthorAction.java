/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package net.tiaozhanbei.action.manage.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.tiaozhanbei.action.BaseAction;
import net.tiaozhanbei.form.regAuthorAndProjectForm;
import net.tiaozhanbei.model.Project;
import net.tiaozhanbei.model.User;
import net.tiaozhanbei.util.UserConst;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/** 
 * MyEclipse Struts
 * Creation date: 04-02-2009
 * 
 * XDoclet definition:
 * @struts.action path="/changeToAuthor" name="regAuthorAndProjectForm" scope="request" validate="true"
 */
public class ChangeToAuthorAction extends BaseAction {
	/*
	 * Generated Methods
	 */

	/** 
	 * Method execute
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		regAuthorAndProjectForm regAuthorAndProjectForm = (regAuthorAndProjectForm) form;// TODO Auto-generated method stub
		
		
		
		Project project=new Project();
		User user;
		user=(User)request.getSession().getAttribute("user");
		if(user==null||user.getType()!=UserConst.Type.COMMONUSER)
		{
			 request.setAttribute("message", "failure");
				
				return mapping.findForward("ajaxSuccessOrFailure");
				
			
		}
		try {
			project.setBrief(regAuthorAndProjectForm.getBrief());
			project.setName(regAuthorAndProjectForm.getName());
			project.setType(String.valueOf(regAuthorAndProjectForm.getType()));
			user.setPhone(regAuthorAndProjectForm.getPhone());
			user.setRealName(regAuthorAndProjectForm.getRealName());
			user.setDepartment(regAuthorAndProjectForm.getDepartment());
			user.setType(UserConst.Type.AUTHOR);//�����û�����Ϊ��������
			user.setVerify(false);//�������״̬Ϊδͨ��
			System.out.println("��ʼִ������ע���Action!");
			System.out.println("��session�еõ����û�"+user.getName()+user.getRegisterTime()+user.getType());
			System.out.println("project:"+project.getName()+project.getBrief());
			System.out.println("�û��������޸�Ϊ"+user.getType());
			//System.out.println("ownerID:"+project.getOwner().getId());
			if(getUserService().registerAuthor(user, project))
			{
				request.getSession().setAttribute("user", user);//����session�е��û���Ϣ
				 request.setAttribute("message", "success");
					
					return mapping.findForward("ajaxSuccessOrFailure");
					
			}

	
		
			
		} catch (Exception e) {
			System.out.println(e);
			return mapping.findForward("error");
		}
		
		
		
		return null;
	}
}
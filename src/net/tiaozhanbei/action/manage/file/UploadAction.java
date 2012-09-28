/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.tiaozhanbei.action.manage.file;

import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.tiaozhanbei.action.BaseAction;
import net.tiaozhanbei.model.FileInfo;
import net.tiaozhanbei.model.User;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.log4j.Logger;


/**
 *
 * @author buaatw
 */
public class UploadAction extends BaseAction {

	private static Logger logger = Logger.getLogger(UploadAction.class);

    @SuppressWarnings("deprecation")
	public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        FileInfo file = new FileInfo();
        
        //设置权限
        int access = 1 +
                (request.getParameter("ac2") == null ? 0 : 1) * 2 +
                (request.getParameter("ac3") == null ? 0 : 1) * 4 +
                (request.getParameter("ac4") == null ? 0 : 1) * 8 +
                (request.getParameter("ac5") == null ? 0 : 1) * 16;
        file.setAccess(access);
       
        logger.info("session_param:"+request.getSession().getId());
        logger.info("userid:"+request.getParameter("userid"));
       
        int userid=Integer.parseInt(request.getParameter("userid"));
                      
        User user=getUserService().getUserById(userid);
        logger.info("userName:"+user.getName());
        file.setOwner(user);//session."user
        String result = getFileInfoService().upload(getServlet().getServletConfig(),request,response,file);
        logger.info("result:"+result);
        request.setAttribute("result", result);
        if (result.equals("success")) {
			
		return mapping.findForward("result");
        }else{
        	
        	return mapping.findForward("error404");
        }


    }
}

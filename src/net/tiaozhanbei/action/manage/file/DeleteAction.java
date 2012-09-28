/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.tiaozhanbei.action.manage.file;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.tiaozhanbei.action.BaseAction;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author buaatw
 */
public class DeleteAction extends BaseAction {
	

    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) {
    	try {
            getFileInfoService().del(Integer.parseInt(request.getParameter("fileid")));
            request.setAttribute("message", "success");
        } catch (RuntimeException ex) {
            ex.printStackTrace();
            request.setAttribute("message", "failure");
        }
        return mapping.findForward("ajaxSuccessOrFailure");
        
    }
}

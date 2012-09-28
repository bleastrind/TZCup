/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.tiaozhanbei.action.file;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.tiaozhanbei.action.BaseAction;
import net.tiaozhanbei.model.FileInfo;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author Administrator
 */
public class DownloadAction extends BaseAction {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response){
		 int id=Integer.parseInt(request.getParameter("fileid"));
         try{
             FileInfo file=getFileInfoService().download(id);
             request.setAttribute("file", file);
             System.out.print("filename:"+file.getName());
             return mapping.findForward("success");
         }catch(RuntimeException ex){
             ex.printStackTrace();
             request.setAttribute("message", "fail to access to data");
             return mapping.findForward("error");
         }
	}
 
}

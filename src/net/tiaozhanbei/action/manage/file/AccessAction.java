/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.tiaozhanbei.action.manage.file;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.tiaozhanbei.action.BaseAction;
import net.tiaozhanbei.model.FileInfo;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author buaatw
 */
public class AccessAction extends BaseAction {

    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) {
        try {
            /*fileid�����ж�Ҫ�������ļ�����
             * ac1...ac5��Ӧ��λ����λ��Ȩ��ѡ��
             *ac1--���޸ò��������ʾǰ̨Ҫ�鿴
             *ac1--���иò��������ʾǰ̨Ҫ�޸�
             */
        	//System.out.println(request.getParameter("fileid"));
            if (request.getParameter("fileid") == null) {
                request.setAttribute("message", "����������´���ע�⣡����");
            }
            
            int file_id = Integer.parseInt(request.getParameter("fileid"));

            if (request.getParameter("ac1")==null){
                FileInfo fileinfo=getFileInfoService().download(file_id);//��ȡ�ļ�Ȩ����Ϣ
                int access=fileinfo.getAccess();
                
                request.setAttribute("ac2",(access/2)%2);
                request.setAttribute("ac3",(access/4)%2);
                request.setAttribute("ac4",(access/8)%2);
                request.setAttribute("ac5",(access/16)%2);
                request.setAttribute("fileinfo", fileinfo);
                return mapping.findForward("access");
            }


            int access =1+
                    (request.getParameter("ac2")==null?0:1) * 2 +
                    (request.getParameter("ac3")==null?0:1) * 4 +
                    (request.getParameter("ac4")==null?0:1) * 8 +
                    (request.getParameter("ac5")==null?0:1) * 16;
           // System.out.println("access:"+access);
            getFileInfoService().Access(file_id, access);
            request.setAttribute("message", "success");
        
        } catch (Exception ex){
            ex.printStackTrace();
            request.setAttribute("message", "failed:"+ex.getMessage());

        }
        
        return mapping.findForward("ajaxSuccessOrFailure");
    }
}

/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package net.tiaozhanbei.action.manage;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.tiaozhanbei.action.BaseAction;
import net.tiaozhanbei.event.AutoLoginEvent;
import net.tiaozhanbei.exception.LogicException;
import net.tiaozhanbei.util.CommonResources;
import net.tiaozhanbei.util.datastruct.UrlTree;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import net.tiaozhanbei.util.UrlAccessJudger;

/** 
 * MyEclipse Struts
 * Creation date: 03-02-2009
 * 
 * XDoclet definition:
 * @struts.action
 */
public class ManageAction extends BaseAction {
	/*
	 * Generated Methods
	 */
    ResourceBundle bundle= CommonResources.getControlPanelTreeBundle();
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
		
		UrlTree tree = readToUrlTree(request);
		request.setAttribute("lefttree",tree);
		
		publishEvent(new AutoLoginEvent(this,request));
		
		return mapping.findForward("success");
	}

	private UrlTree readToUrlTree(HttpServletRequest request){
		UrlTree tree=new UrlTree();
		tree.setName("controlpanel");
        tree.setChildren(new ArrayList<UrlTree>());
		Enumeration<String> strs = bundle.getKeys();
        while(strs.hasMoreElements())
        {
            String str = strs.nextElement();
            String value = bundle.getString(str);
            try {
				if(UrlAccessJudger.getInstance().accessable(value, request))
				    addToTree(tree,str);
			} catch (LogicException e) {
				e.printStackTrace();
			}

        }

		return tree;
	}

    private void addToTree(UrlTree urltree,String str){
        String[] group = str.split("\\.");
        UrlTree tobechanged;
        switch(group.length){
             case 2:
                tobechanged=getChild(urltree,group[1]);
                break;
            case 3:
                tobechanged=getChild(urltree,group[1]);
                tobechanged=getChild(tobechanged,group[2]);
                break;
            default:
                System.out.println("ControlPanelTree Resouce Format Error!");
                return;
        }
        tobechanged.setValue(bundle.getString(str));
    }

    private UrlTree getChild(UrlTree tree,String name){
        for(UrlTree ctree : tree.getChildren()){
            if(ctree.getName().equals(name))
                return ctree;
        }
        UrlTree ntree = new UrlTree();
        ntree.setName(name);
        ntree.setParent(tree);
        tree.getChildren().add(ntree);
        return ntree;
    }
}
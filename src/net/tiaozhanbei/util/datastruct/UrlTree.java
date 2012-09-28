package net.tiaozhanbei.util.datastruct;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.ResourceBundle;
import javax.servlet.http.HttpServletRequest;



public class UrlTree extends Tree<UrlTree,String>{
	private String urlContext="";
	
	private UrlTree parent;

	public String getContextPath() {
		return urlContext;
	}

	public void setContextPath(HttpServletRequest request) {
		this.urlContext = request.getContextPath();
	}
	
	@Override
	public String getValue(){
		return urlContext + value;
	}

	public UrlTree getParent() {
		return parent;
	}

	public void setParent(UrlTree parent) {
		this.parent = parent;
	}
	
	public String getFullName(){
		StringBuffer buffer = new StringBuffer();
		fillBuffer(buffer, this);
		return buffer.toString();
	}
	private static void fillBuffer(StringBuffer buffer,UrlTree tree){
		if(tree.parent!=null){
			fillBuffer(buffer, tree.parent);
			buffer.append("."+tree.name);
		}else 
			buffer.append(tree.name);
	}

	public static UrlTree load(String rootName,ResourceBundle bundle){
		UrlTree tree=new UrlTree();
		tree.setName(rootName);
        tree.setChildren(new ArrayList<UrlTree>());
		Enumeration<String> strs = bundle.getKeys();
        while(strs.hasMoreElements())
        {
            String str = strs.nextElement();
			addToTree(bundle,tree,str);
        }

		return tree;
	}

    private static void addToTree(ResourceBundle bundle, UrlTree urltree,String str){
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

    private static UrlTree getChild(UrlTree tree,String name){
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

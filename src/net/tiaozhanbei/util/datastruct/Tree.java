package net.tiaozhanbei.util.datastruct;

import java.util.ArrayList;
import java.util.List;

abstract class Tree<TreeNode,Data> {

	protected String name=null;
	protected Data value=null;
	protected TreeNode parent=null;
	protected List<TreeNode> children=new ArrayList<TreeNode>();
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public TreeNode getParent() {
		return parent;
	}
	public void setParent(TreeNode parent) {
		this.parent = parent;
	}
	public List<TreeNode> getChildren() {
		return children;
	}
	public void setChildren(List<TreeNode> children) {
		this.children = children;
	}
	
	public Tree(){}
	public Data getValue() {
		return value;
	}
	public void setValue(Data value) {
		this.value = value;
	}
	
	
	@SuppressWarnings("unchecked")
	public boolean equals(Tree tree){
        if(this.name.equals(tree.name))
                return true;
        return false;
    }
}

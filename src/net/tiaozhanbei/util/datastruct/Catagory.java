package net.tiaozhanbei.util.datastruct;

import java.util.ArrayList;
import java.util.List;

import net.tiaozhanbei.exception.LogicException;

public class Catagory extends Tree<Catagory,Object>{

	private List<Catagory> children=new ArrayList<Catagory>();
	//TODO 未测试
	/**
	 * 
	 * @param 根节点
	 * @param 父节点
	 * @return c1.c2.c3的形式
	 */
	public String toString(Catagory root) throws LogicException{
		if(this == root)
			return name;
		else if (this.parent == null) {
			throw new LogicException("The node isn't in the root!");
		}else {
			return parent.toString(root)+'.'+name; 
		}
	}
	

	//TODO 未测试
	/**
	 * 通过字符串生成Catagory
	 */
	public static Catagory constructCatagory(Catagory root,String constructString)throws LogicException{
		String[] paths= constructString.split(".");
		outter: 
		for (String node : paths) {
			for (Catagory catagory : (List<Catagory>)root.children) {
				if(catagory.name.equals(node)){
					root = catagory;
					continue outter;
				}
			}
			throw new LogicException(constructString+" isn't in the catagory tree!");
		}
		return root;
	}
}

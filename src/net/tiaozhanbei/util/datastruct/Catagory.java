package net.tiaozhanbei.util.datastruct;

import java.util.ArrayList;
import java.util.List;

import net.tiaozhanbei.exception.LogicException;

public class Catagory extends Tree<Catagory,Object>{

	private List<Catagory> children=new ArrayList<Catagory>();
	//TODO δ����
	/**
	 * 
	 * @param ���ڵ�
	 * @param ���ڵ�
	 * @return c1.c2.c3����ʽ
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
	

	//TODO δ����
	/**
	 * ͨ���ַ�������Catagory
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

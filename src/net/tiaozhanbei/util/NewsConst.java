package net.tiaozhanbei.util;

import java.util.Map;

public class NewsConst {
	
	public static class Type{
		public static int NORMAL=0;
		public static int SPECIAL=1;
		public static int HEAD=2;
	}
	
	private Map<Integer, String> catagory;

	public Map<Integer, String> getCatagory() {
		return catagory;
	}

	
	public void setCatagory(Map<Integer,String> catagory) {
		this.catagory = catagory;
	}
}

package net.tiaozhanbei.util;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class Page<T> {
	private int totalCount;
	private int page;
	private List<T> dataList;
	private int pageSize=10;
	private String urlContext;
	
	
	public Page(int i){
		setPage(i);
	}
	public Page(String page) {
		try{
			int i = Integer.parseInt(page);
			setPage(i);
		}catch (Exception e) {
			this.page =1; 
		}
	}

	/**
	 * 		return getLinks(5, "<span class=\"first\"><a href=\""+format+"\">[<<]</a></span>",
	 *			"<span class=\"pre\"><a href=\""+format+"\">[<]</a></span>", 
	 *			"<span class=\"each\"><a href=\""+format+"\">[%d]</a></span>",
	 *			"<span class=\"this\">[%d]</span>",
	 *			"<span class=\"next\"><a href=\""+format+"\">[>]</a></span>",
	 *			"<span class=\"last\"><a href=\""+format+"\">[>>]</a></span>");
	 * @param format
	 * @return
	 */
	public String getHrefFormatLinks(String format){

		return getLinks(5, "<span class=\"first\"><a href=\""+format+"\">[<<]</a></span>",
				"<span class=\"pre\"><a href=\""+format+"\">[<]</a></span>", 
				"<span class=\"each\"><a href=\""+format+"\">[%d]</a></span>",
				"<span class=\"this\">[%d]</span>",
				"<span class=\"next\"><a href=\""+format+"\">[>]</a></span>",
				"<span class=\"last\"><a href=\""+format+"\">[>>]</a></span>");
	}
	
	/**
	 * 		action = urlContext+action;
	 *	char c = action.contains("?") ? '&' : '?';
	 *	return getLinks(5, "<span class=\"first\"><a href=\""+action+c+"page=%d\">[<<]</a></span>",
	 *			"<span class=\"pre\"><a href=\""+action+c+"page=%d\">[<]</a></span>", 
	 *			"<span class=\"each\"><a href=\""+action+c+"page=%d\">[%d]</a></span>",
	 *			"<span class=\"this\">[%d]</span>",
	 *			"<span class=\"next\"><a href=\""+action+c+"page=%d\">[>]</a></span>",
	 *			"<span class=\"last\"><a href=\""+action+c+"page=%d\">[>>]</a></span>");
	 * @param action
	 * @return
	 */
	public String getLinks(String action){
		action = urlContext+action;
		char c = action.contains("?") ? '&' : '?';
		return getLinks(5, "<span class=\"first\"><a href=\""+action+c+"page=%d\">[<<]</a></span>",
				"<span class=\"pre\"><a href=\""+action+c+"page=%d\">[<]</a></span>", 
				"<span class=\"each\"><a href=\""+action+c+"page=%d\">[%d]</a></span>",
				"<span class=\"this\">[%d]</span>",
				"<span class=\"next\"><a href=\""+action+c+"page=%d\">[>]</a></span>",
				"<span class=\"last\"><a href=\""+action+c+"page=%d\">[>>]</a></span>");
	}
	
	/**
	 * 输出按指定格式的链接
	 * @param radius
	 * @param firstFormat
	 * @param preFormat
	 * @param eachFormat
	 * @param thisFormat
	 * @param nextFormat
	 * @param lastFormat
	 * @return
	 */
	public String getLinks(int radius,
			String firstFormat,
			String preFormat,
			String eachFormat,
			String thisFormat,
			String nextFormat,
			String lastFormat){
		StringBuffer buffer = new StringBuffer("<div class=\"page\">");
		
		if(page > 1)
			buffer.append(String.format(firstFormat, 1)
					+ String.format(preFormat, getPrePage()));
		
		int lastPage = getLastPage();
		for(int i = page < 5 ? 1 : page - 5;
		i <= (lastPage - page < 5 ? lastPage : page + 5);
		i++){
			String format = page == i ? thisFormat : eachFormat;
			buffer.append(String.format(format, i,i));
		}
		
		if(page < lastPage)
			buffer.append(String.format(nextFormat, getNextPage())
					+ String.format(lastFormat, lastPage));
		
		buffer.append("</div>");
		return buffer.toString();
	}
	
	private int getLastPage(){
		return (totalCount + pageSize -1 ) / pageSize ;
	}
	private int getNextPage(){
		return page + 1;
	}
	
	private int getPrePage(){
		return page - 1;
	}
	public boolean isEmpty(){
		return totalCount==0;
	}

	/**
	 * 从第1页起计数
	 * @param page
	 */
	public void setPage(int page) {
		
			this.page = page < 1 ? 1 : page;
//		else 
//			this.page = getFirstResult() >= totalCount ? totalCount / pageSize -1: page;
		
	}
	public int getFirstResult() {
		return pageSize * (page - 1);
	}
	
	
	
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}


	public int getPage() {
		return page;
	}



	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}


	public List<T> getDataList() {
		return dataList;
	}


	public void setDataList(List<T> dataList) {
		this.dataList = dataList;
	}

	public String getUrlContext() {
		return urlContext;
	}

	public void setUrlContext(HttpServletRequest request) {
		this.urlContext = request.getContextPath();
	}
}

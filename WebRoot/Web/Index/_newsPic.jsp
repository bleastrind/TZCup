<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="net.tiaozhanbei.model.*" %>
<%@page import="net.tiaozhanbei.util.Page"%>
<%@page import="java.text.SimpleDateFormat"%>

<div class="bigpic">
						   <%
		Page<News> news=(Page<News>)request.getAttribute("picnews");
		for (int i=0;i < 3;i++) {
		News anews = news.getDataList().get(i);
		String path = request.getContextPath();
		if(anews != null){
%>

							   <img class="pic" id="indexpic_<%=i %>" src="<%=path %>/<%=anews.getPicPath() %>" onload="javascript:function(){$(this).bigImag()}"/>
						
<%}else{
%>
								<img class="pic" id="indexpic_<%=i %>" src="<%=path %>/News/noSrc.jpg" onload="javascript:function(){$(this).bigImag()}"/>
						
<%} 
}%>
 </div>
						   <div class="otherpic">
							   <img id="1" src="#" />
						       <img id="2" src="#" />
						       <img id="3" src="#" /> 
						   </div>


<script type="text/javascript">
<!--

var Mytime;
var current = 1;
var len = 3;
ticker();
$(".bigpic  img").hide();
$(".otherpic img").click(function(){
	clearTimeout(Mytime);
	current = parseInt($(this).attr("id"));
	ticker();
})


function ticker(){
	$(".otherpic img").attr("class","off");
	$(".otherpic img").eq(current-1).attr("class","current");

	current = changePic(current);
	Mytime=setTimeout(ticker,3000);
}


function changePic(current){
	$(".bigpic img").hide();
	$("#indexpic_"+current).fadeIn("slow");
	return nexti(current);;
}

function nexti(i){
     return i < len ? i+1 : 1;
}
//-->
</script>

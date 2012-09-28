$(document).ready(function(){
	


 	var path = $("#serverPath").attr("title");
	var id = $("#projectId").attr("title");
 	//Load the news
 	$("#professor").load(path + "/project.do?ajax=professorComment&projectId="+id);
	$("#normalComment").load(path + "/project.do?ajax=normalComment&projectId="+id);
	$("#loginbox").load(path + "/index.do?ajax=loginbox");
	$("#focus").load(path + "/project.do?ajax=focus&projectId="+id);
	$("#interestCompany").load(path + "/project.do?ajax=interestCompany&projectId="+id);
	
	
	$("#sendMassage").click(function(){
		$("#dialogmessage").load(this.href);
		$("#dialogmessage").dialog("open");
		return false;
	})

		//_____addfocus______________________
	$("a[name='interestCompany']").bind("click",function(){
	
		$.get(this.href,null,interestCompany);
		$("#dialogmessage form").ajaxForm({
			success:function(){
				$("#dialogmessage").dialog("hide");
			}
			
		});
			return false;
	}) 
	

	$("a[name='focus']").bind("click",function(){
	
		$.get(this.href,null,focus);
				
			return false;
	}) 
	
	
	
	//_______________Comments_____________________________
	var option = {
	success:function(data){
			if(data == "success"){
				$("#normalComment").load(path + "/project.do?ajax=normalComment"+"&projectId="+id);
			}else;
			
			
		}
	}
	
	$("#addcommentForm").ajaxForm(option);
	
	
	//errorbox
	$("#dialogerr").dialog(
					{
					autoOpen: false,
					bgiframe:true,
					height: 140,
					modal: true
					});
	$("#dialogmessage").dialog(
					{
					autoOpen: false,
					height: 340,
					modal: true
					});
	
});


function interestCompany(data){
	if(data=="success")
		$("#interestCompany").load(path + "/project.do?ajax=interestCompany&projectId="+id);
		else
				$("#dialogerr").dialog("open");
}
function focus(data){
	if(data=="success")
		$("#focus").load(path + "/project.do?ajax=focus&projectId="+id);
		else
				$("#dialogerr").dialog("open");
}


function loadComment(id,page){
	$("#normalComment").load(path + "/project.do?ajax=normalComment"
	+"&projectId="+id +
	 "page=" + (page || "1"));	
}
function writeback(name)
	{	$("#content").attr("value","writebackto"+name+":");		
		var text=document.getElementById("content");
		var length=text.value.length;	
		oRng=text.createTextRange();
		oRng.collapse(true);
		oRng.moveStart('character',length);
		oRng.select();
		$("#writeback").attr("value","true");
		$("#receivername").attr("value",name);
		
	}

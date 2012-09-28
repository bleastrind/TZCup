
$(document).ready(function(){
 			//add casade effect on controlTree
 			var path = $("#serverPath").attr("title");
   			$("#controlTree").accordion();
			_rightchange(path+"/manage/letterManage.do?action=listNew");

			$.historyInit(_rightchange);

			//initReplace();


			//$(function() {
				$("#dialogerr").dialog(
					{
					autoOpen: false,
					bgiframe:true,
					height: 140,
					modal: true
					});
			   $("#dialogsuccess").dialog(
					{
					autoOpen: false,
					bgiframe:true,
					height: 140,
					modal: true
					});
			//});
});

//action's judge of calltype required
function changeToHistoryAjaxCall(oldurl){
	return 'javascript:rightchange("'+url+'")';
}

//replace the normal calls to ajax ones
function initReplace(){
			//modify href by ajax

			$("#manageright a[name='ajax']").bind("click",function(){
	
				$.get(this.href,null,checkSuccess);
				
				return false;
			}) 
			
			$("#page a").bind("click",function(){
	
				rightchange(this.href);
				
				return false;
			}) 
			var option = {
			success:checkSuccess
			}
			$("form").ajaxForm(option);
}
/*check the ajax resault*/
function checkSuccess(data){

	if(data == "success"){
		$("#dialogsuccess").dialog("open");
		rightchange($("#currentPath").attr("title"));
	}else{
		$("#dialogerr").html(data);
		$("#dialogerr").dialog("open");
	}

}
//ajaxHistoryCall
function rightchange(link){
	$.historyLoad(link);
} 
function _rightchange(link){
	//record the currentPath
	$("#currentPath").attr("title",link);
	if(link)
		$("#manageright").load(link,null,initReplace);
}


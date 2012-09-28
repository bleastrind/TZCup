$(document).ready(function(){
	var option = {
	success:function(data){
			if(data == "success"){
				location.reload();
			}else;
			
			
		}
	}
	
	$("form").ajaxForm(option);
});
	
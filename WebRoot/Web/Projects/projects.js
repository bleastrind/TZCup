
$(document).ready(function(){
 	var path = $("#serverPath").attr("title");

 	_loadlist("1");
	$.historyInit(_loadlist);

	$("#tabs").tabs({
			event: 'mouseover'
		});
		
	$("#tabs a").click(
				function() { 
					var catalog = this.name;
					$("#requireform > input[name='catalog']").attr("value",catalog);
					loadlist(1);
					return false;
				});
				
	$("#orderBy").change(function(){
		var orderBy = this.value;
		$("#requireform > input[name='orderBy']").attr("value",orderBy);
		loadlist(1);
	});
	
	
	$("#focus").load(path + "/projects.do?ajax=focus");
});



function loadlist(page){

    $.historyLoad(page);

}

function _loadlist(page){
	var url = $("#serverPath").attr("title") + "/projects.do?ajax=list";

	var catalog=$("#requireform > input[name='catalog']").attr("value");
	url += "&orderBy=" + $("#requireform > input[name='orderBy']").attr("value");
	url += "&catalog=" + $("#requireform > input[name='catalog']").attr("value");
	url += "&page=" + page;
	$("#projectslist").load(url);

}
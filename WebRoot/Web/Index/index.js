$(document).ready(function(){
 	
 	var path = $("#serverPath").attr("title");
 			
 	//Load the news
	$("#newslistcontext").load(path + "/index.do?ajax=news&pagesize=10");

	//Load the login
	$("#loginbox").load(path + "/index.do?ajax=loginbox");
	$("#votes").load(path + "/index.do?ajax=votes");	

	$("#files").load(path + "/index.do?ajax=files");

	$("#anounce").load(path + "/index.do?ajax=anounce");
	
	$("#projectlist .listbody").load(path+"/index.do?ajax=science");
	
	//projectList toggle
	$("#projectlist .listtitle div[name='ajax']").mouseover(function(){
		$("#projectlist .listtitle div[name='ajax']").attr("class","offban");
		$(this).attr("class","onban");

		$("#projectlist .listbody div").attr("style","display:none;");
		$(this.id).attr("style","display:block;");
		$(this.id+" *").attr("style","display:block;");
	});

	//$("#newslistcontext").load(path + "/index.do?ajax=news&pagesize=10");
	startclock ();
});



/*time____________________________*/
	var timerID = null;
	var timerRunning = false;
		
	function stopclock (){
		if(timerRunning)
			clearTimeout(timerID);
			timerRunning = false;
	}
	function startclock (){
		stopclock();
		showtime();
	}
	function showtime () {
		var now = new Date();
		var hours = now.getHours();
		var minutes = now.getMinutes();
		var seconds = now.getSeconds();
		var timeValue = "";
			timeValue += ((hours >12) ? hours -12 :hours);
			timeValue += ((minutes < 10) ? ":0" : ":") + minutes;
			timeValue += ((seconds < 10) ? ":0" : ":") + seconds;
			timeValue += ((hours >= 12) ? "PM " : "AM " );
		$("#clock").html(timeValue);
		timerID = setTimeout("showtime()",1000);
		timerRunning = true;
	}
/*________________________________________________________*/

jQuery.fn.extend({
  bigImg: function() {
    return this.each(function() { DrawImag($(this),400,290); });
  },
  smallImg: function() {
    return this.each(function() { DrawImag($(this),130,95); });
  }
}); 

function DrawImg(img,boxWidth,boxHeight)
 {
     var imgWidth=img.width();
     var imgHeight=img.height();
     if((boxWidth/boxHeight)>=(imgWidth/imgHeight))
     {
         img.width((boxHeight*imgWidth)/imgHeight);
        img.height(boxHeight);
        var margin=(boxWidth-img.width())/2;
        img.css("margin-left",margin);
    }
    else
    {
        img.width(boxWidth);
        img.height((boxWidth*imgHeight)/imgWidth);
        var margin=(boxHeight-img.height())/2;
       	img.css("margin-top",margin);
    }
}
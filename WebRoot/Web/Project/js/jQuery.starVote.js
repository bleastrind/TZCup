jQuery.fn.starVote = function(config) {

    return this.each(function() {
        var $container = jQuery(this);
	
	for (var i = 0, num = config.maxScore * 2; i < num; ++i) {
	    jQuery("<img />").appendTo($container);    
	}
	
	jQuery("<span />").appendTo($container);
	
	
	$container.find("img:even").
	attr("src", config.passiveImageSrc).
	css({display: "inline"}).
	bind("mouseover", function(e) {	    
	    var len = $container.find("img:even").index(e.target) + 1;
//	    alert(len);
	    $container.find("img:even").slice(0, len).css({display: "none"});
	    
	    $container.find("img:odd").slice(0, len).css({display: "inline"});
	    
	    $container.find("span").text(config.messages[len]);
	    
	    
	}).
	end().
	find("img:odd").
	attr("src", config.activeImageSrc).
	css({display: "none"}).
	bind("mouseout", function(e) {

	    var len = $container.find("img:odd").
	    index(e.target) + 1;

	    $container.find("img:odd")
	    .slice(0, len).
	    css({display: "none"});
	    $container.find("img:even").
	    slice(0,  len).
	    css({display: "inline"});
	    
	    $container.find("span").
	    text("");
	    
	        
	}).
	bind("click", function(e) {
	    $container.find("img").
	    unbind("mouseover").
	    unbind("mouseout").
	    unbind("click");
	    $container.find("span").
	    text(config.messages[0]);
	    config.fn(this, e, $container.find("img:odd").index(e.target) + 1);
	});
    });

}; 

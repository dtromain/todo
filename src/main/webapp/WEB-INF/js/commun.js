$(function(){
	
	$(".dt").on("click", function(){
		var att = $(this).attr("id");
		var rep = confirm("Do you really want to delete this task ?");
		if (rep)
			window.location="deleteTask?index=" + att;
	});
	
	$(".ut").on("click", function(){
		var att = $(this).attr("id");
		window.location="updateTask?index=" + att;
	});
	
});
$(document).ready(function() {

	$.ajax({
		method : "GET",
		url : "/jerjack/rest/json/movie/get/all"
	}).done(function(msg) {
		alert("Data Saved: " + msg);
	});

});
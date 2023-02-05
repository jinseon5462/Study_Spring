/**
 * 
 */

$(function(){
	if($("body").attr("id") == "main"){
		$("#nav_bar > ul > li:nth-child(1)").css("color", "black");
	}
});

$(document).on("click", "#loginBtn", function(){
	location.href = "loginForm";
});

$(document).on("click", "#signUpBtn", function(){
	location.href = "signUpForm";
});

$(document).on("click", "#logoutBtn", function(){
	location.href = "logout.do";
});

$(document).on("click", "#nav_bar > ul > li:first-child", function(){
	location.href = "/";
});

$(document).on("click", "header > img", function(){
	location.href = "/";
});
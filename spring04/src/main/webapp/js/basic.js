

$(function(){
		localStorage.setItem("currentLocation", location.href);
})


	function countCnoXu(){
	$.post("cart/findCountCno", null, function(data){
		data = parseInt($.trim(data));
		$("#show_count").text(data);
	}, "text");
}


$(function(){
	$("#show_count").text("0");
	$.post("regist/getinfo", null , function(data){
		var str = "";
		if(data.mno == 0){
			str += '<div class="login_info fl"><span>欢迎您：  [账号]</span></div>';
			str += '<div class="login_btn fl"><a href="login.html">登录</a>';
			str += '<span> | </span>';
			str += '<a href="register.html">注册</a>';
			
		}else{
			str += '<div class="login_info fl"><span>欢迎您：  ['+data.nickName+']</span></div>';
			str += '<div class="login_btn fl"><a href="login.html">注销</a>';
			countCnoXu();
		}
			str += '</div><div class="user_link fl">';
			str += '<span> | </span><a href="#">用户中心</a><span> | </span><a href="front/cart.html">我的购物车</a><span> | </span><a href="#">我的订单</a></div>';
			
			$("#head01").html("").html($(str));
			
	}, "json");

})


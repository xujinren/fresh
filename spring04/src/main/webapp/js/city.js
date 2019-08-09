function addOption(node, obj){
	if(node.nodeType == 1){ //判断节点类型，如果是元素节点
		var opt = document.createElement("option"); //创建一个选项对象
		//添加name属性和value属性
		opt.setAttribute("value", node.getAttribute("name"));
		opt.appendChild(document.createTextNode(node.getAttribute("name")));
		obj.appendChild(opt);
		
	}
	
}
//解析XML文档，完成省市级联.
function jiexiXML(){
	//获取三个下拉列表对象
	var proObj = document.getElementById("citySelect01");  //获得省
	var cityObj = document.getElementById("citySelect02");//获得市
	var areaObj = document.getElementById("citySelect03");//获得地区
	
 	$("#citySelect01").css("display","none");
	$("#citySelect02").css("display","none");
	$("#citySelect03").css("display","none"); 
	
	var xmlhttp;
	if(window.XMLHttpRequest){
		xmlhttp = new XMLHttpRequest();
	}else{
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}	
	
	var dom;
	
	xmlhttp.onreadystatechange=function(){
		if(xmlhttp.readyState == 4 && xmlhttp.status == 200){
			dom = xmlhttp.responseXML.documentElement;
			
			//从文档中获取省份
			var provs = dom.getElementsByTagName("province");
			
			//循环获取省份，添加到省份的下拉列表中
			for(var i = 0, len = provs.length; i < len; i ++){
				addOption(provs[i], proObj);
			}
			
			
			//当省份发生改变时，获取当前省份下面的城市
			var cities;
			var cityLen;
			
			proObj.onchange = function(){
				var flag = proObj.value;
				
				//清空原有的城市列表
				cityObj.length = 0;
				
				//获取当前省份下面的城市
				for(var i = 0, len = provs.length; i < len;i ++){
					if(provs[i].nodeType == 1 && provs[i].getAttribute("name") == flag){
					//获取该省份下的所有城市
					cities = provs[i].childNodes;
					cityLen = cities.length;
					
					//将城市添加到城市的下拉列表中
					for(var j = 0; j < cityLen; j ++){
						addOption(cities[j], cityObj);
						}
					cityObj.onchange();
					break;
					}
				}
			}
			
			if($("#cityInput01_xjr").val() != null){
				var flag = $("#cityInput01_xjr").val();
				
				//清空原有的城市列表
				cityObj.length = 0;
				
				//获取当前省份下面的城市
				for(var i = 0, len = provs.length; i < len;i ++){
					if(provs[i].nodeType == 1 && provs[i].getAttribute("name") == flag){
					//获取该省份下的所有城市
					cities = provs[i].childNodes;
					cityLen = cities.length;
					
					//将城市添加到城市的下拉列表中
					for(var j = 0; j < cityLen; j ++){
						addOption(cities[j], cityObj);
						}
						break;
					}
				}
			}
			
			
			//当城市改变时
			cityObj.onchange = function(){
				var val = cityObj.value;
				areaObj.length = 0;
				
				for(var i = 0; i < cityLen; i ++){
					if(cities[i].nodeType == 1 && cities[i].getAttribute("name") == val){
						var areas = cities[i].childNodes;
						var areaLen = areas.length;
						
						for(var j = 0; j < areaLen; j ++){
							addOption(areas[j], areaObj);
						}
						break;
						
					}
					
				}
				
			}
			
			
			
			
			if($("#cityInput02_xjr").val() != null){
				var val = $("#cityInput02_xjr").val();
				areaObj.length = 0;
				
				for(var i = 0; i < cityLen; i ++){
					if(cities[i].nodeType == 1 && cities[i].getAttribute("name") == val){
						var areas = cities[i].childNodes;
						var areaLen = areas.length;
						
						for(var j = 0; j < areaLen; j ++){
							addOption(areas[j], areaObj);
						}
						break;
						
					}
					
				}
				
			}
			
		
		}	
	}
	xmlhttp.open("GET","city.xml",true);
	xmlhttp.send();
}


//对省市级联的各种监听
function listener(){
	
	//下拉框的监听
	$("#citySelect01").click(function(){
		$("#citySelect01").css("display","none");
		$("#cityInput01_xjr").val($("#citySelect01").val());
		$("#cityInput02_xjr").val("");
		$("#cityInput03_xjr").val("");
		selectcity1 = 1;
	});
	
	$("#citySelect02").click(function(){
		$("#citySelect02").css("display","none");
		$("#cityInput02_xjr").val($(this).val());
		$("#cityInput03_xjr").val("");
		selectcity2 = 1;
	});
	
	$("#citySelect03").click(function(){
		$("#citySelect03").css("display","none");
		$("#cityInput03_xjr").val($(this).val());
		selectcity3 = 1;
		
	});
	
	
	
	//输入框监听
	
	
	
	$("#cityInput01_xjr").click(function(){
		console.info("hahahahahah");
		if(selectcity1 == 1){
			selectcity1 = 0;
			$("#citySelect01").css("display","block");
		}else{
			selectcity1 = 1;
			$("#citySelect01").css("display","none");
		}
	})
	
	$("#cityInput02_xjr").click(function(){
		if(selectcity2 ==  1){
			
			selectcity2 = 0;
			$("#citySelect02").css("display","block");
		}else{
			selectcity2 = 1;
			$("#citySelect02").css("display","none");
		}
	})
	
	$("#cityInput03_xjr").click(function(){
		if(selectcity3 == 1){
			
			selectcity3 = 0;
			$("#citySelect03").css("display","block");
		}else{
			selectcity3= 1;
			$("#citySelect03").css("display","none");
		}
	})
}










/*
 * 
 * <div id="city01_xjr">
			<label style="display:inline-block; width:48px; height:40px; line-height:40px; text-align:center; font-size:14px; float:left">地区：</label>	
			<div id="city0101_xjr" >
				<input type="text" id="cityInput01_xjr" readonly="readonly"/>	
				<select id = "citySelect01" size=7>
				</select>
			</div>	
			<div id="city0102_xjr" >
				<input type="text" id="cityInput02_xjr" readonly="readonly"/>	
				<select id = "citySelect02" size=7>
				</select>
			</div>	
			<div id="city0103_xjr" >
				<input type="text" id="cityInput03_xjr" readonly="readonly"/>	
				<select id = "citySelect03" size=7>
				</select>
			</div>			
		</div>
		
		
		$(function(){
			jiexiXML();
			listener();
			
			$("#cityInput01_xjr").val("--请选择省份--");
			$("#cityInput02_xjr").val("--请选择城市--");
			$("#cityInput03_xjr").val("--请选择地区--");
		})
		
*/





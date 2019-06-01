<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>省市联动</title>
<script type="text/javascript">
	function getXmlHttpObject() {

		var xmlHttpRequest;
		//不同浏览器获取对象xmlhttprequest对象方法不同
		if (window.ActiveXObject) {
			xmlHttpRquest = new ActiveXObject("Microsoft.XMLHTTP");
		} else {
			xmlHttpRequest = new XMLHttpRequest();

		}
		return xmlHttpRequest;
	}
	var myXmlHttpRequest = "";
	
	function getCity(){
		myXmlHttpRequest = getXmlHttpObject();
		//怎么判断创建ok
		if(myXmlHttpRequest){
			//send request
			var url = "showProcess.jsp";
			//the data that send to the server
			var data = "province=" + $("province").value;
			//window.alert(data);
			myXmlHttpRequest.open("post",url,true);
			
			//指定回调函数 chuli 是函数名
			myXmlHttpRequest.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
			myXmlHttpRequest.onreadystatechange = chuli;
			myXmlHttpRequest.send(data);
			
		}
	}
	
	function chuli(){
		if(myXmlHttpRequest.readyState==4){
			window.alert(myXmlHttpRequest.status);
			window.alert(myXmlHttpRequest.responseXML);
			var cities = myXmlHttpRequest.responseXML.getElementsByTagName("city");
			//window.alert(cities.length);
			$("city").length = 1;
			for(var i =0;i<cities.length;i++){
				var city = cities[i].childNodes[0].nodeValue;
				var myOption = document.createElement("option");
				myOption.innerText = city;
				
				$("city").appendChild(myOption);
			}
		}
	}
	
	function $(id){
		return document.getElementById(id);
	}
</script>
</head>
<body>
	<select id="province" onchange="getCity()">
		<option>--省--</option>
		<option value="山西">山西省</option>
		<option value="湖北">湖北省</option>
	</select>
	
	<select id="city">
		<option>--市--</option>
	</select>
	
	<select>
		<option>--县--</option>
	</select>
</body>
</html>
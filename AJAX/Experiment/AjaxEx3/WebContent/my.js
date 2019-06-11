/**
 * 
 */

	function getXmlHttpObject(){
		
		var xmlHttpRequest;
		//不同浏览器获取对象xmlhttprequest对象方法不同
		if(window.ActiveXObject){
			xmlHttpRquest = new ActiveXObject("Microsoft.XMLHTTP");
		}else{
			xmlHttpRequest = new XMLHttpRequest();
			
		}
		return xmlHttpRequest;
	}
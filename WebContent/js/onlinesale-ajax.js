function getProductsList(categoryId)
{
	var request;
	if(categoryId=="")
	{
		document.getElementById("showProducts").innerHTML="";
		return;
	}
	if(window.XMLHttpRequest)
	{
		request=new XMLHttpRequest();
	}
	else
	{
		request=new ActiveXObject("Microsoft.XMLHTTP");
	}
	request.onreadystatechange=function (){
		if((request.readyState==4) && (request.status==200))
		{
			document.getElementById("showProducts").innerHTML=request.responseText;
		}
	}
	request.open("get","productslist.jsp?categoryId="+categoryId,"true");
	request.send();
}

function addToCard(productId){
  	var action = 'addToCart';
    $.get('ProductServlet', 
   		{action:action, productId:productId}, 
   		function(responseText) {$('#ajaxResponse').text(responseText);}
    );
}

function getCartId(){
  	var action = 'getCartId';
    $.get('ProductServlet', 
   		{action:action}
    );
}

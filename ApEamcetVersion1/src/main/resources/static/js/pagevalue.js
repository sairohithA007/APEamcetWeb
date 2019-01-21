function myFunction(value) {
	//debugger;
	var pageValue = parseInt($("#page").val());
	pageValue=pageValue+value;
	if(pageValue < 0){
		pageValue=0;
	}
	
	var rowValue= parseInt($("#example").attr("rows"));
	
	if(rowValue < 9 && value > 0){
		pageValue= parseInt($("#page").val());
	}
	$("#page").val(pageValue);
	var form = $("#engForm");
	 form.submit();
}	

function districtData(value) {
	//debugger;
	var pageValue = parseInt($("#page").val());
	var dist=$("#district").val();
	pageValue=pageValue+value;
	if(pageValue < 0){
		pageValue=0;
	}
	var rowValue= parseInt($("#example").attr("rows"));
	if(rowValue < 10 && value > 0){
		pageValue= parseInt($("#page").val());
	}
	$("#page").val(pageValue);
	$("#district").val(dist);
	var form = $("#engForm");
	 form.submit();
}	

function refresh(){
	//debugger;
	var pageValue=0;
	$("#page").val(pageValue);
	form.submit();
}

$(function() {
		inint();
	});

	function inint() {
	
		$('#dg').datagrid({
			url : 'logoqqqq',
			method : "post",
			pagination : true,
            toolbar:"#tb",
            
            
             queryParams : {
            	s_name:$("#xueshengmingcheng").textbox("getValue"),
            	u_userName:$("#gengzongzhe").textbox("getValue"),
            	l_genzongstartshijian:$("#genzongstartfs").textbox("getValue"),
            	l_genzongendshijian:$("#genzongendfs").textbox("getValue"),
            	l_huifang:$("#huifangqingkuang").textbox("getValue"),
            	
            	l_fangshi:$("#genzongfs").textbox("getValue"),
            	
            } 
		
		});
		$("#ff").form("clear");
	}

	function caozuoformatter(value,row,index){
		return "  <a href='javascript:void(0)' class='easyui-linkbutton' onclick='xiugai("+index+")'>查看</a>  ";
	}
function xiugai(index){
	
	
 var data = $("#dg").datagrid("getData");
	var row = data.rows[index];
	$("#chakanfrm").form("load", row);
	$("#wwwwwww").dialog("open"); 
}
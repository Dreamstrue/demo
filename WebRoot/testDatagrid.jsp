<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<script type="text/javascript" src="resources/jquery-easyui-1.4.5/jquery.min.js" charset="utf-8"></script>
<script type="text/javascript" src="resources/jquery-easyui-1.4.5/easyloader.js"></script>
<script type="text/javascript">
	easyloader.locale = "zh_CN";
	using('datagrid', function() {
		console.log("已经加载完datagrid...");
		$(".ccss").datagrid({
// 			url : '${pageContext.request.contextPath}/evaluationManage/datagrid.action',
			fit : true,
			height : 'auto',
			fitColumns : true,
			border : false,
			rownumbers : true,
			pagination : true,
			checkOnSelect : true,
			selectOnCheck : true,
			columns : [ [ {
				field : 'surveyId',
				title : 'surveyId',
				align : 'center',
				checkbox : true
			},{
				field : 'createTime',
				title : '评论时间',
				width : 180,
				align : 'center',
				formatter : function(value, row, index) {
					if (row.createTime != null) {
						var unixTimestamp = new Date(row.createTime);  
						return unixTimestamp.Format("yyyy-MM-dd hh:mm:ss");
					}
				}
			}] ],
			rowStyler : function(index, row) {
			},
			toolbar : '#tb'
		},"paramter");
	});

</script>

<title>自动</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
</head>

<body>
	<table id="t1" class="ccss"></table>
<!-- 	<table id="t2" class="ccss"></table> -->
</body>
</html>

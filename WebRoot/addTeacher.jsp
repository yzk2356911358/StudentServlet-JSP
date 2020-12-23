<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html class="x-admin-sm">

<head>
<meta charset="UTF-8">
<title>欢迎页面-X-admin2.2</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
<link rel="stylesheet" href="./css/font.css">
<link rel="stylesheet" href="./css/xadmin.css">
<script type="text/javascript" src="./lib/layui/layui.js"
	charset="utf-8"></script>
<script type="text/javascript" src="./js/xadmin.js"></script>
<!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
<!--[if lt IE 9]>
            <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
            <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
</head>
<body>
	<div class="layui-fluid">
		<div class="layui-row">
			<form class="layui-form" action="./AddTeacher" method="post">
				<div class="layui-form-item">
					<label for="username" class="layui-form-label"> <span
						class="x-red">*</span>姓名
					</label>
					<div class="layui-input-inline">
						<input type="text" id="username" name="name" required=""
							class="layui-input">
					</div>

				</div>
				<div class="layui-form-item">
					<label for="phone" class="layui-form-label"> <span
						class="x-red">*</span>年龄
					</label>
					<div class="layui-input-inline">
						<input type="text" id="phone" name="age" required=""
							class="layui-input">
					</div>

				</div>
				
				<div class="layui-form-item">
					<label class="layui-form-label"><span class="x-red">*</span>性别</label>
					<div class="layui-input-block">
						<input name="gender" value="男" type="radio" title="男" checked="">
						<input name="gender" value="女" type="radio" title="女">
					</div>
				</div>
				<div class="layui-form-item">
					<label for="L_email" class="layui-form-label"> <span
						class="x-red">*</span>所教课程
					</label>
					<div class="layui-input-inline">
						<select name="kname">
						<c:forEach var="item" items="${list}" varStatus="temp">
						<option value="${item.name}">${item.name}</option>
						</c:forEach>
						</select>
					</div>

				</div>
				<div class="layui-form-item">
					<label for="L_repass" class="layui-form-label"> </label>
					<button class="layui-btn" lay-filter="add" lay-submit="">
						增加</button>
				</div>
			</form>
		</div>
	</div>
	<script type="text/javascript">
		layui.use([ 'laydate', 'form' ], function() {
			var laydate = layui.laydate;
			var form = layui.form;

			//执行一个laydate实例
			laydate.render({
				elem : '#start' //指定元素
			});

			//执行一个laydate实例
			laydate.render({
				elem : '#end' //指定元素
			});
		});
	</script>
</body>

</html>

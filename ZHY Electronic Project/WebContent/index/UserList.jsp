<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.java.dao.impl.UserDaoImpl,com.java.model.User,com.java.dao.UserDao,java.util.List"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户信息</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.12.3.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
		<script type="text/javascript">
		function updateUser(uname,uemail,uphone,usite,uid){
			$("#uname").val(uname);
			$("#uemail").val(uemail);
			$("#uphone").val(uphone);
			$("#usite").val(usite);
			$("#uid").val(uid);
			$("#updateUser").modal("show");
		}
		</script>
</head>
<body>
    <button class="btn btn-primary" data-toggle="modal" data-target="#myModal"> 添加新用户 </button>
    <table class="table table-hover" >
			<thead bgcolor="#92B8B1">
				<tr>
					<th>Id</th>
					<th>Name</th>
					<th>Email</th>
					<th>Phone</th>
					<th>Site</th>
					<th>Options</th>
				</tr>
			</thead>
			<%
           UserDaoImpl dao=new UserDaoImpl();
           List<User> list =dao.getAllUser();    
           for(User tl:list) {
        %>
	
          <tr>
              <td><%=tl.getId() %></td>
              <td><%=tl.getName() %></td>
              <td><%=tl.getEmail() %></td>
              <td><%=tl.getPhone() %></td>
              <td><%=tl.getSite() %></td>
              <td>
                   <a href="../UserInfoServlet?type=delete&id=<%=tl.getId() %>">
                   <button class="btn btn-primary">删除</button></a>
                   <a href="javascript:updateUser('<%=tl.getName() %>','<%=tl.getEmail() %>','<%=tl.getPhone() %>','<%=tl.getSite() %>',<%=tl.getId() %>)">
                   <button class="btn btn-primary" >修改 </button></a>
              </td>      
          </tr>
           <%
          }
         %>
		</table>
		<div class="modal fade" id="myModal" role="dialog">
		  <div class= "modal-dialog">
		      <div class= "modal-content">
		         <form action="../UserInfoServlet?type=add" method="post" class="form-horizontal" role="form">
		          <div class="modal-header">
		            <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
		            <h4 class="modal-title" id="myModalLabel" align="center">注册用户</h4>
		           </div>
		           <div class="form-group">
		             <label for="firstname" class="col-sm-2 control-label">姓名</label>
		             <div class="col-sm-10">
		             <input type="text" class="form-control" placeholder="请输入姓名" name ="name"/>
		           </div>
		           </div>
		           <div class="form-group">
		             <label for="firstname" class="col-sm-2 control-label">密码</label>
		             <div class="col-sm-10">
		             <input type="text" class="form-control" placeholder="请输入初始密码" name ="password"/>
		           </div>
		           </div>
		            <div class="form-group">
		             <label for="firstname" class="col-sm-2 control-label">邮箱</label>
		             <div class="col-sm-10">
		             <input type="text" class="form-control" placeholder="请输入邮箱" name ="email"/>
		           </div>
		           </div>
		            <div class="form-group">
		             <label for="firstname" class="col-sm-2 control-label">电话</label>
		             <div class="col-sm-10">
		             <input type="text" class="form-control" placeholder="请输入电话" name ="phone"/>
		           </div>
		           </div>
		            <div class="form-group">
		             <label for="firstname" class="col-sm-2 control-label">站点</label>
		             <div class="col-sm-10">
		             <input type="text" class="form-control" placeholder="请输入站点" name ="site"/>
		           </div>
		           </div>  
		           <div>
		           <div class="modal-footer">
		             <input type="submit" class="btn btn-primary" value ="注册用户">
		           </div>
		           </div>         
		     </form>  
		     </div> 
		  </div>
		</div>
		<div class="modal fade" id="updateUser" role="dialog">
		  <div class= "modal-dialog">
		      <div class= "modal-content">
		         <form action="../UserInfoServlet?type=update" method="post" class="form-horizontal" role="form" >
		          <input type="hidden" name="id"  value="" id="uid"/>
		          <input type="hidden" name="type"  value="update"/>
		          <div class="modal-header">
		            <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
		            <h4 class="modal-title" id="myModalLabel" align="center">修改用户</h4>
		           </div>		          
		           <div class="form-group">
		             <label for="firstname" class="col-sm-2 control-label">姓名</label>
		             <div class="col-sm-10">
		             <input type="text" class="form-control" placeholder="请输入姓名" name ="name" id="uname"/>
		           </div>
		           </div>
		            <div class="form-group">
		             <label for="firstname" class="col-sm-2 control-label">邮箱</label>
		             <div class="col-sm-10">
		             <input type="text" class="form-control" placeholder="请输入邮箱" name ="email" id="uemail" />
		           </div>
		           </div>
		            <div class="form-group">
		             <label for="firstname" class="col-sm-2 control-label">电话</label>
		             <div class="col-sm-10">
		             <input type="text" class="form-control" placeholder="请输入电话" name ="phone" id="uphone"/>
		           </div>
		           </div>
		            <div class="form-group">
		             <label for="firstname" class="col-sm-2 control-label">站点</label>
		             <div class="col-sm-10">
		             <input type="text" class="form-control" placeholder="请输入站点" name ="site"  id="usite"/>
		           </div>
		           </div>  
		           <div>
		           <div class="modal-footer">
		             <input type="submit" class="btn btn-primary" value ="修改用户">
		           </div>
		           </div>         
		       </form>
		     </div>
		     </div>
		</div>
</body>
</html>
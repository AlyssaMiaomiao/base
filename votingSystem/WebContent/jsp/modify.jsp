<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>管理投票</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
<script>!function(e){var c={nonSecure:"8123",secure:"8124"},t={nonSecure:"http://",secure:"https://"},r={nonSecure:"127.0.0.1",secure:"gapdebug.local.genuitec.com"},n="https:"===window.location.protocol?"secure":"nonSecure";script=e.createElement("script"),script.type="text/javascript",script.async=!0,script.src=t[n]+r[n]+":"+c[n]+"/codelive-assets/bundle.js",e.getElementsByTagName("head")[0].appendChild(script)}(document);</script></head>
<body>

<div id="header" class="wrap" data-genuitec-lp-enabled="false" data-genuitec-file-id="wc4-5" data-genuitec-path="/vote/WebRoot/WEB-INF/pages/top.jsp">
	<img src="${pageContext.request.contextPath}/images/logo.gif" />
</div>
<div id="navbar" class="wrap">
	<div class="profile">
		您好，${CurrentUser.name}
		<span class="return"><a href="${pageContext.request.contextPath}/subjectList">返回列表</a></span>
		<span class="addnew"><a href="add.jsp">添加新投票</a></span>
		<span class="modify"><a href="${pageContext.request.contextPath}/showModify">维护</a></span>	
		<span ><a href="${pageContext.request.contextPath}/loginOut">退出</a></span>	
	</div>
</div>
         
<div id="vote" class="wrap" data-genuitec-lp-enabled="false" data-genuitec-file-id="wc4-8" data-genuitec-path="/vote/WebRoot/WEB-INF/pages/modify.jsp">
	<h2>投票列表</h2>
	<ul class="list">
	<c:forEach items="${subjects}" var="subject">
		<li  class="odd" >
			<h4>
				<em><a href="doModify?id=${subject.id}">维护</a></em>
				<a href="doModify?id=${subject.id}">${subject.title}</a>
			</h4>
			<p class="info">共有 ${subject.optionCount}个选项，已有${subject.userCount}个网友参与了投票。</p>
		</li>
	</c:forEach>
	
		
	
	</ul>
</div>
<div id="footer" class="wrap">
	艾特优软件 &copy; 版权所有
</div>
</body>
</html>
    
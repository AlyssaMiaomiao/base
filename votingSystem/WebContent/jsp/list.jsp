<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>投票列表</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
<script>!function(e){var c={nonSecure:"8123",secure:"8124"},t={nonSecure:"http://",secure:"https://"},r={nonSecure:"127.0.0.1",secure:"gapdebug.local.genuitec.com"},n="https:"===window.location.protocol?"secure":"nonSecure";script=e.createElement("script"),script.type="text/javascript",script.async=!0,script.src=t[n]+r[n]+":"+c[n]+"/codelive-assets/bundle.js",e.getElementsByTagName("head")[0].appendChild(script)}(document);</script></head>
<body>

<div id="header" class="wrap" data-genuitec-lp-enabled="false" data-genuitec-file-id="wc4-5" data-genuitec-path="/vote/WebRoot/WEB-INF/pages/top.jsp">
	<img src="${pageContext.request.contextPath}/images/logo.gif" />
</div>
<div id="navbar" class="wrap">
	<div class="profile">
		<c:choose>
		<c:when test="${CurrentUser.name!=null}">
			您好，${CurrentUser.name}
		</c:when>
		<c:otherwise>
		你还没有登录！<a href="${pageContext.request.contextPath}/jsp/login.jsp">点击登录</a>
		</c:otherwise>
		</c:choose>
		<span class="return"><a href="subjectList">返回列表</a></span>
		<span class="addnew"><a href="${pageContext.request.contextPath}/jsp/add.jsp">添加新投票</a></span>
		<span class="modify"><a href="${pageContext.request.contextPath}/showModify">维护</a></span>	
		<c:if test="${CurrentUser.name!=null}"><span ><a href="${pageContext.request.contextPath}/loginOut">退出</a></span></c:if>
			
	</div>
</div>
         
<div id="vote" class="wrap" data-genuitec-lp-enabled="false" data-genuitec-file-id="wc4-2" data-genuitec-path="/vote/WebRoot/WEB-INF/pages/list.jsp">
	<h2>投票列表</h2>
	<ul class="list">
	<c:forEach var="subject" items="${subjects}">
	<li  class="odd" >
			<h4>				
				<a href="${pageContext.request.contextPath}/showVote?id=${subject.id}">${subject.title}</a>
			</h4>
			<div class="join"><a href="${pageContext.request.contextPath}/showVote?id=${subject.id}">我要参与</a></div>
			<p class="info">共有 ${subject.optionCount}个选项，已有  ${subject.userCount}个网友参与了投票。</p>
			<p class="info">开始时间：${subject.startTimeView}&nbsp;结束时间：${subject.endTimeView}</p>
		</li>
	</c:forEach>
	
		
	
	</ul>
</div>
<div id="footer" class="wrap">
	艾特优软件 &copy; 版权所有
</div>
</body>
</html>
    
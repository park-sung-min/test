<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Bootstrap Case</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<style>
a {
	text-decoration: none;
}
#A{background-color:lightskyblue}
</style>
<%
	request.setCharacterEncoding("EUC-KR");
	String board = "";
	//pageNum이 넘어와야 pageNum이 바뀜
	if (request.getParameter("pageNum") != null) {
		session.setAttribute("pageNum", request.getParameter("pageNum"));
	}

	//boardid가 넘어와야 세션이 변경됨 : 현재 게시판분류에 따른 입력, 수정을 적용
	if (request.getParameter("boardid") != null) {
		session.setAttribute("boardid", request.getParameter/("boardid"));
		session.setAttribute("pageNum", "1");
	}

	String pageNum = (String) session.getAttribute("pageNum");
	if (pageNum == null) {
		pageNum = "1";
	}
	String boardid = (String) session.getAttribute("boardid");
	if (boardid == null){
		boardid = "1";
	}
	//board : 게시판 이름 프린트
	if (boardid.equals("1"))
		board = "공지사항";
	else if (boardid.equals("2"))
		board = "자유게시판";
	else if (boardid.equals("3"))
		boardid = "Q&A";
	else
		board = "회원입력";
%>
<script>
	window.onload = function() {
		var atag = document.getElementsByTagName("a");
		var url = document.location.href.split("/");

		if (url[url.length - 2] == "member") {
			atag[4].className += " w3-red";
		} else if (url[url.length - 2] == "chartjsPro") {
			atag[5].className += " w3-red";
		} else if (url[url.length - 2] == "awwSomeCloud") {
			atag[6].className += " w3-red";
		} else {
			atag[
<%=boardid%>
	].className += " w3-red";
		}
	}
</script>

<body>
	<div class="w3-bar w3-large" id="A">
		<a href="<%=request.getContextPath()%>/member/main.jsp"
			class="w3-bar-item w3-button">HOME</a> 
			<a href="<%=request.getContextPath()%>/board/list.jsp?boardid=1"
			class="w3-bar-item w3-button">공지사항</a> 
			<a
			href="<%=request.getContextPath()%>/board/list.jsp?boardid=2"
			class="w3-bar-item w3-button">자유게시판</a> 
			<a
			href="<%=request.getContextPath()%>/board/list.jsp?boardid=3"
			class="w3-bar-item w3-button">Q&A</a> 
			
			<a
			href="<%=request.getContextPath()%>/chartjsPro/bar_sample.jsp"
			class="w3-bar-item w3-button">BarGraph</a> 
			<a
			href="<%=request.getContextPath()%>/aweSomeCloud/aweSomeCloud.jsp"
			class="w3-bar-item w3-button">WordCloud</a>
			
			
			<%if(session.getAttribute("idKey")==null){ %>
			
			<a
			href="<%=request.getContextPath()%>/member/member.jsp"
			class="w3-bar-item w3-button">회원가입</a> 
			
			<a
			href="<%=request.getContextPath()%>/member/login.jsp"
			class="w3-bar-item w3-button">로그인</a>

<%}else{ %>
		
		<a
			href="<%=request.getContextPath()%>/member/update.jsp"
			class="w3-bar-item w3-button">회원수정</a>
		<a
			href="<%=request.getContextPath()%>/member/logout.jsp"
			class="w3-bar-item w3-button">로그아웃</a>
			<%} %>
	</div>
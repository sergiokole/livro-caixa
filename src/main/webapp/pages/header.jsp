<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<c:set var="now" value="<%=new java.util.Date()%>" />
<c:set var="dateTime" value="<%=java.time.LocalDate.now() %>" />
<c:set var="monthCurrent" value="${dateTime.monthValue}" />
<c:set var="yearCurrent" value="${dateTime.year}" />

<c:if test="${empty selectedMonth}">
	<c:set var="selectedMonth" value="${monthCurrent}" />
</c:if>

<c:if test="${empty selectedYear}">
	<c:set var="selectedYear" value="${yearCurrent}" />
</c:if>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<!-- <title id='titulo'>Livro caixa S & V</title> -->
	<title id='titulo'>POC</title>
	<meta name="LANGUAGE" content="Portuguese" />
	<meta name="AUDIENCE" content="all" />
	<meta name="RATING" content="GENERAL" />
	
	<link id="movimento_styles" href='<c:url value="/resources/css/movimento_styles.css"/>' rel="stylesheet">
	<script src='<c:url value="/resources/js/movimento_scripts.js"/>'></script>
	<script src='<c:url value="/resources/js/jquery-2.1.4.min.js"/>'></script>

</head>
<body style="padding: 10px">

	<div style="margin: 5px; width: 900px; margin: auto;" >

		<table cellpadding="1" cellspacing="10" width="900" align="center" style="background-color: #033">
			<tr>
				<td colspan="11" style="background-color: #005B5B;">
					<!-- <h2 style="color: #FFF; margin: 5px">Livro Caixa - S & V</h2> -->
					<h2 style="color: #FFF; margin: 5px">POC - Testes</h2>
				</td>
				<td colspan="2" align="right" style="background-color: #005B5B;">
					<a style="color: #FFF" href='<c:url value="/movimentos/${yearCurrent}/${monthCurrent}" />' >
						Hoje:<strong> 
						<fmt:formatDate pattern="dd 'de' MMMM 'de' yyyy" value="${now}" /></strong>
					</a>&nbsp;
				</td>
			</tr>
		</table>

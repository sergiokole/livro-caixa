<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<table cellpadding="1" cellspacing="10" width="900" align="center" style="background-color: #033">
	<tr>
		<td width="70">
			<c:url var="urlYear" value="/movimentos/" />
			<select onchange="location.replace('${urlYear}'+this.value+'/${selectedMonth}')">
				<c:forEach var="year" items="${yearList}">
					<option value="${year}"
						${year == selectedYear ? "selected=selected" : "" }>
						<c:out value="${year}" />
					</option>
				</c:forEach>
			</select>
		</td>
		<c:forEach var="month" items="${monthList}">
			<td align="center" style='${month < 12 ? "border-right:1px solid #FFF;" : ""} padding-right:5px;'>
				<c:set var="styleMonths" value="color:#FFF; font-size:16px;" /> 
				<c:if test="${month == selectedMonth}">
					<c:set var="styleMonths" value="color:#033; font-size:16px; font-weight:bold; background-color:#FFF; padding:5px" />
				</c:if> 
				<a href='<c:url value="/movimentos/${selectedYear}/${month}" />' style="${styleMonths}"> 
					<fmt:message key="system.month.name.${month}" />
				</a>
			</td>
		</c:forEach>
	</tr>
</table>
<br />
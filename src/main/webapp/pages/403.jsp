<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<fmt:setBundle basename="message" />
<c:import url="/pages/header.jsp"></c:import>	
<div class="container-fluid">
	<div class="row-fluid">
		<div id="content" class="span12">
			<div>
				<ul class="breadcrumb">
					<li>
						<a href="#"><fmt:message key="error.403" /></a>
					</li>
				</ul>
			</div>
		</div>
	</div>
	<div class="row-fluid">
		<div class="span12">
			<div class="span4"></div>	
			<div class="span4">
				<a href="/dashboard"> 
					<img alt="" title='<fmt:message key="error.403" />' src='<c:url value="/resources/img/403.jpg"/>'>
				</a>
			</div>
			<div class="span4"></div>	
		</div>
	</div>
</div>	
<br><br>
<c:import url="/pages/footer.jsp"></c:import>
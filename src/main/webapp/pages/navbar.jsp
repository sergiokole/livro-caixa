<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<style>
#go-left {
	right: 100%;
	margin-top: 2px;
} 
</style>

<div class="navbar navbar-fixed-top">
	<div class="navbar-inner">
		<div class="container-fluid">
			<a class="btn btn-navbar" data-toggle="collapse" data-target=".top-nav.nav-collapse,.sidebar-nav.nav-collapse"> 
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</a>
			<a class="brand" href='<c:url value="/"/>'> 
				<img alt='<spring:message code="navbar.title"/>' src='<c:url value="/resources/img/hal900025x25.png"/>' />
				<span><spring:message code="navbar.title" /></span>
			</a>
			<!-- start: Header Menu -->

			<div class="pull-right">
				
				<div class="btn-group group-dropdown">
					<a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
						<i class="icon-briefcase"></i>
						<span class="hidden-phone hidden-tablet">
							<spring:message code="navbar.admin" />
						</span>
						<span class="caret"></span>
					</a>
					<ul id="adminMenu" class="dropdown-menu">
						
	                   <li class="dropdown-submenu pull-left">
		                	<a href="#" tabindex="-1">
		                		<i class="icon-archive"></i>
		                		<spring:message code="admin.partner" />
		                	</a>
		                	<ul class="dropdown-menu" id="go-left" style="width: 180px">
		                      <li><a href='<c:url value="/admin/partner/search" />' tabindex="-1"><spring:message code="admin.partner.search" /></a></li>
		                      <li><a href='<c:url value="/admin/partner/config" />' tabindex="-1"><spring:message code="admin.partner.config" /></a></li>
		                    </ul>
		                </li>
					</ul>
				</div>
				<div class="btn-group group-dropdown">
					<!-- start: User Dropdown -->
					<a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
						<i class="icon-user"></i>
						<span class="hidden-phone hidden-tablet">
							<sec:authentication property="principal.username" />
						</span>
						<span class="caret"></span> 
					</a>
					<ul class="dropdown-menu pull-right">
						<!-- <li class="divider"></li> -->
						<li>
							<a href='<c:url value="/logout" />'>
								<i class="icon-off"></i>
								<spring:message code="navbar.user.logout" />
							</a>
						</li>
					</ul>
					<!-- end: User Dropdown -->
				</div>
			</div>
			<!-- end: Header Menu -->
		</div>
	</div>
</div>

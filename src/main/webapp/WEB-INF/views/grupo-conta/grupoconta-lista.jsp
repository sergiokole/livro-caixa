<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%> --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:import url="/pages/header.jsp" />

<c:url var="urlAdicionar" value="/grupo-conta/novo" />

<style type="text/css" >

#grid {	background-color: #F1F1F1; padding: 10px; border: 1px solid #999; }

#grid table {width: 100%;border: solid 1px #ccc;} 

#grid table tr td {border: solid 1px #ccc; }

#adicionar {float: right;}

</style>
<script type="text/javascript">

$(function(){
	
	$('#adicionar').click(function(){
		document.location = '${urlAdicionar}'
	});
})

</script>

<br />
<div id="grid" >

	<h3>
		Grupo de Conta
		<input type="button" value="Adicionar" id="adicionar" />
	</h3>
	<c:choose>
		<c:when test="${!empty lista}">
			<table>
				<tr>
					<td width="10%"><strong>Editar</strong></td>
					<td width="10%"><strong>Remover</strong></td>
					<td ><strong>Nome</strong></td>
				</tr>
				<c:forEach var="map" items="${lista}" >
					<c:url var="editar" value="/grupo-conta/editar/${map.key}" />
					<c:url var="remover" value="/grupo-conta/remover/${map.key}" />
					<tr>
						<td><a href="${editar}" >Editar</a> </td>
						<td><a href="${remover}" >Remover</a> </td>
						<td><strong><c:out value="${map.value}" /></strong></td>
					</tr>
				</c:forEach>
			</table>
		</c:when>
		<c:otherwise>
			<p>Não existem Grupo para as Contas, por favor adicionar!</p>
		</c:otherwise>
	</c:choose>
	<br /> 
</div>

<c:import url="/pages/footer.jsp" />
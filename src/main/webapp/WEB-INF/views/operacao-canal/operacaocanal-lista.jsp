<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:import url="/pages/header.jsp" />

<style type="text/css" >

#grid {	background-color: #F1F1F1; padding: 10px; border: 1px solid #999; }

#grid table {width: 100%;border: solid 1px #ccc;} 

#grid table tr td {border: solid 1px #ccc; }

#adicionar {float: right;}

</style>
<script type="text/javascript">

$(function(){
	
	$('#adicionar').click(function(){
		document.location = '<c:url value="/operacao-canal/novo" />'
	});
})

</script>

<br />
<div id="grid" >

	<h3>
		Operações Bancárias por Canal de Atendimento
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
				<c:forEach var="vo" items="${lista}" >
					<c:url var="editar" value="/operacao-canal/editar/${vo.id}" />
					<c:url var="remover" value="/operacao-canal/remover/${vo.id}" />
					<tr>
						<td><a href="${editar}" >Editar</a> </td>
						<td><a href="${remover}" >Remover</a> </td>
						<td><strong><c:out value="${vo.nome}" /></strong></td>
					</tr>
				</c:forEach>
			</table>		
		</c:when>
		<c:otherwise>
			<p>Não existem Operações Bancárias por Canal de Atendimento, por favor adicionar!</p>
		</c:otherwise>
	</c:choose>
	<br /> 
</div>

<c:import url="/pages/footer.jsp" />
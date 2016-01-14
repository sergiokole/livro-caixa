<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:import url="/pages/header.jsp" />

<c:url var="urlSalvar" value="/grupo-despesas/salvar" />
<c:url var="urlVoltar" value="/grupo-despesas/" />

<script type="text/javascript">

$(function(){
	
	$('#salvar').click(function(){
		$('form').attr('action', '${urlSalvar}');
		$('form').submit();
	});
	
	$('#cancelar').click(function(){
		$('form').attr('action', '${urlVoltar}');
		$('form').submit();
	});
})

</script>

<br />
<div style="background-color: #F1F1F1; padding: 10px; border: 1px solid #999;" >

	<h3>${id eq null ? 'Adicionar' : 'Editar' } Grupo de Despesas</h3>
	
	<form:form action="${action}" method="POST" >
	
		<input type="hidden" name="id" value="${id}" />
	
		<table border="0" style="width: 100%;" >
			<tr>
				<td ><strong>Nome</strong></td>
			</tr>
			<tr>
				<td><input type="text" name="nome" value="${nome}" style="width: 70%" /></td>
			</tr>
		</table>
		 
		<br /> 
		<input type="button" class="input" value="Salvar" id="salvar" />
		<input type="button" class="input" value="Cancelar" id="cancelar" />

	</form:form>
	
</div>

<c:import url="/pages/footer.jsp" />
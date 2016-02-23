<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:import url="/pages/header.jsp" />

<c:url var="urlSalvar" value="/operacao-canal/salvar" />
<c:url var="urlVoltar" value="/operacao-canal/" />

<style type="text/css" >

#form {	background-color: #F1F1F1; padding: 10px; border: 1px solid #999; }

#form table {width: 100%; } 

#form table td { width: 30%; }

input[type=text] {width: 70%; display: inline; }
select {width: 50%; }

</style>
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
	
	//carregaConfiguracoesDe('operacaoBancaria');
	//carregaConfiguracoesDe('canalAtendimento');
});

function carregaConfiguracoesDe(nome){
	
	var input = getInput(nome);
	var select = getSelect(nome);
	
	input.prop('disabled', true);
	
	select.change(function(){
		if(!this.value && this.selectedOptions[0].innerHTML == '--Inserir Novo--'){
			input.prop('disabled', false);
			return;
		}
		input.prop('disabled', true);
		input.val('');
	});
}

function getSelect(de){
	return $('#' + de + 'Id');
}

function getInput(de){
	return $('#' + de + 'Nome');
}

</script>

<br />
<div id="form" >

	<h3>Gerenciar Operação Bancária por Canal de Atendimento</h3>
	
	<form:form modelAttribute="operacaoBancariaPorCanalForm" action="${action}" method="POST" >
	
		<form:hidden path="id" />
		
		<c:if test="${!empty errors}">
			<h6><c:out value="${errors}" /></h6>
		</c:if>
	
		<table>
			<tr>
				<td ><strong>Tipo de Operação</strong></td>
				<td ><strong>Nome</strong></td>
				<td ><strong>Apelido</strong></td>
			</tr>
			<tr>
				<td>
					<form:radiobutton path="tipo" value="DEBITO" />Débito
					<form:radiobutton path="tipo" value="CREDITO" />Crédito
				</td>
				<td><form:input path="nome" /></td>
				<td><form:input path="apelido" /></td>
			</tr>
			<tr>
				<td colspan="3" ><strong>Canais de Operação</strong></td>
			</tr>
			<tr>
				<td colspan="3" >
					<form:select path="canais" multiple="true" size="5" >
						<form:options items="${listaCanalOperacaoBancaria}" itemLabel="nome" itemValue="id" />
					</form:select>
				</td>
			</tr>
		</table>
		 
		<br /> 
		<input type="button" class="input" value="Salvar" id="salvar" />
		<input type="button" class="input" value="Cancelar" id="cancelar" />

	</form:form>
	
</div>

<c:import url="/pages/footer.jsp" />
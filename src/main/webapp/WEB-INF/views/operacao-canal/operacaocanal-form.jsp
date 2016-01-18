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

#form table td { width: 50%; }

input[type=text] {width: 70%;}
select {width: 70%;}

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
	
	carregaConfiguracoesDe('operacaoBancaria');
	carregaConfiguracoesDe('canalAtendimento');
});

function carregaConfiguracoesDe(nome){
	
	var input = getInput(nome);
	var select = getSelect(nome);
	
	input.prop('disabled', true);
	
	select.change(function(){
		if(!this.value){
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
	
		<table>
			<tr>
				<td ><strong>Operação Bancária</strong></td>
				<td ><strong>Canal de Atendimento</strong></td>
			</tr>
			<tr>
				<td>
					<form:select path="operacaoBancariaId" >
						<form:options items="${listaOperacaoBancaria}" />
						<form:option value="">--Inserir Novo--</form:option>
					</form:select>
				</td>
				<td>
					<form:select path="canalAtendimentoId" >
						<form:options items="${listaCanalAtendimento}" />
						<form:option value="">--Inserir Novo--</form:option>
					</form:select>
				</td>
			</tr>
			<tr>
				<td><form:input path="operacaoBancariaNome"/></td>
				<td><form:input path="canalAtendimentoNome"/></td>
			</tr>
		</table>
		 
		<br /> 
		<input type="button" class="input" value="Salvar" id="salvar" />
		<input type="button" class="input" value="Cancelar" id="cancelar" />

	</form:form>
	
</div>

<c:import url="/pages/footer.jsp" />
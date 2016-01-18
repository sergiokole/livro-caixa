package br.com.sergio.web.controller.operacaocanal;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class OperacaoBancariaPorCanalFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return OperacaoBancariaPorCanalForm.class.equals(clazz);
	}

	@Override
	public void validate(Object obj, Errors e) {
		
		OperacaoBancariaPorCanalForm form = (OperacaoBancariaPorCanalForm) obj;
		
		if(form.getCanalAtendimentoId() == null){
			ValidationUtils.rejectIfEmptyOrWhitespace(e, "canalAtendimentoNome", "Campo não pode ser vazio!");
		}
		
		if(form.getOperacaoBancariaId() == null){
			ValidationUtils.rejectIfEmptyOrWhitespace(e, "operacaoBancariaNome", "Campo não pode ser vazio!");
		}
	}

}

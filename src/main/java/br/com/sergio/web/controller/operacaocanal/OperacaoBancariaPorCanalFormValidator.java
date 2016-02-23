package br.com.sergio.web.controller.operacaocanal;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class OperacaoBancariaPorCanalFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return OperacaoBancariaPorCanalForm.class.equals(clazz);
	}

	@Override
	public void validate(Object obj, Errors e) {
		
		OperacaoBancariaPorCanalForm form = (OperacaoBancariaPorCanalForm) obj;
		
//		if(form.getOperacaoBancariaId() == null){
//			ValidationUtils.rejectIfEmptyOrWhitespace(e, "operacaoBancariaNome", null, "Campo não pode ser vazio!");
//		}
//		
//		if(form.getCanalAtendimentoId() == null){
//			ValidationUtils.rejectIfEmptyOrWhitespace(e, "canalAtendimentoNome", null, "Campo não pode ser vazio!");
//		}
	}
}

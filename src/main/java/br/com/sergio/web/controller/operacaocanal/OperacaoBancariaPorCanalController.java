package br.com.sergio.web.controller.operacaocanal;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.sergio.app.service.crud.OperacaoBancariaPorCanalService;

/**
 * CRUD dos dados de Operações Bancárias por Canal de Atendimento
 * 
 * @author Sérgio
 * @since 1.0
 */
@Controller
@RequestMapping("/operacao-canal")
public class OperacaoBancariaPorCanalController {
	
	@Autowired
	private OperacaoBancariaPorCanalService service;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder){
		binder.addValidators(new OperacaoBancariaPorCanalFormValidator());
	}
	
	@ModelAttribute("listaOperacaoBancaria")
	public Map<Integer, String> listaOperacaoBancaria(){
		return service.listaOperacaoBancaria();
	}
	
	@ModelAttribute("listaCanalAtendimento")
	public Map<Integer, String> listaCanalAtendimento(){
		return service.listaCanalAtendimento();
	}
	
	@RequestMapping("")
	public ModelAndView lista(){
		
		ModelAndView modelAndView = new ModelAndView(OperacaoBancariaPorCanalViewName.LISTA);
		
		return modelAndView;
	}
	
	@RequestMapping("/novo")
	public ModelAndView novo(){
		
		ModelAndView modelAndView = new ModelAndView(OperacaoBancariaPorCanalViewName.FORM);
		modelAndView.addObject(new OperacaoBancariaPorCanalForm());
		return modelAndView;
	}
	
	@RequestMapping("/editar/{operacaoBancariaId}/{canalAtendimentoId}")
	public ModelAndView editar(
			@PathVariable("operacaoBancariaId") Integer operacaoBancariaId,
			@PathVariable("canalAtendimentoId") Integer canalAtendimentoId){
		
		OperacaoBancariaPorCanalForm form = new OperacaoBancariaPorCanalForm();
		form.setCanalAtendimentoId(canalAtendimentoId);
		form.setOperacaoBancariaId(operacaoBancariaId);

		ModelAndView modelAndView = new ModelAndView(OperacaoBancariaPorCanalViewName.FORM);
		modelAndView.addObject("operacaoBancariaPorCanalForm", form);
		
		return  modelAndView;
	}
	
	@RequestMapping(value="/salvar", method=RequestMethod.POST)
	public ModelAndView salvar(
			ModelAndView modelAndView, 
			OperacaoBancariaPorCanalForm form, 
			BindingResult result){
		
		if(result.hasErrors()){
			return modelAndView;
		}
		
		service.salvar(
				form.getOperacaoBancariaId(), 
				form.getOperacaoBancariaNome(), 
				form.getCanalAtendimentoId(), 
				form.getCanalAtendimentoNome());
		
		modelAndView.setViewName(OperacaoBancariaPorCanalViewName.REDIRECT_LISTA);
		return modelAndView;
	}
	
	@RequestMapping("/remover/{operacaoBancariaId}/{canalAtendimentoId}")
	public ModelAndView remover(
			@PathVariable("operacaoBancariaId") Integer operacaoBancariaId,
			@PathVariable("canalAtendimentoId") Integer canalAtendimentoId){
		
		return new ModelAndView(OperacaoBancariaPorCanalViewName.REDIRECT_LISTA);
	}

}

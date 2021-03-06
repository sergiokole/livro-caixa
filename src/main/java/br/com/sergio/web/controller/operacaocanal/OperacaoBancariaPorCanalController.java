package br.com.sergio.web.controller.operacaocanal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.sergio.app.model.jpa.CanalOperacaoBancaria;
import br.com.sergio.app.model.jpa.OperacaoBancaria;
import br.com.sergio.app.service.OperacaoBancariaPorCanalService;

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
	
	@Autowired
	private OperacaoBancariaPorCanalFormValidator validator;
	
	@InitBinder
	public void initBinder(WebDataBinder binder){
		binder.addValidators(validator);
	}
	
	@ModelAttribute("listaCanalOperacaoBancaria")
	public List<CanalOperacaoBancaria> listaCanalAtendimento(){
		return service.listarCanais();
	}
	
	@RequestMapping("")
	public ModelAndView lista(){
		
		List<OperacaoBancaria> lista = service.listar();
		
		ModelAndView modelAndView = new ModelAndView(OperacaoBancariaPorCanalViewName.LISTA);
		modelAndView.addObject("lista", lista);
		
		return modelAndView;
	}
	
	@RequestMapping("/novo")
	public ModelAndView novo(){
		
		ModelAndView modelAndView = new ModelAndView(OperacaoBancariaPorCanalViewName.FORM);
		modelAndView.addObject(new OperacaoBancariaPorCanalForm());
		return modelAndView;
	}
	
	@RequestMapping("/editar/{operacaoBancariaPorCanalId}")
	public ModelAndView editar(@PathVariable("operacaoBancariaPorCanalId") Integer operacaoBancariaPorCanalId){
		
		ModelAndView modelAndView = new ModelAndView(OperacaoBancariaPorCanalViewName.FORM);
//		modelAndView.addObject(service.edita(operacaoBancariaPorCanalId));
		return  modelAndView;
	}
	
	@RequestMapping(value="/salvar", method=RequestMethod.POST)
	public ModelAndView salvar(
			@Validated OperacaoBancariaPorCanalForm form, 
			BindingResult result){
		
		ModelAndView modelAndView = new ModelAndView(OperacaoBancariaPorCanalViewName.FORM);
		
		if(result.hasErrors()){
			modelAndView.addObject(form);
			return modelAndView;
		}
		
		try{
			service.salvar(
					form.getId(),
					form.getNome(), 
					form.getTipo(), 
					form.getApelido(), 
					form.getCanais());
		} catch (Exception e){
			modelAndView.addObject(form);
			modelAndView.addObject("errors", e.getMessage());
			return modelAndView;
		}
		
		return new ModelAndView(OperacaoBancariaPorCanalViewName.REDIRECT_LISTA);
	}
	
	@RequestMapping(value="/exibir", method=RequestMethod.GET)
	@ResponseBody
	public List<OperacaoBancaria> exibir(){
		return service.listar();
	}
	
	@RequestMapping("/remover/{operacaoBancariaPorId}")
	public ModelAndView remover(@PathVariable("operacaoBancariaPorId") Integer operacaoBancariaPorId){
		
		return new ModelAndView(OperacaoBancariaPorCanalViewName.REDIRECT_LISTA);
	}

}

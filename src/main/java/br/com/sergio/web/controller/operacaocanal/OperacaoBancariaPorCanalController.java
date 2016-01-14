package br.com.sergio.web.controller.operacaocanal;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
		
		return new ModelAndView(OperacaoBancariaPorCanalViewName.FORM);
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
	public ModelAndView salvar(OperacaoBancariaPorCanalForm form){
		
		return new ModelAndView(OperacaoBancariaPorCanalViewName.REDIRECT_LISTA);
	}
	
	@RequestMapping("/remover/{operacaoBancariaId}/{canalAtendimentoId}")
	public ModelAndView remover(
			@PathVariable("operacaoBancariaId") Integer operacaoBancariaId,
			@PathVariable("canalAtendimentoId") Integer canalAtendimentoId){
		
		return new ModelAndView(OperacaoBancariaPorCanalViewName.REDIRECT_LISTA);
	}

}

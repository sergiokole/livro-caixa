package br.com.sergio.web.controller.grupodespesas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.sergio.app.model.vo.GrupoDespesasVO;
import br.com.sergio.app.service.GrupoDespesasService;

@Controller
@RequestMapping("/grupo-despesas")
public class GrupoDespesasController {
	
	@Autowired
	private GrupoDespesasService service;
	
	@RequestMapping("")
	public ModelAndView lista(){
		
		ModelAndView modelAndView = new ModelAndView(GrupoDespesasViewName.LISTA);
		modelAndView.addObject("lista", service.lista());
		
		return modelAndView;
	}
	
	@RequestMapping("/novo")
	public ModelAndView novo(){
		return new ModelAndView(GrupoDespesasViewName.FORM);
	}
	
	@RequestMapping("/editar/{id}")
	public ModelAndView editar(@PathVariable("id") Integer id){
		
		GrupoDespesasVO grupoDespesasVO = service.buscaUm(id);
		
		ModelAndView modelAndView = new ModelAndView(GrupoDespesasViewName.FORM);
		modelAndView.addObject("id", grupoDespesasVO.getId());
		modelAndView.addObject("nome", grupoDespesasVO.getNome());
		
		return  modelAndView;
	}
	
	@RequestMapping(value="/salvar", method=RequestMethod.POST)
	public ModelAndView salvar(
			@RequestParam(name="id") Integer id,
			@RequestParam(name="nome") String nome){
		
		service.salvar(id, nome);
		return new ModelAndView(GrupoDespesasViewName.REDIRECT_LISTA);
	}
	
	@RequestMapping("/remover/{id}")
	public ModelAndView remover(@PathVariable("id") Integer id){
		
		service.remove(id);
		return new ModelAndView(GrupoDespesasViewName.REDIRECT_LISTA);
	}

}

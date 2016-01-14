package br.com.sergio.web.controller.grupoconta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.sergio.app.service.GrupoContaService;

@Controller
@RequestMapping("/grupo-conta")
public class GrupoContaController {
	
	@Autowired
	private GrupoContaService service;
	
	@RequestMapping("")
	public ModelAndView lista(){
		
		ModelAndView modelAndView = new ModelAndView(GrupoContaViewName.LISTA);
		modelAndView.addObject("lista", service.lista());
		
		return modelAndView;
	}
	
	@RequestMapping("/novo")
	public ModelAndView novo(){
		return new ModelAndView(GrupoContaViewName.FORM);
	}
	
	@RequestMapping("/editar/{id}")
	public ModelAndView editar(@PathVariable("id") Long id){
		
		ModelAndView modelAndView = new ModelAndView(GrupoContaViewName.FORM);
		modelAndView.addObject("id", id);
		modelAndView.addObject("nome", service.buscaNome(id));
		
		return  modelAndView;
	}
	
	@RequestMapping(value="/salvar", method=RequestMethod.POST)
	public ModelAndView salvar(
			@RequestParam(name="id") Long id,
			@RequestParam(name="nome") String nome){
		
		id = service.salvar(id, nome);
		return new ModelAndView(GrupoContaViewName.REDIRECT_LISTA);
	}
	
	@RequestMapping("/remover/{id}")
	public ModelAndView remover(@PathVariable("id") Long id){
		
		service.remove(id);
		return new ModelAndView(GrupoContaViewName.REDIRECT_LISTA);
	}

}

package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import domain.Perfil;
import service.PerfilService;

@Controller
@RequestMapping("/perfil")
public class PerfilController {

	@Autowired
	private PerfilService service;
	@GetMapping("/cadastrar")
	public String cadastrar(Perfil perfil) {
		return "/perfil/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("perfil",service.buscarTodos());
		return "/perfil/lista";
	}
	
	@PostMapping("/salvar")
	public String salvar( Perfil perfil, RedirectAttributes attr) {
		service.salvar(perfil);
		attr.addFlashAttribute("sucess","Perfil inserido com sucesso.");
		return "redirect:/perfil/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id,ModelMap model) {
		model.addAttribute("perfil",service.buscarPorId(id));
		return "/peril/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar( Perfil perfil,RedirectAttributes attr) {
		service.editar(perfil);
		attr.addFlashAttribute("sucess","Perfil editado com sucesso.");
		return "redirect:/perfil/cadastrar";
	}
	
	@GetMapping("/excluir/{id})")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		if(service.perfilTemUsuario(id)) {
			model.addAttribute("fail","Perfil não removido. Possui usuario(s) vinculado(s)");
		}
		else {
			service.excluir(id);
			model.addAttribute("sucess","Perfil ecluído com sucesso.");
		}
		return listar(model);
	}
	
	
}


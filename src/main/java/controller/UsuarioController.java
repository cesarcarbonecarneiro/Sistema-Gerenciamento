package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import domain.Cargo;
import domain.Usuario;
import service.CargoService;
import service.UsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private CargoService cargoService;
	
	@GetMapping("/cadastrar")
	public String cadastrar() {
		return "/usuario/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar() {
		return "/usuario/lista";
	}
	
	@PostMapping("/salvar")
	public String salvar(Usuario usuario, RedirectAttributes attr) {
		usuarioService.salvar(usuario);
		attr.addFlashAttribute("sucess","Usuário inserido com sucesso.");
		return "redirect:/usuario/cadastrar";
	}
	
	@ModelAttribute("cargo")
	public List<Cargo>getCargo(){
		return cargoService.buscarTodos();
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id,ModelMap model) {
		model.addAttribute("usuario",usuarioService.buscarPorId(id));
		return "/usuario/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(Cargo cargo,RedirectAttributes attr) {
		cargoService.editar(cargo);
		attr.addFlashAttribute("sucess","Usuário editado com sucesso.");
		return "redirect:/cargo/cadastrar";
	}
	
	@GetMapping("/excluir/{id})")
	public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
		usuarioService.excluir(id);
		attr.addFlashAttribute("sucess","Usuario excluído com sucesso.");
		return "redirect:/usuario/listar";
	}
	
}

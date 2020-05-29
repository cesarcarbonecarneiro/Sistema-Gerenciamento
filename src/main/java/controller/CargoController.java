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

import domain.Cargo;
import service.CargoService;

@Controller
@RequestMapping("/cargos")
public class CargoController {

	@Autowired
	private CargoService cargoService;
	
	@GetMapping("/cadastrar")
	public String cadastrar(Cargo cargo) {
		return "/cargo/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("cargo", cargoService.buscarTodos());
		return "/cargo/lista";
	}
	
	@PostMapping("/salvar")
	public String salvar(Cargo cargo,RedirectAttributes attr) {
		cargoService.salvar(cargo);
		attr.addFlashAttribute("sucess","Cargo inserido com sucesso.");
		return "redirect:/cargo/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id,ModelMap model) {
		model.addAttribute("cargo",cargoService.buscarPorId(id));
		return "/cargo/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar( Cargo cargo,RedirectAttributes attr) {
		cargoService.editar(cargo);
		attr.addFlashAttribute("sucess","Cargo editado com sucesso.");
		return "redirect:/cargo/cadastrar";
	}
	
	@GetMapping("/excluir/{id})")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		if(cargoService.cargoTemUsuario(id)) {
			model.addAttribute("fail","Perfil não removido. Possui usuario(s) vinculado(s)");
		}
		else {
			cargoService.excluir(id);
			model.addAttribute("sucess","Cargo ecluído com sucesso.");
		}
		return "reirect:/cargo/listar";
	}
}

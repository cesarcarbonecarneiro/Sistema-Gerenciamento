package service;

import java.util.List;

import domain.Perfil;

public interface PerfilService {
	
	void salvar(Perfil perfil);
	void editar(Perfil perfil);
	void excluir(Long id);
	Perfil buscarPorId(Long id);
	List<Perfil> buscarTodos();
	boolean perfilTemUsuario(Long id);
}

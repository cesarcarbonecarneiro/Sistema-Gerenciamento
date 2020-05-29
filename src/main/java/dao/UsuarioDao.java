package dao;

import java.util.List;

import domain.Usuario;

public interface UsuarioDao {
	
	void save(Usuario perfil);
	void update(Usuario perfil);
	void delete(Long id);
	Usuario findById(Long id);
	List<Usuario> findAll();

}

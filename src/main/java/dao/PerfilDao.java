package dao;

import java.util.List;

import domain.Perfil;

public interface PerfilDao {
	
	void save(Perfil perfil);
	void update(Perfil perfil);
	void delete(Long id);
	Perfil findById(Long id);
	List<Perfil> findAll();
}

package dao;

import java.util.List;

import domain.Cargo;

public interface CargoDao {

	void save(Cargo perfil);
	void update(Cargo perfil);
	void delete(Long id);
	Cargo findById(Long id);
	List<Cargo> findAll();
}

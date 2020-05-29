package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.PerfilDao;
import domain.Perfil;
import domain.Usuario;

@Service 
public class PerfilServiceImpl implements PerfilService {

	@Autowired
	private PerfilDao dao;
	
	@Autowired
	private UsuarioServiceImpl service;
	
	@Transactional(readOnly= false)
	@Override
	public void salvar(Perfil perfil) {
		dao.save(perfil);
		
	}
	
	@Transactional(readOnly= false)
	@Override
	public void editar(Perfil perfil) {
		dao.update(perfil);
		
	}
	
	@Transactional(readOnly= false)
	@Override
	public void excluir(Long id) {
		dao.delete(id);
		
	}
	
	@Transactional(readOnly= true)
	@Override
	public Perfil buscarPorId(Long id) {
		return dao.findById(id);
	}
	
	@Transactional(readOnly= true)
	@Override
	public List<Perfil> buscarTodos() {
		return dao.findAll();
	}
	
	@Override
	public boolean perfilTemUsuario(Long id) {
		List<Usuario> lista= service.buscarTodos();
		for (Usuario u : lista) {
			for(Perfil p : u.getPerfil()) {
				if(p.getId()==id) {
					return true;
				}
			}
		}
		return false;
	}
	

}

package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.UsuarioDao;
import domain.Usuario;

@Service
@Transactional(readOnly= true)
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	private UsuarioDao dao;
	
	@Transactional(readOnly= true)
	@Override
	public void salvar(Usuario usuario) {
		dao.save(usuario);
		
	}

	@Transactional(readOnly= true)
	@Override
	public void editar(Usuario usuario) {
		dao.update(usuario);
		
	}

	@Transactional(readOnly= true)
	@Override
	public void excluir(Long id) {
		dao.delete(id);
		
	}

	@Override
	public Usuario buscarPorId(Long id) {
		return dao.findById(id);
	}

	@Override
	public List<Usuario> buscarTodos() {
		return dao.findAll();
	}

}

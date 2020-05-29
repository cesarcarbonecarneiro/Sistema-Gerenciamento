package dao;

import org.springframework.stereotype.Repository;

import domain.Usuario;

@Repository
public class UsuarioDaoImpl extends AbstractDao<Usuario, Long> implements UsuarioDao {

}

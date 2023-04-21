package es.uma.ingsoftware.goldendumbbell.service;
import es.uma.ingsoftware.goldendumbbell.model.Usuario;
import es.uma.ingsoftware.goldendumbbell.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UsuarioService {


    @Autowired
    UsuarioRepository usuarioRepository;

    public List<Usuario> getAll() {
        return usuarioRepository.findAll();
    }

    public void save(Usuario e) {
        usuarioRepository.saveAndFlush(e);
    }

    public void delete(Integer id) {
        usuarioRepository.deleteById(id);
    }

    public Usuario getById(Integer id) {
        return usuarioRepository.getOne(id);
    }
}

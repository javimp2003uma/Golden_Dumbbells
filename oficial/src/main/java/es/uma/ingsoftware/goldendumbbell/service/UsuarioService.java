package es.uma.ingsoftware.goldendumbbell.service;
import es.uma.ingsoftware.goldendumbbell.model.Usuario;
import es.uma.ingsoftware.goldendumbbell.repository.UsuarioRepository;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
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

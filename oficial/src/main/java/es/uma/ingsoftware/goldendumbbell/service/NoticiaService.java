package es.uma.ingsoftware.goldendumbbell.service;
import es.uma.ingsoftware.goldendumbbell.model.Noticia;
import es.uma.ingsoftware.goldendumbbell.repository.NoticiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticiaService {


    @Autowired
    NoticiaRepository noticiaRepository;

    public List<Noticia> getAll() {
        return noticiaRepository.findAll();
    }

    public void save(Noticia e) {
        noticiaRepository.saveAndFlush(e);
    }

    public void delete(Integer id) {
        noticiaRepository.deleteById(id);
    }

    public Noticia getById(Integer id) {
        return noticiaRepository.getOne(id);
    }

}

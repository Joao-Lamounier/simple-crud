package application.services;

import application.domain.entities.Cidade;
import application.repositories.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository repository;

    public List<Cidade> findAll(){
        return repository.findAll();
    }
    public Cidade findById(Integer id){
        Optional<Cidade> obj = repository.findById(id);
        return obj.get();
    }
}

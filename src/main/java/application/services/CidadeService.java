package application.services;

import application.domain.entities.Cidade;
import application.repositories.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;

    public List<Cidade> findAll(){
        return cidadeRepository.findAll();
    }
    public Cidade findById(Integer id){
        Optional<Cidade> obj = cidadeRepository.findById(id);
        return obj.get();
    }
}

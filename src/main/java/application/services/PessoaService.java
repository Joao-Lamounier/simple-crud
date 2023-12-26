package application.services;

import application.controller.exceptions.ResourceExceptionHandler;
import application.domain.entities.Cidade;
import application.domain.entities.Pessoa;
import application.repositories.PessoaRepository;
import application.services.exceptions.DataBaseException;
import application.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;


import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

import static ch.qos.logback.core.joran.spi.ConsoleTarget.findByName;

@Service
public class PessoaService {
    @Autowired
    private PessoaRepository repository;

    @Autowired
    CidadeService c_service;

    public List<Pessoa> findAll() {
        return repository.findAll();
    }

    public Pessoa findById(Integer id) {
        Optional<Pessoa> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Pessoa insert(Pessoa obj) {
        Cidade cidade = c_service.findByName(obj.getCidade().getNome(), obj.getCidade().getEstado());
//        if (cidade == null) {
//            System.out.println("Cidade not found");
//            return null;
//        }
        obj.setCidade(cidade);
        System.out.println(cidade.getId() + " " + cidade + "================================");
        return repository.save(obj);
    }

    public void delete(Integer id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataBaseException(e.getMessage());
        }
    }

    public Pessoa update(Integer id, Pessoa obj) {
        try {
            Pessoa entity = repository.getReferenceById(id);
            updateData(entity, obj);
            return repository.save(entity);
        }catch (EntityNotFoundException e){
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(Pessoa entity, Pessoa obj) {
        entity.setNome(obj.getNome());
        entity.setApelido(obj.getApelido());
        entity.setCidade(obj.getCidade());
        entity.setCpf(obj.getCpf());
        entity.setHobbie(obj.getHobbie());
        entity.setTime(obj.getTime());
    }
}

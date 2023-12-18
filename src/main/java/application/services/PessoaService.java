package application.services;

import application.domain.entities.Pessoa;
import application.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {
    @Autowired
    private PessoaRepository repository;

    public List<Pessoa> findAll() {
        return repository.findAll();
    }

    public Pessoa findById(Integer id) {
        Optional<Pessoa> obj = repository.findById(id);
        return obj.get();
    }

    public Pessoa insert(Pessoa obj) {
        return repository.save(obj);
    }
    public void delete(Integer id) {
        repository.deleteById(id);
    }
    public Pessoa update(Integer id, Pessoa obj) {
        Pessoa entity = repository.getReferenceById(id);
        updateData(entity, obj);
        return repository.save(entity);
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

package application.controller;

import application.domain.entities.Cidade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import application.services.CidadeService;

import java.util.List;

@RestController
@RequestMapping( value = "/cidade")
public class CidadeController {

    @Autowired
    private CidadeService service;
    @GetMapping
    public ResponseEntity<List<Cidade>> findALL() {
        List<Cidade> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Cidade> findById(@PathVariable Integer id){
        Cidade obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

}

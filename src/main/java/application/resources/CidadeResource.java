package application.resources;

import application.domain.entities.Cidade;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( "/city")
public class CidadeResource {
    @GetMapping
    public ResponseEntity<Cidade> findALL() {
        Cidade cidade = new Cidade(1, "Mariana", "MG");
        return ResponseEntity.ok().body(cidade);
    }
}

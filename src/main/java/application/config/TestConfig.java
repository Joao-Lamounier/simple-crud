package application.config;

import application.domain.entities.Cidade;
import application.domain.entities.Pessoa;
import application.repositories.CidadeRepository;
import application.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

import static com.fasterxml.jackson.databind.type.LogicalType.Array;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    @Autowired
    private CidadeRepository cidadeRepository;
    @Autowired
    private PessoaRepository pessoaRepository;

    @Override
    public void run(String... args) throws Exception {
        Cidade c1 = new Cidade(null, "Camacho", "MG");
        Cidade c2 = new Cidade(null, "Itapecerica", "MG");
        Pessoa p1 = new Pessoa(null, "Joao Felipe", "Joao", "Cruzeiro", "12345678910", "Estudar", c1);
        Pessoa p2 = new Pessoa(null, "Pedro", "P", "Gremio", "12345678911", "Jogar", c2);
        cidadeRepository.saveAll(Arrays.asList(c1, c2));
        pessoaRepository.saveAll(Arrays.asList(p1, p2));
    }
}

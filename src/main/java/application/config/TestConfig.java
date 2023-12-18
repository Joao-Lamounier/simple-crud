package application.config;

import application.domain.entities.Cidade;
import application.repositories.CidadeRepository;
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

    @Override
    public void run(String... args) throws Exception {
        Cidade c1 = new Cidade(null, "Camacho", "MG");
        Cidade c2 = new Cidade(null, "Itapecerica", "MG");
        cidadeRepository.saveAll(Arrays.asList(c1, c2));
    }
}

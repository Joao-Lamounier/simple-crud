package application;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.entities.Cidade;
import domain.entities.Pessoa;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


@SpringBootApplication
public class Main {
    public static void main(String[] args){

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("simple_crud");

        EntityManager em = emf.createEntityManager();
        Cidade c1 = em.find(Cidade.class, 2);
        System.out.println(c1);
        em.close();
        emf.close();
//        List<Cidade> cidades = lerArquivoJson("/home/joao/Documentos/cidadesjson/cidades.json");

//        em.getTransaction().begin();
//        for (Cidade cidade : cidades) {
//            em.persist(cidade);
//        }
//        em.getTransaction().commit();
//
//        System.out.println("Pronto");

    }
//    public static List<Cidade> lerArquivoJson(String caminhoArquivo) {
//        List<Cidade> cidades = new ArrayList<>();
//
//        try {
//            ObjectMapper objectMapper = new ObjectMapper();
//            JsonNode rootNode = objectMapper.readTree(new File(caminhoArquivo));
//
//            JsonNode estadosNode = rootNode.get("estados");
//            if (estadosNode != null) {
//                Iterator<JsonNode> estadosIterator = estadosNode.elements();
//
//                while (estadosIterator.hasNext()) {
//                    JsonNode estadoNode = estadosIterator.next();
//                    String siglaEstado = estadoNode.get("sigla").asText();
//                    String nomeEstado = estadoNode.get("nome").asText();
//
//                    JsonNode cidadesNode = estadoNode.get("cidades");
//                    if (cidadesNode != null) {
//                        Iterator<JsonNode> cidadesIterator = cidadesNode.elements();
//
//                        while (cidadesIterator.hasNext()) {
//                            String nomeCidade = cidadesIterator.next().asText();
//                            Cidade cidade = new Cidade(null, nomeCidade, siglaEstado);
//                            cidades.add(cidade);
//                        }
//                    }
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return cidades;
//    }
}

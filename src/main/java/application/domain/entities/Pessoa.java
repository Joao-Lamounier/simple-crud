package application.domain.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "tb_pessoa")
public class Pessoa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String apelido;
    @Column(nullable = false)
    private String time;
    @Column(nullable = false)
    private String cpf;
    @Column(nullable = true)
    private String hobbie;
    @ManyToOne
    @JoinColumn(name = "cidade_id", nullable = false)
    private Cidade cidade;

    public Pessoa() {
    }

    public Pessoa(Integer id, String nome, String apelido, String time, String cpf, String hobbie, Cidade cidade) {
        this.id = id;
        this.nome = nome;
        this.apelido = apelido;
        this.time = time;
        this.cpf = cpf;
        this.hobbie = hobbie;
        this.cidade = cidade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getHobbie() {
        return hobbie;
    }

    public void setHobbie(String hobbie) {
        this.hobbie = hobbie;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", apelido='" + apelido + '\'' +
                ", time='" + time + '\'' +
                ", cpf='" + cpf + '\'' +
                ", hobbie='" + hobbie + '\'' +
                ", cidade=" + cidade +
                '}';
    }
}

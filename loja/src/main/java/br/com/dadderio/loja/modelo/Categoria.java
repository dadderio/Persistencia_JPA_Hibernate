package br.com.dadderio.loja.modelo;

import javax.persistence.*;

@Entity
@Table(name = "categorias") //nome da coluna no banco de dados
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    public Categoria(String nome) {
        this.nome = nome;
    }

    public Categoria() {  //CONSTRUTOR DEFAULT É UMA EXIGÊNCIA DA JPA
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}

package br.com.dadderio.loja.modelo;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
//orm - mapeamento objeto relacional na classe via notações @Entity (especificação da JPA importar: javax.persistence.Entity

@Entity
@Table(name = "produtos") //nome da coluna no banco de dados
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //a estratégia de como o valor é gerado da chave primária - depende do banco de dados
    private Long id;
    private String nome;
    //@Column(name = "desc") exemplo caso a coluna seja diferente do nome do atributo
    private String descricao;
    private BigDecimal preco;
    private LocalDate dataCadastro = LocalDate.now();
    @ManyToOne //define a cardinalidade de muitos produtos para uma categoria
    private Categoria categoria;

    public Produto(String nome, String descricao, BigDecimal preco, Categoria categoria) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.categoria = categoria;
    }

    public Produto() {//CONSTRUTOR DEFAULT É UMA EXIGÊNCIA DA JPA
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }
}

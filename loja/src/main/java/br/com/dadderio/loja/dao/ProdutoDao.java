package br.com.dadderio.loja.dao;

import br.com.dadderio.loja.modelo.Produto;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class ProdutoDao {

    private EntityManager em;

    //ao instanciar a classe ProdutoDao, ela não é responsável pela EntityManager, pois ao instanciar ela recebe EntityManager
    public ProdutoDao(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Produto produto) {
        this.em.persist(produto);
    }

    public Produto buscarPorId(Long id) {
        return em.find(Produto.class, id);
    }

    /*Java Persistence Query Language. É uma linguagem de consulta orientada a objetos utilizada para
     fazer consultas em bancos de dados por meio de estruturas de objetos e entidades no contexto
     da JPA (Java Persistence API). Ela se assemelha à linguagem SQL, mas em vez de consultar
     tabelas e colunas, opera com entidades, atributos e relacionamentos de objetos.
     Essa linguagem é independente de banco de dados, o que significa que você pode escrever
     consultas usando JPQL e elas podem ser executadas em diferentes sistemas de gerenciamento de
     banco de dados desde que estejam integrados com a JPA.*/

    public List<Produto> buscarTodos() {
        String jpql = "SELECT p FROM Produto AS p";
        return em.createQuery(jpql, Produto.class).getResultList();
    }

    public List<Produto> buscarPorNome(String nome) {
        // p.nome é "o nome do atributo/entidade da classe Produto", e não da coluna na tabela
        // :nome é um parâmetro dinâmico, poderia ser qualquer outro nome
        String jpql = "SELECT p FROM Produto p WHERE p.nome = :nome";
        return em.createQuery(jpql, Produto.class)
                //setParameter indica que o
                //"nome" que na realidade é o parâmetro dinâmico :nome da query que será substituído
                //pelo nome, que recebemos como parâmetro em buscarPorNome(String nome)
                .setParameter("nome", nome)
                .getResultList();
    }

    public List<Produto> buscarPorNomeDaCategoria(String nome) {
        String jpql = "SELECT p FROM Produto p WHERE p.categoria.nome = :nome";
        return em.createQuery(jpql, Produto.class)
                .setParameter("nome", nome)
                .getResultList();
    }
    public BigDecimal buscarPrecoDoProdutoComNome(String nome) {
        String jpql = "SELECT p.preco FROM Produto p WHERE p.nome = :nome";
        return em.createQuery(jpql, BigDecimal.class)
                .setParameter("nome", nome)
                .getSingleResult();
    }
}
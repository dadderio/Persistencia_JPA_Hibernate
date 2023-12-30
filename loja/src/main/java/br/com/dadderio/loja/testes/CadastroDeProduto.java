package br.com.dadderio.loja.testes;

import br.com.dadderio.loja.dao.CategoriaDao;
import br.com.dadderio.loja.dao.ProdutoDao;
import br.com.dadderio.loja.modelo.Categoria;
import br.com.dadderio.loja.modelo.Produto;
import br.com.dadderio.loja.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.List;

public class CadastroDeProduto {
    public static void main(String[] args) {

        cadastrarProduto();
        //fazer busca por id:
        Long id = 1l;
        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(em);

        Produto p = produtoDao.buscarPorId(1l);
        System.out.println(p.getPreco());

        List<Produto> todosProdutos = produtoDao.buscarTodos();
        todosProdutos.forEach(p2 -> System.out.println(p2.getNome()));

        List<Produto> produtosPorCategoria = produtoDao.buscarPorNomeDaCategoria("CELULARES");
        produtosPorCategoria.forEach(p3 -> System.out.println(p3.getNome()));

        BigDecimal precoDoProduto = produtoDao.buscarPrecoDoProdutoComNome("Samsung Galaxy");
        System.out.println(precoDoProduto);

    }

    private static void cadastrarProduto() {
        Categoria celulares = new Categoria("CELULARES");

        Produto celular = new Produto("Samsung Galaxy", "muito bom", new BigDecimal("1200"), celulares );


        EntityManager em = JPAUtil.getEntityManager();
        //instancia a classe ProdutoDao - comunica com banco de dados
        CategoriaDao categoriaDao = new CategoriaDao(em);
        ProdutoDao produtoDao = new ProdutoDao(em);

        //iniciar a transação no banco de dados
        em.getTransaction().begin();

        //cadastrando uma categoria
        categoriaDao.cadastrar(celulares);
        //cadastrando um produto
        produtoDao.cadastrar(celular);

        em.getTransaction().commit();
        em.close();
    }
}

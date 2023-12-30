package br.com.dadderio.loja.dao;

import br.com.dadderio.loja.modelo.Categoria;
import br.com.dadderio.loja.modelo.Produto;

import javax.persistence.EntityManager;

public class CategoriaDao {

    private EntityManager em;

    //ao instanciar a classe CategoriaDao, ela não é responsável pela EntityManager, pois ao instanciar ela recebe EntityManager
    public CategoriaDao(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Categoria categoria){
        this.em.persist(categoria);
    }

    public void atualizar(Categoria categoria){
        this.em.merge(categoria);
    }

    public void remover(Categoria categoria){
        categoria = em.merge(categoria);
        this.em.remove(categoria);
    }

}

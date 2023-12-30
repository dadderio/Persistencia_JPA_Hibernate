package br.com.dadderio.loja.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
    //EntityManager é uma interface e não pode dar new em interface
    //padrão de projeto factory
    //createEntityManagerFactory(coloca o "nome do persistence unity" do arquivo persistence.xml)
    //Persistence é uma classe
    //factory cria uma única vez, então
    //final = uma constante
    private static final EntityManagerFactory FACTORY = Persistence
            .createEntityManagerFactory("loja");

    public static EntityManager getEntityManager(){
        return FACTORY.createEntityManager();
    }
}

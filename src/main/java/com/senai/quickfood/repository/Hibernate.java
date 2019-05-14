package com.senai.quickfood.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Hibernate {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("senai_QuickFood_Persistence");
    private static final EntityManager em = emf.createEntityManager();

    public static EntityManager getEm() {
        return em;
    }

    public static void inserir(Object o) {
        em.persist(o);
    }

    public static void alterar(Object o) {
        em.merge(o);
    }

    public static void excluir(Object o) {
        em.merge(o);
        em.remove(o);
    }

    public static void commitar() {
        em.getTransaction().begin();
        em.getTransaction().commit();
    }
}

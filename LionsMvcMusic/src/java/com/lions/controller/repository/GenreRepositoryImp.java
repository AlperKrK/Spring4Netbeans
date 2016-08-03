/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lions.controller.repository;

import com.lions.controller.model.Genre;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Asus
 */
//Repository ile entityden olusturulmus db nesneleri daodaki gibi servis katmaninda crud/dml metotlarini olusturdum
//FK alanı olan Genre entitysini burada private olarak alip kullandım
//Birden fazla iliskisel tablo varsa repository cok saglikli degil;fk alanlarindaki nesneleri islemede hata verebiliyor.
@Repository
public class GenreRepositoryImp implements GenreRepository
{

    @Autowired
    public EntityManager getEM()
    {
        EntityManagerFactory factory =Persistence.createEntityManagerFactory("LionsMvcMusicPU");
        return factory.createEntityManager();
    }
    
    @Override
    public List<Genre> listGenre() 
    {
        EntityManager em = getEM();
        TypedQuery<Genre> query;
        query = em.createQuery("SELECT G FROM Genre G ",Genre.class);
        List<Genre> lionl =query.getResultList();
        return lionl;
    }

    @Override
    public void create(Genre genre) 
    {
        EntityManager em = getEM();
        em.persist(genre);
    }

    @Override
    public Genre findByGenreId(int passid) 
    {
         EntityManager em = getEM();
         List<Genre> genreList = new ArrayList<Genre>();
         try
         {
             Query q = em.createNamedQuery("Genre.findByGenreid");
             q.setParameter("genreId", passid);
             genreList =q.getResultList();
         }catch(Exception e)
         {
             
         }
         return genreList.get(0);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lions.controller.deneme;

import com.lions.controller.model.Genre;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Asus
 */
@Component
@Service("genreService")
public class GenreModel 
{
    
    @Autowired
    private EntityManager getEm()
    {
        EntityManagerFactory factory =Persistence.createEntityManagerFactory("LionsMvcMusicPU");
        return factory.createEntityManager();
    }
    
    @Transactional
    public void create(Genre genre)
    {
        EntityManager em = getEm();
        em.persist(genre);
    }
    
    
    public List<Genre> findAllGenre()
    {
        EntityManager em = getEm();
        TypedQuery<Genre> query;
        query = em.createQuery("SELECT G FROM Genre G ",Genre.class);
        List<Genre> lionl =query.getResultList();
        return lionl;   
    }
    public Genre findByGenreId(int passid)
    {
        EntityManager em = getEm();
        List<Genre> myGenreList = new ArrayList<Genre>();
        try
        {
            Query q = em.createNamedQuery("Genre.findByGenreid");
            q.setParameter("genreid", passid);
            myGenreList=q.getResultList();
        }catch(Exception e)
        {
            
        }
        return myGenreList.get(0);
    }
    
}

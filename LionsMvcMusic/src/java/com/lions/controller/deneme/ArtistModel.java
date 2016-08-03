/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lions.controller.deneme;

import com.lions.controller.model.Artist;
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
@Service("artistService")
public class ArtistModel 
{
    
    @Autowired
    private EntityManager getEm()
    {
        EntityManagerFactory factory =Persistence.createEntityManagerFactory("LionsMvcMusicPU");
        return factory.createEntityManager();
    }
    @Transactional
    public void create(Artist artist)
    {
        EntityManager em = getEm();
        em.persist(artist);
    }
    
    public List<Artist> findAllArtist()
    {
        EntityManager em = getEm();
        TypedQuery<Artist> query;
        query=em.createQuery("SELECT A FROM Artist A",Artist.class);
        List<Artist> arList =query.getResultList();
        return arList;
    }
    public Artist findByArtistId(int passid)
    {
        EntityManager em = getEm();
        List<Artist> myArtistList = new ArrayList<Artist>();
        try
        {
            Query q = em.createNamedQuery("Artist.findByArtistid");
            q.setParameter("artistid", passid);
            myArtistList=q.getResultList();
        }catch(Exception e)
        {
            
        }
        return myArtistList.get(0);
    }
}

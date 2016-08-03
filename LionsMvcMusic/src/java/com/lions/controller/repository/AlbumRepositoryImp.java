/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lions.controller.repository;

import com.lions.controller.model.Album;
import com.lions.controller.model.Genre;
import com.lions.controller.service.GenreService;
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
public class AlbumRepositoryImp implements AlbumRepository
{

    private GenreService genreService;
    
    @Autowired
    public EntityManager getEm()
    {
        EntityManagerFactory factory =Persistence.createEntityManagerFactory("LionsMvcMusicPU");
        return factory.createEntityManager();
    }
    
    @Override
    public List<Album> listAlbum()
    {
        EntityManager em = getEm();
        TypedQuery<Album> query;
        query = (TypedQuery<Album>) em.createNamedQuery("Album.findAll") ;  
                
//                createQuery("SELECT A FROM Album A ",Album.class);
        List<Album> myAlbum =query.getResultList();
        return myAlbum;
    }

    @Override
    public void add(Album album) 
    {
        EntityManager em = getEm();
        em.persist(album);
    }

    @Override
    public void edit(Album album) 
    {
        EntityManager em =getEm();
        Album newalbum=null;
        newalbum = findAlbumById(newalbum.getAlbumid().intValueExact());
        newalbum.setGenreid(album.getGenreid());
        newalbum.setArtistid(album.getArtistid());
        newalbum.setTitle(album.getTitle());
        newalbum.setPrice(album.getPrice());
        newalbum.setAlbumarturl(album.getAlbumarturl());
        em.merge(newalbum);
    }

  
    @Override
    public Album findAlbumById(int passid) 
    {
     EntityManager em = getEm();
     List<Album> myAlbum = new ArrayList<Album>();
     try
     {
         Query q = em.createNamedQuery("Album.findByAlbumid");
         q.setParameter("albumid", myAlbum);
         myAlbum =q.getResultList();
     }catch(Exception e)
     {
         
     }
     return myAlbum.get(0);
    }

    @Override
    public Genre findGenreIdByAlbum(int passid)
    {
       return (genreService.findByGenreId(passid));
    }

    @Override
    public void delete(Album album) 
    {
       EntityManager em = getEm();
       Album myAlbum = findAlbumById(album.getAlbumid().intValueExact());
       em.remove(myAlbum);
    }

    
    
}

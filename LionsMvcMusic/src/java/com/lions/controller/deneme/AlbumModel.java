/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lions.controller.deneme;

import com.lions.controller.model.Album;
import com.lions.controller.model.Artist;
import com.lions.controller.model.Genre;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
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

//Olusturdugumuz servis katmaninin ayarlari icin app configten bean yapılandırmalarını yapmak gerekir.
//<bean id="albumService" class="com.lions.controller.deneme.AlbumModel"/> şeklinde serviste ne tanımladıysak app configte de o olması gerekir.
@Component
@Service("albumService")
public class AlbumModel 
{
    
    //EntityManagerFactory ile Jpa otomatik olusan PU objesini tanittim
    @Autowired
    private EntityManager getEm()
    {
        EntityManagerFactory factory =Persistence.createEntityManagerFactory("LionsMvcMusicPU");
        return factory.createEntityManager();
    }
    
    @Resource(name="genreService")
    private GenreModel genreModel;
    
    @Resource(name="artistService")
    private ArtistModel artistModel;
    
    
    //ekleme
    @Transactional
    public void create(Album album)
    {
        EntityManager em = getEm();
        em.persist(album);
    }
    //disardan girilen id ye gore albumbulma metodo
    public Album findByAlbumId(int passid)
    {
        EntityManager em = getEm();
        List<Album> myAlbum = new ArrayList<Album>();
        try
        {
            Query q = em.createNamedQuery("Album.findByAlbumid");
            q.setParameter("albumid", passid);
            myAlbum=q.getResultList();
        }
        catch(Exception e)
        {
            
        }
        return myAlbum.get(0);
        
    }
    //update islemleri
    @Transactional
    public void edit(Album album)
    {
        EntityManager em = getEm();
        Album newAlbum = findByAlbumId(album.getAlbumid().intValueExact());
        newAlbum.setGenreid(album.getGenreid());
        newAlbum.setArtistid(album.getArtistid());
        newAlbum.setTitle(album.getTitle());
        newAlbum.setPrice(album.getPrice());
        newAlbum.setAlbumarturl(album.getAlbumarturl());
        em.merge(newAlbum);   
    }
    
    //silme islemleri
    @Transactional
    public void delete(Album album)
    {
        EntityManager em = getEm();
        
        Album myAlbum = findByAlbumId(album.getAlbumid().intValueExact());
        album=  em.merge(myAlbum);
        em.remove(album);
    }
    //TypedQuery olarak aldim NamedQuery olarakta alinabilir
    public List<Album> findAllAlbum()
    {
        EntityManager em = getEm();
        TypedQuery<Album> query;
        query =em.createQuery("SELECT A FROM Album A",Album.class);
        List<Album> myAlbumList =query.getResultList();
        return myAlbumList;
    }
    //FK alanim olan genreleri albumden id ye gore alma
    public  Genre findGenreIdFromAlbum(int passid)
    {
        return (genreModel.findByGenreId(passid));
    }
    //FK alanim olan artistleri albumden id ye gore alma
    public Artist findArtistIdFromAlbum(int passid)
    {
        return (artistModel.findByArtistId(passid));
    }
    
    
    
}

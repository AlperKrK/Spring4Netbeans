/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lions.controller.deneme;

import com.lions.controller.model.Album;
import com.lions.controller.model.Cart;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Asus
 */
@Component
@Service("shoppingCartService")
public class ShoppingCartModel 
{
    private int currentCartNumber=0;
    
    public List<Album> albumInCart =new ArrayList<Album>();
    
    @Autowired
    private EntityManager getEm()
    {
        EntityManagerFactory factory =Persistence.createEntityManagerFactory("LionsMvcMusicPU");
        return factory.createEntityManager();
    }
    
    @Transactional
    public void create(Cart cart)
    {
        EntityManager em= getEm();
        em.merge(cart);
    }
    
    @Transactional
    public void delete(Cart cart)
    {
        EntityManager em= getEm();
        em.remove(cart);
    }
    public void generateCartid()
    {
        if(currentCartNumber==0)
        {
            Random rnd= new Random();
            currentCartNumber=rnd.nextInt(99999999);
        }
    }
    public List<Cart> findCartById(Integer passid)
    {
        EntityManager em= getEm();
        List<Cart> cartList = null;
        Query q=em.createNamedQuery("Cart.findByCartid");
        q.setParameter("cartid",passid);
        cartList=q.getResultList();
        return cartList;
        
    }
    
    public double getTotalPrice()
    {
        double price=0;
        List<Album> albumList = getAlbumInCart();
        for(Album myAlbum : albumList)
        {
            price +=myAlbum.getPrice().doubleValue();
        }
        return price;
        
    }
    
    public void deleteAlbumFromAlbumList(Album myAlbum)
    {
        getAlbumInCart().remove(myAlbum);
    }

    public Integer getCurrentCartNumber()
    {
        return currentCartNumber;
    }
    public void setCurrentCartNumber(int currentCartNumber)
    {
        this.currentCartNumber=currentCartNumber;
    }
    
    public List<Album> getAlbumInCart() 
    {
       return albumInCart;
    }
    public void setAlbumInCart(List<Album> albumInCart)
    {
        this.albumInCart=albumInCart;
    }
    
    
}

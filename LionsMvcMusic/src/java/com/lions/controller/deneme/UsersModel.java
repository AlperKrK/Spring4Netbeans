/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lions.controller.deneme;

import com.lions.controller.model.Userzs;
import java.util.ArrayList;
import java.util.List;
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
@Service("userService")
public class UsersModel 
{

    @Autowired
    private EntityManager getEm()
    {
        EntityManagerFactory factory =Persistence.createEntityManagerFactory("LionsMvcMusicPU");
        return factory.createEntityManager();
    }
    
    @Transactional
    public void create(Userzs user)
    {
        EntityManager em= getEm();
        em.persist(user);
    }
    
    public List<Userzs> findAllUser()
    {
        EntityManager em= getEm();
        List<Userzs> userList = new ArrayList<Userzs>();
        try
        {
            Query q =em.createNamedQuery("Userzs.findAll");
            userList=q.getResultList();
        }catch(Exception e)
        {
            
        }
        return userList;
    }
    public Userzs findUserByUserName(String passusername)
    {
        EntityManager em= getEm();
        List<Userzs> userList=null;
        Query q =em.createNamedQuery("Userzs.findByUsername");
        q.setParameter("usersname", passusername);
        userList=q.getResultList();
        return userList.get(0);
    }
    public boolean verifyUserLogin(String username,String password)
    {
        boolean result=false;
        List<Userzs> myUserList=null;
        try
        {
            myUserList=findAllUser();
            
        }catch(Exception e)
        {
            System.out.println("Sistemde boyle bir kullanici yok");
            
        }
        for(Userzs myUser:myUserList)
        {
            if((myUser.getUsername().equals(username))&&myUser.getPassword().equals(password))
            {
                result=true;
            }
        }
        return result;
    }

    
}

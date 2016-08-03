/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lions.controller.deneme;

import com.lions.controller.model.Userzsrole;
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
@Service("userRoleService")
public class UsersRoleModel 
{
    @Autowired
    private EntityManager getEm()
    {
        EntityManagerFactory factory =Persistence.createEntityManagerFactory("LionsMvcMusicPU");
        return factory.createEntityManager();
    }
    
    @Transactional
    public void Create(Userzsrole userRole)
    {
        EntityManager em = getEm();
        em.persist(userRole);
    }
    
    public Userzsrole findUserRoleByUserzsroleid(int passid)
    {
        EntityManager em = getEm();
        List<Userzsrole> myUserRoleList =new ArrayList<Userzsrole>();
        try
        {
            Query q =em.createNamedQuery("Userzsrole.findByRoleid");
            q.setParameter("roleid", passid);
            myUserRoleList=q.getResultList(); 
        }catch(Exception e)
        {
            
        }
        return myUserRoleList.get(0);
    }
    
}

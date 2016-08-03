/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lions.controller.deneme;

import com.lions.controller.model.Orderdetail;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Asus
 */
@Component
@Service("orderDetailService")
public class OrdersDetailsModel 
{
 
    @Autowired
    private EntityManager getEm()
    {
        EntityManagerFactory factory =Persistence.createEntityManagerFactory("LionsMvcMusicPU");
        return factory.createEntityManager();
    }
    @Transactional
    public void create(Orderdetail orderDetail)
    {
        EntityManager em=getEm();
        em.persist(orderDetail);
    }
}

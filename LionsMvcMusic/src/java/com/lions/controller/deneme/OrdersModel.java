/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lions.controller.deneme;

import com.lions.controller.model.Orders;
import java.math.BigDecimal;
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
@Service("orderService")
public class OrdersModel 
{
    @Autowired
    private EntityManager getEm()
    {
        EntityManagerFactory factory =Persistence.createEntityManagerFactory("LionsMvcMusicPU");
        return factory.createEntityManager();
    }
    
    @Transactional
    public void create(Orders orders)
    {
        EntityManager em= getEm();
        em.persist(orders);
    }
    
    
    public Orders findOrdersByOrderid(int passid)
    {
        EntityManager em=getEm();
        List<Orders> ordersList=null;
        Query q =em.createNamedQuery("Orders.findByOrderid");
        if(!q.getResultList().isEmpty())
        {
            ordersList =q.getResultList();
            return ordersList.get(0);
        }else
        {
            return null;
        }
    }
    public List<Orders> findAllOrders()
    {
        EntityManager em=getEm();
        TypedQuery<Orders> tq;
        tq=em.createQuery("SELECT O FROM ORDERS",Orders.class);
        List<Orders> myOrderList =tq.getResultList();
        return myOrderList;
    }
    
    public Orders findOrderByUserid(int passid)
    {
        List<Orders> ordersList=findAllOrders();
        Orders returnOrder=null;
        for(Orders myOrder:ordersList)
        {
            if(myOrder.getUserid().intValue()==(passid))
            {
             returnOrder=myOrder;   
            }
        }
        return returnOrder;
    }
    
}

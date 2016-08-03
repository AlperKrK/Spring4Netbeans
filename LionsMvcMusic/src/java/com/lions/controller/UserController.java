/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lions.controller;

import com.lions.controller.deneme.GenreModel;
import com.lions.controller.deneme.OrdersModel;
import com.lions.controller.deneme.ShoppingCartModel;
import com.lions.controller.deneme.UsersModel;
import com.lions.controller.deneme.UsersRoleModel;
import com.lions.controller.model.Genre;
import com.lions.controller.model.Orders;
import com.lions.controller.model.Userzs;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Asus
 */
@Controller
public class UserController 
{
    @Autowired
    private UsersModel userModel =null;
    
    @Autowired
    private OrdersModel ordersModel =null;
    
    @Autowired
    private UsersRoleModel usersRoleModel=null;
    
    @Resource(name="genreService")
    private GenreModel genreModel;
    
    @Resource(name="shoppingCartService")
    private ShoppingCartModel shoppingCartModel;
    
    @RequestMapping(value="/addUser",method=RequestMethod.GET)
    public ModelAndView getAddUserPage(HttpServletRequest request)
    {
        return new ModelAndView("addUser","userModel",userModel);
        
    }
    
    @RequestMapping(value="/addUser",method =RequestMethod.POST)
    public ModelAndView addUserPagePost(@RequestParam(value="error",required=false) boolean error,ModelMap model,HttpServletRequest request)
    {
        
        
        Userzs myUser =new Userzs();
        String myUserName,myPassword,myFirstName,myLastname;
        int myUserRole=2;
        //kullanici bilgilerini aldim
        myUserName =request.getParameter("txtUsername");
        myPassword=request.getParameter("txtPassword");
        myFirstName =request.getParameter("txtFirstName");
        myLastname=request.getParameter("txtLastName");
        
        if(checkUserName(myUserName))
        {
            //giris yaparken kullanici bilgileri aldim,yetkilendirme kontrolune gore sayfa yonlendirmesi yaptim
            myUser.setFirstname(myFirstName);
            myUser.setLastname(myLastname);
            myUser.setPassword(myPassword);
            myUser.setUsername(myUserName);
            myUser.setUserrole(usersRoleModel.findUserRoleByUserzsroleid(myUserRole).getRoleid().toBigIntegerExact());
            userModel.create(myUser);
            model.put("error","");
            //Siparisleri jsp sayfasindan gelen datalari aldim
            Orders myOrders = new Orders();
            String address =request.getParameter("txtAddress");
            String city =request.getParameter("txtCity");
            String state =request.getParameter("txtState");
            String postal =request.getParameter("txtPostal");
            String phone=request.getParameter("txtPhone");
            String email=request.getParameter("txtEmail");
            Date today = new Date();
            double total =0.00;
            
            myOrders.setAdress(address);
            myOrders.setCity(city);
            myOrders.setState(state);
            myOrders.setPostalcode(postal.indexOf(postal));
            myOrders.setPhone(BigInteger.valueOf(Long.parseLong(phone)));
            myOrders.setEmail(email);
            ordersModel.create(myOrders);
            return new ModelAndView("storeIndex","userModel","userModel");
        }else
        {
            model.put("error", "Lutfen farkli bir kullanici adi seciniz.Bu kullanici adi kullanilmaktadir");
        }
        
        
        return new ModelAndView("addUser","userModel",userModel);
    }
//kullanici sifre eslesme methodu 
    public boolean checkUserName(String passUserName) 
    {
        boolean result =true;
        for(Userzs checkUser:userModel.findAllUser())
        {
            if(checkUser.getUsername().equals(passUserName))
            {
                result=false;
            }
        }
        return result;
    }
    //sayfa yapilandirma ayarlari home
    @RequestMapping(value="/",method=RequestMethod.GET)
    public String getIndexPage(ModelMap model)
    {
        List<Genre> myGenreList =genreModel.findAllGenre();
        model.put("genreList", myGenreList);
        model.put("itemNumbers", shoppingCartModel.getAlbumInCart().size());
        return "indexthelast";
    }
}

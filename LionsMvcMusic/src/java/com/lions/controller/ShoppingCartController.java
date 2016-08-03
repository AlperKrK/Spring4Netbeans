/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lions.controller;

import com.lions.controller.deneme.AlbumModel;
import com.lions.controller.deneme.ShoppingCartModel;
import com.lions.controller.model.Album;
import com.lions.controller.model.Cart;
import com.lions.controller.model.Userzs;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Asus
 */
@Controller
public class ShoppingCartController 
{
    //kullanicagim servisleri referans ettim
    @Resource(name="albumService")
    private AlbumModel albumModel;
    @Resource(name="shoppingCartService")
    private ShoppingCartModel shoppingCartModel;
    
    @RequestMapping(value="/ShoppingCart",method=RequestMethod.GET)
    public String getShoppingCartPage(@RequestParam(value="deletedAlbumid",required=false) Integer deletedAlbumid,HttpServletRequest request,HttpSession session,ModelMap model)
    {
        //format ayarlari
        NumberFormat formatter = new DecimalFormat("$0.00");
        Album myAlbum =null;
        Cart myCart = new Cart();
        String totalPrice ="";
        
        if(deletedAlbumid != null)
        {
            //admin sayfasindan album crud islemleri
            Album removedAlbum = albumModel.findByAlbumId(deletedAlbumid);
            deleteThatAlbum(removedAlbum);
            model.addAttribute("removedAlbuminfo", removedAlbum.getTitle()+"sarki listeden silindi");
            
        }else
        {
            shoppingCartModel.generateCartid();
            int addedAlbumid= (Integer) request.getSession().getAttribute("addedAlbumid");
            myAlbum=albumModel.findByAlbumId(addedAlbumid);
            shoppingCartModel.getAlbumInCart().add(myAlbum);
        }
        //attributeler uzerinden islemler
        totalPrice=formatter.format(shoppingCartModel.getTotalPrice());
        model.addAttribute("totalPrice", totalPrice);
        model.addAttribute("albumList", shoppingCartModel.getAlbumInCart());
        model.addAttribute("myCart", myCart);
        return ("ShoppingCart");
        
    }
    @RequestMapping(value="/ShoppingCart",method=RequestMethod.POST)
    public String setShoppingCartPage(@RequestParam(value="deletedAlbumid",required=false) Integer deletedAlbumid,@ModelAttribute("myCart") Cart myCart,ModelMap model)
    {
        model.addAttribute("myCartid", shoppingCartModel.getCurrentCartNumber());
        Userzs tempUsers =new Userzs();
        model.addAttribute("login", tempUsers);
        return "LoginPage";
    }

    public void deleteThatAlbum(Album album) 
    {
       shoppingCartModel.getAlbumInCart().remove(album);
    }
}

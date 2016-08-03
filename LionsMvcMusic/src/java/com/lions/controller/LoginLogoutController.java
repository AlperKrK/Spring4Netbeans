/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lions.controller;

import com.lions.controller.deneme.AlbumModel;
import com.lions.controller.deneme.GenreModel;
import com.lions.controller.deneme.OrdersDetailsModel;
import com.lions.controller.deneme.OrdersModel;
import com.lions.controller.deneme.ShoppingCartModel;
import com.lions.controller.deneme.UsersModel;
import com.lions.controller.model.Album;
import com.lions.controller.model.Cart;
import com.lions.controller.model.Genre;
import com.lions.controller.model.Orderdetail;
import com.lions.controller.model.Orders;
import com.lions.controller.model.Userzs;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
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
@RequestMapping("/Account")
public class LoginLogoutController 
{
    @Resource(name="userService")
    private UsersModel userModel;
    
    @Resource(name="shoppingCartService")
    private ShoppingCartModel shoppingCartModel;
    @Resource(name="orderService")
    private OrdersModel orderModel;
    @Resource(name="albumService")
    private AlbumModel albumModel;
    @Resource(name="orderDetailService")
    private OrdersDetailsModel orderDetailModel;
    @Resource(name="genreService")
    private GenreModel genreModel;
    
    //Login sayfasina erisim login nesnesinden kullanıcıları alıyorum.
    @RequestMapping(value="/login",method=RequestMethod.GET)
    public String getLoginPage(@RequestParam(value="error",required=false) String error,ModelMap model)
    {
        Userzs tempUser =new Userzs();
        model.addAttribute("login", tempUser);
        
        return "LoginPage";
        
    }
    //Login sayfasında kayıt olma,giriş yapma işlemleri,hata varsa error nesnesinden hata firlatir
    @RequestMapping(value="/login",method=RequestMethod.POST)
    public String postLoginPage(@RequestParam(value="error",required=false) boolean error,@ModelAttribute("login") Userzs loginUser,ModelMap model)
    {
        boolean checkLoginUser = false;
        String destination = "";
        
        checkLoginUser =userModel.verifyUserLogin(loginUser.getUsername(), loginUser.getPassword());
        if(checkLoginUser==false)
        {
            model.put("error", "Username veya password hatali");
            destination="LoginPage";
        }else
        {
            //kullanici var mi yok mu kontrolu,siparis vermis mi vermemis mi kontrolu,List olarak temp seklinde tutup kullanıcının yapmis oldugu islemler varsa Listten cekip checkout sayfasinda yansittim.
            int totalalbum=shoppingCartModel.getAlbumInCart().size();
            Userzs tempUser=userModel.findUserByUserName(loginUser.getUsername());
            Orders addOrder=orderModel.findOrderByUserid(tempUser.getUserid().intValue());
            Date now = new Date();
            Orderdetail tempOrderDetail = new Orderdetail();
            Album tempAlbum=null;
            Cart tempCart=new Cart();
            List<Album> albumList=shoppingCartModel.getAlbumInCart();
            for (int i = 0; i <totalalbum; i++) 
            {
                //orderdetail islemleri jspdeki formdan gelen datalari isleme
                tempAlbum =albumModel.findByAlbumId(albumList.get(i).getAlbumid().intValue());
                tempOrderDetail.setOrderid(addOrder);
                tempOrderDetail.setAlbumid(tempAlbum);
                tempOrderDetail.setQuantity(BigInteger.valueOf(i));
                tempOrderDetail.setUnitprice(tempAlbum.getPrice());
                orderDetailModel.create(tempOrderDetail);
                //cart islemleri jspdeki formdan gelen datalari isleme
                tempCart.setCartid(BigInteger.valueOf(shoppingCartModel.getCurrentCartNumber().intValue()));
                tempCart.setAlbumid(albumList.get(i));
                tempCart.setCount(BigInteger.valueOf(i));
                tempCart.setDatecreated(now);
                shoppingCartModel.create(tempCart);
                
            }
            //mycartid olarak alisveris yaptigimiz kartin numarasini aldim
            //genreList nesnesiyle genreleri listedim
            //checkout sayfasina gonderdim
            model.put("error","");
            model.put("myCartid", shoppingCartModel.getCurrentCartNumber());
            List<Genre> myGenreList =genreModel.findAllGenre();
            model.put("genreList", myGenreList);
            destination="CheckOut";
        }
        return destination;
    }
    
}

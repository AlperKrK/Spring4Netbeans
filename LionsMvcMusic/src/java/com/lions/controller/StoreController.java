///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.lions.controller;
//
//import com.lions.controller.deneme.GenreModel;
//import com.lions.controller.model.Genre;
//import java.util.ArrayList;
//import java.util.List;
//import javax.annotation.Resource;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
///**
// *
// * @author Asus
// */
//@Controller
//@RequestMapping("/Store")
//public class StoreController
//{
//
//    @Resource(name="genreService")
//    private GenreModel genreModel;
//    
//    @RequestMapping(value="/",method=RequestMethod.GET)
//    public String getStoreIndexPage(ModelMap model)
//    {
//        List<Genre> myGenre = new ArrayList<Genre>();
//        model.put("genreList", myGenre);
//        model.put("genreCount", myGenre.size());
//        return "StoreIndex";
//    }
//    
//}

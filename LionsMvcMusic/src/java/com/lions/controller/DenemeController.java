/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lions.controller;


import com.lions.controller.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Asus
 */
//@Controller
@Controller
public class DenemeController 
{

    @Autowired
    private GenreService genreService;
    
    @RequestMapping(value="Deneme",method=RequestMethod.GET)
    public String ListGenre(ModelMap model)
    {
        
        model.addAttribute("Lionshere", genreService.genreList());
        model.addAttribute("genreCount",genreService.genreList().size());
        
        return "Deneme";
    }
    
//    @RequestMapping(value="/Deneme",method =RequestMethod.GET)
//    public String getDeneme(Model model)
//    {
//        DenemeDao dd = new DenemeDao();
//        model.addAttribute("Lionshere", dd.genreList());
//        model.addAttribute("genreCount",dd.genreList().size() );
//       return "Deneme";
//        
//    
//    }
}

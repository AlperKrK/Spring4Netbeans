/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lions.controller;


import com.lions.controller.deneme.AlbumModel;
import com.lions.controller.deneme.ArtistModel;
import com.lions.controller.deneme.GenreModel;
import com.lions.controller.model.Album;
import com.lions.controller.model.Genre;
import com.lions.controller.service.AlbumService;
import com.lions.controller.service.GenreService;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


/**
 *
 * @author Asus
 */
@Controller
@RequestMapping("/Store")
public class HomeController 
{
 
    //Kullanacagim servisleri referans ettim
    @Resource(name="genreService")
    private GenreModel genreService;
    
    @Resource(name="albumService")
    private AlbumModel albumService;
    
    @Resource(name="artistService")
    private ArtistModel artistService;
    
    @RequestMapping(value= "",method=RequestMethod.GET)
    public String getBrowse(ModelMap model)
    {
        //parametreler
        List<Genre> myGenreList = genreService.findAllGenre()  ;
//.genreList();
        model.put("genreList", myGenreList);
        model.put("genreCount", myGenreList.size());
        return "StoreIndex";
    }
    
    @RequestMapping(value= "/Browse",method=RequestMethod.GET)
    public String getStoreBrowsePage(@RequestParam(value="genre",required=false) String genreName,ModelMap model)
    {
        List<Album> foundAlbum =   new ArrayList<Album>();
        if(genreName==null)
        {
            model.put("genre", "Empty");
        }else
        {
            //albumleri list olarak aldim parametre olarak verdigim foundalbum nesnesinden jsp sayfasinda isledim browse sayfasina yonlendirme yaptim
            List<Album> myAlbm =albumService.findAllAlbum();  //.listAlbum();
            for(Album tempAlbm :myAlbm)
            {
                if(tempAlbm.getGenreid().getName().equals(genreName))
                {
                    foundAlbum.add(tempAlbm);
                }
            }
            model.put("genre", genreName);
            model.put("foundAlbum", foundAlbum);
        }
       
        return "Browse";
    }
    
    @RequestMapping(value="/Details",method=RequestMethod.GET)
    public String getStoreDetailsPage(@RequestParam(value="albumid",required=false) Integer albumid,ModelMap model)
    {
        Album tmpAlbum =albumService.findByAlbumId(albumid);
        model.put("albumid", albumid);
        model.put("detailedAlbum", tmpAlbum);
        model.addAttribute("addAlbum", tmpAlbum);
        return "Details";
    }





}

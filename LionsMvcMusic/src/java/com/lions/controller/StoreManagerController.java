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
import com.lions.controller.model.Artist;
import com.lions.controller.model.Genre;
import java.math.BigDecimal;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Asus
 */
@Controller
@RequestMapping("/StoreManager")
public class StoreManagerController 
{
    //kullandigim servisleri referans ettim
    @Resource(name="genreService")
    private GenreModel genreModel;
    
    @Resource(name="albumService")
    private AlbumModel albumModel;
    @Resource(name="artistService")
    private ArtistModel artistModel;
    
    //Burda modelmap yerine modelandview kullandim sessionda tutmak icin aksi halde db ye git gel sistemi kastirirdi
    @RequestMapping(value="/",method=RequestMethod.GET)
    public ModelAndView getStoreManagerPage(HttpServletRequest request,HttpSession session,ModelMap model)
    {
        List<Album> albumList = albumModel.findAllAlbum();
        model.put("albumList", albumList);
        return new ModelAndView("StoreManager","albumModel",albumModel);
    }
    //Detailsalbum sayfasina erisim
    @RequestMapping(value="/DetailsAlbum",method=RequestMethod.GET)
    public String getDetailsAlbumPage(@RequestParam("detailsalbumid") int detailsalbumid,ModelMap model)
    {
        //detailsalbumid,detailalbum degerlerini parametre olarak gonderdim jsp sayfasinda da isledim
        Album myAlbum = albumModel.findByAlbumId(detailsalbumid);
        model.put("detailsalbumid", detailsalbumid);
        model.put("detailAlbum", myAlbum);
        
        return "DetailsAlbum";
    }
    //Edit controller sayfasina erisim
    @RequestMapping(value="/EditAlbum",method=RequestMethod.GET)
    public String getEditAlbumPage(@RequestParam("editalbumid") int editalbumid,ModelMap model)
    {
        Album myAlbum= albumModel.findByAlbumId(editalbumid);
        List<Genre> genreList =genreModel.findAllGenre();
        List<Artist> artistList =artistModel.findAllArtist();
        //parametreler jsp sayfasinda islemek icin
        model.put("genres", genreList);
        model.put("artists", artistList);
        model.put("selectgenre", myAlbum.getGenreid().getName());  
        model.put("selectartist", myAlbum.getArtistid().getName());
        model.addAttribute("editAlbum", myAlbum);
        
        return "EditAlbum";
    }
    
    @RequestMapping(value="/EditAlbum",method=RequestMethod.POST)
    public String setEditAlbumPage(@RequestParam("albumarturl") String albumarturl,@RequestParam("price") String price,@RequestParam("title") String txtitle,@RequestParam("genreselected") int genreSelected,@RequestParam("artistselected") int artistselected,@RequestParam("editalbumid") int editalbumid,@ModelAttribute("editAlbum") Album editAlbum)
    {
        //Admin sayfasindaki giris yaptiktan sonra album crud islemlerindeki datayi alma 
        Album myAlbum =albumModel.findByAlbumId(editalbumid);
        Genre myGenre =genreModel.findByGenreId(genreSelected);
        Artist myArtist=artistModel.findByArtistId(artistselected);
        myAlbum.setGenreid(myGenre);
        myAlbum.setTitle(txtitle);
        myAlbum.setArtistid(myArtist);
        BigDecimal bprc= new BigDecimal(price);
        myAlbum.setPrice(bprc);
        myAlbum.setAlbumarturl(albumarturl);
        albumModel.edit(myAlbum);
        
        return "redirect:";
    }
    
    
    @RequestMapping(value="/CreateAlbum",method=RequestMethod.GET)
    public String getCreateAlbumPage(ModelMap model)
    {
        Album myAlbum = new Album();
        List<Genre> genreList =genreModel.findAllGenre();
        List<Artist> artistList =artistModel.findAllArtist();
        //parametreleri jspde isledim sayfa yonlendirmesini yaptim
        model.put("genres", genreList);
        model.put("artists", artistList);
        model.addAttribute("createAlbum",myAlbum);
        
        return "CreateAlbum";
    }
    //Album ekle islemleri burada redirect: ile kendinden bir onceki controllere geri doner otomatik olarak
    @RequestMapping(value="/CreateAlbum",method=RequestMethod.POST)
    public String setCreateAlbumPage(@RequestParam("genreSelected")Integer genreSelected,@RequestParam("artistSelected") Integer artistSelected,@ModelAttribute("createAlbum") Album createAlbum)
    {
        Genre myGenre =genreModel.findByGenreId(genreSelected);
        Artist myArtist=artistModel.findByArtistId(artistSelected);
        createAlbum.setGenreid(myGenre);
        createAlbum.setArtistid(myArtist);
        albumModel.create(createAlbum);
        return "redirect:";
    }
    
    @RequestMapping(value="/DeleteAlbum",method=RequestMethod.GET)
    public String getDeleteAlbumPage(@RequestParam("deletealbumid") Integer deletealbumid,ModelMap model)
    {
        Album myAlbum =albumModel.findByAlbumId(deletealbumid);
        model.put("albumdeleted", myAlbum);
        model.addAttribute("deleteAlbum", myAlbum);
        return "DeleteAlbum";
    }
    @RequestMapping(value="/DeleteAlbum",method=RequestMethod.POST)
    public String setDeleteAlbumPage(@RequestParam("deletealbumid") Integer deletealbumid,@ModelAttribute("deleteAlbum") Album create,ModelMap model)
    {
        Album myAlbum = albumModel.findByAlbumId(deletealbumid);
        model.put("albumdeleted", myAlbum);
        albumModel.delete(myAlbum);
        return"redirect:";
    }
    
}

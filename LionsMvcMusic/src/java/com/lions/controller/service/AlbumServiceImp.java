/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lions.controller.service;

import com.lions.controller.model.Album;
import com.lions.controller.model.Genre;
import com.lions.controller.repository.AlbumRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Asus
 */

//repository classini referans edip methodlari servis katmanında cagirdim
@Service("AlbumService")
public class AlbumServiceImp implements AlbumService
{

    @Autowired
    private AlbumRepository albumRepository;
    
    @Override
    public List<Album> listAlbum() 
    {
     return albumRepository.listAlbum();
    }

    @Override
    public void add(Album album) 
    {
     albumRepository.add(album);
    }

    @Override
    public void edit(Album album) 
    {
      albumRepository.edit(album);
    }

   

    @Override
    public Album findByAlbumId(int passid) 
    {
       return albumRepository.findAlbumById(passid);
    }

    @Override
    public Genre findGenreIdByAlbum(int passid) {
      return albumRepository.findGenreIdByAlbum(passid);
    }

    @Override
    public void delete(Album album) 
    { 
        albumRepository.delete(album);
    }
    
}

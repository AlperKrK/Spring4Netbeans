/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lions.controller.service;

import com.lions.controller.model.Album;
import com.lions.controller.model.Genre;
import java.util.List;

/**
 *
 * @author Asus
 */
public interface AlbumService 
{
    public List<Album> listAlbum();
    public void add(Album album);
    public void edit(Album album);
    public void delete(Album album);
    public Album findByAlbumId(int passid);
    public Genre findGenreIdByAlbum(int passid);
    
}

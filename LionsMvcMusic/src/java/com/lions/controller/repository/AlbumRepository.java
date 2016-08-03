/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lions.controller.repository;

import com.lions.controller.model.Album;
import com.lions.controller.model.Genre;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author Asus
 */

//Projenin basinda repositoryden yapayim demistim ama tek tablo icin daha kullanisli oldugunu gordum.
//Bir veya daha fazla iliskisel tablo yapisi varsa Generic Repository kullanmak daha mantikli olacaktir.
public interface AlbumRepository 
{
    public List<Album> listAlbum();
    public void add(Album album);
    public void edit(Album album);
    public void delete(Album album);
    public Album findAlbumById(int passid);
    public Genre findGenreIdByAlbum(int passid);
    
}

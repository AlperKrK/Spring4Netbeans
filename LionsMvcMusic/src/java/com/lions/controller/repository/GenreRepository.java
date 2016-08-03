/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lions.controller.repository;

import com.lions.controller.model.Genre;
import java.util.List;

/**
 *
 * @author Asus
 */
//Bir veya daha interface ile repository metotlari olusturulabilir.
//Projenin basinda repositoryden yapayim demistim ama tek tablo icin daha kullanisli oldugunu gordum.
//Bir veya daha fazla iliskisel tablo yapisi varsa Generic Repository kullanmak daha mantikli olacaktir.
public interface GenreRepository 
{
    
    public List<Genre> listGenre();
    public void create(Genre genre);
    public Genre findByGenreId(int passid);
    
}

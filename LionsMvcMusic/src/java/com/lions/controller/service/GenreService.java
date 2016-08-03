/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lions.controller.service;

import com.lions.controller.model.Genre;
import java.util.List;

/**
 *
 * @author Asus
 */
public interface GenreService 
{
    public List<Genre> genreList();
    public void create(Genre genre);
    public Genre findByGenreId(int passid);
    
}

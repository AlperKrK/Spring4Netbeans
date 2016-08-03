/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lions.controller.service;

import com.lions.controller.model.Genre;
import com.lions.controller.repository.GenreRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Asus
 */

//repository classini referans edip methodlari servis katmaninda cagirdim
@Service
@Transactional
public class GenreServiceImp implements GenreService
{

    @Autowired
    private GenreRepository genreRepository;
    
    @Override
    public List<Genre> genreList() 
    {
       return genreRepository.listGenre();
    }

    @Override
    public void create(Genre genre) 
    {
        genreRepository.create(genre);
    }

    @Override
    public Genre findByGenreId(int passid) 
    {
        return genreRepository.findByGenreId(passid);
    }
    
}

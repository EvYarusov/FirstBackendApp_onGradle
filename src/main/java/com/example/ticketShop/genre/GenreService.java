package com.example.ticketShop.genre;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenreService
{
    private static final ModelMapper modelMapper = new ModelMapper();

    private GenreRepository genreRepository;

    @Autowired
    public void setGenreRepository(GenreRepository genreRepository)
    {
        this.genreRepository = genreRepository;
    }

    public int createNewGenre(NewGenreDTO newGenreDTO)
    {
        Genre genre = modelMapper.map(newGenreDTO, Genre.class);

        int id = genreRepository.save(genre).getId();

        return id;
    }

    public GenreDTO getGenreById(int genreId)
    {
        //TODO add the handling of exception
        Genre genre = genreRepository.findById(genreId).get();

        GenreDTO genreDTO = modelMapper.map(genre, GenreDTO.class);

        return genreDTO;
    }

}

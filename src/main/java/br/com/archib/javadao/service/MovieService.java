package br.com.archib.javadao.service;

import br.com.archib.javadao.dao.MovieDaoImpl;
import br.com.archib.javadao.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("movieService")
@Transactional
public class MovieService {

    @Autowired
    private MovieDaoImpl dao;

    public void save(Movie movie) {
        dao.save(movie);
    }

    public List<Movie> findAll() {
        return dao.findAll();
    }

    public Movie findById(Integer id) {
        return dao.findById(id);
    }

    public void remove(Movie movie){
        dao.remove(movie);
    }
}

package br.com.archib.javadao.dao;

import br.com.archib.javadao.model.Movie;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class MovieDaoImpl extends DaoBase<Movie> implements MovieDao {

    public MovieDaoImpl(SessionFactory sessionFactory) {
        super(Movie.class);
        super.setSessionFactory(sessionFactory);
    }

}

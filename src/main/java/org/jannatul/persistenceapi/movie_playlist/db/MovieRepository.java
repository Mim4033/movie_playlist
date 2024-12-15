/**
 * @author Jannatul Ferdous
 * @version 1.0
 * this class handles the communication with the database
 * it uses EntityManager to read and write and have some logic to handle
 * if a movie is in database or not
 */

package org.jannatul.persistenceapi.movie_playlist.db;

import jakarta.enterprise.context.ApplicationScoped;// Mark this class as application-wide and reusable
import jakarta.persistence.EntityManager;// EntityManager, to read and write with a database
import jakarta.persistence.PersistenceContext;// Link to a persistence context for managing database operations
import jakarta.persistence.Query;// Tool to create and run database queries
import jakarta.transaction.Transactional;// Mark methods as transactional (ensure data consistency)
import org.jannatul.persistenceapi.movie_playlist.Model.Movie;// Import the Movie class

import java.util.List;// Import List to handle multiple Movie objects


@ApplicationScoped
@Transactional
public class MovieRepository {

    /**
     * EntityManager for reading and writing with the database.
     */
    @PersistenceContext
    private EntityManager em;

    /**
     * Gets all movies from database.
     * @return a list of all Movie
     */
    public List<Movie> findMovie() {
        String sql = "Select * From appmovie";
        Query query = em.createNativeQuery(sql);
        List<Movie> movies = query.getResultList();
        return movies;
    }
    /**
     * New Movie to the database.
     * @param movie the Movie to be created
     */
    public void create(Movie movie) {
        em.persist(movie);// Save the movie to the database
    }
    /**
     * Finds a Movie by its  ID.
     * @param id the ID of the movie to find
     * @return the Movie if found or not found message
     */
    public Movie findById(Long id) {
        Movie movie = em.find(Movie.class, id);
        if (movie != null) {
            System.out.println("Movie found: " + movie.getId());
        } else {
            System.out.println("Movie not found.");
        }
        return em.find(Movie.class, id);
    }
    /**
     * Updates existing Movie in the database.
     * @param movie the Movie with updated attributes
     */
    public void update(Movie movie) {

        em.merge(movie);// Update the movie details in the database
    }
    /**
     * Deletes a Movie by its unique ID.
     * @param Id of the movie to delete
     */

    public void delete(Long Id) {
        Movie movie = findById(Id);
        em.remove(movie);
    }


    public Movie findByTitle(String title) {
        Movie movie = em.find(Movie.class, title);
        if (movie != null) {// If the movie is found
            System.out.println("Movie found: " + movie.getTitle());

        }else {
            System.out.println("Movie not found.");
        }
        return movie;
    }

    /**
     * Work in progress
     * the code below is to allow more ways to get movie information
     * by title, year, director etc. but it's not implemented yet.
     */
    public  Movie findByGenre(String genre) {
        Movie movie = em.find(Movie.class, genre);
        if (movie != null) {
            System.out.println("Movie found: " + movie.getGenre());
        }else {
            System.out.println("Movie not found.");
        }
        return movie;
    }


    public Movie findByYear(int year) {
        Movie movie = em.find(Movie.class, year);
        if (movie != null) {
            System.out.println("Movie found: " + movie.getReleaseYear());
        }else {
            System.out.println("Movie not found.");
        }
        return movie;
    }


    public Movie findByDescription(String description) {
        Movie movie = em.find(Movie.class, description);
        if (movie != null) {
            System.out.println("Movie found: " + movie.getDescription());
        }else {
            System.out.println("Movie not found.");
        }
        return movie;
    }


    public Movie findbyDirector(String director) {
        Movie movie = em.find(Movie.class, director);
        if (movie != null) {
            System.out.println("Movie found: " + movie.getDirector());
        }else {
            System.out.println("Movie not found.");
        }
        return movie;
    }


    public Movie findByActor(String actor) {
        Movie movie = em.find(Movie.class, actor);
        if (movie != null) {
            System.out.println("Movie found: " + movie.getActors());

        }else {
            System.out.println("Movie not found.");
        }
        return movie;
    }

}





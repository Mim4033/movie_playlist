/**
 * @author Jannatul Ferdous
 * @version 1.0
 * this class handles entity and attributes for the movies
 * and maps the attributes to appmovie database
 * access is done through getter and setter methods
 */

package org.jannatul.persistenceapi.movie_playlist.Model;
import jakarta.persistence.*; // Import Java Persistence API annotations

@Entity
@Table(name ="appmovie")

public class Movie {
    /**
     *An empty constructor needed by the JPA
     */
    public Movie() {
    }
    /**
     *ID is unique, the value generated automatically and cant be null
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)

    /**
     * Movie attributes
     * id, title, description, genre, releaseyear, director and actors
     */
    private long id;
    private String title;
    private String description;
    private String genre;
    private int releaseYear;
    private String director;
    private String actors;

    /**
     * Constructor that sets all the fields when creating a new Movie instance
     * @param id            Unique ID for movie
     * @param title         Movie title
     * @param description   Movie description
     * @param genre         Movie genre
     * @param year          Movie year
     * @param director      Movie director
     * @param actors        Movie actors
     */

    public Movie(long id, String title, String description, String genre,
                 int year, String director, String actors) {

        this.id = id;
        this.title = title;
        this.description = description;
        this.genre = genre;
        this.releaseYear = year;
        this.director = director;
        this.actors = actors;
    }
    /**
     * @return movie id
     */
    public long getId() {
        return id;
    }
    /**
     * Sets a new ID for the movie
     */
    public void setId(long id) {
        this.id = id;
    }
    /**
     * @return movie title
     */
    public String getTitle() {
        return title;
    }
    /**
     * Sets a new title for the movie
     */
    public void setTitle(String title) {
        this.title = title;
    }
    /**
     * @return movie description
     */
    public String getDescription() {
        return description;
    }
    /**
     * Sets a new description for the movie
     */
    public void setDescription(String description) {
        this.description = description;
    }
    /**
     * @return movie genre
     */
    public String getGenre() {
        return genre;
    }
    /**
     * Sets a new genre for the movie
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }
    /**
     * @return movie release year
     */
    public int getReleaseYear() {
        return releaseYear;
    }
    /**
     * Sets a new release year for the movie
     */
    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }
    /**
     * @return movie director
     */
    public String getDirector() {
        return director;
    }
    /**
     * Sets a new director for the movie
     */
    public void setDirector(String director) {
        this.director = director;
    }
    /**
     * @return movie actors
     */
    public String getActors() {
        return actors;
    }
    /**
     * Sets a new actors for the movie
     */
    public void setActors(String actors) {
        this.actors = actors;
    }
}

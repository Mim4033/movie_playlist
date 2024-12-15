/**
 * @author Jannatul Ferdous
 * @version 1.0
 * this class handles incoming http request for this application
 * handles the incoming api get, put, post and delete and communicates with MovieRepository
 */

package org.jannatul.persistenceapi.movie_playlist.Model;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.jannatul.persistenceapi.movie_playlist.db.*;
import java.util.List;

/**
 * For creating,showing, editing and removing movies from database using restful api.
 */
    @Path("/movie")
    public class MovieResource {
    /**
     *Inject the MovieRepository dependency
     */
    @Inject
    private MovieRepository movieRepository;
    /**
     * @return all movies in JSON from repository
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)

    public List<Movie> getMovies() {
        return movieRepository.findMovie();
    }
    /**
     *Adds new movie to repository
     *@param movie to be added
     *@return http status code and comment if successful
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response addMovie(Movie movie) {
        movieRepository.create(movie);
        return Response.status(Response.Status.CREATED)
                .entity("Movie created Successfully")
                .build();
    }
    /**
     *gets movie by id from repository
     *@param id to get
     *@return movie if found or trow 404 response if not found
     */
    @GET
    @Path("/{id}")
        public Response getMovieById(@PathParam("id") Long id) {
            Movie movie = movieRepository.findById(id);
            if (movie == null) {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity("Movie not found").build();
            }
            return Response.ok(movie).build();
        }

    /**
     *update movie by id from repository
     *@param id of the movie to update
     *@return if update successful movie is updated and response code 200 with message
     * if failed then response code 404 with message
     */
    @PUT
    @Path("/{id}")
    public Response updateMovie(@PathParam("id") Long id, Movie updatedMovie) {
        Movie existingMovie = movieRepository.findById(id);
        if (existingMovie == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Movie not found").build();

        }

        if (updatedMovie.getTitle() != null) {
            existingMovie.setTitle(updatedMovie.getTitle());
        }
        if (updatedMovie.getGenre() != null) {
            existingMovie.setGenre(updatedMovie.getGenre());
        }
        if (updatedMovie.getReleaseYear() != 0) {
            existingMovie.setReleaseYear(updatedMovie.getReleaseYear());
        }
        if (updatedMovie.getDirector() != null) {
            existingMovie.setDirector(updatedMovie.getDirector());
        }
        if (updatedMovie.getDescription() != null) {
            existingMovie.setDescription(updatedMovie.getDescription());
        }
        if (updatedMovie.getActors() != null) {
            existingMovie.setActors(updatedMovie.getActors());
        }
        movieRepository.update(existingMovie);
        return Response.ok("Movie updated successfully "
                + updatedMovie.getTitle()).build();
    }
    /**
     *delete movie by id from repository
     *@param id of the movie to delete
     *@return if update successfully movie deleted then response code 200 with message
     * if failed then response code 404 with message
     */
    @DELETE
    @Path("/{id}")
    public Response deleteMovie(@PathParam("id") Long id) {
        Movie existingMovie = movieRepository.findById(id);
        if (existingMovie == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Movie not found").build();
        }
        movieRepository.delete(id);
        return Response.ok("Movie with ID " + id + " has been deleted successfully.")
                .build();
    }
    /**
     *Create test movie instance and return JSON
     *@return JSON of test movie instance
     */
    @GET
    @Path("/movie-test")
    @Produces(MediaType.APPLICATION_JSON)
    public Movie createtestMovie() {
        Movie movie = new Movie(10L,"Parasite", "logndec.", "Thriller, Drama", 2019, "Bong Joon-ho", "Song Kang-ho, Lee Sun-kyun, Cho Yeo-jeong, Choi Woo-shik, Park So-dam");

        return movie;
    }

}




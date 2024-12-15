/**
 * @author Jannatul Ferdous
 * @version 1.0
 * this class base url for this application
 * extends the import jakarta.ws.rs.core.Application with our custom path
 */
package org.jannatul.persistenceapi.movie_playlist.Model;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

/**
 * path for application web service
 */
@ApplicationPath("/api")
public class RestApplication extends Application {

}

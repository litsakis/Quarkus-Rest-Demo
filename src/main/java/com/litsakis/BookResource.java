package com.litsakis;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Optional;
import org.jboss.logging.Logger;

@Path("/api/books")
public class BookResource {
    @Inject
    BookRepository repository;
    @Inject
    Logger logger;
    @GET
  //  @Produces(MediaType.TEXT_PLAIN)
    public List<Book> getAllBooks() {
        logger.info("Return All Books");
        return repository.getAllBooks();
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public int countAllBooks(){
        logger.info("Return the number Books");

        return repository.getAllBooks().size();

    }

    @GET
    @Path("{id}")
    public Optional<Book> getBook(@PathParam("id") int id){
        logger.info("Return single Book with id "+id);


        return repository.getBook(id);
    }
}
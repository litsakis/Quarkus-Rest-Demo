package com.litsakis;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Optional;

@Path("/api/books")
public class GreetingResource {

    @GET
  //  @Produces(MediaType.TEXT_PLAIN)
    public List<Book> getAllBooks() {
        return List.of(new Book(1,"Book Title","Alex Litsakis",2022,"IT"),
                new Book(2,"Book Title 2","Alex Litsakis",2020,"IT"),
                new Book(3,"Book Title 3","Alex Litsakis",1990,"IT")
                );
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public int countAllBooks(){
        return getAllBooks().size();

    }

    @GET
    @Path("{id}")
    public Optional<Book> getBook(@PathParam("id") int id){


        return getAllBooks().stream().filter(book -> book.id == id).findFirst();
    }
}
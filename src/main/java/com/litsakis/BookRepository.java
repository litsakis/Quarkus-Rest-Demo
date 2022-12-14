package com.litsakis;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Optional;



@ApplicationScoped
public class BookRepository {
    @ConfigProperty(name= "books.genre", defaultValue="IT")
    String genre;
  //  @Produces(MediaType.TEXT_PLAIN)
    public List<Book> getAllBooks() {
        return List.of(new Book(1,"Book Title","Alex Litsakis",2022,genre),
                new Book(2,"Book Title 2","Alex Litsakis",2020,genre),
                new Book(3,"Book Title 3","Alex Litsakis",1990,genre)
                );
    }

    public Optional<Book> getBook(@PathParam("id") int id){


        return getAllBooks().stream().filter(book -> book.id == id).findFirst();
    }
}
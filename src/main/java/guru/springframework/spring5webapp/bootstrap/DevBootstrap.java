package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }
    private void initData() {

        Publisher publisher = new Publisher();
        publisher.setName("Manning");
        publisher.setAddress("Florida, USA");
        // craig walls
        Author craig = new Author("Craig","Walls");
        Book sia = new Book("Spring in Action","1234");
       // Publisher bkb = new Publisher("Manning", "Florida, USA");
        craig.getBooks().add(sia);
        sia.getAuthors().add(craig);


        authorRepository.save(craig);
        bookRepository.save(sia);
        publisherRepository.save(publisher);

        // Ingeno Joseph
        Author joseph = new Author("Ingeno", "Joseph");
        Book sah = new Book("Software Architect Handbook","5678");
       // Publisher ibm = new Publisher("DB2", "California, United States");
        joseph.getBooks().add(sah);
        sah.getAuthors().add(joseph);


        authorRepository.save(joseph);
        bookRepository.save(sah);


    }

}

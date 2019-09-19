package guru.springframework.spring5webapp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

  private AuthorRepository authorRepository;
  
  private BookRepository bookRepository;
  
  private PublisherRepository publisherRepository;
  
  public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
    super();
    this.authorRepository = authorRepository;
    this.bookRepository = bookRepository;
    this.publisherRepository = publisherRepository;
  }

  @Override
  public void onApplicationEvent(ContextRefreshedEvent event) {
    initData();
  }

  private void initData() {
    //Eric
    Author eric = new Author("Eric", "Evans");
    Publisher harper = new Publisher("Harper Collins", "Main street");
    Book ddd = new Book("Domain Driven Design", "1234", harper);
    eric.getBooks().add(ddd);
    ddd.getAuthors().add(eric);
    
    authorRepository.save(eric);
    publisherRepository.save(harper);
    bookRepository.save(ddd);
    
    //Rod
    Author rod = new Author("Rod", "Johnson");
    Publisher worx = new Publisher("Worx", "Second street");
    Book noEJB = new Book("Java EE Deployment without EJB", "23444", worx);
    rod.getBooks().add(noEJB);
    
    authorRepository.save(rod);
    publisherRepository.save(worx);
    bookRepository.save(noEJB);
  }
}

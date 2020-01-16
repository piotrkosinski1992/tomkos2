package com.tomkos2.product.app.usecase;

import com.tomkos2.product.app.domain.Book;
import com.tomkos2.product.app.domain.Category;
import com.tomkos2.product.app.repo.BookRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BookUsecase {

    private final RestTemplate restTemplate;
    private final BookRepository repository;

    public BookUsecase(RestTemplate restTemplate, BookRepository repository) {
        this.restTemplate = restTemplate;
        this.repository = repository;
    }

    public List<Book> findByCategory(Category category) {
        return repository.findByCategory(category).stream()
          .filter(this::isAvailableInStock)
          .collect(Collectors.toList());
    }

    private Boolean isAvailableInStock(Book book) {
        return restTemplate
          .getForObject("http://inventory/isbn/" + book.getIsbn() + "/instock", Boolean.class);
    }

    public Book findByIsbn(String isbn) {
        return repository.findByIsbn(isbn)
          .orElseThrow(() -> new RuntimeException("Book with isbn " + isbn + " not found"));
    }

    public List<Book> findLike(String phrase) {
        return repository.findLike(phrase).stream()
          .filter(this::isAvailableInStock)
          .collect(Collectors.toList());
    }

    public List<Book> findAllBy(List<String> isbnList) {
        return repository.findAllById(isbnList);
    }
}

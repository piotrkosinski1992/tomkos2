package com.tomkos2.monolith.app.book.usecase;

import com.tomkos2.monolith.app.book.domain.Book;
import com.tomkos2.monolith.app.book.domain.BookDetails;
import com.tomkos2.monolith.app.book.domain.Category;
import com.tomkos2.monolith.app.book.repo.BookRepository;
import com.tomkos2.monolith.app.inventory.usecase.InventoryUsecase;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class BookUsecase {

  private final InventoryUsecase inventoryUsecase;
  private final BookRepository repository;

  public BookUsecase(InventoryUsecase inventoryUsecase, BookRepository repository) {
    this.inventoryUsecase = inventoryUsecase;
    this.repository = repository;
  }

  public List<Book> findByCategory(Category category) {
    return repository.findByCategory(category).stream()
        .filter(this::isAvailableInStock)
        .collect(Collectors.toList());
  }

  private Boolean isAvailableInStock(Book book) {
    return inventoryUsecase.isBookInStock(book.getIsbn());
  }

  public BookDetails findByIsbn(String isbn) {
    return repository.findByIsbn(isbn)
        .orElseThrow(() -> new RuntimeException("Book with isbn " + isbn + " not found"));
  }

  public List<Book> findLike(String phrase) {
    return repository.findLike(phrase).stream()
        .filter(this::isAvailableInStock)
        .collect(Collectors.toList());
  }

  public List<BookDetails> findAllBy(List<String> isbnList) {
    return repository.findAllById(isbnList);
  }

  public List<Book> findNewest() {
    return repository.findNewest();
  }
}

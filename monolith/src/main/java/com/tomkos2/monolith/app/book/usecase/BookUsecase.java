package com.tomkos2.monolith.app.book.usecase;

import com.tomkos2.monolith.app.book.domain.Book;
import com.tomkos2.monolith.app.book.domain.BookDetails;
import com.tomkos2.monolith.app.book.domain.Category;
import com.tomkos2.monolith.app.book.repo.BookRepository;
import com.tomkos2.monolith.app.book.repo.CategoryRepository;
import com.tomkos2.monolith.app.inventory.usecase.InventoryUsecase;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class BookUsecase {

  private final InventoryUsecase inventoryUsecase;
  private final BookRepository bookRepository;
  private final CategoryRepository categoryRepository;

  public BookUsecase(InventoryUsecase inventoryUsecase, BookRepository bookRepository,
      CategoryRepository categoryRepository) {
    this.inventoryUsecase = inventoryUsecase;
    this.bookRepository = bookRepository;
    this.categoryRepository = categoryRepository;
  }

  private Boolean isAvailableInStock(Book book) {
    return inventoryUsecase.isBookInStock(book.getIsbn());
  }

  public BookDetails findByIsbn(String isbn) {
    return bookRepository.findByIsbn(isbn)
        .orElseThrow(() -> new RuntimeException("Book with isbn " + isbn + " not found"));
  }

  public List<Book> findLike(String phrase) {
    return bookRepository.findLike(phrase).stream()
        .filter(this::isAvailableInStock)
        .collect(Collectors.toList());
  }

  public List<BookDetails> findAllBy(List<String> isbnList) {
    return bookRepository.findAllById(isbnList);
  }

  public List<Book> findNewest() {
    return bookRepository.findNewest();
  }

  public List<Category> fetchCategories() {
    return categoryRepository.findAll();
  }
}

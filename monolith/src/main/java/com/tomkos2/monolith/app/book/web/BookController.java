package com.tomkos2.monolith.app.book.web;

import com.tomkos2.monolith.app.book.domain.Category;
import com.tomkos2.monolith.app.book.usecase.BookUsecase;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {

  private final BookUsecase usecase;
  private final BookMapper mapper;

  public BookController(BookUsecase usecase, BookMapper mapper) {
    this.usecase = usecase;
    this.mapper = mapper;
  }

  @GetMapping("/category/{category}")
  public List<BookDTO> findByCategory(@PathVariable String category) {
    return usecase.findByCategory(Category.valueOf(category)).stream()
        .map(mapper::toBookDTO)
        .collect(Collectors.toList());
  }

  @GetMapping("/isbn/{isbn}")
  public BookDetailsDTO findByIsbn(@PathVariable String isbn) {
     return mapper.toBookDetailsDTO(usecase.findByIsbn(isbn));
  }

  @GetMapping("/like/{phrase}")
  public List<BookDTO> findLike(@PathVariable String phrase) {
    return usecase.findLike(phrase).stream()
        .map(mapper::toBookDTO)
        .collect(Collectors.toList());
  }

  @GetMapping("/newest")
  public List<BookDTO> findNewest() {
    return usecase.findNewest().stream()
        .map(mapper::toBookDTO)
        .collect(Collectors.toList());
  }
}

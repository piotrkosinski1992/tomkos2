package com.tomkos2.book.app.web;

import com.tomkos2.book.app.domain.Category;
import com.tomkos2.book.app.usecase.BookUsecase;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
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

    @PostMapping("/isbn/all")
    public List<BookDTO> findAllById(@RequestBody List<String> isbnList) {
        return usecase.findAllBy(isbnList).stream()
          .map(mapper::toBookDTO)
          .collect(Collectors.toList());
    }

    @GetMapping("/like/{phrase}")
    public List<BookDTO> findLike(@PathVariable String phrase) {
        return usecase.findLike(phrase).stream()
          .map(mapper::toBookDTO)
          .collect(Collectors.toList());
    }
}

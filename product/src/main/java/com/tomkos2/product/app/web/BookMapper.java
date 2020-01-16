package com.tomkos2.product.app.web;

import com.tomkos2.product.app.domain.Book;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class BookMapper {

    ModelMapper mapper = new ModelMapper();

    BookDetailsDTO toBookDetailsDTO(Book book) {
        return mapper.map(book, BookDetailsDTO.class);
    }

    BookDTO toBookDTO(Book book) {
        return mapper.map(book, BookDTO.class);
    }
}

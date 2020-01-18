package com.tomkos2.monolith.app.book.web;

import com.tomkos2.monolith.app.book.domain.Book;
import com.tomkos2.monolith.app.book.domain.BookDetails;
import org.modelmapper.AbstractConverter;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class BookMapper {

  ModelMapper mapper;

  public BookMapper() {
    mapper = new ModelMapper();
    mapper.addConverter(formatPriceToDouble());
  }

  BookDetailsDTO toBookDetailsDTO(BookDetails bookDetails) {
    return mapper.map(bookDetails, BookDetailsDTO.class);
  }

  public BookDTO toBookDTO(Book book) {
    return mapper.map(book, BookDTO.class);
  }

  private AbstractConverter<String, Double> formatPriceToDouble() {
    return new AbstractConverter<String, Double>() {
      @Override
      protected Double convert(String priceWithCurrency) {
        String priceWithoutCurrency = priceWithCurrency
            .substring(1, priceWithCurrency.length() - 1);
        return Double.parseDouble(priceWithoutCurrency);
      }
    };
  }
}

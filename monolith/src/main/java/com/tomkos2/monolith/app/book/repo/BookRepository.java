package com.tomkos2.monolith.app.book.repo;

import com.tomkos2.monolith.app.book.domain.Book;
import com.tomkos2.monolith.app.book.domain.BookDetails;
import com.tomkos2.monolith.app.book.domain.Page;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class BookRepository {

  private final RestTemplate restTemplate;
  private HttpEntity<String> headers;
  private final String URL = "https://api.itbook.store/1.0";

  public BookRepository(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
    this.headers = addHeaders(this.restTemplate);
  }

  public List<Book> findLike(String phrase) {
    return restTemplate
        .exchange(URL + "/search/" + phrase, HttpMethod.GET,
            headers, Page.class).getBody().getBooks();
  }

  public Optional<BookDetails> findByIsbn(String isbn) {
    return Optional.of(queryBookDetailsByIsbn(isbn));
  }

  public List<BookDetails> findAllById(List<String> isbnList) {
    return isbnList.stream()
        .map(this::queryBookDetailsByIsbn)
        .collect(Collectors.toList());
  }

  private BookDetails queryBookDetailsByIsbn(String isbn) {
    return restTemplate
        .exchange(URL + "/books/" + isbn, HttpMethod.GET,
            headers, BookDetails.class).getBody();
  }

  public List<Book> findNewest() {
    return restTemplate
        .exchange(URL + "/new", HttpMethod.GET,
            headers, Page.class).getBody().getBooks();
  }

  private HttpEntity<String> addHeaders(RestTemplate restTemplate) {
    HttpHeaders headers = new HttpHeaders();
    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
    headers.add("user-agent",
        "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
    return new HttpEntity<>("parameters", headers);
  }
}

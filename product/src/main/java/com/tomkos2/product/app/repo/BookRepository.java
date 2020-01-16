package com.tomkos2.product.app.repo;

import com.tomkos2.product.app.domain.Book;
import com.tomkos2.product.app.domain.Category;
import com.tomkos2.product.app.domain.Page;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Qualifier;
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

    public BookRepository(@Qualifier("external") RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        this.headers = addHeaders(this.restTemplate);
    }

    public List<Book> findByCategory(Category category) {
        return restTemplate
          .exchange(URL +"/search/" + category.name(), HttpMethod.GET,
            headers, Page.class).getBody().getBooks();
    }

    public List<Book> findLike(String phrase) {
        return restTemplate
          .exchange(URL + "/search/" + phrase, HttpMethod.GET,
            headers, Page.class).getBody().getBooks();
    }

    public Optional<Book> findByIsbn(String isbn) {
        //TODO ZBADAC RETURN TYPE POJEDYNCZEGO
/*        return Optional.of(restTemplate
          .exchange(URL + "/books/" + isbn, HttpMethod.GET,
            headers, Page.class).getBody().getBooks());*/
        return null;
    }

    public List<Book> findAllById(List<String> isbnList) {
        //TODO odwoływac się do metody powyżej i kumulować input
        return null;
    }

    public List<Book> findNewest() {
        //TODO URL + "/new"
        return null;
    }

    private HttpEntity<String> addHeaders(RestTemplate restTemplate) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("user-agent",
          "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        return new HttpEntity<>("parameters", headers);
    }
}

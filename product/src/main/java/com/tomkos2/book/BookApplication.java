package com.tomkos2.book;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.web.client.RestTemplate;

@EnableDiscoveryClient
@SpringBootApplication
public class BookApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(BookApplication.class, args);
    }

    @Override
    public void run(String... args) {
/*    HttpHeaders headers = new HttpHeaders();
    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
    headers.add("user-agent",
      "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
    HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
    Page response = getExternalRestTemplate()
      .exchange("https://api.itbook.store/1.0/search/java", HttpMethod.GET,
        entity, Page.class).getBody();

    System.out.println(response.getBooks());*/
    }

    @LoadBalanced
    @Primary
    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @Bean("external")
    public RestTemplate getExternalRestTemplate() {
        return new RestTemplate();
    }
}

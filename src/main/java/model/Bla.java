package model;

import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.util.retry.Retry;

import java.time.Duration;

@SpringBootApplication
public class Bla {

    public static void main(String[] args) {
        System.out.println("Miau");
        SpringApplication.run(Bla.class, args);

        int iTest = 47;


    //    WebClient webClient = WebClient.create("https://www.google.com/");

/*
        webClient.get().uri("search?q=Hallo")
                       .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                               .retrieve();
*/

      //  String testString = "df";

//https://de.search.yahoo.com/search?p=test
        String testString = WebClient.create("https://de.search.yahoo.com").get()
                .uri("/search?p=test")
                .retrieve()
                .bodyToMono(String.class)
                .block();





        System.out.println(testString);



        /*
        WebClient webClient = WebClient.create("http://localhost:3000");
        Student tmpStudent = new Student("Willi", 69);

        webClient.post()
                .uri("/students/add/")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(Mono.just(tmpStudent), Student.class);
                */

    }
}

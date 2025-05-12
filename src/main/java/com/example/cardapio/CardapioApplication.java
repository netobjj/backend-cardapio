package com.example.cardapio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.example.cardapio")
@SpringBootApplication
public class CardapioApplication {

    public static void main(String[] args) {
        SpringApplication.run(CardapioApplication.class, args);
    }

}

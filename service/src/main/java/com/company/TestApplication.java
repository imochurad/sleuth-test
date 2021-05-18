package com.company;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class TestApplication {

    public static void main(String[] args) {

        new SpringApplicationBuilder()
                .bannerMode(Banner.Mode.CONSOLE)
                .sources(TestApplication.class)
                .run(args);

    }
}

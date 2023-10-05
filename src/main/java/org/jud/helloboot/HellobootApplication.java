package org.jud.helloboot;

import config.MySpringBootApplication;
import org.springframework.boot.SpringApplication;

@MySpringBootApplication
public class HellobootApplication {

    public static void main(String[] args) {
        // 클래스를 따로 만들어서 상속하지않고 익명클래스로 만듦
        SpringApplication.run(HellobootApplication.class, args);
    }

}

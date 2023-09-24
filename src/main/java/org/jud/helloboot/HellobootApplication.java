package org.jud.helloboot;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import java.io.IOException;

@SpringBootApplication
public class HellobootApplication {

    public static void main(String[] args) {

        // Tomcat의 정보를 담은 객체를 생성 (servletContainer)
        ServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
        // servlet Container에 servlet 등록
        WebServer webServer = serverFactory.getWebServer(servletContext -> {

            servletContext.addServlet("hello", new HttpServlet() {
                @Override
                protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

                    String name = req.getParameter("name");

                    resp.setStatus(HttpStatus.OK.value());
                    resp.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_PLAIN_VALUE);
                    resp.getWriter().println("Hello " + name);

                }
            }).addMapping("/hello");

        });
        webServer.start();

    }

}

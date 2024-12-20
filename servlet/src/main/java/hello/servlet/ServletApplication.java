package hello.servlet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

//@ServletComponentScan
@SpringBootApplication
@ComponentScan
public class ServletApplication {
	public static void main(String[] args) {
		SpringApplication.run(ServletApplication.class, args);
	}

//	@Bean
//	InternalResourceViewResolver internalResourceViewResolver(){
//		return new InternalResourceViewResolver("/WEB-INF/views/", ".jsp");
//	}

}
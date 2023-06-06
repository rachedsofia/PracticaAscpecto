package web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import web.AppFutbol;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AppFutbol {

	public static void main(String[] args) {

		SpringApplication.run(AppFutbol.class, args);

	}

}

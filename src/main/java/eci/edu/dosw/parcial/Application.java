package eci.edu.dosw.parcial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import eci.edu.dosw.parcial.PaymentSystemDemo;
@SpringBootApplication
public class Application {

	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);
		PaymentSystemDemo.run();
	}

}

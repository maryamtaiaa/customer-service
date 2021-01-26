package org.sid.customersevice;

import org.sid.customersevice.entities.Customer;
import org.sid.customersevice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class CustomerSeviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerSeviceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(CustomerRepository customerRepository,
			RepositoryRestConfiguration restConfiguration){
		return args -> {
			restConfiguration.exposeIdsFor(Customer.class);
			customerRepository.save(new Customer(null,"Adil","adil@gmail.com"));
			customerRepository.save(new Customer(null,"Maryam","maryam@gmail.com"));
			customerRepository.save(new Customer(null,"Imad","Imad@gmail.com"));
			customerRepository.findAll().forEach(c->{
				System.out.println(c.toString());
			});
		};
	}
}

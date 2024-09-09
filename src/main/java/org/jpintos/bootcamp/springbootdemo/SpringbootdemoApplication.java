package org.jpintos.bootcamp.springbootdemo;

import org.jpintos.bootcamp.springbootdemo.model.Cliente;
import org.jpintos.bootcamp.springbootdemo.repository.ClienteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringbootdemoApplication {

	private static final Logger log= LoggerFactory.getLogger(SpringbootdemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringbootdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(ClienteRepository clienteRepository){
		return args -> {
			clienteRepository.save(new Cliente("Javier", "Pintos"));
			clienteRepository.save(new Cliente("Lionel", "Messi"));
			clienteRepository.save(new Cliente("María", "Diaz"));
			clienteRepository.save(new Cliente("Jose", "Diaz"));

			log.info("Consultando clientes con findAll()");
			clienteRepository.findAll().forEach(cliente -> {
				log.info(cliente.toString());
			});

			log.info("");

			log.info("Consultando cliente con id 1");
			Cliente cliente = clienteRepository.findById(1L);
			log.info(cliente.toString());

			log.info("");

			log.info("Consultar clientes con apellido Diaz");
			clienteRepository.findByApellido("Diaz").forEach(diaz -> {
				log.info(diaz.toString());
			});
		};
	}

}

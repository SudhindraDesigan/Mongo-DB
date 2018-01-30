package sample.data.mongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories("sample.data.mongo")
public class PersonMongoApplication {
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(PersonMongoApplication.class, args);
	}

}
	



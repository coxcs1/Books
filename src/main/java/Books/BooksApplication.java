package Books;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

// Specify location of your JpaRepository
@EnableJpaRepositories(basePackages = "Books.repository")
@SpringBootApplication
public class BooksApplication {
	// Main method.
	public static void main(String[] args) {
		SpringApplication.run(BooksApplication.class, args);
	}
}

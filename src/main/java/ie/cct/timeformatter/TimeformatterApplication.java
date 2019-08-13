package ie.cct.timeformatter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("ie.cct")
public class TimeformatterApplication {

	public static void main(String[] args) {
		SpringApplication.run(TimeformatterApplication.class, args);
	}
}

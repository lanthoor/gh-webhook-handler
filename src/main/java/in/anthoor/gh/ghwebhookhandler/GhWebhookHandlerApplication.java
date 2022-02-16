package in.anthoor.gh.ghwebhookhandler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class GhWebhookHandlerApplication {

    public static void main(String[] args) {
        SpringApplication.run(GhWebhookHandlerApplication.class, args);
    }

}

package com.anupama.ks.simulator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableScheduling
public class DataSimulatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataSimulatorApplication.class, args);
		scheduledataPoint();
	}
	
	@Scheduled(cron = "0 0/02 * * * ?")
	public static  void scheduledataPoint() {
		
		String data = "(1, 1)";
		System.out.println(data);
	    final String uri = "http://localhost:8082/user/consume?data="+data;
	    System.out.println(uri);

	    RestTemplate restTemplate = new RestTemplate();
	    String result = restTemplate.getForObject(uri, String.class);

	    System.out.println(result);
	}

}

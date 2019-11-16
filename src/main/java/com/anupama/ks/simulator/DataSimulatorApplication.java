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
	
	public void macAddress() {
		
	}
	
	@Scheduled(cron = "0/5 * * * * ?")
	public static  void scheduledataPoint() {
		
		String data = "(1, 1)";
		String registerMac = "00:0a:95:9d:68:16";
	    final String uri = "http://localhost:8082/data/consumer?data="+data+"&mac="+registerMac;
	    System.out.println(uri);

	    RestTemplate restTemplate = new RestTemplate();
	    String result = restTemplate.getForObject(uri, String.class);

	    System.out.println(result);
	}

}

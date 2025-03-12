package com.codewithamit.blogappapis.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;

@Component
@Slf4j
public class ApiScheduler {

    private final RestTemplate restTemplate = new RestTemplate();
    private static final String API_URL = "https://blog-app-apis-2o43.onrender.com/api/server/start";

    @Scheduled(fixedRate = 300000) // Every 5 minutes (300,000 ms)
    public void fetchUsers() {
        try {
            ResponseEntity<String> response = restTemplate.getForEntity(API_URL, String.class);
            log.info("Fetched API Response: " + response.getBody());
        } catch (Exception e) {
            log.info("Failed to fetch API: " + e.getMessage());
        }
    }
}

package io.john.amiscaray.http;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Map;

@Service
public class AuthServiceClient {

    private WebClient.Builder webClientBuilder;
    @Value("${auth.client-secret}")
    private String clientSecret;

    public AuthServiceClient(WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
    }

    public Mono<String> getAuthToken() {
        return webClientBuilder.build().post()
                .uri("http://auth-service/oauth2/token")
                .headers(headers -> headers.setBasicAuth("student-service", clientSecret))
                .body(BodyInserters.fromFormData("grant_type", "client_credentials").with("scope", "write:student"))
                .retrieve()
                .bodyToMono(Map.class)
                .map(response -> (String) response.get("access_token"));
    }

}

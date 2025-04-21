package io.john.amiscaray.http;

import io.john.amiscaray.dto.CourseSaveStudentRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.*;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class CourseServiceClient {

    private WebClient.Builder webClientBuilder;
    private AuthServiceClient authServiceClient;

    public Mono<Void> saveNewStudent(CourseSaveStudentRequest saveStudentRequest) {
        return authServiceClient.getAuthToken()
                .flatMap(authToken -> webClientBuilder
                        .build()
                        .post()
                        .uri("http://course-service/student") // course-service will resolve to the correct host because of consul's service discovery
                        .headers(headers -> headers.setBearerAuth(authToken))
                        .bodyValue(saveStudentRequest)
                        .retrieve()
                        .bodyToMono(Void.class));
    }

}

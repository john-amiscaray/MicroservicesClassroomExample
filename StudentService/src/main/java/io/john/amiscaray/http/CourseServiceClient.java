package io.john.amiscaray.http;

import io.john.amiscaray.dto.CourseSaveStudentRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class CourseServiceClient {

    private WebClient.Builder webClientBuilder;

    public Mono<Void> saveNewStudent(CourseSaveStudentRequest saveStudentRequest) {
        return webClientBuilder.build()
                .post()
                .uri("http://course-service/student") // course-service will resolve to the correct host because of consul's service discovery
                .bodyValue(saveStudentRequest)
                .retrieve()
                .bodyToMono(Void.class);
    }

}

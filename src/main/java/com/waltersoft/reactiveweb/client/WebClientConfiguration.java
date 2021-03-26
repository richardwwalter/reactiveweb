package com.waltersoft.reactiveweb.client;

/*
@Configuration
@Slf4j
public class WebClientConfiguration {

    //@Value("${server.port}")
    @LocalServerPort
    private int port;

    @Bean
    public WebClient webClient(){
        return WebClient.builder()
                .baseUrl("http://localhost:" +port)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .filter(logRequest())
                .build();
    }

    private ExchangeFilterFunction logRequest() {
        return (clientRequest, next) -> {
            log.info("Request: {} {}", clientRequest.method(), clientRequest.url());
            clientRequest.headers()
                    .forEach((name, values) -> values.forEach(value -> log.info("{}={}", name, value)));
            return next.exchange(clientRequest);
        };
    }

}

 */

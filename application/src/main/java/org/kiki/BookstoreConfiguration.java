package org.kiki;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.config.WebFluxConfigurer;


@Configuration
@EnableWebFlux
public class BookstoreConfiguration implements WebFluxConfigurer {
}

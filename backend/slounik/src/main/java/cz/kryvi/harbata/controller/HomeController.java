package cz.kryvi.harbata.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/")
public class HomeController {
    @GetMapping
    public Mono<Void> hello() {
        return Mono
                .just("Hello!")
                .then();
    }
}

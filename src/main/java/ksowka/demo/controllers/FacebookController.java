package ksowka.demo.controllers;

import ksowka.demo.Facebook;
import ksowka.demo.services.FacebookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

@RestController("/facebook")
public class FacebookController {

    private final FacebookService facebookService;

    public FacebookController(FacebookService facebookService){
        this.facebookService = facebookService;
    }

    @GetMapping(value = "/{id}")
    public Facebook findById(@PathVariable String id) throws IOException {
            //throws NotFoundException {
        return facebookService.findById(id);
    }

    @GetMapping(value = "/most-common-words")
    public Map<String, Long> findMostCommonWords() {
        return facebookService.findMostCommonWords();
    }

    @GetMapping(value = "/posts")
    public Set<String> findPostIdsByKeyword(@RequestParam String word) {
        return facebookService.findPostIdsByKeyword(word);
    }

    @GetMapping
    public Set<Facebook> findAll() {
        return facebookService.findAll();
    }
}

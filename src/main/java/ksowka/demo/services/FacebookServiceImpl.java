package ksowka.demo.services;

import ksowka.demo.models.Facebook;
import ksowka.demo.utils.JsonData;
import ksowka.demo.utils.NotFoundException;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

@Component
public class FacebookServiceImpl implements FacebookService {

    private final JsonData jsonData;

    public FacebookServiceImpl(JsonData jsonData){
        this.jsonData = jsonData;
    }

    public Facebook findById(String id) throws IOException, NotFoundException {
        return jsonData.getData()
                .stream()
                .filter(fb -> fb.getId().equals(id))
                .findFirst()
                .orElseThrow(IOException::new);
    }

    public Map<String, Long> findMostCommonWords() {
        return jsonData.getData()
                .stream()
                .flatMap(fb -> fb.getPosts().stream())
                .flatMap(posts -> posts.entrySet().stream())
                .map(Map.Entry::getValue)
                .flatMap(value -> Arrays.stream(value.split("\\W+")))
                .collect(groupingBy(Function.identity(), counting()));

    }

    public Set<String> findPostIdsByKeyword(String word) throws IOException {

        return null;

    }

    public Set<Facebook> findAll() {
        return jsonData.getData()
                .stream()
                .collect(Collectors.toSet());
    }
}

package ksowka.demo.services;

import ksowka.demo.models.Facebook;
import ksowka.demo.utils.JsonData;
import ksowka.demo.utils.NotFoundException;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

@Component
public class FacebookServiceImpl implements FacebookService {

    private final JsonData jsonData;

    public FacebookServiceImpl(JsonData jsonData) {
        this.jsonData = jsonData;
    }

    public Facebook findById(String id) throws IOException, NotFoundException {
        return jsonData.getData()
                .stream()
                .filter(fb -> fb.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Facebook model with id" + id + " doesn't exist"));
    }

    public Map<String, Long> findMostCommonWords() {
        final Map<String, Long> wordsCounted = jsonData.getData()
                .stream()
                .flatMap(fb -> fb.getPosts().stream())
                .flatMap(posts -> posts.entrySet().stream())
                .map(Map.Entry::getValue)
                .flatMap(value -> Arrays.stream(value.split("\\W+")))
                .collect(groupingBy(Function.identity(), counting()));

        return wordsCounted.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));


    }

    public Set<String> findPostIdsByKeyword(String word) throws IOException {

        return jsonData.getData()
                .stream()
                .map(Facebook::getPosts)
                .map(l -> l.stream()
                        .filter(e -> e.get("message").contains(word))
                        .map(e -> e.get("id"))
                        .collect(toList()))
                .flatMap(Collection::stream)
                .collect(toSet());
    }

    public Set<Facebook> findAll() {
        return jsonData.getData()
                .stream()
                .collect(Collectors.toSet());
    }
}

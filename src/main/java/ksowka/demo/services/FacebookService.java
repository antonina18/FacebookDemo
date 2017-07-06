package ksowka.demo.services;

import ksowka.demo.models.Facebook;
import ksowka.demo.utils.NotFoundException;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

public interface FacebookService {

    Facebook findById(String id) throws IOException, NotFoundException;

    Map<String,Long> findMostCommonWords();

    Set<String> findPostIdsByKeyword(String word) throws IOException;

    Set<Facebook> findAll();
}

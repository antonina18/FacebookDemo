package ksowka.demo.services;

import ksowka.demo.Facebook;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

public interface FacebookService {

    Facebook findById(String id) throws IOException;
    //throws
            //NotFoundException();

    Map<String,Long> findMostCommonWords();

    Set<String> findPostIdsByKeyword(String word);

    Set<Facebook> findAll();
}

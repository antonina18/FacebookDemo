package ksowka.demo.services;

import com.google.gson.Gson;
import ksowka.demo.Facebook;
import ksowka.demo.FilesUtil;
import ksowka.demo.JsonParser;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

@Component
public class FacebookServiceImpl implements FacebookService {

    private final static String F1 = "/f1.json";
    private final FilesUtil filesUtil;
    private final JsonParser jsonParser;
    private final Gson gson;

    public FacebookServiceImpl(FilesUtil filesUtil, JsonParser jsonParser){
        this.filesUtil = filesUtil;
        this.jsonParser = jsonParser;
        this.gson = new Gson();
    }

    public Facebook findById(String id) throws IOException //throws NotFoundException
    {
        final File file = filesUtil.load(F1);
        final String s = file.toString();
        return jsonParser.toFacebook(s);
    }

    public Map<String, Long> findMostCommonWords() {

        return null;
    }

    public Set<String> findPostIdsByKeyword(String word) {

        return null;
    }

    public Set<Facebook> findAll() {
        //TODO: parser do wielu jsonow
        return null;
    }
}

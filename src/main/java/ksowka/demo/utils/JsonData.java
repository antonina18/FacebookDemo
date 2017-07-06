package ksowka.demo.utils;

import ksowka.demo.models.Facebook;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static ksowka.demo.utils.JsonParser.toFacebook;

@Component
public class JsonData {
    private final List<Facebook> data = new ArrayList<>();

    @PostConstruct
    public void init() throws URISyntaxException {
        try {
            data.add(toFacebook(new String(Files.readAllBytes(Paths.get(ClassLoader.getSystemResource("f1.json").toURI())))));
            data.add(toFacebook(new String(Files.readAllBytes(Paths.get(ClassLoader.getSystemResource("f2.json").toURI())))));
            data.add(toFacebook(new String(Files.readAllBytes(Paths.get(ClassLoader.getSystemResource("f3.json").toURI())))));
            data.add(toFacebook(new String(Files.readAllBytes(Paths.get(ClassLoader.getSystemResource("f4.json").toURI())))));
            data.add(toFacebook(new String(Files.readAllBytes(Paths.get(ClassLoader.getSystemResource("f5.json").toURI())))));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Facebook> getData() {
        return new ArrayList(data);
    }
}

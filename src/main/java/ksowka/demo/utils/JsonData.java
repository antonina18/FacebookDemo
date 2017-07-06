package ksowka.demo.utils;

import ksowka.demo.models.Facebook;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static ksowka.demo.utils.JsonParser.toFacebook;

@Component
public class JsonData {

    private final FilesUtil filesUtil;
    private final List<Facebook> data = new ArrayList<>();

    public JsonData(FilesUtil filesUtil) {
        this.filesUtil = filesUtil;
    }

    @PostConstruct
    public void init() {
        try {
            data.add(toFacebook(new String(Files.readAllBytes(Paths.get("/f1.json")))));
            data.add(toFacebook(new String(Files.readAllBytes(Paths.get("/f2.json")))));
            data.add(toFacebook(new String(Files.readAllBytes(Paths.get("/f3.json")))));
            data.add(toFacebook(new String(Files.readAllBytes(Paths.get("/f4.json")))));
            data.add(toFacebook(new String(Files.readAllBytes(Paths.get("/f5.json")))));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Facebook> getData() {
        return new ArrayList(data);
    }
}

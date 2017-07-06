package ksowka.demo.utils;

import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

@Component
public class FilesUtil {

    public File load(String path) throws IOException {
        return new File(path);
    }

}

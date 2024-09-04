package service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileService {
    public String readFile(String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            return reader.readLine();
        }
    }
}

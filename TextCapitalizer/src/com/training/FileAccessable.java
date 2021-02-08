package com.training;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public interface FileAccessable {
    default FileReader getFileReader(String path) throws FileNotFoundException {
        return new FileReader(path);
    }
    default BufferedReader getBufferedReader() throws FileNotFoundException{
        return new BufferedReader(getFileReader("src/com/LPTraining/TextFileWithLetters"));
    }

    String getTextInTheFile(BufferedReader bufferedReader);
}

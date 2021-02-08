package com.training;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
//        System.out.printf("%S","aab");
        PrintUsingPrintf usingPrintf = new PrintUsingPrintf();
        PrintUsingMap usingMap = new PrintUsingMap();
        try {
            System.out.println("-------------Using printf--------------------");
            String text = usingPrintf.getTextInTheFile(usingPrintf.getBufferedReader());
            System.out.printf("%S",text);
            System.out.println("-------------Using Map--------------------");
            String textUsingMap = usingMap.getTextInTheFile(usingMap.getBufferedReader());
            System.out.println(textUsingMap);

        }catch (FileNotFoundException fileNotFoundException){
            fileNotFoundException.printStackTrace();
        }
    }
}

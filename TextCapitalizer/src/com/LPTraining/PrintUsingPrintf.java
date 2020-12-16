package com.LPTraining;

import java.io.BufferedReader;
import java.io.IOException;

public class PrintUsingPrintf implements FileAccessable{

    @Override
    public String getTextInTheFile(BufferedReader bufferedReader) {
        String finalText="";

        while (true){
            try {
                String readLine = bufferedReader.readLine();
                if (readLine == null){
                    break;
                }
                finalText += readLine+"\n";
            }catch (IOException exception){
                System.err.println("Error While Reading File");
            }
        }

        return finalText;
    }
}

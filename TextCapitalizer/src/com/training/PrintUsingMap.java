package com.training;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;

public class PrintUsingMap implements FileAccessable{
   private static HashMap<Character,String> values=new HashMap<>();
    static {
        values.put('a',"A");
        values.put('b',"B");
        values.put('c',"C");
        values.put('d',"D");
        values.put('e',"E");
        values.put('f',"F");
        values.put('g',"G");
        values.put('h',"H");
        values.put('i',"I");
        values.put('j',"J");
        values.put('k',"K");
        values.put('l',"L");
        values.put('m',"M");
        values.put('n',"N");
        values.put('o',"O");
        values.put('p',"P");
        values.put('q',"Q");
        values.put('r',"R");
        values.put('s',"S");
        values.put('t',"T");
        values.put('u',"U");
        values.put('v',"V");
        values.put('w',"W");
        values.put('x',"X");
        values.put('y',"Y");
        values.put('z',"Z");
    }
    @Override
    public String getTextInTheFile(BufferedReader bufferedReader) {
        String finalText="";
        while (true) {
            try {
                int read = bufferedReader.read();
                if(read== -1){
                    break;
                }
                if(read== 13 ){
                    read=bufferedReader.read();
                    if(read==10){
                        finalText+="\n";
                        continue;
                    }
                }else if(read==32){
                    finalText+=" ";
                    continue;
                }
                Character character=(char)read;
                finalText+=getCapitalLetter(character);
            } catch (IOException exception) {
                System.err.println("Error while reading file");
            }
        }
        return finalText;
    }
    private String getCapitalLetter(Character c){
        return Character.isUpperCase(c.charValue())? String.valueOf(c):values.get(c);
    }
}

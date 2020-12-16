package com.LPTraining;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            int inputValue = scanner.nextInt();
            System.out.println("-------------Actual Value---------");
            System.out.println(inputValue);
            int reversedValue = getReversedValue(inputValue);
            System.out.println("-------------Reversed Value---------");
            System.out.println(reversedValue);
        }finally {
            scanner.close();
        }
    }

    private static int getReversedValue(int inputValue) {
        int reversedValue = 0;
        while (inputValue != 0) {
            //get whether last digit postion whether 1 , 10 or 100
            int numPosition = getNumPostion(inputValue);

            //get last value of the number
            int remains = inputValue % 10;
            //get value without last value
            inputValue = inputValue / 10;

            reversedValue += remains * numPosition;
        }
        return reversedValue;
    }

    //get int value and check the postion value whether 10,100 or 1000 and return it
    private static int getNumPostion(int inputValue) {
        int returnValue=1;
            while(inputValue>=10){
                inputValue/=10;
                returnValue*=10;
            }
        return returnValue;
    }
}

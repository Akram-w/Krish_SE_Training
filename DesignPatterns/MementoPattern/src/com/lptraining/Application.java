package com.lptraining;

public class Application {

    public static void main(String[] args) {
        CareTaker careTaker = new CareTaker();
        TextBuilder textBuilder = new TextBuilder();

        textBuilder.write("Hi,");
        textBuilder.write("How are u.");

        careTaker.save(textBuilder);
        System.out.println(textBuilder);

        textBuilder.write("This is from Memento Pattern. ");

        careTaker.save(textBuilder);
        System.out.println(textBuilder);

        textBuilder.write("bye");
        careTaker.save(textBuilder);
        System.out.println(textBuilder);

        careTaker.revert(textBuilder);
        careTaker.revert(textBuilder);
        System.out.println(textBuilder);
    }
}

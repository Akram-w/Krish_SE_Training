package com.training;

import java.util.Stack;

public class CareTaker {
    Stack<TextBuilder.TextBuilderMemento> history= new Stack<>();
    public void save(TextBuilder textBuilder){
        history.push(textBuilder.save());
    }
    public void revert(TextBuilder textBuilder){
        if(!history.isEmpty()){
            textBuilder.revert(history.pop());
        }else{
            System.out.println("Cannot undo");
        }
    }
}

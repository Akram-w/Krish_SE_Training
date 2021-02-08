package com.training;

public class TextBuilder {
    String text="";

    public void write(String text){
        this.text+=text+" ";
    }

    public String getText() {
        return text;
    }

    public TextBuilderMemento save(){
        return new TextBuilderMemento(getText());
    }
    public void revert(TextBuilderMemento textBuilderMemento){
        text=textBuilderMemento.getText();
    }

    @Override
    public String toString() {
        return "TextBuilder{" +
                "text='" + text + '\'' +
                '}';
    }

    static class TextBuilderMemento{
        String text;

        public TextBuilderMemento(String text) {
            this.text = text;
        }

        private String getText() {
            return text;
        }
    }
}

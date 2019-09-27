package model;

import javax.xml.bind.annotation.XmlElement;

public class Question {
    private String text;
    private int number;

    @XmlElement
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @XmlElement
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

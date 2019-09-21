package application;

import javafx.scene.Node;
import javafx.scene.control.TextArea;
import model.Question;
import model.Table;

import java.util.ArrayList;
import java.util.List;

public class DataAdapter {

    public Table generateTestData() {
        Table table = new Table();
        Question question = new Question();
        question.setText("Who is the inventor of the telephone?");
        List<Question> questions = new ArrayList<>();
        questions.add(question);
        table.setQuestions(questions);
        return table;
    }

    public Table processData(List nodes) {
        Table table = new Table();
        List<Question> questions = table.getQuestions();
        for (Object object : nodes) {
            String textFromNode = ((TextArea) object).getText();
            Question question = new Question();
            question.setText(textFromNode);
            questions.add(question);
        }
        return table;
    }
}

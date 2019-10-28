package application;

import javafx.scene.Node;
import javafx.scene.control.TextArea;
import model.Question;
import model.Table;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    public Table processData(Map<TextArea, Integer> textAreaToNumber) {
        Table table = new Table();
        List<Question> questions = table.getQuestions();
        textAreaToNumber.forEach((textArea, number) -> {
            Question question = new Question();
            question.setText(textArea.getText());
            question.setNumber(number + 1);
            questions.add(question);
        });
        return table;
    }
}

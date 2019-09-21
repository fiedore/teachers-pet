package application;

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
}

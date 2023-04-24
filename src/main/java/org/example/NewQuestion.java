package org.example;

import javax.swing.*;
import java.awt.*;

import static javax.swing.JOptionPane.*;
public class NewQuestion extends Interface{



    private JTextField questionField = new JTextField(20);
    private JTextField answerField = new JTextField(20);

    QuestionPanel questionPanel = new QuestionPanel();

    public NewQuestion(JFrame parent){
        super(parent, "New Question");
        add(new JPanel(), BorderLayout.NORTH);
        add(getQuestionPanel(), BorderLayout.CENTER);
        add(getNewQuestionButtonPanel(), BorderLayout.SOUTH);
        setSize(400, 400);
        pack();
    }

    private class QuestionPanel extends JPanel {
        public QuestionPanel(){
            setLayout(new GridLayout(4, 4));
            add(new JLabel("New question:"));
            add(questionField);
            add(new JLabel("Answer"));
            add(answerField);

        }
    }

    public JPanel getQuestionPanel() {
        return questionPanel;
    }

    public String getQuestion() {
        String questionString = questionField.getText();
        return questionString;
    }

    public String getAnswer() {
        String answerString = answerField.getText();
        return answerString;
    }

    protected boolean getRegQuestionClicked () {
        return registerQuestionClicked;

    }
    protected boolean getCancelRegisterUserClicked () {
        return cancelRegisterQestion;
    }


    protected boolean QuestiondataOk(String question, String answer) {
        boolean value = false;

        if (!getCancelRegisterUserClicked()) {
            if (question.trim().equals("") || answer.trim().equals("")) {
                showMessageDialog(null, "You need to fill in a question, answer and author to register a new question");
                if (question.trim().equals("")) {
                    questionField.requestFocusInWindow();
                }
            } else {
                setVisible(false);
                value = true;
            }
        }
        return value;
    }

    protected void showRegMessage () {
        showMessageDialog(NewQuestion.this, "Question registered successfully!");
    }



}


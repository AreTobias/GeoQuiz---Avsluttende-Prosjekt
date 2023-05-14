package org.example;

import javax.swing.*;
import java.awt.*;

public class quizSizeWindow extends Interface{

        public static JTextField inpNumber = new JTextField(3);

        quizSizePanel quizSizePanel = new quizSizePanel();



        public quizSizeWindow(JFrame parent){
            super(parent, "Quiz Size");
            setLayout(new GridLayout(3, 3));
            inpNumber.setText("");
            add(getQuizWindowPanel(), BorderLayout.NORTH);
            add(getNumberQuestionButtonPanel(), BorderLayout.SOUTH);

            pack();

        }

        private class quizSizePanel extends JPanel {
            public quizSizePanel(){
                setLayout(new GridLayout(2, 2));
                JLabel numQuestions = new JLabel("Number of questions:");
                add(numQuestions, BorderLayout.WEST);
                add(inpNumber, BorderLayout.EAST);


            }
        }


        public JPanel getQuizWindowPanel () {
            return quizSizePanel;
        }

        public boolean getCreateQuizClicked() { return createQuizClicked; }

        public boolean getQuizCancelClicked() { return quizCancelButtonClicked; }

        public void setInpNumber () {
            inpNumber.setText(" ");
        }

}

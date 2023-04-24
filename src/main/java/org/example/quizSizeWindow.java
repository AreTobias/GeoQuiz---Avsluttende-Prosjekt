package org.example;

import javax.swing.*;
import java.awt.*;

public class quizSizeWindow extends Interface{

        public static JTextField inpNumber = new JTextField(3);

        quizSizePanel quizSizePanel = new quizSizePanel();



        public quizSizeWindow(JFrame parent){
            super(parent, "Quiz Size");
            add(new JPanel(), BorderLayout.NORTH);
            add(getQuizWindowPanel(), BorderLayout.CENTER);
            add(getNumberQuestionButtonPanel(), BorderLayout.SOUTH);

            pack();

        }

        private class quizSizePanel extends JPanel {
            public quizSizePanel(){
                setLayout(new GridLayout(4, 4));
                JLabel numQuestions = new JLabel("Number of questions:");
                //JTextField inpNumQuestions = new JTextField(5);
                add(inpNumber);
                add(numQuestions);
                //add(inpNumQuestions);

            }
        }


        public JPanel getQuizWindowPanel () {
            return quizSizePanel;
        }

        public boolean getCreateQuizClicked() { return createQuizClicked; }

        public boolean getQuizCancelClicked() { return quizCancelClicked; }

        public void setInpNumber () {
            inpNumber.setText(" ");
        }

}

package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import static org.example.quizSizeWindow.inpNumber;

public class quizWindow extends Interface {

        public static int quizScore = 0;
        public static ArrayList<String> questions = new ArrayList<>(Database.getAllQuestions());
        public static ArrayList<String> checkBoxes = new ArrayList<>();
        public static  StringBuilder questionString = new StringBuilder();

        public static StringBuilder correctAnswer = new StringBuilder();
        public static JLabel question = new JLabel();
        public static JCheckBox answer1 = new JCheckBox();
        public static JCheckBox answer2 = new JCheckBox();
        public static JCheckBox answer3 = new JCheckBox();
        public static JCheckBox answer4 = new JCheckBox();
        quizButtonPanel buttonPanel = new quizButtonPanel();
        showQuizPanel showQuizPanel = new showQuizPanel();
        quizCheckBoxPanel quizcheckbox = new quizCheckBoxPanel();
        public static StringBuilder questionSource = new StringBuilder();
        public static StringBuilder questionCountry = new StringBuilder();
        public static StringBuilder questionCapital = new StringBuilder();
        public static StringBuilder questionRegion = new StringBuilder();

        public static int score = 0;

        public quizWindow(JFrame parent) throws Exception {
            super(parent, "Quiz");
            add(new JPanel());
            add(question, BorderLayout.NORTH);
            //add(getShowQuizPanel(), BorderLayout.NORTH);
            add(getQuizcheckbox(), BorderLayout.CENTER);
            add(getQuizButtonPanel(), BorderLayout.SOUTH);
            pack();

        }

        private class showQuizPanel extends JPanel{
            public showQuizPanel() throws Exception{
                add(question);
            }
        }

        public class quizCheckBoxPanel extends JPanel {
            public quizCheckBoxPanel() throws Exception {
                setLayout(new GridLayout(2, 2));


                Random random = new Random();
                questionString.setLength(0);
                questionString.append(questions.get(random.nextInt(questions.size())));
                questionSource.append(Database.findQuestionSource(questionString.toString()));


                add(question);
                add(answer1);
                add(answer2);
                add(answer3);
                add(answer4);

                checkBoxes.add("answer1");
                checkBoxes.add("answer2");
                checkBoxes.add("answer3");
                checkBoxes.add("answer4");
                answer1.setText(" ");
                answer2.setText(" ");
                answer3.setText(" ");
                answer4.setText(" ");
                answer1.setSelected(false);
                answer2.setSelected(false);
                answer3.setSelected(false);
                answer4.setSelected(false);


                if (questionSource.toString().equalsIgnoreCase("capital")){
                    questionCountry.append(Api.getCountryRandom());
                    question.setText(questionString.toString() + questionCountry + "?");

                    answer1.setText("1 - " + Api.getCapitalRandom());
                    answer2.setText("2 - " + Api.getCapitalRandom());
                    answer3.setText("3 - " + Api.getCapitalRandom());
                    answer4.setText("4 - " + Api.getCountryCapitalFromName(questionCountry.toString()));

                } else if (questionSource.toString().equalsIgnoreCase("region")){
                    ArrayList<String> regions = new ArrayList<>(Api.getRegionsArrayList());
                    questionCountry.append(Api.getCountryRandom());
                    question.setText(questionString.toString() + questionCountry + "?");

                    answer1.setText("1 - " + Api.getRegionString(questionCountry.toString()));
                    regions.remove(answer1.getText());
                    answer2.setText("2 - " + regions.get(random.nextInt(regions.size())));
                    regions.remove(answer2.getText());
                    answer3.setText("3 - " + regions.get(random.nextInt(regions.size())));
                    regions.remove(answer3.getText());
                    answer4.setText("4 - " + regions.get(random.nextInt(regions.size())));

                } else if (questionSource.toString().equalsIgnoreCase("population")) {

                    questionCountry.append(Api.getCountryRandom());
                    question.setText(questionString.toString() + questionCountry + "?");
                    correctAnswer.append(Api.getCountryCapitalFromName(questionCountry.toString()));

                    answer1.setText("1 - " + Integer.toString(Api.getPopulationRandom()));
                    answer2.setText("2 - " + Integer.toString(Api.getPopulationRandom()));
                    answer3.setText("3 - " + Api.getPopulationString(questionCountry.toString()));
                    answer4.setText("4 - " + Integer.toString(Api.getPopulationRandom()));

                } else if(questionSource.toString().equalsIgnoreCase("area")){

                    questionCountry.append(Api.getCountryRandom());
                    question.setText(questionString.toString() + questionCountry + "?");
                    answer1.setText("1 - " + Api.getAreaRandom());
                    answer2.setText("2 - " + Api.getAreaRandom());
                    answer3.setText("3 - " + Api.getAreaString(questionCountry.toString()));
                    answer4.setText("4 - " + Api.getAreaRandom());
                }

                pack();
            }
        }


        protected JPanel getQuizButtonPanel() { return buttonPanel; }

        protected JPanel getShowQuizPanel(){ return showQuizPanel; }
        public boolean getNextQuestionClicked(){
            return nextQuestionClicked;
        }
        public boolean getQuizCancelButtonClicked() {
            return quizCancelButtonClicked;
        }

        public JPanel getQuizcheckbox() { return quizcheckbox; }

        public static int getNumberOfQuiz() { return Integer.parseInt(inpNumber.getText()); }

        private class quizButtonPanel extends JPanel {
        public quizButtonPanel() {
            setLayout(new GridLayout(1, 2));
            JButton next = new JButton("Next");
            JButton cancel = new JButton("Cancel");

            add(next);
            add(cancel);

            quizButtonListener listener = new quizButtonListener();
            next.addActionListener(listener);
            cancel.addActionListener(listener);
        }
    }

        public void setQuestionSource(int length) { questionSource.setLength(length); }
        public void setQuestionCountry(int length) { questionCountry.setLength(length); }

        public void setQuestionCapital(int length) { questionCapital.setLength(length); }

        public class quizButtonListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent event) {

                String button = event.getActionCommand();

                if (button.equals("Next") && questionSource.toString().equalsIgnoreCase("capital")) {
                    if (answer4.isSelected()) {
                        quizScore++;
                        setVisible(false);
                    }

                } else if (button.equals("Next") && questionSource.toString().equalsIgnoreCase("population")) {
                    if (answer2.isSelected()) {
                        quizScore++;
                        setVisible(false);
                    }


                } else if (button.equals("Next") && questionSource.toString().equalsIgnoreCase("area")) {
                    if (answer3.isSelected()) {
                        quizScore++;
                        setVisible(false);
                    }

                } else if (button.equals("Next") && questionSource.toString().equalsIgnoreCase("region")) {
                    if (answer1.isSelected()) {
                        quizScore++;
                        setVisible(false);
                    }
                } else {
                    if (button.equals("Cancel")) {
                        quizCancelClicked = true;
                        setVisible(false);
                    }

                    setVisible(false);
            }
        }
    }
}


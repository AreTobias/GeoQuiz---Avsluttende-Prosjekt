package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import static org.example.quizSizeWindow.*;

public class quizWindow extends Interface {

        public static int quizScore = 0;

        public static ArrayList<String> questions = new ArrayList<>();



        ArrayList<String> Capitals = new ArrayList<>();
        ArrayList<String> Regions = new ArrayList<>();
        ArrayList<String> Areas = new ArrayList<>();
        ArrayList<String> Populations = new ArrayList<>();
        ArrayList<String> SubRegions= new ArrayList<>();
        ArrayList<String> NativeName = new ArrayList<>();
        public static JLabel question = new JLabel();
        public static JCheckBox answer1 = new JCheckBox();
        public static JCheckBox answer2 = new JCheckBox();
        public static JCheckBox answer3 = new JCheckBox();
        public static JCheckBox answer4 = new JCheckBox();
        public static ArrayList<JCheckBox> answers = new ArrayList<>(4);
        quizButtonPanel buttonPanel = new quizButtonPanel();
        quizCheckBoxPanel quizcheckbox = new quizCheckBoxPanel();
        public static StringBuilder questionSource = new StringBuilder();
        public static StringBuilder questionCountry = new StringBuilder();
        public static StringBuilder questionString = new StringBuilder();
        public static StringBuilder correctAnswer = new StringBuilder();


        public quizWindow(JFrame parent) throws Exception {
            super(parent, "Quiz");
            setBackground(Color.GRAY);
            add(new JPanel());
            add(question, BorderLayout.NORTH);
            add(getQuizcheckbox(), BorderLayout.CENTER);
            add(getQuizButtonPanel(), BorderLayout.SOUTH);
            pack();

        }


        public static class quizCheckBoxPanel extends JPanel {
            public quizCheckBoxPanel() throws Exception {
                setLayout(new GridLayout(2, 2));

                System.out.println("test1");

                answers.add(answer1);
                answers.add(answer2);
                answers.add(answer3);
                answers.add(answer4);

                System.out.println("test2");
                for (int i = 0; i <= answers.size() - 1; i++) {
                    add(answers.get(i));
                }

                questions.add("What's the capital of ");
                questions.add("What's the population of ");
                questions.add("What's the total area of ");
                questions.add("What's the region of ");
                questions.add("What's the subregion of ");
                questions.add("What's the nativeName of ");


            }
        }

        public void setQuestionString(String country)  {

            Random random = new Random();
            questionString.append(questions.get(random.nextInt(questions.size())));
            question.setText(questionString.toString() + country + "?");
            //System.out.println(questionString.toString());
        }

        public void setQuestionSource(String question) throws Exception {
            questionSource.append(Database.findQuestionSource(question));
            System.out.println(questionSource.toString());
        }
        public void setQuestionSourceLength(int len) { questionSource.setLength(len); }

        public void setQuestionCountry() throws Exception {
            questionCountry.append(Api.getCountryRandom());
            System.out.println(questionCountry.toString());
        }

        public void setQuestionCountryLength(int len){ questionCountry.setLength(len); }

        public void setQuestionStringLength(int len) {
            questionString.setLength(len);
        }

        public String getQuestionString(){
            return questionString.toString();
        }

        public void deSelectAnswers() {
           for (int i = 0; i <= answers.size() - 1; i++) {
               answers.get(i).setSelected(false);
           }
        }

        public String getQuestionSource() {
            return questionSource.toString();
        }

        public String getQuestionCountry() {
            return questionCountry.toString();
        }


        public void isCapital() throws Exception {
            Random random = new Random();

            ArrayList<String> Capital = Capitals;
            for (int i = 0; i <= answers.size() - 1; i++) {
                answers.get(i).setText(Capital.get(random.nextInt(Capital.size())));
                Capital.remove(answers.get(i).getText());
            }

            boolean isCorrect = false;

            for (int i = 0; i <= answers.size() - 1; i++) {
                if (answers.get(i).getText().equals(Api.getCountryCapitalFromName(questionCountry.toString()))) {
                    isCorrect = true;
                }
            }

            if (!isCorrect) {
                answers.get(random.nextInt(answers.size())).setText(Api.getCountryCapitalFromName(questionCountry.toString()));
            }

            correctAnswer.append(Api.getCountryAreaFromName(questionCountry.toString()));
        }

        public void isPopulation() throws Exception {
            ArrayList<String> Population = Populations;

            boolean isCorrect;
            Random random = new Random();
            for (int i = 0; i <= answers.size() - 1; i++) {
                answers.get(i).setText(Population.get(random.nextInt(Population.size())));
                Population.remove(answers.get(i).getText());
            }

            isCorrect = false;

            for (int i = 0; i <= answers.size() - 1; i++) {
                if (answers.get(i).getText().equals(Api.getPopulationString(questionCountry.toString()))) {
                    isCorrect = true;
                }
            }

            if (!isCorrect) {
                answers.get(random.nextInt(answers.size())).setText(Api.getPopulationString(questionCountry.toString()));
            }

            correctAnswer.append(Api.getPopulationString(questionCountry.toString()));
        }

        public void isArea() throws Exception {
            ArrayList<String> Area = Areas;

            boolean isCorrect = false;
            Random random = new Random();

            for (int i = 0; i <= answers.size() - 1; i++) {
                answers.get(i).setText(Area.get(random.nextInt(Area.size())));
                Area.remove(answers.get(i).getText());
            }



            for (int i = 0; i <= answers.size() - 1; i++) {
                if (answers.get(i).getText().equals(Api.getAreaString(questionCountry.toString()))) {
                    isCorrect = true;
                }
            }

            if (!isCorrect) {
                answers.get(random.nextInt(answers.size())).setText(Api.getAreaString(questionCountry.toString()));
            }

            correctAnswer.append(Api.getAreaString(questionCountry.toString()));
        }

        public void isRegion() throws Exception {
            ArrayList<String> Region = Regions;
            //ArrayList<String> Regions = Region;

            boolean isCorrect = false;
            Random random = new Random();

            for (int i = 0; i <= answers.size() - 1; i++) {
                answers.get(i).setText(Region.get(random.nextInt(Region.size())));
                Region.remove(answers.get(i).getText());
            }


            for (int i = 0; i <= answers.size() - 1; i++) {
                if (answers.get(i).getText().equals(Api.getRegionString(questionCountry.toString()))) {
                    isCorrect = true;
                }
            }

            if (!isCorrect) {
                answers.get(random.nextInt(answers.size())).setText(Api.getRegionString(questionCountry.toString()));
            }
            correctAnswer.append(Api.getRegionString(questionCountry.toString()));
        }

        public void isSubRegion() throws Exception {
            ArrayList<String> Sub_region = SubRegions;
            //ArrayList<String> sub_regions = Sub_region;

            boolean isCorrect = false;
            Random random = new Random();

            for (int i = 0; i <= answers.size() - 1; i++) {
                answers.get(i).setText(Sub_region.get(random.nextInt(Sub_region.size())));
                Sub_region.remove(answers.get(i).getText());
            }



            for (long i = 0; i <= answers.size() - 1; i++) {
                if (answers.get((int) i).getText().equals(Api.getSubregionFromCountryName(questionCountry.toString()))) {
                    isCorrect = true;
                }
            }

            if (!isCorrect) {
                answers.get(random.nextInt(answers.size())).setText(Api.getSubregionFromCountryName(questionCountry.toString()));
            }
            correctAnswer.append(Api.getSubregionFromCountryName(questionCountry.toString()));
        }

        public void isNativeName() throws Exception {
            ArrayList<String> Native_name = NativeName;
            //ArrayList<String> native_names = Native_name;

            boolean isCorrect = false;
            Random random = new Random();

            for (int i = 0; i <= answers.size() - 1; i++) {
                answers.get(i).setText(Native_name.get(random.nextInt(Native_name.size())));
                Native_name.remove(answers.get(i).getText());
            }



            for (long i = 0; i <= answers.size() - 1; i++) {
                if (answers.get((int) i).getText().equals(Api.getNativeNameFromCountryName(questionCountry.toString()))) {
                    isCorrect = true;
                }
            }

            if (!isCorrect) {
                answers.get(random.nextInt(answers.size())).setText(Api.getNativeNameFromCountryName(questionCountry.toString()));
            }
            correctAnswer.append(Api.getNativeNameFromCountryName(questionCountry.toString()));
        }

        protected JPanel getQuizButtonPanel() { return buttonPanel; }

        public boolean getQuizCancelButtonClicked() {
            return quizCancelClicked;
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

    public void fillRegions() throws Exception {
            Regions =  Api.getRegionsArrayList();
    }

    public void fillCapitals() throws Exception {
        Capitals = Api.getCountryCapitalArray();
    }

    public void fillPopulations() throws Exception {
        Populations =  Api.getPopulationArray();
    }

    public void fillAreas() throws Exception {
        Areas =  Api.getAreaArray();
    }

    public void fillNativeNames() throws Exception {
        NativeName = Api.getNativeNameArray();
    }

    public void fillSubRegion() throws Exception {
        SubRegions = (ArrayList<String>) Api.getSubRegionArray();
    }
        public class quizButtonListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent event) {

                String button = event.getActionCommand();

                if (button.equalsIgnoreCase("next")) {
                    for (int i = 0; i <= answers.size() - 1; i++) {
                        if (answers.get(i).isSelected() && answers.get(i).getText().equalsIgnoreCase(correctAnswer.toString())) {
                            quizScore++;
                        }

                    }
                }


                setVisible(false);
            }
        }
}



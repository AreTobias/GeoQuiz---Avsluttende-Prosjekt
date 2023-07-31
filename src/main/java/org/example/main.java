package org.example;

import javax.swing.*;

import static javax.swing.JOptionPane.showMessageDialog;

class ParentWindow extends JFrame {

    public ParentWindow() throws Exception {

        LoginInterface newLoginInterface = new LoginInterface(this);
        Login newLogin = new Login(newLoginInterface.getUserName(), newLoginInterface.getPassWord());
        UserAccessWindow useraccesswindow = new UserAccessWindow(this);
        AdminWindow newAdmin = new AdminWindow(this);

        while(!newLoginInterface.getLoginCancelClicked()) {
            newLoginInterface.setUsernameField("");
            newLoginInterface.setPasswordField("");
            newLoginInterface.setLocation(1150, 500);
            newLoginInterface.setSize(500, 300);
            newLoginInterface.setVisible(true);
            newAdmin.setAdminCancelButton();
            useraccesswindow.setQuizCancelButtonClicked();

            if (newLoginInterface.getSelfRegisterClicked()) {
                SelfRegister selfreg = new SelfRegister(this);
                selfreg.setSize(500, 300);
                selfreg.setLocation(1150, 500);
                selfreg.setVisible(true);
                newLoginInterface.setSelfRegisterClicked(false);
            }

            if (newLoginInterface.getLoginClicked() && newLoginInterface.checkLogin(newLogin)) {
                while (Database.checkAccess(newLogin.getUserName(), newLogin.getPassWord()).equals("admin") && !newAdmin.getAdminCancelButton()) {
                    newAdmin.setLocation(850, 500);
                    newAdmin.setSize(700, 300);
                    newAdmin.setVisible(true);


                    if (newAdmin.getNewUserClicked()) {
                        UserWindow newUserWindow = new UserWindow(this);
                        newUserWindow.setLocation(850, 500);
                        newUserWindow.setSize(700, 300);
                        newUserWindow.setVisible(true);
                        if (newAdmin.getNewUserClicked() && !Database.CheckUserNameExist(newUserWindow.getUserName()) && newUserWindow.dataOk(newUserWindow.getUserName(), newUserWindow.getPassWord(), newUserWindow.getAccess()) && Database.newUser(newUserWindow.getUserName(), newUserWindow.getPassWord(), newUserWindow.getAccess())) {
                            newUserWindow.showRegisteredUserMessage();
                        } else if (Database.CheckUserNameExist(newUserWindow.getUserName())) {
                            newUserWindow.showFailedRegisteredUserMessage();
                        }

                    } else if (newAdmin.getNewQuestionClicked()) {
                        NewQuestion newQuestion = new NewQuestion(this);
                        newQuestion.setLocation(850, 500);
                        newQuestion.setSize(700, 300);
                        newQuestion.setVisible(true);

                        if (newQuestion.QuestiondataOk(newQuestion.getQuestion(), newQuestion.getAnswer()) && Database.newQuestion(newQuestion.getQuestion(), newQuestion.getAnswer(), newLogin.getUserName())) {
                            newQuestion.showRegMessage();
                        }
                    } else if (newAdmin.getRegisteredUsersClicked()) {
                        while (!newAdmin.getDelUserCancelClicked()){
                            showRegisteredUsersWindow showReg = new showRegisteredUsersWindow(this);
                            showReg.setLocation(850, 500);
                            showReg.setSize(700, 300);
                            showReg.setVisible(true);

                            if (showReg.getDelUserCancelClicked()){
                                break;
                            }
                        }
                    }
                }
            }

            if (newLoginInterface.getLoginClicked() && newLoginInterface.checkLogin(newLogin)) {
                while (Database.checkAccess(newLogin.getUserName(), newLogin.getPassWord()).equals("user") && !useraccesswindow.getQuizCancelButtonClicked()) {
                    useraccesswindow.setLocation(850, 500);
                    useraccesswindow.setSize(700, 300);
                    useraccesswindow.setVisible(true);

                    if (useraccesswindow.getGetQuizClicked()) {
                        quizSizeWindow quizSize = new quizSizeWindow(this);
                        quizSize.setLocation(850, 500);
                        quizSize.setSize(1000, 400);
                        quizSize.setVisible(true);

                        if (!quizSize.getQuizCancelClicked()){


                            quizWindow quiz = new quizWindow(this);


                            for (int i = 0; i < quizWindow.getNumberOfQuiz(); i++) {
                                quiz.setTitle("Question " + (i + 1));


                                quiz.setQuestionCountry();
                                quiz.setQuestionString(quiz.getQuestionCountry());
                                quiz.setQuestionSource(quiz.getQuestionString());

                                switch (quiz.getQuestionSource()) {
                                    case "capital" -> {
                                        long start = System.currentTimeMillis();
                                        quiz.fillCapitals();
                                        quiz.isCapital();
                                        long end = System.currentTimeMillis();
                                        System.out.println(end - start);
                                    }
                                    case "population" -> {
                                        long start = System.currentTimeMillis();
                                        quiz.fillPopulations();
                                        quiz.isPopulation();
                                        long end = System.currentTimeMillis();
                                        System.out.println(end - start);
                                    }
                                    case "region" -> {
                                        long start = System.currentTimeMillis();
                                        quiz.fillRegions();
                                        quiz.isRegion();
                                        long end = System.currentTimeMillis();
                                        System.out.println(end - start);
                                    }
                                    case "area" -> {
                                        long start = System.currentTimeMillis();
                                        quiz.fillAreas();
                                        quiz.isArea();
                                        long end = System.currentTimeMillis();
                                        System.out.println(end - start);
                                    }
                                    case "subregion" -> {
                                        long start = System.currentTimeMillis();
                                        quiz.fillSubRegion();
                                        quiz.isSubRegion();
                                        long end = System.currentTimeMillis();
                                        System.out.println(end - start);
                                    }
                                    case "nativeName" -> {
                                        long start = System.currentTimeMillis();
                                        quiz.fillNativeNames();
                                        quiz.isNativeName();
                                        long end = System.currentTimeMillis();
                                        System.out.println(end - start);
                                    }
                                }


                                quiz.setLocation(850, 500);
                                quiz.setSize(400, 300);
                                quiz.setVisible(true);

                                if (quiz.getQuizCancelButtonClicked()) {
                                    break;
                                }

                                quiz.deSelectAnswers();
                                quiz.setQuestionSourceLength(0);
                                quiz.setQuestionCountryLength(0);
                                quiz.setQuestionStringLength(0);
                                System.out.println("Test5");
                            }

                        showMessageDialog(this, "Hey " + newLogin.getUserName() + "!\nYou got: " + newLoginInterface.getScore() + " correct answers!");
                        }
                    }
                }
            }
        }
    }
}

class testPålogging {
    static public void main(String[] args) throws Exception {
        ParentWindow test = new ParentWindow();

    }
}

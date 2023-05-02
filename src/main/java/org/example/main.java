package org.example;

import javax.swing.*;

import static javax.swing.JOptionPane.showMessageDialog;

class ParentWindow extends JFrame {

    public ParentWindow() throws Exception {
        /**setTitle("Overview");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        setLocation(1150, 500);
        setSize(500, 300);
         **/
        LoginInterface newLoginInterface = new LoginInterface(this);
        newLoginInterface.setLocation(1150, 500);
        newLoginInterface.setSize(500, 300);
        newLoginInterface.setVisible(true);
        Login newLogin = new Login(newLoginInterface.getUserName(), newLoginInterface.getPassWord());
        UserAccessWindow useraccesswindow = new UserAccessWindow(this);
        AdminWindow newAdmin = new AdminWindow(this);


        while(!newLoginInterface.getLoginCancelClicked()){
            if (newLoginInterface.getLoginClicked() && newLoginInterface.dataOk() && newLoginInterface.checkLogin(newLogin)) {
                while (Database.checkAccess(newLogin.getUserName(), newLogin.getPassWord()).equals("admin") && !newAdmin.getAdminCancelButton()){
                    newAdmin.setLocation(950, 500);
                    newAdmin.setSize(500, 300);
                    newAdmin.setVisible(true);

                    if (newAdmin.getNewUserClicked()){
                        UserWindow newUserWindow = new UserWindow(this);
                        newUserWindow.setLocation(1150, 500);
                        newUserWindow.setSize(500, 300);
                        newUserWindow.setVisible(true);
                        if (newAdmin.getNewUserClicked() && newUserWindow.dataOk(newUserWindow.getUserName(), newUserWindow.getPassWord(), newUserWindow.getAccess()) && Database.newUser(newUserWindow.getUserName(), newUserWindow.getPassWord(), newUserWindow.getAccess())){
                            newUserWindow.showRegisteredUserMessage();
                        }

                    } else if (newAdmin.getNewQuestionClicked()){
                            NewQuestion newQuestion = new NewQuestion(this);
                            newQuestion.setLocation(1150, 500);
                            newQuestion.setSize(500, 300);
                            newQuestion.setVisible(true);

                            if (newQuestion.QuestiondataOk(newQuestion.getQuestion(), newQuestion.getAnswer()) && Database.newQuestion(newQuestion.getQuestion(), newQuestion.getAnswer(), newLogin.getUserName())){
                                newQuestion.showRegMessage();
                            }
                    } else if (newAdmin.getRegisteredUsersClicked()){
                        showRegisteredUsersWindow showReg = new showRegisteredUsersWindow(this);
                        showReg.setLocation(1150, 500);
                        showReg.setSize(500, 300);
                        showReg.setVisible(true);

                    }
                }
            } if (newLoginInterface.getLoginClicked() && newLoginInterface.dataOk() && newLoginInterface.checkLogin(newLogin)){
                while (Database.checkAccess(newLogin.getUserName(), newLogin.getPassWord()).equals("user") && !useraccesswindow.getQuizCancelButtonClicked()) {
                    useraccesswindow.setLocation(1150, 500);
                    useraccesswindow.setSize(500, 300);
                    useraccesswindow.setVisible(true);

                    if (useraccesswindow.getGetQuizClicked()){
                        quizSizeWindow quizSize = new quizSizeWindow(this);
                        quizSize.setLocation(1050, 500);
                        quizSize.setSize(800, 300);
                        quizSize.setVisible(true);

                        for (int i = 0; i < quizWindow.getNumberOfQuiz(); i++) {
                            quizWindow quiz = new quizWindow(this);
                            quiz.setTitle("Question " + (i + 1));
                            quiz.setLocation(1050, 500);
                            quiz.setSize(400, 300);
                            quiz.setVisible(true);

                            if (quiz.getQuizCancelButtonClicked()){
                                break;
                            }

                            quiz.setQuestionSource(0);
                            quiz.setQuestionCountry(0);
                            quiz.setQuestionCapital(0);
                        }
                        showMessageDialog(this, "Hey " + newLogin.getUserName() + "!\nYou got: " + newLoginInterface.getScore() + " correct answers!");
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

package org.example;


import javax.swing.*;
import java.awt.event.*;

import static javax.swing.JOptionPane.*;

public class Interface extends JDialog {

    public int getScore () {
        return quizWindow.quizScore;
    }

    public void setScore() { quizWindow.quizScore = 0;}
    public boolean cancelRegisterQestion = false;
    public boolean quizCancelClicked = false;

    public boolean loginClicked = false;

    public boolean newUserClicked = false;

    public boolean newQuestionClicked = false;

    public boolean isVerified = true;

    public boolean registerUserClicked = false;
    public boolean registerQuestionClicked = false;

    public boolean getQuestionClicked = false;

    public boolean getQuizClicked = false;

    public void setQuizClicked (boolean value) {
        getQuizClicked = value;
    }

    public boolean getRegisteredUsers = false;

    public static boolean deleteUsersClicked = false;
    public boolean deleteButtonClicked = false;
    public boolean adminCancelButton = false;
    public boolean createQuizClicked = false;
    public boolean nextQuestionClicked = false;
    public boolean quizCancelButtonClicked = false;
    private final LoginButtonPanel loginButton = new LoginButtonPanel();
    private final adminButtonPanel adminbuttonpanel = new adminButtonPanel();
    private final newUserButtonPanel newUserbuttonpanel = new newUserButtonPanel();
    private final newQuestionPanel newQuestionPanel = new newQuestionPanel();
    private final UserAccessButtonPanel userAccessButtonPanel = new UserAccessButtonPanel();
    private final deleteUserButtonPanel deleteuserbuttonpanel = new deleteUserButtonPanel();
    private final numberQuestionButtonPanel numberQuestionButtonPanel = new numberQuestionButtonPanel();

    protected Interface(JFrame parent, String title) {

        super(parent, title, true);
    }

    protected JPanel getLoginButtonPanel() {return loginButton;  }

    protected JPanel getAdminButtonPanel() { return adminbuttonpanel; }

    protected JPanel getUserAccessButtonPanel() { return userAccessButtonPanel; }

    protected JPanel getNewUserButtonPanel() {
        return newUserbuttonpanel;
    }

    protected JPanel getNewQuestionButtonPanel () { return newQuestionPanel; }

    protected JPanel getDeleteUserButtonPanel () { return deleteuserbuttonpanel; }

    protected JPanel getNumberQuestionButtonPanel () { return numberQuestionButtonPanel; }



    protected void setVerified(boolean value) {
        isVerified = true;
    }

    protected boolean dataOk() {
        return true;
    }

    private class LoginButtonPanel extends JPanel {
        public LoginButtonPanel() {
            JButton LoginButton = new JButton("Login");
            JButton cancelButton = new JButton("Cancel");
            add(LoginButton);
            add(cancelButton);

            loginButtonListener listener = new loginButtonListener();

            LoginButton.addActionListener(listener);
            cancelButton.addActionListener(listener);

            KeyStroke escape = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0);
            InputMap keyMap = cancelButton.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
            keyMap.put(escape, "cancelButton");
            ActionMap actionMap = cancelButton.getActionMap();
            actionMap.put("cancelButton", listener);

        }
    }

    private class adminButtonPanel extends JPanel {
        public adminButtonPanel() {

            JButton newUser = new JButton("New user");
            JButton newQuestion = new JButton("New question");
            JButton getUsers = new JButton("Show Current Users");
            //JButton deleteUser = new JButton("Delete users");
            JButton cancel = new JButton("Cancel");
            add(newUser);
            add(newQuestion);
            add(getUsers);
            //add(deleteUser);
            add(cancel);

            newUser.setActionCommand("NewUserButton");
            newQuestion.setActionCommand("NewQuestionButton");
            cancel.setActionCommand("adminCancel");

            adminButtonListener listener = new adminButtonListener();
            newUser.addActionListener(listener);
            newQuestion.addActionListener(listener);
            getUsers.addActionListener(listener);
            //deleteUser.addActionListener(listener);
            cancel.addActionListener(listener);

        }
    }

    private class newUserButtonPanel extends JPanel {
        public newUserButtonPanel() {


            JButton Register = new JButton("Register");
            JButton Cancel = new JButton("Back");
            add(Register);
            add(Cancel);

            newUserButtonListener listener = new newUserButtonListener();
            Register.addActionListener(listener);
            Cancel.addActionListener(listener);

        }
    }

    private class newQuestionPanel extends JPanel {
        public newQuestionPanel() {
            JButton Register = new JButton("Register");
            JButton Cancel = new JButton("Back");

            add(Register);
            add(Cancel);

            newQuestionButtonListener listener = new newQuestionButtonListener();
            Register.addActionListener(listener);
            Cancel.addActionListener(listener);
        }
    }

    private class deleteUserButtonPanel extends JPanel {
        public deleteUserButtonPanel() {
            JButton deleteUser = new JButton("Delete");
            JButton Cancel = new JButton("Cancel");

            add(deleteUser);
            add(Cancel);

            deleteUserButtonListener listener = new deleteUserButtonListener();
            deleteUser.addActionListener(listener);
            Cancel.addActionListener(listener);
        }
    }

    private class UserAccessButtonPanel extends JPanel {
        public UserAccessButtonPanel() {


            JButton getQuiz = new JButton("Get Quiz");
            JButton Cancel = new JButton("Cancel");


            add(getQuiz);
            add(Cancel);

            UserAccessButtonListener listener = new UserAccessButtonListener();
            getQuiz.addActionListener(listener);
            Cancel.addActionListener(listener);

        }
    }

    private class numberQuestionButtonPanel extends JPanel {
        public numberQuestionButtonPanel() {

            JButton createQuiz = new JButton("Create quiz");
            JButton cancelQuestion = new JButton("Cancel");

            add(createQuiz);
            add(cancelQuestion);

            UserAccessButtonListener listener = new UserAccessButtonListener();
            createQuiz.addActionListener(listener);
            cancelQuestion.addActionListener(listener);



        }
    }



    private class WindowListener extends WindowAdapter {
        public void windowClosing(WindowEvent event) {
            int reply = showConfirmDialog(Interface.this, "Do you want to exit or proceed to login?", "Closing the window.", YES_NO_OPTION);

            if (reply == YES_OPTION) {
                setVisible(false);
            } else {

                setVisible(false);
            }
        }
    }

    public class loginButtonListener extends AbstractAction {
        public void actionPerformed(ActionEvent event) {
            String button = event.getActionCommand();

            if (button.equals("Login")) {
                loginClicked = true;
                adminCancelButton = false;
                System.out.println("Login clicked: " + loginClicked);
                setVisible(false);
            } else if (button.equals("Cancel")) {
                loginClicked = false;
                adminCancelButton = false;
                setVisible(false);
            }
        }
    }

    public class adminButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            String button = event.getActionCommand();

            if (button.equals("NewUserButton")) {
                newUserClicked = true;
                newQuestionClicked = false;
                deleteUsersClicked = false;
                getRegisteredUsers = false;
                adminCancelButton = false;
                setVisible(false);

            } else if (button.equals("NewQuestionButton")) {
                newQuestionClicked = true;
                newUserClicked = false;
                getRegisteredUsers = false;
                deleteUsersClicked = false;
                adminCancelButton = false;
                setVisible(false);

            } else if (button.equals("Show Current Users")){
                getRegisteredUsers = true;
                newUserClicked = false;
                deleteUsersClicked = false;
                newQuestionClicked = false;
                adminCancelButton = false;
                setVisible(false);

            } else if (button.equals("Delete users")){
                deleteUsersClicked = true;
                newUserClicked = false;
                newQuestionClicked = false;
                getRegisteredUsers = false;
                adminCancelButton = false;
                System.out.println("Delete clicked");
                setVisible(false);
            } else if (button.equals("adminCancel")){
                adminCancelButton = true;
                deleteUsersClicked = false;
                newUserClicked = false;
                newQuestionClicked = false;
                getRegisteredUsers = false;
                setVisible(false);
            }
            setVisible(false);
        }
    }

    public class newUserButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {

            String button = event.getActionCommand();

            if (button.equals("Register")) {
                registerUserClicked = true;
                System.out.println("Register user clicked: " + registerUserClicked);
                setVisible(false);
            } else {
                if (button.equals("Back")){
                    registerUserClicked = false;
                    setVisible(false);
                }
            }
        }
    }

    public class newQuestionButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {

            String button = event.getActionCommand();

            if (button.equals("Register")) {
                registerQuestionClicked = true;
                System.out.println("Register question clicked: " + registerQuestionClicked);
                setVisible(false);
            } else {
                if (button.equals("Back")){
                    registerQuestionClicked = false;
                    cancelRegisterQestion = true;
                    setVisible(false);
                }
            }

        }
    }

    public class UserAccessButtonListener implements ActionListener {
        public void actionPerformed (ActionEvent event) {

            String button = event.getActionCommand();


            if (button.equals("Create quiz")) {
                createQuizClicked = true;
                setVisible(false);
            } else if (button.equalsIgnoreCase("get quiz")) {
                getQuizClicked = true;
                setVisible(false);
            } else {
                createQuizClicked = false;
                getQuizClicked = false;
                quizCancelButtonClicked = true;
                setVisible(false);
            }
        }
    }

    public class deleteUserButtonListener implements ActionListener {
        public void actionPerformed (ActionEvent event) {

            String button = event.getActionCommand();

            if (button.equals("Delete")) {
                deleteButtonClicked = true;
                setVisible(false);
            }
            setVisible(false);

        }
    }

    public class nextQuestionButtonListener implements ActionListener {
        public void actionPerformed (ActionEvent event){
            String button = event.getActionCommand();

            if (button.equalsIgnoreCase("next")){
                nextQuestionClicked = true;
                setVisible(false);
            } else {
                if (button.equalsIgnoreCase("Cancel")){
                    quizCancelButtonClicked = true;
                    setVisible(false);
                }

            }
        }
    }

}











package org.example;

public class oppsamling {

/*



        JLabel nameLabel = new JLabel("Username:");
        JLabel passLabel = new JLabel("Password:");
        //JTextField userName = new JTextField(10);
        JPasswordField passWord = new JPasswordField(10);;
        //JPanel loginPanel = new JPanel(new java.awt.GridBagLayout());


        loginPanel.add(nameLabel, newInterface.createConstraint(0,0));
        loginPanel.add(userName, newInterface.createConstraint(1, 0));
        loginPanel.add(passLabel, newInterface.createConstraint(0, 1));
        loginPanel.add(passWord, newInterface.createConstraint(1, 1));


        int login = showConfirmDialog(null, loginPanel, "Type your username and password to login", OK_CANCEL_OPTION);{




 */
}



/*

package org.example;


import javax.swing.*;
import java.awt.*;
import javax.swing.JButton;
import java.awt.event.*;

import static org.example.Database.checkAccess;
import static org.example.Database.checkLogin;
import static org.example.Interface.passWord;
import static org.example.Interface.userName;

class Interface extends JFrame
{
    private final JLabel nameLabel = new JLabel("Username:");
    private final JLabel passLabel = new JLabel("Password:");
    public static JTextField userName = new JTextField(10);
    public static JPasswordField passWord = new JPasswordField(10);;

    public void AdminPanel()
    {
        setTitle("Admin panel");
        setLayout(new FlowLayout());
        setSize(300,200);
        setLocation(1200, 500);

        JButton RegNewUser = new JButton("New User");
        JButton RegNewQuestion = new JButton("New Question");


        add(RegNewUser);
        add(RegNewQuestion);

        AdminPanelListener adminListener = new AdminPanelListener();
        RegNewUser.addActionListener(adminListener);
        RegNewQuestion.addActionListener(adminListener);

        setVisible(true);
        pack();


    }

    public void newUser(){
        setTitle("Register new user");
        setLayout(new GridLayout(4,2,4,4));
        setVisible(true);
        setSize(300, 200);
        setLocation(1200, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Database newDb = new Database();

        JLabel usernameLabel = new JLabel("Username: ");
        JLabel passwordLabel = new JLabel("Password: ");
        JLabel accessLabel = new JLabel("Access type: ");

        JTextField usernameField = new JTextField(10);
        JPasswordField passwordField = new JPasswordField(10);
        JTextField accessField = new JTextField(10);

        JButton regUser = new JButton("Register");
        JButton cancelReg = new JButton("Cancel");

        JRootPane pane = getRootPane();
        pane.setDefaultButton(regUser);

        add(usernameLabel);
        add(usernameField);

        add(passwordLabel);
        add(passwordField);

        add(accessLabel);
        add(accessField);

        add(regUser);
        add(cancelReg);

        String newUserName = usernameField.getText();
        String newPassWord = passwordField.getText();
        String newAccess = accessField.getText();

        //Database.newUser(usernameField.getText(), passwordField.getText(), accessField.getText());

        newUserListener userListener = new newUserListener();
        regUser.addActionListener(userListener);
        cancelReg.addActionListener(userListener);


        pack();


    }




    public void User()
    {
        setTitle("User panel");
        setLayout(new FlowLayout());
        setSize(300,200);
        setLocation(1200, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton getQuestion = new JButton("Get question");
        JButton getQuiz = new JButton("Get quiz");


        add(getQuestion);
        add(getQuiz);
        setVisible(true);
        pack();

    }

    private static final int I_GAP = 3;
    static GridBagConstraints createConstraint(int x, int y)
    {
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = x;
        gbc.gridy = y;
        gbc.fill = java.awt.GridBagConstraints.HORIZONTAL;

        gbc.weightx = 1.0;
        gbc.weighty = 0.0;

        gbc.insets = new java.awt.Insets(I_GAP, I_GAP, I_GAP, I_GAP);
        gbc.anchor = x % 2 == 0 ? java.awt.GridBagConstraints.WEST : java.awt.GridBagConstraints.EAST;
        return gbc;
    }


    public void loginInterface(){
        setTitle("Login panel");
        setLayout(new GridLayout(3, 2, 10, 10));
        setSize(500,500);
        setLocation(1200, 500);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        LoginPanelListener buttonListener = new LoginPanelListener();

        JButton login = new JButton("Login");
        JButton cancelLogin = new JButton("Cancel");
        JRootPane pane = getRootPane();
        pane.setDefaultButton(login);
        KeyStroke escapeKey = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0);
        InputMap keyMap = cancelLogin.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        keyMap.put(escapeKey, "Cancel");
        ActionMap actionMap = cancelLogin.getActionMap();
        //actionMap.put(escapeKey, buttonListener);


        add(nameLabel);
        add(userName);
        add(passLabel);
        add(passWord);
        add(login);
        add(cancelLogin);





        login.addActionListener(buttonListener);
        cancelLogin.addActionListener(buttonListener);

        pack();
    }


}




if (button.equals("LoginParent"))
            {
                newLoginInterface.setVisible(true);
                if (newLoginInterface.loginClicked)
                {
                    if(Database.checkLogin(newLoginInterface.getUserName(), newLoginInterface.getPassWord())) {
                        System.out.println("Login successful");
                        if (Database.checkAccess(newLoginInterface.getUserName(), newLoginInterface.getPassWord()).equals("admin")) {
                            newAdmin.setVisible(true);
                        }
                    }

                    if (newAdmin.newUserClicked){
                        newUserWindow.setVisible(true);
                        System.out.println("new user clicked: " + newLoginInterface.newUserClicked);
                        if (newLoginInterface.registerUserClicked){
                            System.out.println("register new user clicked");
                        }
                    } else {
                        if (newAdmin.newQuestionClicked){
                            System.out.println("new question clicked");
                        }
                    }
                    if (Database.newUser(newUserWindow.getUserName(), newUserWindow.getPassWord(), newUserWindow.getPassWord())){
                        System.out.println("New user is registered successfully!");
                    } else {
                        System.out.println("Failed to register user.");
                    }
                }
            } else {
                setVisible(false);
            }

*
*  */

/**
 private class ButtonListener implements ActionListener {
@Override
public void actionPerformed(ActionEvent event) {

String button = event.getActionCommand();

if (newLoginInterface.getLoginClicked())
{                         // Starting the parent window when "login" button is clicked
setVisible(false);
newLoginInterface.setVisible(true);
if (newLoginInterface.dataOk()) {                       // Sets the login credentials from the parent window to the Login method
//System.out.println("test1");
if (newLoginInterface.checkLogin(newLogin)) {       // Checks if the login credentials are valid
if (Database.checkLogin(newLogin.getUserName(), newLogin.getPassWord())) { // Checks if credentials exists in a database
//System.out.println("test2");
if (Database.checkAccess(newLogin.getUserName(), newLogin.getPassWord()).equals("admin")) { // Checks if the credentials have admin rights
while (!newAdmin.getAdminCancelButton()){
newAdmin.setVisible(true);
if (newAdmin.getNewUserClicked()) {      // Checks if the new user button is clicked
newUserWindow.setVisible(true);
if (newAdmin.getNewUserClicked()) { // Checks if the credentials for the new user is valid e.g not empty
if (newUserWindow.dataOk(newUserWindow.getUserName(), newUserWindow.getPassWord(), newUserWindow.getAccess())) {
if (Database.newUser(newUserWindow.getUserName(), newUserWindow.getPassWord(), newUserWindow.getAccess())) {
newUserWindow.showRegisteredUserMessage();
}
}
}
} else if (newAdmin.getNewQuestionClicked()) {
newQuestion.setVisible(true);
if (newQuestion.QuestiondataOk(newQuestion.getQuestion(), newQuestion.getAnswer())) {
if (Database.newQuestion(newQuestion.getQuestion(), newQuestion.getAnswer(), newLogin.getUserName())) {
newQuestion.showRegMessage();
}
}
} else if (newAdmin.getShowAllUsers()) {
Database.getUsers();

} else if (newAdmin.getDeletedUsersClicked()) {
deleteUser.setVisible(true);
if (deleteUser.getDeleteUserClicked()) {
System.out.println("Delete user clicked 2");
if (deleteUser.deleteUserDataOk(deleteUser.getId(), deleteUser.getDeleteUsername())) {
System.out.println("Delete userdata ok");
if (Database.deleteUser(deleteUser.getId(), deleteUser.getDeleteUsername())) {
deleteUser.showDeleteUserMessage();
}
}
}
}
}
} else {
if (Database.checkAccess(newLogin.getUserName(), newLogin.getPassWord()).equals("user")) {
useraccesswindow.setVisible(true);
if (useraccesswindow.getQuizClicked){
quizSize.setVisible(true);
newQuiz.setVisible(true);
}
}
}
}
}
}
}else {
setVisible(false);
}
}
}**/
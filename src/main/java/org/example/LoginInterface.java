package org.example;

import javax.swing.*;
import java.awt.*;

import static javax.swing.JOptionPane.*;

public class LoginInterface extends Interface {


     // false = user, true == admin
    private JTextField userName = new JTextField(10);
    private JPasswordField passWord = new JPasswordField(10);

    LoginPanel loginPanel = new LoginPanel();


    public LoginInterface(JFrame parent){
        super(parent, "Login");
        add(new JPanel(), BorderLayout.NORTH);
        add(new LoginPanel(), BorderLayout.CENTER);
        add(getLoginButtonPanel(), BorderLayout.SOUTH);
        pack();  }

    private class LoginPanel extends JPanel {
        public LoginPanel(){
            setLayout(new GridLayout(3, 2));
            add(new JLabel("Username"));
            add(userName);
            add(new JLabel("Password"));
            add(passWord);

        }
    }

    public JPanel getLoginPanel() {
        return loginPanel;
    }

    public String getUserName() {
        String username = userName.getText();
        return username;
    }

    public void setUserName(JTextField userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        String password = passWord.getText();
        return password;
    }

    public void setPassWord(JPasswordField passWord) {
        this.passWord = passWord;
    }

    protected boolean checkLogin(Login login){

        String username = userName.getText();
        String password = passWord.getText();

        login.setUserName(username);
        login.setPassWord(password);

        setVerified(false);
        pack();
        userName.requestFocusInWindow();
        if (dataOk()){
            login.setUserName(userName.getText());
            login.setPassWord(passWord.getText());
            return true;
        }
        return false;
    }


    protected boolean dataOk() {
        String username = userName.getText().trim();
        String password = passWord.getText().trim();


        if (username.equals("") || password.equals(""))
        {
            showMessageDialog(LoginInterface.this, "Wrong username or password");
            if (username.equals("")) {
                userName.requestFocusInWindow();
            } else {
                passWord.requestFocusInWindow();
            } return false;
        }
        return true;
    }

    public boolean getLoginClicked() {return loginClicked; }




}


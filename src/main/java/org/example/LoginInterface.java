package org.example;

import javax.swing.*;
import java.awt.*;

import static javax.swing.JOptionPane.*;

public class LoginInterface extends Interface {

    private JTextField userName = new JTextField(10);
    private JPasswordField passWord = new JPasswordField(10);

    public void setUsernameField(String username) {
        userName.setText(username);
    }

    public void setPasswordField(String password){
        passWord.setText(password);
    }

    LoginPanel loginPanel = new LoginPanel();
    infoPanel infopanel = new infoPanel();

    public LoginInterface(JFrame parent){
        super(parent, "Login");
        userName.setText("");
        passWord.setText("");

        add(new JPanel());
        add(new LoginPanel(), BorderLayout.NORTH);
        add(getInfoPanel(), BorderLayout.CENTER);
        add(getLoginButtonPanel(), BorderLayout.SOUTH);
        pack();
    }

    private class LoginPanel extends JPanel {
        public LoginPanel(){
            setLayout(new GridLayout(2, 2));
            add(new JLabel("Username"));
            add(userName);
            add(new JLabel("Password"));
            add(passWord);

        }
    }

    public class infoPanel extends JPanel {
        public infoPanel () {
            setLayout(new GridLayout(1, 2));
            JLabel registerInfo = new JLabel("Do you not have an account?");
            JLabel registerInfoTwo = new JLabel("\nClick \"Register\" to create one!");
            add(registerInfo, BorderLayout.NORTH);
            add(registerInfoTwo, BorderLayout.SOUTH);
            pack();
        }
    }

    public JPanel getLoginPanel() {
        return loginPanel;
    }

    public JPanel getInfoPanel () { return infopanel; }
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
        showMessageDialog(LoginInterface.this, "Wrong username or password");
        return false;
    }


    protected boolean dataOk() {
        String username = userName.getText().trim();
        String password = passWord.getText().trim();


        if (username.equals("") || password.equals(""))
        {
            if (username.equals("")) {
                userName.requestFocusInWindow();
            } else {
                passWord.requestFocusInWindow();
            } return false;
        }
        return true;
    }

    public boolean getLoginClicked() {return loginClicked; }
    public boolean getLoginCancelClicked () { return loginCancelButtonClicked; }
    public boolean getSelfRegisterClicked() { return LoginsSelfRegisterCLicked; }

    public void setSelfRegisterClicked(boolean value) {
        LoginsSelfRegisterCLicked = value;
    }


}


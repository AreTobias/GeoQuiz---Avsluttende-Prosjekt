package org.example;

import javax.swing.*;
import java.awt.*;

import static javax.swing.JOptionPane.showMessageDialog;
public class UserWindow extends Interface{

    private JTextField userName = new JTextField(10);
    private JPasswordField passWord = new JPasswordField(10);
    private JTextField accessField = new JTextField(10);
    UserPanel userpanel = new UserPanel();

    public UserWindow(JFrame parent){
        super(parent, "New user");
        add(new JPanel(), BorderLayout.NORTH);
        add(getUserPanel(), BorderLayout.CENTER);
        add(getNewUserButtonPanel(), BorderLayout.SOUTH);
        setSize(400, 400);
        pack();
    }

    private class UserPanel extends JPanel {
        public UserPanel(){
            setLayout(new GridLayout(4, 4));
            add(new JLabel("Username"));
            add(userName);
            add(new JLabel("Password"));
            add(passWord);
            add(new JLabel("Access"));
            add(accessField);


        }
    }

    public JPanel getUserPanel() {
        return userpanel;
    }

    public String getUserName() {
        String username = userName.getText();
        return username;
    }

    public String getPassWord() {
        String password = passWord.getText();
        return password;
    }

    public String getAccess() {
        String accessString = accessField.getText();
        return accessString;
    }

    protected boolean getRegisteredUserClick () {
        return registerUserClicked;

    }

    protected void showRegisteredUserMessage() {
        showMessageDialog(UserWindow.this, "New User registered successfully!");
    }


    protected boolean dataOk(String username, String password, String access)
    {
        boolean value = false;
        if (getRegisteredUserClick()){
            if (username.trim().equals("") || password.trim().equals("") || access.trim().equals("")) {
                showMessageDialog(UserWindow.this, "You need to fill in username, password and accessrights");
                if (username.trim().equals("")) {
                    userName.requestFocusInWindow();
                } else if (password.trim().equals("")) {
                    passWord.requestFocusInWindow();
                } else {
                    accessField.requestFocusInWindow();
                }
            } else {
                value = true;
                setVisible(false);
            }
        }

        return value;
    }

    protected void ShowRegisteredUsers () {

    }
}


package org.example;

import org.jetbrains.annotations.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import static javax.swing.JOptionPane.*;

public class SelfRegister extends Interface{

        selfRegisterPanel selfregpanel = new selfRegisterPanel();
        SelfRegGreetings selfreggreetings = new SelfRegGreetings();

        selfRegisterButtonPanel selfregbutton = new selfRegisterButtonPanel();
        public static JTextField usernamefield = new JTextField(10);
        public static JPasswordField passwordfield = new JPasswordField(10);

        public SelfRegister(JFrame parent) {
            super(parent, "Register user");

            add(new JPanel(new FlowLayout()));
            add(getSelfRegGreetings(), BorderLayout.NORTH);
            add(getSelfRegPanel(), BorderLayout.CENTER);
            add(getSeflRegButtons(), BorderLayout.SOUTH);
            pack();

        }


        private class  selfRegisterPanel extends JPanel{
            public selfRegisterPanel(){
                setLayout(new GridLayout(2, 1));
                JLabel usernamelabel = new JLabel("Username: ");
                add(usernamelabel);
                add(usernamefield);
                JLabel passwordlabel = new JLabel("Password: ");
                add(passwordlabel);
                add(passwordfield);
                pack();

            }
        }

        private class SelfRegGreetings extends JPanel {
            public SelfRegGreetings(){
                setLayout(new FlowLayout());
                JLabel greeting = new JLabel(" ");
                JLabel greetintwo = new JLabel("Fill in the form below to register a user.");
                add(greeting);
                add(greetintwo, BorderLayout.CENTER);
                pack();
            }
        }

        public JPanel getSelfRegPanel () { return selfregpanel; }

        public JPanel getSeflRegButtons() { return selfregbutton; }
        public JPanel getSelfRegGreetings() { return selfreggreetings; }

        public class selfRegisterButtonPanel extends JPanel{
            public selfRegisterButtonPanel () {
                setLayout(new GridLayout(1,2));
                JButton SelfRegister = new JButton("Register");
                JButton SelfRegCancel = new JButton("Back");
                add(SelfRegister);
                add(SelfRegCancel);

                selfRegButtonListener listener = new selfRegButtonListener();
                SelfRegister.addActionListener(listener);
                SelfRegCancel.addActionListener(listener);

                pack();
            }
        }

        public boolean registerOk (String username){
            boolean verify = Database.CheckUserNameExist(username);
            return verify;
        }
        public class selfRegButtonListener implements ActionListener {
            public void actionPerformed (@NotNull ActionEvent event){
                String button = event.getActionCommand();
                System.out.println(registerOk(usernamefield.getText()));
                if (button.equals("Register")){
                    System.out.println(button);
                    LoginsSelfRegisterCLicked = false;
                    if (!registerOk(usernamefield.getText()) && Database.newUser(usernamefield.getText(), passwordfield.getText(), "user")){
                        showMessageDialog(SelfRegister.this, "User registered successfully!" +
                                                                                "\nYou can now log in with username: " + usernamefield.getText() +
                                                                                "\nand the password you typed.");
                        setVisible(false);

                    } else {
                        showMessageDialog(null, "Couldn't register user, username already taken.");
                        //12333333setVisible(false);
                    }

                } else if (button.equals("Back")){
                    selfRegisterCancelClicked = false;
                    setVisible(false);

                }
            }
        }

}

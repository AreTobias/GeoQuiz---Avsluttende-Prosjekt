package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import static javax.swing.JOptionPane.showMessageDialog;

public class showRegisteredUsersWindow extends Interface {

    showRegisteredUsersPanel showRegUsersPanel = new showRegisteredUsersPanel();

    public static HashMap<Integer, String[]> users = new HashMap<>(Database.getUser());
    public static JLabel ID = new JLabel();
    public static JLabel userName = new JLabel();
    public static JLabel access = new JLabel();
    public static JTextField idTextField = new JTextField(10);
    //public int idInt = Integer.parseInt(idTextField.getText());
    public static JTextField usernameTextField = new JTextField(10);
    public static JTextArea textArea = new JTextArea();
    public void setIdTextField(String idFelt) {
        idTextField.setText(idFelt);
    }
    public void setUsernameTextField(String username) {
        usernameTextField.setText(username);
    }

    public void setID(String IDInput) { ID.setText(IDInput); }

    public void setTextArea (String id, String username, String access) {
        textArea.append(id);
        textArea.append(username);
        textArea.append(access);
    }

    public void setUserName(String userNameInput) {
        userName.setText(userNameInput);
    }

    public void setAccess(String AccessInput) {
        access.setText(AccessInput);
    }

    showRegisteredUsersButtonPanel buttonpanel = new showRegisteredUsersButtonPanel();

    public showRegisteredUsersWindow(JFrame parent) {
        super(parent, "Registered users");
        add(getshowRegisteredUsersPanel(), BorderLayout.CENTER);
        add(getShowRegisteredusersButtonPanel(), BorderLayout.SOUTH);
        pack();

    }

    private class showRegisteredUsersPanel extends JPanel{
        public showRegisteredUsersPanel() {
            setLayout(new GridLayout(3, 3));
            JPanel textPanel = new JPanel();


            ArrayList<String[]> test = new ArrayList<String[]>(users.values());

            for(String[] s: test){
                System.out.println(users.entrySet());
                System.out.println(s);
            }
            textPanel.add(textArea);
            textArea.setEditable(false);
            JScrollPane scrollPane = new JScrollPane(textPanel);

            JLabel delId = new JLabel("Id:");
            JLabel delUserName = new JLabel("Username:");
            //textPanel.add(ID);
            //textPanel.add(userName);
            //textPanel.add(access);
            add(scrollPane);
            add(delId);
            add(idTextField);
            add(delUserName);
            add(usernameTextField);
            pack();
        }
    }


    public class showRegisteredUsersButtonPanel extends JPanel {
        public showRegisteredUsersButtonPanel() {
            setLayout(new GridLayout(2, 2));
            JButton delUser = new JButton("Delete");
            JButton cancel = new JButton("Cancel");
            add(delUser);
            add(cancel);

            showUsersButtonListener listener = new showUsersButtonListener();
            delUser.addActionListener(listener);
            cancel.addActionListener(listener);
            pack();
        }
    }

    public JPanel getShowRegisteredusersButtonPanel() {return buttonpanel;}

    public  JPanel getshowRegisteredUsersPanel() { return showRegUsersPanel;}


    public class showUsersButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {

            String button = event.getActionCommand();

            if (button.equals("Delete")) {
                if (Database.deleteUser(Integer.parseInt(idTextField.getText()), usernameTextField.getText())) {
                    deleteUsersClicked = true;

                }

            } else {
                if (button.equals("Cancel"))
                    setVisible(false);
            }
        }
    }

    protected void showDeleteUserMessage () {
        showMessageDialog(showRegisteredUsersWindow.this, "User deleted successfully!");
    }

    protected boolean getDeleteUsersClicked() {return deleteUsersClicked; }



}


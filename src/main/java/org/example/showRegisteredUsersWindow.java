package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static javax.swing.JOptionPane.showMessageDialog;

public class showRegisteredUsersWindow extends Interface {

    showRegisteredUsersPanel showRegUsersPanel = new showRegisteredUsersPanel();

    public static JTextField idTextField = new JTextField(10);

    public static JTextField usernameTextField = new JTextField(10);
    public static JTextArea textArea = new JTextArea();
    public static JScrollPane scrollpane = new JScrollPane();
    showRegisteredUsersButtonPanel buttonpanel = new showRegisteredUsersButtonPanel();

    showDeleteUsersInputPanel showDeleteUsersInputPanel = new showDeleteUsersInputPanel();

    public showRegisteredUsersWindow(JFrame parent) {
        super(parent, "Registered users");
        add(getshowRegisteredUsersPanel(), BorderLayout.NORTH);
        add(getShowDeleteUsersInputPanel(), BorderLayout.CENTER);
        add(getShowRegisteredusersButtonPanel(), BorderLayout.SOUTH);
        pack();

    }

    private class showRegisteredUsersPanel extends JPanel{
        public showRegisteredUsersPanel() {
            setLayout(new GridLayout(1, 1));
            JPanel textPanel = new JPanel();
            HashMap<Integer, String[]> users = new HashMap<>(Database.getUser());
            textArea.setText("");
            idTextField.setText("");
            usernameTextField.setText("");

            for (Map.Entry<Integer, String[]> set : users.entrySet()){
                textArea.append(set.getKey().toString() + " - " + Arrays.toString(set.getValue()) + "\n");
            }

            textPanel.add(textArea);
            scrollpane.add(textArea);
            textArea.setEditable(false);
            add(textArea);
            add(scrollpane);
            pack();
        }
    }


    public class showRegisteredUsersButtonPanel extends JPanel {
        public showRegisteredUsersButtonPanel() {
            setLayout(new GridLayout(1, 1));
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

    public class showDeleteUsersInputPanel extends JPanel {
        public showDeleteUsersInputPanel() {
            setLayout(new GridLayout(2, 1));
            JLabel delId = new JLabel("Id:");
            JLabel delUserName = new JLabel("Username:");

            add(delId);
            add(idTextField);
            add(delUserName);
            add(usernameTextField);
        }
    }

    public JPanel getShowRegisteredusersButtonPanel() {return buttonpanel;}

    public  JPanel getshowRegisteredUsersPanel() { return showRegUsersPanel;}

    public JPanel getShowDeleteUsersInputPanel () { return showDeleteUsersInputPanel; }

    public boolean getDelUserCancelClicked () { return deleteUserCancelClicked; }

    public class showUsersButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {

            String button = event.getActionCommand();

            if (button.equals("Delete")) {
                if (Database.CheckUserNameExist(usernameTextField.getText())){
                    if (Database.deleteUser(Integer.parseInt(idTextField.getText()), usernameTextField.getText())) {
                        deleteUsersClicked = true;
                        showDeleteUserMessage();
                        setVisible(false);

                    }
                }
                 else {
                    showMessageDialog(null, "Couldn't delete that user!");
                    setVisible(false);
                }

            } else {
                if (button.equals("Cancel")){
                    deleteUserCancelClicked = true;
                    setVisible(false);
                }

            }
        }
    }

    protected void showDeleteUserMessage () {
        showMessageDialog(showRegisteredUsersWindow.this, "User deleted successfully!");
    }





}


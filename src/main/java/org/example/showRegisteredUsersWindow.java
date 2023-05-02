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
    delUserInputPanel delUserInputPanel = new delUserInputPanel();
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


    public void setUserName(String userNameInput) {
        userName.setText(userNameInput);
    }

    public void setAccess(String AccessInput) {
        access.setText(AccessInput);
    }

    showRegisteredUsersButtonPanel buttonpanel = new showRegisteredUsersButtonPanel();

    public showRegisteredUsersWindow(JFrame parent) {
        super(parent, "Registered users");
        add(getshowRegisteredUsersPanel(), BorderLayout.NORTH);
        add(getShowRegisteredusersButtonPanel(), BorderLayout.SOUTH);
        add(getDelUserInputPanel(), BorderLayout.CENTER);
        pack();

    }

    private class showRegisteredUsersPanel extends JPanel{
        public showRegisteredUsersPanel() {
            setLayout(new GridLayout(2, 1));
            JPanel textPanel = new JPanel();
            textArea.setText("");
            setDeleteUsersClicked(false);
            usernameTextField.setText("");
            idTextField.setText("");
            HashMap<Integer, String[]> users = new HashMap<>(Database.getUser());

            for (Map.Entry<Integer, String[]> set : users.entrySet()){
                textArea.append(set.getKey().toString() + " - ");
                textArea.append(Arrays.toString(set.getValue()) + "\n");
            }
            textPanel.add(textArea);
            textArea.setEditable(false);
            JScrollPane scrollPane = new JScrollPane(textPanel);

            add(scrollPane);




            pack();
        }
    }

    public class delUserInputPanel extends JPanel{
        public delUserInputPanel(){
            setLayout(new GridLayout(2, 1));
            JLabel delId = new JLabel("Id:");
            JLabel delUserName = new JLabel("Username:");
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

    public JPanel getDelUserInputPanel() { return delUserInputPanel; }

    public class showUsersButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {

            String button = event.getActionCommand();

            if (button.equals("Delete")) {
                if (Database.deleteUser(Integer.parseInt(idTextField.getText().trim()), usernameTextField.getText().trim())) {
                    deleteUsersClicked = true;
                    showDeleteUserMessage();
                    setVisible(false);
                }

            } else {
                if (button.equals("Cancel"))
                    deleteUsersClicked = false;
                    setVisible(false);
            }
        }
    }

    protected void showDeleteUserMessage () {
        showMessageDialog(showRegisteredUsersWindow.this, "User deleted successfully!");
    }

    protected boolean getDeleteUsersClicked() {return deleteUsersClicked; }

    protected boolean getDeletedUsersCancelClicked() { return deleteUsersClicked; }

}


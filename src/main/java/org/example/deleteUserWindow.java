package org.example;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.text.*;
import static javax.swing.JOptionPane.*;
public class deleteUserWindow extends Interface{



    private JTextField IDField = new JTextField(20);
    private JTextField usernameField = new JTextField(20);

    deleteUserPanel deleteUserPanel = new deleteUserPanel();

    public deleteUserWindow(JFrame parent){
        super(parent, "Delete users");
        add(new JPanel(), BorderLayout.NORTH);
        add(getDeleteUserPanel(), BorderLayout.CENTER);
        add(getDeleteUserButtonPanel(), BorderLayout.SOUTH);
        pack();
    }

    private class deleteUserPanel extends JPanel {
        public deleteUserPanel(){
            setLayout(new GridLayout(4, 4));
            add(new JLabel("ID:"));
            add(IDField);
            add(new JLabel("Username"));
            add(usernameField);

        }
    }

    public JPanel getDeleteUserPanel() {
        return deleteUserPanel;
    }

    public int getId() {
        String deleteuserId = IDField.getText();
        int deleteUserInt = Integer.parseInt(deleteuserId);
        return deleteUserInt;
    }

    public String getDeleteUsername() {
        String username = usernameField.getText();
        return username;
    }

    protected boolean getDeleteUserClicked () {
        return deleteButtonClicked;

    }



    protected boolean deleteUserDataOk(int id, String username)
    {
        if (id == 0 || username.trim().equals(""))
        {
            showMessageDialog(deleteUserWindow.this, "You need to fill out the ID and username of the user you want to delete");
            if (id == 0)
            {
                IDField.requestFocusInWindow();
            } else {
                if (username.trim().equals("")){
                    usernameField.requestFocusInWindow();
                }
            } return false;
        } return true;
    }

    protected void showDeleteUserMessage () {
        showMessageDialog(deleteUserWindow.this, "User deleted successfully!");
    }

}


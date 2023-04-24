package org.example;

import javax.swing.*;
import java.awt.*;

class AdminWindow extends Interface{

    AdminPanel newAdminPanel = new AdminPanel();



    public AdminWindow(JFrame parent){
        super(parent, "Admin Window");
        add(new JPanel(), BorderLayout.NORTH);
        add(getAdminPanel(), BorderLayout.SOUTH);
        pack();
    }

    private class AdminPanel extends JPanel {
        public AdminPanel(){
            setLayout(new FlowLayout());
            add(getAdminButtonPanel());
        }
    }

    protected boolean getNewUserClicked() {
        return newUserClicked;
    }

    protected boolean getDeletedUsersClicked() { return deleteUsersClicked;}

    protected boolean getNewQuestionClicked() { return newQuestionClicked; }

    protected JPanel getAdminPanel() {
        return newAdminPanel;
    }

    protected boolean getRegisteredUsersClicked() {
        return getRegisteredUsers;
    }

    protected boolean getAdminCancelButton() { return adminCancelButton; }


}
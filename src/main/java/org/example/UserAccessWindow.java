package org.example;

import javax.swing.*;
import java.awt.*;

public class UserAccessWindow extends Interface {

    UserAccessPanel accessPanel = new UserAccessPanel();

    public UserAccessWindow(JFrame parent) {
        super(parent, "New Question");
        add(new JPanel(), BorderLayout.NORTH);
        add(getUserAccessPanel(), BorderLayout.CENTER);
        add(getUserAccessButtonPanel(), BorderLayout.SOUTH);
        pack();
    }

    private class UserAccessPanel extends JPanel {
        public UserAccessPanel() {
            setLayout(new GridLayout(4, 4));


        }
    }

    public JPanel getUserAccessPanel () {
        return accessPanel;
    }

    protected boolean getQuizCancelButtonClicked() {
        return quizCancelButtonClicked;
    }

    public void setQuizCancelButtonClicked() {
        quizCancelButtonClicked = false;
    }

    protected boolean getGetQuizClicked() {
        return getQuizClicked;
    }
}
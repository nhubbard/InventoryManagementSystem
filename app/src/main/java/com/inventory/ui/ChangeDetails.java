package com.inventory.ui;

import com.inventory.dao.UserDAO;
import com.inventory.ui.util.MouseClickedListener;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.util.Objects;

import static javax.swing.GroupLayout.Alignment.*;
import static javax.swing.GroupLayout.DEFAULT_SIZE;
import static javax.swing.GroupLayout.PREFERRED_SIZE;
import static javax.swing.LayoutStyle.ComponentPlacement.RELATED;
import static javax.swing.LayoutStyle.ComponentPlacement.UNRELATED;

public class ChangeDetails extends JPanel {
    String user;

    public ChangeDetails(String userSelect) {
        initComponents();
        user = userSelect;
        fullNameText.setEnabled(false);
        locationText.setEnabled(false);
        phoneText.setEnabled(false);
        usernameText.setEnabled(false);
        passwordText.setEnabled(false);
        newPasswordText.setEnabled(false);
        categoryText.setEnabled(false);
        ResultSet rs = new UserDAO().getUser(user);
        try {
            while (rs.next()) {
                fullNameText.setText(rs.getString("fullname"));
                locationText.setText(rs.getString("location"));
                phoneText.setText(rs.getString("phone"));
                usernameText.setText(rs.getString("username"));
                categoryText.setText(rs.getString("category"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initComponents() {
        mainPanel = new JPanel();
        JTabbedPane tabbedPane = new JTabbedPane();
        inputPanel = new JPanel();
        usernameText = new JTextField();
        JLabel usernameLabel = new JLabel();
        JLabel passwordLabel = new JLabel();
        JLabel locationLabel = new JLabel();
        JLabel fullNameLabel = new JLabel();
        phoneText = new JTextField();
        locationText = new JTextField();
        fullNameText = new JTextField();
        JLabel phoneLabel = new JLabel();
        JLabel clearButton = new JLabel();
        JLabel editButton = new JLabel();
        passwordText = new JPasswordField();
        JLabel passwordLabelOne = new JLabel();
        categoryText = new JTextField();
        JLabel updateButtonLabel = new JLabel();
        JLabel clearButtonLabel = new JLabel();
        JLabel passwordLabelTwo = new JLabel();
        newPasswordText = new JPasswordField();
        JButton editProfileButton = new JButton();

        inputPanel.setBorder(BorderFactory.createTitledBorder(""));

        usernameText.setBorder(new LineBorder(new Color(204, 204, 204), 1, true));

        usernameLabel.setText("Username");
        passwordLabel.setText("Old Password");
        locationLabel.setText("Location");
        fullNameLabel.setText("Full Name");

        phoneText.setBorder(new LineBorder(new Color(204, 204, 204), 1, true));
        locationText.setBorder(new LineBorder(new Color(204, 204, 204), 1, true));
        fullNameText.setBorder(new LineBorder(new Color(204, 204, 204), 1, true));

        phoneLabel.setText("Phone");

        clearButton.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/com/inventory/ui/images" +
            "/clear.png"))));
        clearButton.addMouseListener((MouseClickedListener) this::clearButtonMouseClicked);

        editButton.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/com/inventory/ui/images" +
            "/editPeople.png"))));
        editButton.addMouseListener((MouseClickedListener) this::editButtonMouseClicked);

        passwordText.setBorder(new LineBorder(new Color(204, 204, 204), 1, true));

        passwordLabelOne.setText("Category");

        categoryText.setBorder(new LineBorder(new Color(204, 204, 204), 1, true));

        updateButtonLabel.setText("Update");

        clearButtonLabel.setText("Clear");

        passwordLabelTwo.setText("New Password");

        newPasswordText.setBorder(new LineBorder(new Color(204, 204, 204), 1, true));

        GroupLayout inputPanelLayout = new GroupLayout(inputPanel);
        inputPanel.setLayout(inputPanelLayout);
        inputPanelLayout.setHorizontalGroup(
            inputPanelLayout.createParallelGroup(LEADING)
                .addGroup(
                    inputPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(
                            inputPanelLayout.createParallelGroup(LEADING)
                                .addGroup(inputPanelLayout.createSequentialGroup()
                                    .addGap(10, 10, 10)
                                    .addComponent(updateButtonLabel)
                                    .addGap(23, 23, 23)
                                    .addComponent(clearButtonLabel))
                                .addGroup(inputPanelLayout.createSequentialGroup()
                                    .addComponent(editButton)
                                    .addPreferredGap(UNRELATED)
                                    .addComponent(clearButton))
                                .addGroup(inputPanelLayout.createSequentialGroup()
                                    .addGroup(inputPanelLayout.createParallelGroup(LEADING)
                                        .addComponent(passwordLabelTwo, PREFERRED_SIZE, 92, PREFERRED_SIZE)
                                        .addComponent(locationLabel)
                                        .addComponent(fullNameLabel)
                                        .addComponent(phoneLabel)
                                        .addComponent(usernameLabel, PREFERRED_SIZE, 61, PREFERRED_SIZE)
                                        .addComponent(passwordLabelOne, PREFERRED_SIZE, 61, PREFERRED_SIZE)
                                        .addComponent(passwordLabel, PREFERRED_SIZE, 92, PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(inputPanelLayout.createParallelGroup(LEADING)
                                        .addComponent(fullNameText, TRAILING)
                                        .addComponent(locationText, TRAILING)
                                        .addComponent(phoneText, TRAILING)
                                        .addComponent(usernameText, TRAILING)
                                        .addComponent(passwordText)
                                        .addComponent(categoryText)
                                        .addComponent(newPasswordText))))
                        .addGap(34, 34, 34)));
        inputPanelLayout.setVerticalGroup(
            inputPanelLayout.createParallelGroup(LEADING)
                .addGroup(inputPanelLayout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addGroup(inputPanelLayout.createParallelGroup(BASELINE)
                        .addComponent(fullNameText, PREFERRED_SIZE, 32, PREFERRED_SIZE)
                        .addComponent(fullNameLabel))
                    .addPreferredGap(RELATED)
                    .addGroup(inputPanelLayout.createParallelGroup(BASELINE)
                        .addComponent(locationLabel)
                        .addComponent(locationText, PREFERRED_SIZE, 32, PREFERRED_SIZE))
                    .addPreferredGap(RELATED)
                    .addGroup(inputPanelLayout.createParallelGroup(BASELINE)
                        .addComponent(phoneLabel)
                        .addComponent(phoneText, PREFERRED_SIZE, 32, PREFERRED_SIZE))
                    .addPreferredGap(RELATED)
                    .addGroup(inputPanelLayout.createParallelGroup(LEADING)
                        .addComponent(usernameText, PREFERRED_SIZE, 32, PREFERRED_SIZE)
                        .addComponent(usernameLabel, PREFERRED_SIZE, 31, PREFERRED_SIZE))
                    .addPreferredGap(RELATED)
                    .addGroup(inputPanelLayout.createParallelGroup(BASELINE)
                        .addComponent(passwordText, PREFERRED_SIZE, 31, PREFERRED_SIZE)
                        .addComponent(passwordLabel, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE))
                    .addPreferredGap(RELATED)
                    .addGroup(inputPanelLayout.createParallelGroup(BASELINE)
                        .addComponent(newPasswordText, PREFERRED_SIZE, 31, PREFERRED_SIZE)
                        .addComponent(passwordLabelTwo, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE))
                    .addPreferredGap(RELATED)
                    .addGroup(inputPanelLayout.createParallelGroup(LEADING)
                        .addComponent(passwordLabelOne, PREFERRED_SIZE, 36, PREFERRED_SIZE)
                        .addComponent(categoryText, PREFERRED_SIZE, 32, PREFERRED_SIZE))
                    .addPreferredGap(UNRELATED)
                    .addGroup(inputPanelLayout.createParallelGroup(LEADING)
                        .addComponent(editButton)
                        .addComponent(clearButton))
                    .addGap(12, 12, 12)
                    .addGroup(inputPanelLayout.createParallelGroup(BASELINE)
                        .addComponent(updateButtonLabel)
                        .addComponent(clearButtonLabel))
                    .addGap(29, 29, 29)));

        tabbedPane.addTab("Profile Detail", inputPanel);

        editProfileButton.setText("Edit Profile");
        editProfileButton.addActionListener(this::editProfileButtonActionPerformed);

        GroupLayout mainPanelLayout = new GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(mainPanelLayout.createParallelGroup(LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(172, 172, 172)
                .addGroup(mainPanelLayout.createParallelGroup(LEADING)
                    .addComponent(editProfileButton)
                    .addComponent(tabbedPane, PREFERRED_SIZE, 381, PREFERRED_SIZE))
                .addContainerGap(126, Short.MAX_VALUE)));
        mainPanelLayout.setVerticalGroup(mainPanelLayout.createParallelGroup(LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(editProfileButton)
                .addPreferredGap(RELATED)
                .addComponent(tabbedPane)
                .addContainerGap()));

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(LEADING)
            .addComponent(mainPanel, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE));
        layout.setVerticalGroup(layout.createParallelGroup(LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(mainPanel, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)));
    }

    private void editButtonMouseClicked(MouseEvent ignoredEvt) {
        if (fullNameText.getText().equals("") || locationText.getText().equals("") || phoneText.getText().equals("") ||
                usernameText.getText().equals("") || new String(passwordText.getPassword()).equals("") ||
                new String(newPasswordText.getPassword()).equals("")) {
            JOptionPane.showMessageDialog(null, "Please fill all the fields!");
        } else {
            String encryptPass = new Users().encryptPassword(new String(passwordText.getPassword()));
            ResultSet rs = new UserDAO().getPassword(usernameText.getText(), encryptPass);
            try {
                if (rs.next()) {
                    new UserDAO().changePassword(usernameText.getText(), new String(newPasswordText.getPassword()));
                } else {
                    JOptionPane.showMessageDialog(null, "Wrong Password!");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void editProfileButtonActionPerformed(ActionEvent evt) {
        passwordText.setEnabled(true);
        newPasswordText.setEnabled(true);
    }

    private void clearButtonMouseClicked(MouseEvent ignoredEvt) {
        passwordText.setText("");
        newPasswordText.setText("");
    }

    private JTextField categoryText;
    private JTextField fullNameText;
    public JPanel inputPanel;
    private JTextField locationText;
    public JPanel mainPanel;
    private JPasswordField newPasswordText;
    private JPasswordField passwordText;
    private JTextField phoneText;
    private JTextField usernameText;
}

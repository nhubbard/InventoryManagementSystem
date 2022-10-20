package com.inventory.ui;

import com.inventory.dao.UserDAO;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.util.Objects;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.LineBorder;

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
        usernameText.addActionListener(this::usernameTextActionPerformed);

        usernameLabel.setText("Username");
        passwordLabel.setText("Old Password");
        locationLabel.setText("Location");
        fullNameLabel.setText("Full Name");

        phoneText.setBorder(new LineBorder(new Color(204, 204, 204), 1, true));
        locationText.setBorder(new LineBorder(new Color(204, 204, 204), 1, true));
        fullNameText.setBorder(new LineBorder(new Color(204, 204, 204), 1, true));

        phoneLabel.setText("Phone");

        clearButton.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/com/inventory/ui/images/clear.png")))); // NOI18N
        clearButton.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                clearButtonMouseClicked(evt);
            }
        });

        editButton.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/com/inventory/ui/images/editPeople.png")))); // NOI18N
        editButton.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                editButtonMouseClicked(evt);
            }
        });

        passwordText.setBorder(new LineBorder(new Color(204, 204, 204), 1, true));
        passwordText.addActionListener(this::passwordTextActionPerformed);

        passwordLabelOne.setText("Category");

        categoryText.setBorder(new LineBorder(new Color(204, 204, 204), 1, true));

        updateButtonLabel.setText("Update");

        clearButtonLabel.setText("Clear");

        passwordLabelTwo.setText("New Password");

        newPasswordText.setBorder(new LineBorder(new Color(204, 204, 204), 1, true));
        newPasswordText.addActionListener(this::newPasswordTxtActionPerformed);

        GroupLayout inputPanelLayout = new GroupLayout(inputPanel);
        inputPanel.setLayout(inputPanelLayout);
        inputPanelLayout.setHorizontalGroup(inputPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(inputPanelLayout.createSequentialGroup().addContainerGap().addGroup(inputPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(inputPanelLayout.createSequentialGroup().addGap(10, 10, 10).addComponent(updateButtonLabel).addGap(23, 23, 23).addComponent(clearButtonLabel)).addGroup(inputPanelLayout.createSequentialGroup().addComponent(editButton).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(clearButton)).addGroup(inputPanelLayout.createSequentialGroup().addGroup(inputPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(passwordLabelTwo, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE).addComponent(locationLabel).addComponent(fullNameLabel).addComponent(phoneLabel).addComponent(usernameLabel, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE).addComponent(passwordLabelOne, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE).addComponent(passwordLabel, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)).addGap(18, 18, 18).addGroup(inputPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(fullNameText, GroupLayout.Alignment.TRAILING).addComponent(locationText, GroupLayout.Alignment.TRAILING).addComponent(phoneText, GroupLayout.Alignment.TRAILING).addComponent(usernameText, GroupLayout.Alignment.TRAILING).addComponent(passwordText).addComponent(categoryText).addComponent(newPasswordText)))).addGap(34, 34, 34)));
        inputPanelLayout.setVerticalGroup(inputPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(inputPanelLayout.createSequentialGroup().addGap(20, 20, 20).addGroup(inputPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(fullNameText, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE).addComponent(fullNameLabel)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(inputPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(locationLabel).addComponent(locationText, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(inputPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(phoneLabel).addComponent(phoneText, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(inputPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(usernameText, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE).addComponent(usernameLabel, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(inputPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(passwordText, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE).addComponent(passwordLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(inputPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(newPasswordText, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE).addComponent(passwordLabelTwo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(inputPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(passwordLabelOne, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE).addComponent(categoryText, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(inputPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(editButton).addComponent(clearButton)).addGap(12, 12, 12).addGroup(inputPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(updateButtonLabel).addComponent(clearButtonLabel)).addGap(29, 29, 29)));

        tabbedPane.addTab("Profile Detail", inputPanel);

        editProfileButton.setText("Edit Profile");
        editProfileButton.addActionListener(this::editProfileButtonActionPerformed);

        GroupLayout mainPanelLayout = new GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(mainPanelLayout.createSequentialGroup().addGap(172, 172, 172).addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(editProfileButton).addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 381, GroupLayout.PREFERRED_SIZE)).addContainerGap(126, Short.MAX_VALUE)));
        mainPanelLayout.setVerticalGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(mainPanelLayout.createSequentialGroup().addContainerGap().addComponent(editProfileButton).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(tabbedPane).addContainerGap()));

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(mainPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(mainPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addGap(0, 0, Short.MAX_VALUE)));
    }

    private void usernameTextActionPerformed(ActionEvent evt) {
        // This does nothing.
    }

    private void passwordTextActionPerformed(ActionEvent evt) {
        // This does nothing.
    }

    private void editButtonMouseClicked(MouseEvent ignoredEvt) {
        if (fullNameText.getText().equals("") ||
            locationText.getText().equals("") ||
            phoneText.getText().equals("") ||
            usernameText.getText().equals("") ||
            new String(passwordText.getPassword()).equals("") ||
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

    private void newPasswordTxtActionPerformed(ActionEvent evt) {
        // This does nothing.
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

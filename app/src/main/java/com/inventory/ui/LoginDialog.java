/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.inventory.ui;

import com.inventory.database.ConnectionFactory;
import com.inventory.ui.util.MouseClickedListener;
import com.inventory.ui.util.WindowClosingListener;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseEvent;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;

import static javax.swing.GroupLayout.*;
import static javax.swing.GroupLayout.Alignment.*;
import static javax.swing.LayoutStyle.ComponentPlacement.*;

/**
 * @author ADMIN
 */
public class LoginDialog extends JDialog {

    /**
     * Creates new form LoginDialog
     */
    public LoginDialog() {
        initComponents();
    }

    private void initComponents() {
        comboBox = new JComboBox<>();
        JLabel memberLoginLabel = new JLabel();
        JLabel usernameLabel = new JLabel();
        usernameField = new JTextField();
        JLabel passwordLabel = new JLabel();
        JLabel loginButton = new JLabel();
        JLabel clearButton = new JLabel();
        passwordField = new JPasswordField();
        JLabel loginLabel = new JLabel();
        JLabel clearLabel = new JLabel();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Login");

        comboBox.setModel(new DefaultComboBoxModel<>(new String[]{"ADMINISTRATOR", "NORMAL USER"}));

        memberLoginLabel.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/com/inventory/ui/images" +
            "/loginMember.png"))));

        usernameLabel.setText("Username");

        usernameField.setBorder(new LineBorder(new Color(204, 204, 204), 1, true));
        passwordLabel.setText("Password");

        loginButton.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/com/inventory/ui/images" +
            "/logout-icon.png"))));
        loginButton.addMouseListener((MouseClickedListener) this::loginBttnMouseClicked);
        clearButton.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/com/inventory/ui/images/clear" +
            ".png"))));
        clearButton.addMouseListener((MouseClickedListener) this::clearButtonMouseClicked);

        passwordField.setBorder(new LineBorder(new Color(204, 204, 204), 1, true));
        loginLabel.setText("Login");

        clearLabel.setText("Clear");

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(30, 30, 30)
                    .addGroup(layout.createParallelGroup(TRAILING)
                        .addComponent(comboBox, 0, DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(LEADING)
                                .addComponent(usernameLabel)
                                .addComponent(passwordLabel))
                            .addPreferredGap(RELATED, DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(LEADING, false)
                                .addComponent(usernameField)
                                .addComponent(passwordField, DEFAULT_SIZE, 188, Short.MAX_VALUE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(LEADING)
                                        .addComponent(loginButton)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(17, 17, 17)
                                            .addComponent(loginLabel)))
                                    .addGroup(layout.createParallelGroup(LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(29, 29, 29)
                                            .addComponent(clearButton))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(42, 42, 42)
                                            .addComponent(clearLabel)))))))
                    .addGap(22, 22, 22))
                .addGroup(TRAILING, layout.createSequentialGroup()
                    .addContainerGap(DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(memberLoginLabel)
                    .addGap(80, 80, 80))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(memberLoginLabel, PREFERRED_SIZE, 114, PREFERRED_SIZE)
                    .addPreferredGap(RELATED)
                    .addComponent(comboBox, PREFERRED_SIZE, 54, PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(BASELINE)
                        .addComponent(usernameLabel)
                        .addComponent(usernameField, PREFERRED_SIZE, 29, PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(21, 21, 21)
                            .addComponent(passwordLabel)
                            .addGap(23, 23, 23))
                        .addGroup(TRAILING, layout.createSequentialGroup()
                            .addPreferredGap(RELATED)
                            .addComponent(passwordField, PREFERRED_SIZE, 29, PREFERRED_SIZE)
                            .addGap(18, 18, 18)))
                    .addGap(1, 1, 1)
                    .addGroup(layout.createParallelGroup(TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(clearButton)
                            .addGap(9, 9, 9)
                            .addComponent(clearLabel))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(loginButton)
                            .addGap(1, 1, 1)
                            .addComponent(loginLabel)))
                    .addContainerGap(12, Short.MAX_VALUE))
        );
        pack();
    }

    private String encryptPassword(String input) {
        String encPass = null;
        if (input == null) return null;

        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            digest.update(input.getBytes(), 0, input.length());
            encPass = new BigInteger(1, digest.digest()).toString(16);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return encPass;
    }

    String user;

    private void loginBttnMouseClicked(MouseEvent evt) {
        String username = usernameField.getText();
        String p = new String(passwordField.getPassword());
        String password = encryptPassword(p);
        user = (String) comboBox.getSelectedItem();

        if (new ConnectionFactory().checkLogin(username, password, user)) {
            dispose();
            new Dashboard(user, username);
        } else {
            JOptionPane.showMessageDialog(null, "Invalid username or password");
        }
    }


    private void clearButtonMouseClicked(MouseEvent evt) {
        usernameField.setText("");
        passwordField.setText("");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | UnsupportedLookAndFeelException | IllegalAccessException |
                 InstantiationException ex) {
            Logger.getLogger(LoginDialog.class.getName()).log(Level.SEVERE, null,
                ex);
        }

        /* Create and display the dialog */
        EventQueue.invokeLater(() -> {
            LoginDialog dialog = new LoginDialog();
            dialog.addWindowListener((WindowClosingListener) e -> System.exit(0));
            dialog.setVisible(true);
        });
    }

    private JComboBox<String> comboBox;
    private JPasswordField passwordField;
    private JTextField usernameField;
}

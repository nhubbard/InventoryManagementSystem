/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.inventory.ui;

import com.inventory.dao.UserDAO;
import com.inventory.dto.UserDTO;
import com.inventory.ui.util.MouseClickedListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.sql.SQLException;
import java.util.Objects;

import static javax.swing.GroupLayout.Alignment.*;
import static javax.swing.GroupLayout.DEFAULT_SIZE;
import static javax.swing.GroupLayout.PREFERRED_SIZE;
import static javax.swing.LayoutStyle.ComponentPlacement.RELATED;
import static javax.swing.LayoutStyle.ComponentPlacement.UNRELATED;

/**
 * @author ADMIN
 */
public class Users extends JPanel {
    JFileChooser chooser;
    String username;
    String user;

    public Users() {

        initComponents();

        usernameField.setVisible(false);
        chooser = new JFileChooser();
        loadData();
    }

    private void initComponents() {

        mainPanel = new JPanel();
        JTabbedPane userTabbedPane = new JTabbedPane();
        JScrollPane scrollPane = new JScrollPane();
        table = new JTable();
        JSeparator separator = new JSeparator();
        JLabel usersHeaderLabel = new JLabel();
        JPanel contentPanel = new JPanel();
        JLabel addButton = new JLabel();
        JLabel locationLabel = new JLabel();
        userComboBox = new JComboBox<>();
        JLabel fullNameLabel = new JLabel();
        phoneField = new JTextField();
        locationField = new JTextField();
        fullNameField = new JTextField();
        JLabel phoneLabel = new JLabel();
        JLabel deleteButton = new JLabel();
        JLabel clearButton = new JLabel();
        JLabel addLabel = new JLabel();
        JLabel deleteLabel = new JLabel();
        JLabel clearLabel = new JLabel();
        usernameField = new JTextField();
        JLabel editButton = new JLabel();
        JLabel editLabel = new JLabel();

        mainPanel.addMouseListener((MouseClickedListener) this::mainPanelMouseClicked);

        table.setModel(new DefaultTableModel(
            new Object[][]{
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String[]{
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        table.addMouseListener((MouseClickedListener) this::tableMouseClicked);
        scrollPane.setViewportView(table);

        userTabbedPane.addTab("Users", scrollPane);

        usersHeaderLabel.setFont(new Font("Comfortaa", Font.BOLD, 24));
        usersHeaderLabel.setForeground(new Color(0, 102, 204));
        usersHeaderLabel.setText("USERS");

        contentPanel.setBorder(BorderFactory.createLineBorder(Color.black));

        addButton.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/com/inventory/ui/images" +
            "/addPeople.png"))));
        addButton.addMouseListener((MouseClickedListener) this::addButtonMouseClicked);

        locationLabel.setText("Location");

        userComboBox.setModel(new DefaultComboBoxModel<>(new String[]{"ADMINISTRATOR", "NORMAL USER"}));

        fullNameLabel.setText("Full Name ");

        phoneLabel.setText("Phone");

        deleteButton.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/com/inventory/ui/images" +
            "/deletelarge" +
            ".png"))));
        deleteButton.addMouseListener((MouseClickedListener) this::deleteButtonMouseClicked);

        clearButton.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/com/inventory/ui/images/clear.png"))));
        clearButton.addMouseListener((MouseClickedListener) this::clearButtonMouseClicked);

        addLabel.setText("Add");

        deleteLabel.setText("Delete");

        clearLabel.setText("Clear");

        editButton.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/com/inventory/ui/images/editPeople.png"))));
        editButton.addMouseListener((MouseClickedListener) this::editButtonMouseClicked);

        editLabel.setText("Edit");

        GroupLayout contentLayout = new GroupLayout(contentPanel);
        contentPanel.setLayout(contentLayout);
        contentLayout.setHorizontalGroup(
            contentLayout.createParallelGroup(LEADING)
                .addGroup(contentLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentLayout.createParallelGroup(LEADING)
                        .addGroup(contentLayout.createSequentialGroup()
                            .addComponent(userComboBox, 0, DEFAULT_SIZE, Short.MAX_VALUE)
                            .addContainerGap())
                        .addGroup(contentLayout.createSequentialGroup()
                            .addGroup(contentLayout.createParallelGroup(LEADING)
                                .addComponent(locationLabel)
                                .addComponent(fullNameLabel)
                                .addComponent(phoneLabel))
                            .addGap(22, 22, 22)
                            .addGroup(contentLayout.createParallelGroup(LEADING)
                                .addComponent(locationField)
                                .addGroup(contentLayout.createSequentialGroup()
                                    .addComponent(usernameField, PREFERRED_SIZE, 21, PREFERRED_SIZE)
                                    .addGap(0, 0, Short.MAX_VALUE))
                                .addComponent(phoneField)
                                .addComponent(fullNameField))
                            .addGap(10, 10, 10))
                        .addGroup(contentLayout.createSequentialGroup()
                            .addGroup(contentLayout.createParallelGroup(LEADING)
                                .addComponent(addButton)
                                .addGroup(contentLayout.createSequentialGroup()
                                    .addGap(10, 10, 10)
                                    .addComponent(addLabel)))
                            .addPreferredGap(RELATED, DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(contentLayout.createParallelGroup(LEADING)
                                .addGroup(TRAILING,
                                    contentLayout.createSequentialGroup()
                                    .addComponent(editButton)
                                    .addGap(5, 5, 5))
                                .addGroup(TRAILING,
                                    contentLayout.createSequentialGroup()
                                    .addComponent(editLabel)
                                    .addGap(16, 16, 16)))
                            .addGroup(contentLayout.createParallelGroup(LEADING)
                                .addComponent(deleteButton)
                                .addGroup(contentLayout.createSequentialGroup()
                                    .addGap(10, 10, 10)
                                    .addComponent(deleteLabel)))
                            .addPreferredGap(RELATED)
                            .addGroup(contentLayout.createParallelGroup(LEADING, false)
                                .addGroup(contentLayout.createSequentialGroup()
                                    .addGap(10, 10, 10)
                                    .addComponent(clearLabel, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(clearButton))
                            .addGap(116, 116, 116))))
        );
        contentLayout.setVerticalGroup(
            contentLayout.createParallelGroup(LEADING)
                .addGroup(contentLayout.createSequentialGroup()
                    .addGap(35, 35, 35)
                    .addComponent(userComboBox, PREFERRED_SIZE, 45, PREFERRED_SIZE)
                    .addPreferredGap(RELATED)
                    .addComponent(usernameField, PREFERRED_SIZE, 32, PREFERRED_SIZE)
                    .addPreferredGap(RELATED)
                    .addGroup(contentLayout.createParallelGroup(BASELINE)
                        .addComponent(fullNameField, PREFERRED_SIZE, 32, PREFERRED_SIZE)
                        .addComponent(fullNameLabel))
                    .addPreferredGap(RELATED)
                    .addGroup(contentLayout.createParallelGroup(BASELINE)
                        .addComponent(locationLabel)
                        .addComponent(locationField, PREFERRED_SIZE, 32, PREFERRED_SIZE))
                    .addPreferredGap(RELATED)
                    .addGroup(contentLayout.createParallelGroup(BASELINE)
                        .addComponent(phoneLabel)
                        .addComponent(phoneField, PREFERRED_SIZE, 32, PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentLayout.createParallelGroup(LEADING)
                        .addGroup(contentLayout.createSequentialGroup()
                            .addGroup(contentLayout.createParallelGroup(LEADING)
                                .addComponent(deleteButton)
                                .addComponent(clearButton))
                            .addPreferredGap(RELATED)
                            .addGroup(contentLayout.createParallelGroup(BASELINE)
                                .addComponent(deleteLabel)
                                .addComponent(clearLabel)
                                .addComponent(editLabel))
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(contentLayout.createSequentialGroup()
                            .addGroup(contentLayout.createParallelGroup(LEADING)
                                .addComponent(addButton)
                                .addComponent(editButton))
                            .addPreferredGap(RELATED)
                            .addComponent(addLabel)
                            .addContainerGap(80, Short.MAX_VALUE))))
        );

        GroupLayout mainPanelLayout = new GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(LEADING)
                .addComponent(separator)
                .addGroup(mainPanelLayout.createSequentialGroup()
                    .addComponent(userTabbedPane, PREFERRED_SIZE, 536, PREFERRED_SIZE)
                    .addPreferredGap(UNRELATED)
                    .addComponent(contentPanel, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                    .addContainerGap(247, Short.MAX_VALUE))
                .addGroup(mainPanelLayout.createSequentialGroup()
                    .addComponent(usersHeaderLabel)
                    .addGap(0, 0, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(LEADING)
                .addGroup(mainPanelLayout.createSequentialGroup()
                    .addComponent(usersHeaderLabel)
                    .addGap(7, 7, 7)
                    .addComponent(separator, PREFERRED_SIZE, 10, PREFERRED_SIZE)
                    .addPreferredGap(RELATED)
                    .addGroup(mainPanelLayout.createParallelGroup(LEADING, false)
                        .addComponent(contentPanel, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(userTabbedPane, PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addContainerGap(DEFAULT_SIZE, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(LEADING)
                .addComponent(mainPanel, TRAILING, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(LEADING)
                .addComponent(mainPanel, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
        );
    }

    // TODO: Bcrypt
    public String encryptPassword(String input) {
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

    private void addButtonMouseClicked(MouseEvent ignoredEvt) {
        UserDTO userdto = new UserDTO();
        if (fullNameField.getText().equals("") || locationField.getText().equals("") || phoneField.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Please fill all the fields!");
        } else {
            user = (String) userComboBox.getSelectedItem();
            userdto.setFullName(fullNameField.getText());
            userdto.setLocation(locationField.getText());
            userdto.setPhone(phoneField.getText());
            userdto.setCategory(user);
            new UserDAO().addUserDAO(userdto, user);
            loadData();
        }
    }

    private void tableMouseClicked(MouseEvent ignoredEvt) {
        int row = table.getSelectedRow();
        int column = table.getColumnCount();
        Object[] val = new Object[column];
        for (int i = 0; i < column; i++) val[i] = table.getValueAt(row, i);
        usernameField.setText(val[3].toString());
        fullNameField.setText((String) val[0]);
        locationField.setText((String) val[1]);
        phoneField.setText((String) val[2]);
        user = (String) userComboBox.getSelectedItem();
        userComboBox.setSelectedItem(user);
        username = (String) val[3];
    }

    private void deleteButtonMouseClicked(MouseEvent ignoredEvt) {
        if (table.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(null, "Select a table data first!");
        } else {
            new UserDAO().deleteUserDAO(String.valueOf(table.getValueAt(table.getSelectedRow(), 3)));
            loadData();
        }
    }

    private void clearButtonMouseClicked(MouseEvent ignoredEvt) {
        usernameField.setText("");
        fullNameField.setText("");
        locationField.setText("");
        phoneField.setText("");
    }

    private void mainPanelMouseClicked(MouseEvent ignoredEvt) {
        usernameField.setText("");
        fullNameField.setText("");
        locationField.setText("");
        phoneField.setText("");
    }

    private void editButtonMouseClicked(MouseEvent ignoredEvt) {
        if (table.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(null, "Select a table data first!");
        } else {
            UserDTO userdto = new UserDTO();
            if (fullNameField.getText().equals("") || locationField.getText().equals("") || phoneField.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Please fill all the fields!");
            } else {
                user = (String) userComboBox.getSelectedItem();
                userdto.setFullName(fullNameField.getText());
                userdto.setLocation(locationField.getText());
                userdto.setPhone(phoneField.getText());
                userdto.setUsername(usernameField.getText());
                userdto.setCategory(user);
                new UserDAO().editUserDAO(userdto);
                loadData();
            }
        }
    }

    public void loadData() {
        try {
            UserDAO userDAO = new UserDAO();
            table.setModel(userDAO.buildTableModel(userDAO.getQueryResult1()));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private JTextField fullNameField;
    private JTextField locationField;
    public JPanel mainPanel;
    private JTextField phoneField;
    private JTable table;
    private JComboBox<String> userComboBox;
    private JTextField usernameField;
}

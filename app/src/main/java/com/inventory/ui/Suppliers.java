/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.inventory.ui;

import com.inventory.dao.SupplierDAO;
import com.inventory.dto.SupplierDTO;
import com.inventory.ui.util.KeyReleasedListener;
import com.inventory.ui.util.MouseClickedListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
public class Suppliers extends JPanel {

    /**
     * Creates new form Suppliers
     */
    public Suppliers() {
        initComponents();
        supplierCodeField.setVisible(false);
        loadData();
    }

    private void initComponents() {
        popUpMenu = new JPopupMenu();
        mainPanel = new JPanel();
        JScrollPane scrollPane = new JScrollPane();
        table = new JTable();
        JTabbedPane tabbedPane = new JTabbedPane();
        JPanel inputPanel = new JPanel();
        suppliersNameField = new JTextField();
        phoneField = new JTextField();
        locationField = new JTextField();
        JLabel suppliersNameLabel = new JLabel();
        JLabel locationLabel = new JLabel();
        JLabel phoneLabel = new JLabel();
        JLabel addButton = new JLabel();
        JLabel editButton = new JLabel();
        JLabel deleteButton = new JLabel();
        JLabel clearButton = new JLabel();
        supplierCodeField = new JTextField();
        JLabel addLabel = new JLabel();
        JLabel editLabel = new JLabel();
        JLabel deleteLabel = new JLabel();
        JLabel clearLabel = new JLabel();
        JLabel suppliersHeaderLabel = new JLabel();
        JSeparator separator = new JSeparator();
        searchField = new JTextField();
        JLabel searchByLabel = new JLabel();

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
        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                tableMouseClicked(evt);
            }

            public void mousePressed(MouseEvent evt) {
                tableMousePressed(evt);
            }
        });
        scrollPane.setViewportView(table);

        inputPanel.setBorder(BorderFactory.createLineBorder(Color.black));

        suppliersNameLabel.setText("Supplier's name");

        locationLabel.setText("Location");

        phoneLabel.setText("Phone");

        addButton.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/com/inventory/ui/images" +
            "/addPeople.png"))));
        addButton.addMouseListener((MouseClickedListener) this::addButtonMouseClicked);

        editButton.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/com/inventory/ui/images/editPeople.png"))));
        editButton.addMouseListener((MouseClickedListener) this::editButtonMouseClicked);

        deleteButton.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/com/inventory/ui/images" +
            "/deletelarge" +
            ".png"))));
        deleteButton.addMouseListener((MouseClickedListener) this::deleteButtonMouseClicked);

        clearButton.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/com/inventory/ui/images/clear.png"))));
        clearButton.addMouseListener((MouseClickedListener) this::clearButtonMouseClicked);

        addLabel.setText("Add");

        editLabel.setText("Edit");

        deleteLabel.setText("Delete");

        clearLabel.setText("Clear");

        GroupLayout inputPanelLayout = new GroupLayout(inputPanel);
        inputPanel.setLayout(inputPanelLayout);
        inputPanelLayout.setHorizontalGroup(
            inputPanelLayout.createParallelGroup(LEADING)
                .addGroup(TRAILING, inputPanelLayout.createSequentialGroup()
                    .addContainerGap(22, Short.MAX_VALUE)
                    .addGroup(inputPanelLayout.createParallelGroup(LEADING)
                        .addGroup(inputPanelLayout.createSequentialGroup()
                            .addGroup(inputPanelLayout.createParallelGroup(LEADING)
                                .addComponent(addButton)
                                .addGroup(inputPanelLayout.createSequentialGroup()
                                    .addGap(10, 10, 10)
                                    .addComponent(addLabel)))
                            .addPreferredGap(RELATED)
                            .addGroup(inputPanelLayout.createParallelGroup(LEADING, false)
                                .addGroup(inputPanelLayout.createSequentialGroup()
                                    .addGap(10, 10, 10)
                                    .addComponent(editLabel, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(editButton))
                            .addPreferredGap(RELATED)
                            .addGroup(inputPanelLayout.createParallelGroup(LEADING)
                                .addGroup(inputPanelLayout.createSequentialGroup()
                                    .addComponent(deleteButton)
                                    .addPreferredGap(RELATED)
                                    .addComponent(clearButton))
                                .addGroup(inputPanelLayout.createSequentialGroup()
                                    .addComponent(deleteLabel, PREFERRED_SIZE, 62, PREFERRED_SIZE)
                                    .addPreferredGap(RELATED)
                                    .addComponent(clearLabel, PREFERRED_SIZE, 50, PREFERRED_SIZE))))
                        .addGroup(inputPanelLayout.createParallelGroup(TRAILING)
                            .addComponent(supplierCodeField, PREFERRED_SIZE, 11, PREFERRED_SIZE)
                            .addGroup(inputPanelLayout.createSequentialGroup()
                                .addGroup(inputPanelLayout.createParallelGroup(LEADING)
                                    .addComponent(suppliersNameLabel)
                                    .addComponent(locationLabel)
                                    .addComponent(phoneLabel))
                                .addPreferredGap(UNRELATED)
                                .addGroup(inputPanelLayout.createParallelGroup(LEADING, false)
                                    .addComponent(locationField, DEFAULT_SIZE, 193, Short.MAX_VALUE)
                                    .addComponent(suppliersNameField)
                                    .addComponent(phoneField)))))
                    .addContainerGap(26, Short.MAX_VALUE))
        );
        inputPanelLayout.setVerticalGroup(
            inputPanelLayout.createParallelGroup(LEADING)
                .addGroup(inputPanelLayout.createSequentialGroup()
                    .addGap(34, 34, 34)
                    .addGroup(inputPanelLayout.createParallelGroup(BASELINE)
                        .addComponent(suppliersNameLabel)
                        .addComponent(suppliersNameField, PREFERRED_SIZE, 32, PREFERRED_SIZE))
                    .addPreferredGap(RELATED)
                    .addGroup(inputPanelLayout.createParallelGroup(BASELINE)
                        .addComponent(locationLabel)
                        .addComponent(locationField, PREFERRED_SIZE, 32, PREFERRED_SIZE))
                    .addPreferredGap(RELATED)
                    .addGroup(inputPanelLayout.createParallelGroup(BASELINE)
                        .addComponent(phoneField, PREFERRED_SIZE, 32, PREFERRED_SIZE)
                        .addComponent(phoneLabel))
                    .addPreferredGap(UNRELATED)
                    .addComponent(supplierCodeField, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addGroup(inputPanelLayout.createParallelGroup(LEADING)
                        .addGroup(inputPanelLayout.createSequentialGroup()
                            .addGroup(inputPanelLayout.createParallelGroup(LEADING)
                                .addComponent(addButton)
                                .addComponent(editButton)
                                .addComponent(deleteButton))
                            .addPreferredGap(RELATED)
                            .addGroup(inputPanelLayout.createParallelGroup(LEADING)
                                .addComponent(addLabel)
                                .addGroup(inputPanelLayout.createParallelGroup(BASELINE)
                                    .addComponent(editLabel)
                                    .addComponent(deleteLabel)
                                    .addComponent(clearLabel))))
                        .addComponent(clearButton))
                    .addContainerGap(32, Short.MAX_VALUE))
        );

        tabbedPane.addTab("SUPPLIERS", inputPanel);

        suppliersHeaderLabel.setFont(new Font("Comfortaa", Font.BOLD, 24));
        suppliersHeaderLabel.setForeground(new Color(0, 102, 204));
        suppliersHeaderLabel.setText("SUPPLIERS");

        searchField.setToolTipText("Search using Full Name Location, Phone OR Supplier Code");
        searchField.addKeyListener((KeyReleasedListener) this::searchTxtKeyReleased);

        searchByLabel.setText("SEARCH");

        GroupLayout mainPanelLayout = new GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(LEADING)
                .addGroup(mainPanelLayout.createSequentialGroup()
                    .addComponent(scrollPane, PREFERRED_SIZE, 559, PREFERRED_SIZE)
                    .addPreferredGap(RELATED)
                    .addComponent(tabbedPane, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE))
                .addGroup(TRAILING, mainPanelLayout.createSequentialGroup()
                    .addGroup(mainPanelLayout.createParallelGroup(TRAILING)
                        .addComponent(separator, LEADING)
                        .addGroup(mainPanelLayout.createSequentialGroup()
                            .addComponent(suppliersHeaderLabel)
                            .addPreferredGap(RELATED, DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(searchByLabel)
                            .addGap(18, 18, 18)
                            .addComponent(searchField, PREFERRED_SIZE, 270, PREFERRED_SIZE)))
                    .addGap(21, 21, 21))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(LEADING)
                .addGroup(mainPanelLayout.createSequentialGroup()
                    .addGroup(mainPanelLayout.createParallelGroup(LEADING)
                        .addGroup(mainPanelLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(suppliersHeaderLabel))
                        .addGroup(mainPanelLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(mainPanelLayout.createParallelGroup(BASELINE)
                                .addComponent(searchByLabel, PREFERRED_SIZE, 34, PREFERRED_SIZE)
                                .addComponent(searchField, PREFERRED_SIZE, 30, PREFERRED_SIZE))))
                    .addPreferredGap(RELATED)
                    .addComponent(separator, PREFERRED_SIZE, 10, PREFERRED_SIZE)
                    .addPreferredGap(RELATED)
                    .addGroup(mainPanelLayout.createParallelGroup(LEADING, false)
                        .addComponent(tabbedPane)
                        .addComponent(scrollPane, PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addContainerGap(110, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(mainPanel, PREFERRED_SIZE, 940, Short.MAX_VALUE)
                    .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(mainPanel, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                    .addGap(0, 50, Short.MAX_VALUE))
        );
    }

    private void mainPanelMouseClicked(MouseEvent ignoredEvt) {
        supplierCodeField.setText("");
        suppliersNameField.setText("");
        locationField.setText("");
        phoneField.setText("");
    }

    private void searchTxtKeyReleased(KeyEvent evt) {
        String text = searchField.getText();
        loadSearchSuppliersData(text);
        table.getColumn("sid").setMaxWidth(0);
    }

    private void tableMousePressed(MouseEvent evt) {
        if (evt.isPopupTrigger()) {
            popUpMenu.show(this, evt.getX(), evt.getY());
        }
    }

    private void tableMouseClicked(MouseEvent ignoredEvt) {
        int row = table.getSelectedRow();
        int column = table.getColumnCount();
        Object[] val = new Object[column];
        for (int i = 0; i < column; i++) {
            val[i] = table.getValueAt(row, i);
        }
        supplierCodeField.setText(val[0].toString());
        suppliersNameField.setText((String) val[1]);
        locationField.setText((String) val[2]);
        phoneField.setText((String) val[3]);
    }

    private void editButtonMouseClicked(MouseEvent ignoredEvt) {
        if (table.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(null, "Select a table data first!");
        } else {
            if (suppliersNameField.getText().equals("") || locationField.getText().equals("") || phoneField.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Please fill all the fields!");
            } else {
                SupplierDTO supplierdto = new SupplierDTO();
                supplierdto.setSupplierCode(supplierCodeField.getText());
                supplierdto.setFullName(suppliersNameField.getText());
                supplierdto.setLocation(locationField.getText());
                supplierdto.setPhone(phoneField.getText());
                new SupplierDAO().editSupplierDAO(supplierdto);
                loadData();
            }
        }
    }

    private void deleteButtonMouseClicked(MouseEvent ignoredEvt) {
        if (table.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(null, "Select a table data first!");
        } else {
            new SupplierDAO().deleteSupplierDAO(table.getValueAt(table.getSelectedRow(), 0).toString());
            loadData();
        }
    }

    private void addButtonMouseClicked(MouseEvent evt) {

        if (suppliersNameField.getText().equals("") || locationField.getText().equals("") || phoneField.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Please fill all the fields!");
        } else {

            SupplierDTO supplierdto = new SupplierDTO();
            supplierdto.setFullName(suppliersNameField.getText());
            supplierdto.setLocation(locationField.getText());
            supplierdto.setPhone(phoneField.getText());
            new SupplierDAO().addSupplierDAO(supplierdto);
            loadData();
        }
    }

    private void clearButtonMouseClicked(MouseEvent ignoredEvt) {
        supplierCodeField.setText("");
        suppliersNameField.setText("");
        locationField.setText("");
        phoneField.setText("");
    }

    public void loadData() {
        try {
            SupplierDAO supplierDAO = new SupplierDAO();
            table.setModel(supplierDAO.buildTableModel(supplierDAO.getQueryResult()));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void loadSearchSuppliersData(String text) {
        try {
            SupplierDAO supplierDAO = new SupplierDAO();
            table.setModel(supplierDAO.buildTableModel(supplierDAO.getSearchSuppliersQueryResult(text)));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private JTextField locationField;
    public JPanel mainPanel;
    private JTextField phoneField;
    private JPopupMenu popUpMenu;
    private JTextField searchField;
    private JTextField supplierCodeField;
    private JTextField suppliersNameField;
    private JTable table;
}

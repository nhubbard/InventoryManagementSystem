/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.inventory.ui;

import com.inventory.dao.ProductDAO;
import com.inventory.dto.ProductDTO;
import com.inventory.ui.util.KeyReleasedListener;
import com.inventory.ui.util.MouseClickedListener;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.Objects;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import static javax.swing.GroupLayout.*;
import static javax.swing.GroupLayout.Alignment.*;
import static javax.swing.LayoutStyle.ComponentPlacement.*;

/**
 * @author ADMIN
 */
public class Products extends JPanel {
    ProductDTO productdto;
    String username;
    int userId;

    public Products(String user) {
        initComponents();
        username = user;
        productCodeField.setVisible(false);
        loadData();
    }

    private void initComponents() {
        productsPanel = new JPanel();
        JScrollPane scrollPane = new JScrollPane();
        table = new JTable();
        JTabbedPane tabbedPane = new JTabbedPane();
        JPanel actionPanel = new JPanel();
        JLabel productNameLabel = new JLabel();
        productNameField = new JTextField();
        JLabel costPriceLabel = new JLabel();
        costPriceField = new JTextField();
        sellingPriceField = new JTextField();
        JLabel sellingPriceLabel = new JLabel();
        JLabel brandLabel = new JLabel();
        brandField = new JTextField();
        JLabel addProductLabel = new JLabel();
        JLabel editButton = new JLabel();
        JLabel deleteButton = new JLabel();
        JLabel clearButton = new JLabel();
        JLabel addLabel = new JLabel();
        JLabel editLabel = new JLabel();
        JLabel deleteLabel = new JLabel();
        JLabel clearLabel = new JLabel();
        productCodeField = new JTextField();
        JLabel productsLabel = new JLabel();
        JSeparator separator = new JSeparator();
        searchField = new JTextField();
        JLabel searchByLabel = new JLabel();
        JButton refreshButton = new JButton();

        productsPanel.addMouseListener((MouseClickedListener) this::productsPanelMouseClicked);

        table.setModel(new DefaultTableModel(
            new Object[][]{
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

        actionPanel.setBorder(BorderFactory.createLineBorder(Color.black));

        productNameLabel.setText("Product Name");

        costPriceLabel.setText("Cost Price");

        sellingPriceLabel.setText("Selling Price");

        brandLabel.setText("Brand");

        addProductLabel.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/com/inventory/ui/images/add " +
            "item.png"))));
        addProductLabel.addMouseListener((MouseClickedListener) this::addProductMouseClicked);

        editButton.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/com/inventory/ui/images/edit " +
            "item.png"))));
        editButton.addMouseListener((MouseClickedListener) this::editButtonMouseClicked);

        deleteButton.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/com/inventory/ui/images" +
            "/delete item" +
            ".png"))));
        deleteButton.addMouseListener((MouseClickedListener) this::deleteButtonMouseClicked);

        clearButton.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/com/inventory/ui/images/clear" +
            ".png"))));
        clearButton.addMouseListener((MouseClickedListener) this::clearButtonMouseClicked);

        addLabel.setText("Add");

        editLabel.setText("Edit");

        deleteLabel.setText("Delete");

        clearLabel.setText("Clear");

        GroupLayout actionPanelLayout = new GroupLayout(actionPanel);
        actionPanel.setLayout(actionPanelLayout);
        actionPanelLayout.setHorizontalGroup(
            actionPanelLayout.createParallelGroup(LEADING)
                .addGroup(actionPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(actionPanelLayout.createParallelGroup(TRAILING, false)
                        .addGroup(LEADING, actionPanelLayout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(addLabel)
                            .addGap(42, 42, 42)
                            .addComponent(editLabel)
                            .addGap(30, 30, 30)
                            .addComponent(deleteLabel)
                            .addGap(28, 28, 28)
                            .addComponent(clearLabel))
                        .addGroup(LEADING, actionPanelLayout.createSequentialGroup()
                            .addComponent(addProductLabel)
                            .addGap(18, 18, 18)
                            .addComponent(editButton)
                            .addGap(21, 21, 21)
                            .addComponent(deleteButton)
                            .addGap(18, 18, 18)
                            .addComponent(clearButton)
                            .addGap(18, 18, 18)
                            .addComponent(productCodeField, PREFERRED_SIZE, 13, PREFERRED_SIZE))
                        .addGroup(actionPanelLayout.createSequentialGroup()
                            .addGroup(actionPanelLayout.createParallelGroup(LEADING)
                                .addComponent(brandLabel, PREFERRED_SIZE, 47, PREFERRED_SIZE)
                                .addComponent(productNameLabel)
                                .addGroup(actionPanelLayout.createParallelGroup(TRAILING, false)
                                    .addComponent(costPriceLabel, LEADING, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(sellingPriceLabel, LEADING, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addPreferredGap(RELATED)
                            .addGroup(actionPanelLayout.createParallelGroup(TRAILING)
                                .addComponent(costPriceField, PREFERRED_SIZE, 194, PREFERRED_SIZE)
                                .addComponent(sellingPriceField, PREFERRED_SIZE, 194, PREFERRED_SIZE)
                                .addComponent(brandField, PREFERRED_SIZE, 194, PREFERRED_SIZE)
                                .addComponent(productNameField, PREFERRED_SIZE, 194, PREFERRED_SIZE))))
                    .addContainerGap(DEFAULT_SIZE, Short.MAX_VALUE))
        );
        actionPanelLayout.setVerticalGroup(
            actionPanelLayout.createParallelGroup(LEADING)
                .addGroup(actionPanelLayout.createSequentialGroup()
                    .addGap(37, 37, 37)
                    .addGroup(actionPanelLayout.createParallelGroup(BASELINE)
                        .addComponent(productNameLabel)
                        .addComponent(productNameField, PREFERRED_SIZE, 28, PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(actionPanelLayout.createParallelGroup(BASELINE)
                        .addComponent(costPriceLabel)
                        .addComponent(costPriceField, PREFERRED_SIZE, 30, PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(actionPanelLayout.createParallelGroup(BASELINE)
                        .addComponent(sellingPriceLabel)
                        .addComponent(sellingPriceField, PREFERRED_SIZE, 30, PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(actionPanelLayout.createParallelGroup(BASELINE)
                        .addComponent(brandLabel)
                        .addComponent(brandField, PREFERRED_SIZE, 31, PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(actionPanelLayout.createParallelGroup(LEADING)
                        .addComponent(addProductLabel)
                        .addComponent(deleteButton)
                        .addComponent(clearButton)
                        .addComponent(editButton)
                        .addComponent(productCodeField, PREFERRED_SIZE, 28, PREFERRED_SIZE))
                    .addPreferredGap(RELATED)
                    .addGroup(actionPanelLayout.createParallelGroup(LEADING)
                        .addGroup(actionPanelLayout.createParallelGroup(BASELINE)
                            .addComponent(deleteLabel)
                            .addComponent(clearLabel)
                            .addComponent(editLabel))
                        .addComponent(addLabel))
                    .addContainerGap(43, Short.MAX_VALUE))
        );

        tabbedPane.addTab("PRODUCTS", actionPanel);

        productsLabel.setFont(new Font("Comfortaa", Font.BOLD, 24));
        productsLabel.setForeground(new Color(0, 102, 204));
        productsLabel.setText("PRODUCTS");

        searchField.setToolTipText("Search using Product Name, Brand Name OR Product Code");
        searchField.addKeyListener((KeyReleasedListener) this::searchFieldKeyReleased);

        searchByLabel.setFont(new Font("Ubuntu", Font.PLAIN, 14));
        searchByLabel.setText("SEARCH");

        refreshButton.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/com/inventory/ui/images" +
            "/reload.png"))));
        refreshButton.setText("Refresh");
        refreshButton.addActionListener(this::refreshButtonActionPerformed);

        GroupLayout productsPanelLayout = new GroupLayout(productsPanel);
        productsPanel.setLayout(productsPanelLayout);
        productsPanelLayout.setHorizontalGroup(
            productsPanelLayout.createParallelGroup(LEADING)
                .addGroup(productsPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(scrollPane, PREFERRED_SIZE, 557, PREFERRED_SIZE)
                    .addPreferredGap(UNRELATED)
                    .addComponent(tabbedPane, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                    .addContainerGap(50, Short.MAX_VALUE))
                .addGroup(productsPanelLayout.createSequentialGroup()
                    .addGroup(productsPanelLayout.createParallelGroup(TRAILING, false)
                        .addComponent(separator, LEADING)
                        .addGroup(LEADING, productsPanelLayout.createSequentialGroup()
                            .addComponent(refreshButton)
                            .addPreferredGap(RELATED)
                            .addComponent(productsLabel)
                            .addGap(330, 330, 330)
                            .addComponent(searchByLabel)
                            .addPreferredGap(RELATED)
                            .addComponent(searchField, PREFERRED_SIZE, 270, PREFERRED_SIZE)))
                    .addGap(0, 0, Short.MAX_VALUE))
        );
        productsPanelLayout.setVerticalGroup(
            productsPanelLayout.createParallelGroup(LEADING)
                .addGroup(productsPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(productsPanelLayout.createParallelGroup(TRAILING)
                        .addComponent(refreshButton)
                        .addGroup(productsPanelLayout.createParallelGroup(BASELINE)
                            .addComponent(productsLabel)
                            .addComponent(searchByLabel, PREFERRED_SIZE, 34, PREFERRED_SIZE)
                            .addComponent(searchField, PREFERRED_SIZE, 30, PREFERRED_SIZE)))
                    .addPreferredGap(RELATED)
                    .addComponent(separator, PREFERRED_SIZE, 10, PREFERRED_SIZE)
                    .addPreferredGap(RELATED)
                    .addGroup(productsPanelLayout.createParallelGroup(LEADING, false)
                        .addComponent(scrollPane, PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(tabbedPane))
                    .addContainerGap(34, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(productsPanel, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                    .addGap(0, 75, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(LEADING)
                .addComponent(productsPanel, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
        );
    }

    static String productCode;

    private void tableMouseClicked(MouseEvent evt) {
        int row = table.getSelectedRow();
        int column = table.getColumnCount();
        Object[] val = new Object[column];
        for (int i = 0; i < column; i++) val[i] = table.getValueAt(row, i);
        productCodeField.setText(val[0].toString());
        productNameField.setText(val[1].toString());
        costPriceField.setText(val[2].toString());
        sellingPriceField.setText(val[3].toString());
        brandField.setText(val[4].toString());
        productCode = val[1].toString();
    }

    private void searchFieldKeyReleased(KeyEvent ignoredEvt) {
        String text = searchField.getText();
        loadSearchProductsData(text);
    }

    private void productsPanelMouseClicked(MouseEvent evt) {
        productCodeField.setText("");
        productNameField.setText("");
        costPriceField.setText("");
        sellingPriceField.setText("");
        brandField.setText("");
    }

    private void refreshButtonActionPerformed(ActionEvent evt) {
        productCodeField.setText("");
        productNameField.setText("");
        costPriceField.setText("");
        sellingPriceField.setText("");
        brandField.setText("");
    }

    private void clearButtonMouseClicked(MouseEvent evt) {
        productCodeField.setText("");
        productNameField.setText("");
        costPriceField.setText("");
        sellingPriceField.setText("");
        brandField.setText("");
    }

    private void deleteButtonMouseClicked(MouseEvent evt) {
        if (table.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(null, "Select a table data first!");
        } else {
            new ProductDAO().deleteProductDAO(((String) table.getValueAt(table.getSelectedRow(), 0)));
            loadData();
        }
    }

    private void editButtonMouseClicked(MouseEvent evt) {
        if (table.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(null, "Select a table data first!");
        } else {
            productdto = new ProductDTO();
            if (productNameField.getText().equals("") ||
                costPriceField.getText().equals("") ||
                sellingPriceField.getText().equals("") ||
                brandField.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Please fill all the fields!");
            } else {
                productdto.setProductCode(productCodeField.getText());
                productdto.setProductName(productNameField.getText());
                productdto.setCostPrice(Double.parseDouble(costPriceField.getText()));
                productdto.setSellingPrice(Double.parseDouble(sellingPriceField.getText()));
                productdto.setBrand((brandField.getText()));
                productdto.setUserId(userId);
                new ProductDAO().editProductDAO(productdto);
            }
            loadData();
        }
    }

    private void addProductMouseClicked(MouseEvent evt) {
        productdto = new ProductDTO();
        if (productNameField.getText().equals("") ||
            costPriceField.getText().equals("") ||
            sellingPriceField.getText().equals("") ||
            brandField.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Please fill all the fields!");
        } else {
            productdto.setProductName(productNameField.getText());
            productdto.setCostPrice(Double.parseDouble(costPriceField.getText()));
            productdto.setSellingPrice(Double.parseDouble(sellingPriceField.getText()));
            productdto.setBrand((brandField.getText()));
            productdto.setUserId(userId);
            new ProductDAO().addProductDAO(productdto);
            loadData();
        }
    }

    public void loadData() {
        try {
            ProductDAO productDAO = new ProductDAO();
            table.setModel(productDAO.buildTableModel(productDAO.getQueryResult()));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void loadSearchProductsData(String text) {
        try {
            ProductDAO productDAO = new ProductDAO();
            table.setModel(productDAO.buildTableModel(productDAO.getSearchProductsQueryResult(text)));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private JTextField brandField;
    private JTextField costPriceField;
    private JTextField productCodeField;
    private JTextField productNameField;
    public JPanel productsPanel;
    private JTextField searchField;
    private JTextField sellingPriceField;
    private JTable table;
}

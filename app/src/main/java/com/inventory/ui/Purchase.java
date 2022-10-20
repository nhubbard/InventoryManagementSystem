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
import com.toedter.calendar.JDateChooser;

import static com.inventory.ui.Products.productCode;
import static javax.swing.GroupLayout.*;
import static javax.swing.GroupLayout.Alignment.*;
import static javax.swing.LayoutStyle.ComponentPlacement.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 * @author dell pc
 */
public class Purchase extends JPanel {
    ProductDTO productdto;

    /**
     * Creates new form Purchase
     */
    public Purchase() {
        initComponents();
        comboBox.removeAllItems();
        comboBox.addItem("Select Supplier's Name");
        suppliersName();
        purchaseIdField.setVisible(false);
        productNameLabel.setVisible(false);
        loadData();
    }

    private void initComponents() {
        productsPanel = new JPanel();
        JScrollPane scrollPane = new JScrollPane();
        table = new JTable();
        JTabbedPane tabbedPane = new JTabbedPane();
        JPanel optionsPanel = new JPanel();
        comboBox = new JComboBox<>();
        JLabel addProductLabel = new JLabel();
        JLabel deleteIconLabel = new JLabel();
        JLabel clearIconLabel = new JLabel();
        JLabel purchaseLabel = new JLabel();
        JLabel deleteLabel = new JLabel();
        JLabel clearLabel = new JLabel();
        purchaseIdField = new JTextField();
        JLabel dateLabel = new JLabel();
        productCodeField = new JTextField();
        JLabel productCodeLabelOne = new JLabel();
        quantityField = new JTextField();
        JLabel quantityLabel = new JLabel();
        productNameLabel = new JLabel();
        JLabel productCodeLabelTwo = new JLabel();
        costPriceField = new JTextField();
        dateChooser = new JDateChooser();
        JLabel purchaseHeaderLabel = new JLabel();
        JSeparator separatorOne = new JSeparator();
        searchField = new JTextField();
        JLabel searchByLabel = new JLabel();
        JPanel supplierInfoPanel = new JPanel();
        JLabel supplierInfoLabel = new JLabel();
        supplierInfoLab = new JLabel();
        JLabel purchaseDateLabel = new JLabel();
        purchasedDateLabel = new JLabel();
        JButton refreshButton = new JButton();
        JPanel separatorPanel = new JPanel();
        JSeparator separatorTwo = new JSeparator();

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

        optionsPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        optionsPanel.setFont(new Font("Comfortaa", Font.PLAIN, 12));

        comboBox.setModel(new DefaultComboBoxModel<>(new String[]{"Select Supplier's Name"}));

        addProductLabel.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/com/inventory/ui/images/add " +
            "item.png"))));
        addProductLabel.addMouseListener((MouseClickedListener) this::addProductMouseClicked);

        deleteIconLabel.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/com/inventory/ui/images" +
            "/delete item" +
            ".png"))));
        deleteIconLabel.addMouseListener((MouseClickedListener) this::deleteButtonMouseClicked);

        clearIconLabel.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/com/inventory/ui/images/clear" +
            ".png"))));
        clearIconLabel.addMouseListener((MouseClickedListener) this::clearButtonMouseClicked);

        purchaseLabel.setText("Purchase");

        deleteLabel.setText("Delete");

        clearLabel.setText("Clear");

        dateLabel.setText("Date");

        productCodeField.addKeyListener((KeyReleasedListener) this::productCodeFieldKeyReleased);

        productCodeLabelOne.setText("Product Code");

        quantityLabel.setText("Quantity");

        productNameLabel.setBackground(new Color(204, 204, 255));
        productNameLabel.setFont(new Font("Comfortaa", Font.PLAIN, 14));
        productNameLabel.setForeground(new Color(102, 102, 255));

        productCodeLabelTwo.setText("Cost Price");

        GroupLayout jPanel1Layout = new GroupLayout(optionsPanel);
        optionsPanel.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(LEADING)
                                .addComponent(purchaseLabel)
                                .addComponent(addProductLabel))
                            .addPreferredGap(RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(LEADING)
                                .addComponent(deleteIconLabel)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(10, 10, 10)
                                    .addComponent(deleteLabel)))
                            .addPreferredGap(UNRELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(LEADING)
                                .addComponent(clearIconLabel)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(10, 10, 10)
                                    .addComponent(clearLabel)))
                            .addPreferredGap(RELATED, 138, Short.MAX_VALUE)
                            .addComponent(purchaseIdField, PREFERRED_SIZE, 13, PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(LEADING)
                                .addGroup(jPanel1Layout.createParallelGroup(LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(LEADING)
                                            .addComponent(productCodeLabelOne)
                                            .addComponent(quantityLabel))
                                        .addPreferredGap(RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(LEADING)
                                            .addComponent(productCodeField)
                                            .addComponent(quantityField)
                                            .addComponent(costPriceField, TRAILING)))
                                    .addComponent(comboBox, 0, 301, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(dateLabel)
                                        .addPreferredGap(RELATED, DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(dateChooser, PREFERRED_SIZE, 230, PREFERRED_SIZE))
                                    .addComponent(productNameLabel, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(productCodeLabelTwo))
                            .addGap(0, 0, Short.MAX_VALUE)))
                    .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(LEADING)
                .addGroup(TRAILING, jPanel1Layout.createSequentialGroup()
                    .addGroup(jPanel1Layout.createParallelGroup(LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(23, 23, 23)
                            .addComponent(dateLabel))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(17, 17, 17)
                            .addComponent(dateChooser, PREFERRED_SIZE, 25, PREFERRED_SIZE)))
                    .addGap(18, 18, 18)
                    .addComponent(comboBox, PREFERRED_SIZE, 36, PREFERRED_SIZE)
                    .addGap(20, 20, 20)
                    .addGroup(jPanel1Layout.createParallelGroup(BASELINE)
                        .addComponent(productCodeField, PREFERRED_SIZE, 34, PREFERRED_SIZE)
                        .addComponent(productCodeLabelOne))
                    .addGap(4, 4, 4)
                    .addComponent(productNameLabel, PREFERRED_SIZE, 19, PREFERRED_SIZE)
                    .addPreferredGap(RELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(BASELINE)
                        .addComponent(costPriceField, PREFERRED_SIZE, 34, PREFERRED_SIZE)
                        .addComponent(productCodeLabelTwo))
                    .addPreferredGap(UNRELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(BASELINE)
                        .addComponent(quantityField, PREFERRED_SIZE, 34, PREFERRED_SIZE)
                        .addComponent(quantityLabel))
                    .addPreferredGap(UNRELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(TRAILING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(purchaseIdField, PREFERRED_SIZE, 28, PREFERRED_SIZE)
                                    .addGap(26, 26, 26))
                                .addGroup(LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(addProductLabel)
                                    .addPreferredGap(RELATED, DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(purchaseLabel))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(LEADING)
                                .addComponent(deleteIconLabel)
                                .addComponent(clearIconLabel))
                            .addPreferredGap(RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(BASELINE)
                                .addComponent(deleteLabel)
                                .addComponent(clearLabel))))
                    .addContainerGap(97, Short.MAX_VALUE))
        );

        tabbedPane.addTab("PRODUCTS", optionsPanel);

        purchaseHeaderLabel.setFont(new Font("Comfortaa", Font.BOLD, 24));
        purchaseHeaderLabel.setForeground(new Color(0, 102, 204));
        purchaseHeaderLabel.setText("PURCHASE");

        searchField.setToolTipText("Search using Product Name, Brand Name OR Product Code");
        searchField.addKeyListener((KeyReleasedListener) this::searchFieldKeyReleased);

        searchByLabel.setText("SEARCH");

        supplierInfoPanel.setBackground(new Color(255, 255, 204));

        supplierInfoLabel.setForeground(new Color(0, 0, 51));
        supplierInfoLabel.setText("Supplier Info: ");

        supplierInfoLab.setForeground(new Color(0, 0, 51));
        supplierInfoLab.setText("         ");

        purchaseDateLabel.setForeground(new Color(0, 0, 51));
        purchaseDateLabel.setText("Purchased Date:");

        purchasedDateLabel.setForeground(new Color(0, 51, 51));
        purchasedDateLabel.setText("                ");

        GroupLayout supplierInfoPanelLayout = new GroupLayout(supplierInfoPanel);
        supplierInfoPanel.setLayout(supplierInfoPanelLayout);
        supplierInfoPanelLayout.setHorizontalGroup(
            supplierInfoPanelLayout.createParallelGroup(LEADING)
                .addGroup(supplierInfoPanelLayout.createSequentialGroup()
                    .addGap(19, 19, 19)
                    .addGroup(supplierInfoPanelLayout.createParallelGroup(LEADING)
                        .addGroup(supplierInfoPanelLayout.createSequentialGroup()
                            .addComponent(purchaseDateLabel)
                            .addPreferredGap(UNRELATED)
                            .addComponent(purchasedDateLabel))
                        .addGroup(supplierInfoPanelLayout.createSequentialGroup()
                            .addComponent(supplierInfoLabel)
                            .addPreferredGap(RELATED)
                            .addComponent(supplierInfoLab, PREFERRED_SIZE, 291, PREFERRED_SIZE)))
                    .addContainerGap(DEFAULT_SIZE, Short.MAX_VALUE))
        );
        supplierInfoPanelLayout.setVerticalGroup(
            supplierInfoPanelLayout.createParallelGroup(LEADING)
                .addGroup(TRAILING, supplierInfoPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(purchasedDateLabel)
                    .addContainerGap(DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(TRAILING, supplierInfoPanelLayout.createSequentialGroup()
                    .addContainerGap(DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(purchaseDateLabel)
                    .addPreferredGap(RELATED)
                    .addGroup(supplierInfoPanelLayout.createParallelGroup(BASELINE)
                        .addComponent(supplierInfoLabel)
                        .addComponent(supplierInfoLab))
                    .addContainerGap())
        );

        refreshButton.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/com/inventory/ui/images" +
            "/reload.png"))));
        refreshButton.setText("Refresh");
        refreshButton.addActionListener(this::refreshButtonActionPerformed);

        GroupLayout separatorPanelLayout = new GroupLayout(separatorPanel);
        separatorPanel.setLayout(separatorPanelLayout);
        separatorPanelLayout.setHorizontalGroup(
            separatorPanelLayout.createParallelGroup(LEADING)
                .addGap(0, 0, Short.MAX_VALUE)
        );
        separatorPanelLayout.setVerticalGroup(
            separatorPanelLayout.createParallelGroup(LEADING)
                .addGap(0, 21, Short.MAX_VALUE)
        );

        GroupLayout productsPanelLayout = new GroupLayout(productsPanel);
        productsPanel.setLayout(productsPanelLayout);
        productsPanelLayout.setHorizontalGroup(
            productsPanelLayout.createParallelGroup(LEADING)
                .addGroup(productsPanelLayout.createSequentialGroup()
                    .addGroup(productsPanelLayout.createParallelGroup(TRAILING, false)
                        .addGroup(productsPanelLayout.createSequentialGroup()
                            .addComponent(refreshButton)
                            .addPreferredGap(RELATED)
                            .addComponent(purchaseHeaderLabel)
                            .addPreferredGap(RELATED, DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(searchByLabel)
                            .addPreferredGap(RELATED)
                            .addComponent(searchField, PREFERRED_SIZE, 270, PREFERRED_SIZE)
                            .addGap(41, 41, 41))
                        .addGroup(productsPanelLayout.createSequentialGroup()
                            .addGroup(productsPanelLayout.createParallelGroup(LEADING, false)
                                .addComponent(supplierInfoPanel, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(scrollPane, PREFERRED_SIZE, 557, PREFERRED_SIZE))
                            .addPreferredGap(RELATED)
                            .addComponent(tabbedPane, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE))
                        .addComponent(separatorTwo, LEADING))
                    .addPreferredGap(RELATED, 51, Short.MAX_VALUE)
                    .addGroup(productsPanelLayout.createParallelGroup(LEADING)
                        .addComponent(separatorOne)
                        .addGroup(productsPanelLayout.createSequentialGroup()
                            .addComponent(separatorPanel, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE)
                            .addContainerGap())))
        );
        productsPanelLayout.setVerticalGroup(
            productsPanelLayout.createParallelGroup(LEADING)
                .addGroup(productsPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(productsPanelLayout.createParallelGroup(LEADING, false)
                        .addComponent(refreshButton, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(productsPanelLayout.createParallelGroup(BASELINE)
                            .addComponent(purchaseHeaderLabel, PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(searchByLabel, PREFERRED_SIZE, 34, PREFERRED_SIZE)
                            .addComponent(searchField, PREFERRED_SIZE, 30, PREFERRED_SIZE)))
                    .addPreferredGap(UNRELATED)
                    .addComponent(separatorTwo, PREFERRED_SIZE, 12, PREFERRED_SIZE)
                    .addGap(5, 5, 5)
                    .addGroup(productsPanelLayout.createParallelGroup(LEADING)
                        .addGroup(productsPanelLayout.createSequentialGroup()
                            .addComponent(separatorOne, PREFERRED_SIZE, 10, PREFERRED_SIZE)
                            .addPreferredGap(RELATED, DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(separatorPanel, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                            .addGap(100, 100, 100))
                        .addGroup(productsPanelLayout.createSequentialGroup()
                            .addGroup(productsPanelLayout.createParallelGroup(LEADING)
                                .addComponent(scrollPane, PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addComponent(tabbedPane))
                            .addPreferredGap(RELATED)
                            .addComponent(supplierInfoPanel, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                            .addContainerGap())))
        );

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(LEADING)
                .addComponent(productsPanel, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(LEADING)
                .addComponent(productsPanel, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
        );
    }

    int quantity;

    private void tableMouseClicked(MouseEvent evt) {
        int row = table.getSelectedRow();
        int column = table.getColumnCount();
        Object[] val = new Object[column];
        for (int i = 0; i < column; i++) {
            val[i] = table.getValueAt(row, i);
        }
        purchaseIdField.setText(val[0].toString());
        String sup = new ProductDAO().getProductsSupplier(Integer.parseInt(purchaseIdField.getText()));
        supplierInfoLab.setText("Purchased from " + sup);
        String purchasedDate = new ProductDAO().getPurchasedDate(Integer.parseInt(purchaseIdField.getText()));
        purchasedDateLabel.setText(purchasedDate);

        quantity = Integer.parseInt(val[3].toString());
        productCode = val[1].toString();
    }

    public void loadData() {
        try {
            ProductDAO productDAO = new ProductDAO();
            table.setModel(productDAO.buildTableModel(productDAO.getPurchaseResult()));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void searchFieldKeyReleased(KeyEvent evt) {
        String text = searchField.getText();
        loadSearchPurchaseData(text);
    }

    public void loadSearchPurchaseData(String text) {
        try {
            ProductDAO productDAO = new ProductDAO();
            table.setModel(productDAO.buildTableModel(productDAO.getSearchPurchaseQueryResult(text)));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void refreshButtonActionPerformed(ActionEvent evt) {
        comboBox.removeAllItems();
        comboBox.addItem("Select Supplier's Name");
        suppliersName();
        purchaseIdField.setText("");
        productCodeField.setText("");
        productNameLabel.setText("");
        dateChooser.setDate(null);
        productCodeField.setText("");
    }

    private void productsPanelMouseClicked(MouseEvent evt) {
        purchaseIdField.setText("");
        dateChooser.setDate(null);
        productNameLabel.setText("");
        productNameLabel.setVisible(false);
        productCodeField.setText("");
    }

    private void clearButtonMouseClicked(MouseEvent evt) {
        purchaseIdField.setText("");
        productNameLabel.setText("");
        productNameLabel.setVisible(false);
        dateChooser.setDate(null);
        productCodeField.setText("");
    }

    private void deleteButtonMouseClicked(MouseEvent evt) {
        if (table.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(null, "Select a table data first!");
        } else {
            new ProductDAO().deletePurchaseDAO(String.valueOf(table.getValueAt(table.getSelectedRow(), 0)));
            new ProductDAO().editStock(String.valueOf(table.getValueAt(table.getSelectedRow(), 1)), quantity);
            loadData();
        }
    }

    private void addProductMouseClicked(MouseEvent evt) {
        productdto = new ProductDTO();
        if (productCodeField.getText().equals("") ||
            dateChooser.getDate() == null ||
            productCodeField.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Please fill all the fields!");
        } else {
            String supplier = (String) comboBox.getSelectedItem();
            if ("SELECT SUPPLIER'S NAME".equalsIgnoreCase(supplier)) {
                JOptionPane.showMessageDialog(null, "Please select a supplier and try again!");
            } else {
                String supplierCode = new ProductDAO().getSupplierCode(supplier);
                productdto.setSupplierCode(supplierCode);
                productdto.setProductCode(productCodeField.getText());
                try {
                    ResultSet rs = new ProductDAO().getProductName(productCodeField.getText());
                    if (rs.next()) {
                        productdto.setDate(dateChooser.getDate().toString());
                        productdto.setQuantity(Integer.parseInt(quantityField.getText()));
                        double costPrice = Double.parseDouble(costPriceField.getText());
                        Double totalCost = costPrice * Integer.parseInt(quantityField.getText());
                        productdto.setTotalCost(totalCost);
                        new ProductDAO().addPurchaseDAO(productdto);
                        loadData();
                    } else {
                        productNameLabel.setText("Not associated with any Products!");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void productCodeFieldKeyReleased(KeyEvent evt) {
        productNameLabel.setVisible(true);

        try {
            ResultSet rs = new ProductDAO().getProductName(productCodeField.getText());
            if (rs.next()) {
                productNameLabel.setText(rs.getString("productname"));
                Double costPrice = new ProductDAO().getProductCostPrice(productCodeField.getText());
                costPriceField.setText(costPrice.toString());
            } else {
                productNameLabel.setText("Not associated with any Products!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void suppliersName() {
        ResultSet rs = new ProductDTO().getSuppliersName();
        try {
            while (rs.next()) {
                String suppliersName = rs.getString("fullname");
                comboBox.addItem(suppliersName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private JComboBox<String> comboBox;
    private JTextField costPriceField;
    private JDateChooser dateChooser;
    private JTextField productCodeField;
    private JLabel productNameLabel;
    public JPanel productsPanel;
    private JTextField purchaseIdField;
    private JLabel purchasedDateLabel;
    private JTextField quantityField;
    private JTextField searchField;
    private JLabel supplierInfoLab;
    private JTable table;
}

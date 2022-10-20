/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.inventory.ui;

import com.inventory.dao.CustomerDAO;
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
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
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
 * @author ADMIN
 */
public class SalesReport extends JPanel {
    String u;

    /**
     * Creates new form SalesReport
     */
    public SalesReport(String user) {
        initComponents();
        u = user;
        loadData();
        salesIdField.setVisible(false);
        customerNameLab.setVisible(false);
        productNameLabel.setVisible(false);
    }

    private void initComponents() {
        JScrollPane scrollPane = new JScrollPane();
        table = new JTable();
        JLabel salesHeaderLabel = new JLabel();
        JSeparator separator = new JSeparator();
        JTabbedPane tabbedPane = new JTabbedPane();
        JPanel salePanelContainer = new JPanel();
        JPanel salePanel = new JPanel();
        JLabel productCodeLabel1 = new JLabel();
        productCodeField = new JTextField();
        quantityField = new JTextField();
        JLabel quantityLabel = new JLabel();
        sellingPriceField = new JTextField();
        JLabel sellingPriceLabel = new JLabel();
        dateChooser = new JDateChooser();
        JLabel dateLabel = new JLabel();
        customerCodeField = new JTextField();
        JLabel productCodeLabel2 = new JLabel();
        productNameLabel = new JLabel();
        JLabel sellButton = new JLabel();
        JLabel deleteLabel = new JLabel();
        JLabel deleteButton = new JLabel();
        JLabel clearButton = new JLabel();
        JLabel clearLabel = new JLabel();
        JLabel sellLabel = new JLabel();
        salesIdField = new JTextField();
        customerNameLab = new JLabel();
        JPanel supplierInfoPanel = new JPanel();
        JLabel customerInfoLabel = new JLabel();
        supplierInfoLabel = new JLabel();
        JLabel soldDateLabel = new JLabel();
        purchasedDateLabel = new JLabel();
        JLabel searchByLabel = new JLabel();
        searchField = new JTextField();

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

        salesHeaderLabel.setFont(new Font("Comfortaa", Font.BOLD, 24));
        salesHeaderLabel.setForeground(new Color(0, 102, 204));
        salesHeaderLabel.setText("SALES");

        salePanelContainer.setBorder(BorderFactory.createLineBorder(Color.black));
        salePanelContainer.setFont(new Font("Comfortaa", Font.PLAIN, 12));

        productCodeLabel1.setText("Product Code");

        productCodeField.addKeyListener((KeyReleasedListener) this::productCodeFieldKeyReleased);

        quantityLabel.setText("Quantity");

        sellingPriceLabel.setText("Selling Price");

        dateLabel.setText("Date");

        customerCodeField.addKeyListener((KeyReleasedListener) this::customerCodeFieldKeyReleased);

        productCodeLabel2.setText("Customer Code");

        productNameLabel.setBackground(new Color(204, 204, 255));
        productNameLabel.setFont(new Font("Comfortaa", Font.PLAIN, 14));
        productNameLabel.setForeground(new Color(102, 102, 255));

        sellButton.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/com/inventory/ui/images" +
            "/saleLarge.png"))));
        sellButton.addMouseListener((MouseClickedListener) this::sellButtonMouseClicked);

        deleteLabel.setText("Delete");

        deleteButton.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/com/inventory/ui/images" +
            "/delete item" +
            ".png"))));
        deleteButton.addMouseListener((MouseClickedListener) this::deleteButtonMouseClicked);

        clearButton.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/com/inventory/ui/images" +
            "/clear.png"))));
        clearButton.addMouseListener((MouseClickedListener) this::clearButton1MouseClicked);

        clearLabel.setText("Clear");

        sellLabel.setText("Sell");

        customerNameLab.setBackground(new Color(204, 204, 255));
        customerNameLab.setFont(new Font("Comfortaa", Font.PLAIN, 14));
        customerNameLab.setForeground(new Color(102, 102, 255));

        GroupLayout salePanelLayout = new GroupLayout(salePanel);
        salePanel.setLayout(salePanelLayout);
        salePanelLayout.setHorizontalGroup(
            salePanelLayout.createParallelGroup(LEADING)
                .addGroup(salePanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(salePanelLayout.createParallelGroup(LEADING)
                        .addComponent(customerNameLab, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(TRAILING, salePanelLayout.createSequentialGroup()
                            .addGroup(salePanelLayout.createParallelGroup(TRAILING)
                                .addComponent(sellButton)
                                .addGroup(salePanelLayout.createSequentialGroup()
                                    .addComponent(sellLabel)
                                    .addGap(19, 19, 19)))
                            .addGap(10, 10, 10)
                            .addGroup(salePanelLayout.createParallelGroup(TRAILING)
                                .addComponent(deleteLabel)
                                .addComponent(deleteButton))
                            .addPreferredGap(UNRELATED)
                            .addGroup(salePanelLayout.createParallelGroup(LEADING)
                                .addGroup(salePanelLayout.createSequentialGroup()
                                    .addGap(10, 10, 10)
                                    .addComponent(clearLabel))
                                .addComponent(clearButton))
                            .addPreferredGap(RELATED, DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(salesIdField, PREFERRED_SIZE, 30, PREFERRED_SIZE)
                            .addGap(7, 7, 7))
                        .addGroup(salePanelLayout.createSequentialGroup()
                            .addGroup(salePanelLayout.createParallelGroup(LEADING)
                                .addComponent(sellingPriceLabel)
                                .addComponent(quantityLabel))
                            .addPreferredGap(RELATED, DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(salePanelLayout.createParallelGroup(LEADING, false)
                                .addComponent(sellingPriceField, DEFAULT_SIZE, 239, Short.MAX_VALUE)
                                .addComponent(quantityField)))
                        .addComponent(productNameLabel, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(salePanelLayout.createSequentialGroup()
                            .addGroup(salePanelLayout.createParallelGroup(LEADING)
                                .addComponent(productCodeLabel2)
                                .addComponent(productCodeLabel1)
                                .addComponent(dateLabel))
                            .addGap(18, 18, 18)
                            .addGroup(salePanelLayout.createParallelGroup(LEADING)
                                .addComponent(dateChooser, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(customerCodeField)
                                .addGroup(salePanelLayout.createSequentialGroup()
                                    .addGap(0, 1, Short.MAX_VALUE)
                                    .addComponent(productCodeField, PREFERRED_SIZE, 238, PREFERRED_SIZE)))))
                    .addContainerGap())
        );
        salePanelLayout.setVerticalGroup(
            salePanelLayout.createParallelGroup(LEADING)
                .addGroup(salePanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(salePanelLayout.createParallelGroup(LEADING)
                        .addGroup(TRAILING, salePanelLayout.createSequentialGroup()
                            .addComponent(dateLabel)
                            .addGap(18, 18, 18))
                        .addGroup(salePanelLayout.createSequentialGroup()
                            .addComponent(dateChooser, PREFERRED_SIZE, 27, PREFERRED_SIZE)
                            .addPreferredGap(UNRELATED, DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(salePanelLayout.createParallelGroup(BASELINE)
                        .addComponent(productCodeLabel2)
                        .addComponent(customerCodeField, PREFERRED_SIZE, 29, PREFERRED_SIZE))
                    .addPreferredGap(RELATED)
                    .addComponent(customerNameLab, PREFERRED_SIZE, 19, PREFERRED_SIZE)
                    .addGap(7, 7, 7)
                    .addGroup(salePanelLayout.createParallelGroup(BASELINE)
                        .addComponent(productCodeField, PREFERRED_SIZE, 29, PREFERRED_SIZE)
                        .addComponent(productCodeLabel1))
                    .addPreferredGap(RELATED)
                    .addComponent(productNameLabel, PREFERRED_SIZE, 19, PREFERRED_SIZE)
                    .addPreferredGap(RELATED)
                    .addGroup(salePanelLayout.createParallelGroup(LEADING)
                        .addComponent(sellingPriceField, PREFERRED_SIZE, 29, PREFERRED_SIZE)
                        .addComponent(sellingPriceLabel, PREFERRED_SIZE, 30, PREFERRED_SIZE))
                    .addGap(25, 25, 25)
                    .addGroup(salePanelLayout.createParallelGroup(BASELINE)
                        .addComponent(quantityLabel)
                        .addComponent(quantityField, PREFERRED_SIZE, 29, PREFERRED_SIZE))
                    .addGroup(salePanelLayout.createParallelGroup(LEADING)
                        .addGroup(salePanelLayout.createSequentialGroup()
                            .addGap(39, 39, 39)
                            .addComponent(salesIdField, PREFERRED_SIZE, 34, PREFERRED_SIZE))
                        .addGroup(salePanelLayout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addGroup(salePanelLayout.createParallelGroup(LEADING)
                                .addComponent(sellButton)
                                .addGroup(salePanelLayout.createSequentialGroup()
                                    .addGroup(salePanelLayout.createParallelGroup(LEADING)
                                        .addComponent(deleteButton)
                                        .addComponent(clearButton))
                                    .addPreferredGap(RELATED)
                                    .addGroup(salePanelLayout.createParallelGroup(BASELINE)
                                        .addComponent(deleteLabel)
                                        .addComponent(clearLabel)
                                        .addComponent(sellLabel))))))
                    .addContainerGap(DEFAULT_SIZE, Short.MAX_VALUE))
        );

        GroupLayout salePanelContainerLayout = new GroupLayout(salePanelContainer);
        salePanelContainer.setLayout(salePanelContainerLayout);
        salePanelContainerLayout.setHorizontalGroup(
            salePanelContainerLayout.createParallelGroup(LEADING)
                .addGroup(salePanelContainerLayout.createSequentialGroup()
                    .addGap(8, 8, 8)
                    .addComponent(salePanel, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(9, 9, 9))
        );
        salePanelContainerLayout.setVerticalGroup(
            salePanelContainerLayout.createParallelGroup(LEADING)
                .addGroup(salePanelContainerLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(salePanel, PREFERRED_SIZE, 351, PREFERRED_SIZE)
                    .addContainerGap(DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabbedPane.addTab("Sales", salePanelContainer);

        supplierInfoPanel.setBackground(new Color(255, 255, 204));

        customerInfoLabel.setForeground(new Color(0, 0, 51));
        customerInfoLabel.setText("Customer Info: ");

        supplierInfoLabel.setForeground(new Color(0, 0, 51));
        supplierInfoLabel.setText("         ");

        soldDateLabel.setForeground(new Color(0, 0, 51));
        soldDateLabel.setText("Sold Date:");

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
                            .addComponent(soldDateLabel)
                            .addPreferredGap(UNRELATED)
                            .addComponent(purchasedDateLabel))
                        .addGroup(supplierInfoPanelLayout.createSequentialGroup()
                            .addComponent(customerInfoLabel)
                            .addPreferredGap(RELATED)
                            .addComponent(supplierInfoLabel, PREFERRED_SIZE, 291, PREFERRED_SIZE)))
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
                    .addComponent(soldDateLabel)
                    .addPreferredGap(RELATED)
                    .addGroup(supplierInfoPanelLayout.createParallelGroup(BASELINE)
                        .addComponent(customerInfoLabel)
                        .addComponent(supplierInfoLabel))
                    .addContainerGap())
        );

        searchByLabel.setText("SEARCH");

        searchField.setToolTipText("Search using Product Name, Brand Name OR Product Code");
        searchField.addKeyListener((KeyReleasedListener) this::searchFieldKeyReleased);

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(TRAILING, false)
                        .addComponent(supplierInfoPanel, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(scrollPane, DEFAULT_SIZE, 483, Short.MAX_VALUE))
                    .addPreferredGap(RELATED)
                    .addComponent(tabbedPane, PREFERRED_SIZE, 427, PREFERRED_SIZE)
                    .addContainerGap(DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(separator, PREFERRED_SIZE, 883, PREFERRED_SIZE)
                            .addContainerGap(DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(salesHeaderLabel)
                            .addPreferredGap(RELATED, DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(searchByLabel)
                            .addPreferredGap(RELATED)
                            .addComponent(searchField, PREFERRED_SIZE, 270, PREFERRED_SIZE)
                            .addGap(93, 93, 93))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(23, 23, 23)
                    .addGroup(layout.createParallelGroup(LEADING)
                        .addComponent(salesHeaderLabel, TRAILING)
                        .addGroup(TRAILING, layout.createParallelGroup(BASELINE)
                            .addComponent(searchField, PREFERRED_SIZE, 30, PREFERRED_SIZE)
                            .addComponent(searchByLabel, PREFERRED_SIZE, 34, PREFERRED_SIZE)))
                    .addPreferredGap(RELATED)
                    .addComponent(separator, PREFERRED_SIZE, 11, PREFERRED_SIZE)
                    .addPreferredGap(RELATED)
                    .addGroup(layout.createParallelGroup(LEADING)
                        .addComponent(scrollPane, PREFERRED_SIZE, 430, PREFERRED_SIZE)
                        .addComponent(tabbedPane, TRAILING, PREFERRED_SIZE, 430, PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addComponent(supplierInfoPanel, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                    .addContainerGap(DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }

    int quantity;

    private void tableMouseClicked(MouseEvent evt) {
        int row = table.getSelectedRow();
        int column = table.getColumnCount();
        Object[] val = new Object[column];
        for (int i = 0; i < column; i++) val[i] = table.getValueAt(row, i);
        salesIdField.setText(val[0].toString());
        String cus = new ProductDAO().getProductsCustomer(Integer.parseInt(salesIdField.getText()));
        supplierInfoLabel.setText("Sold to " + cus);
        String soldDate = new ProductDAO().getSoldDate(Integer.parseInt(salesIdField.getText()));
        purchasedDateLabel.setText(soldDate);
        quantity = Integer.parseInt(val[3].toString());
        productCode = val[1].toString();
    }

    private void searchFieldKeyReleased(KeyEvent evt) {
        String text = searchField.getText();
        loadSearchSalesData(text);
    }

    private void clearButton1MouseClicked(MouseEvent evt) {
        salesIdField.setText("");
        customerCodeField.setText("");
        productNameLabel.setText("");
        productNameLabel.setVisible(false);
        customerNameLab.setText("");
        customerNameLab.setVisible(false);
        dateChooser.setDate(null);
        productCodeField.setText("");
    }

    private void deleteButtonMouseClicked(MouseEvent evt) {
        if (table.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(null, "Select a table data first!");
        } else {
            new ProductDAO().deleteSalesDAO(String.valueOf(table.getValueAt(table.getSelectedRow(), 0)));
            new ProductDAO().editSoldStock(String.valueOf(table.getValueAt(table.getSelectedRow(), 1)), quantity);
            loadData();
        }
    }

    private void sellButtonMouseClicked(MouseEvent evt) {
        if (dateChooser.getDate() == null || quantityField.getText().equals("") || customerCodeField.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Please fill all the fields!");
        } else {
            try {
                ResultSet rs = new CustomerDAO().getCustomersName(customerCodeField.getText());
                if (rs.next()) {
                    ProductDTO productdto = new ProductDTO();
                    productdto.setCustomerCode(customerCodeField.getText());
                    productdto.setSellDate(dateChooser.getDate().toString());
                    productdto.setProductCode(productCodeField.getText());
                    double sellingPrice = Double.parseDouble(sellingPriceField.getText());
                    Double totalRevenue = sellingPrice * Integer.parseInt(quantityField.getText());
                    productdto.setTotalRevenue(totalRevenue);
                    productdto.setQuantity(Integer.parseInt(quantityField.getText()));
                    new ProductDAO().sellProductDAO(productdto, u);
                    loadData();
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter valid customer code!");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void customerCodeFieldKeyReleased(KeyEvent evt) {
        customerNameLab.setVisible(true);

        try {
            ResultSet rs = new CustomerDAO().getCustomersName(customerCodeField.getText());
            if (rs.next()) {
                customerNameLab.setText("Name: " + rs.getString("fullname") + " | Location: " + rs.getString(
                    "location"));
            } else {
                customerNameLab.setText("Not associated with any Customers!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void productCodeFieldKeyReleased(KeyEvent evt) {
        productNameLabel.setVisible(true);

        try {
            ResultSet rs = new CustomerDAO().getProductsName(productCodeField.getText());
            if (rs.next()) {
                productNameLabel.setText("Name: " + rs.getString("productname") + " | Available Quantity: " + rs.getInt("quantity"));
                Double sellingPrice = new ProductDAO().getProductSellingPrice(productCodeField.getText());
                sellingPriceField.setText(sellingPrice.toString());
            } else {
                productNameLabel.setText("Not associated with any Products!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadData() {
        try {
            ProductDAO productDAO = new ProductDAO();
            table.setModel(productDAO.buildTableModel(productDAO.getSalesReportQueryResult()));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void loadSearchSalesData(String text) {
        try {
            ProductDAO productDAO = new ProductDAO();
            table.setModel(productDAO.buildTableModel(productDAO.getSearchSalesQueryResult(text)));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private JTextField customerCodeField;
    private JLabel customerNameLab;
    private JDateChooser dateChooser;
    private JTextField productCodeField;
    private JLabel productNameLabel;
    private JLabel purchasedDateLabel;
    private JTextField quantityField;
    private JTextField salesIdField;
    private JTextField searchField;
    private JTextField sellingPriceField;
    private JLabel supplierInfoLabel;
    private JTable table;
}

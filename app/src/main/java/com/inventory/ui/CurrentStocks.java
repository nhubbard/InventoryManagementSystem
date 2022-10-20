/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.inventory.ui;

import com.inventory.dao.ProductDAO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;
import java.util.Objects;

import static javax.swing.GroupLayout.*;
import static javax.swing.GroupLayout.Alignment.*;
import static javax.swing.LayoutStyle.ComponentPlacement;

public class CurrentStocks extends JPanel {

    /**
     * Creates new form CurrentStocks
     */
    String u;

    public CurrentStocks(String username) {
        initComponents();
        loadData();
        u = username;
    }

    private void initComponents() {
        JPanel mainPanel = new JPanel();
        JScrollPane scrollPane = new JScrollPane();
        table = new JTable();
        JSeparator separator = new JSeparator();
        JLabel currentStocksLabel = new JLabel();
        JButton refreshButton = new JButton();

        table.setModel(new DefaultTableModel(
            new Object[][]{
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String[]{"Title 1", "Title 2", "Title 3", "Title 4"}
        ));
        scrollPane.setViewportView(table);

        currentStocksLabel.setFont(new Font("Comfortaa", Font.BOLD, 24));
        currentStocksLabel.setForeground(new Color(0, 102, 204));
        currentStocksLabel.setText("CURRENT STOCKS");

        refreshButton.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/com/inventory/ui/images" +
            "/reload.png"))));
        refreshButton.setText("Refresh");
        refreshButton.addActionListener(evt -> loadData());

        GroupLayout mainPanelLayout = new GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(LEADING)
                .addGroup(mainPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(mainPanelLayout.createParallelGroup(LEADING)
                        .addComponent(separator, TRAILING)
                        .addGroup(mainPanelLayout.createSequentialGroup()
                            .addGroup(mainPanelLayout.createParallelGroup(LEADING)
                                .addComponent(scrollPane, PREFERRED_SIZE, 747, PREFERRED_SIZE)
                                .addGroup(mainPanelLayout.createSequentialGroup()
                                    .addComponent(refreshButton)
                                    .addPreferredGap(ComponentPlacement.RELATED)
                                    .addComponent(currentStocksLabel)))
                            .addGap(0, 58, Short.MAX_VALUE)))
                    .addContainerGap()));
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(LEADING)
                .addGroup(TRAILING, mainPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(mainPanelLayout.createParallelGroup(LEADING)
                        .addComponent(refreshButton)
                        .addGroup(mainPanelLayout.createSequentialGroup()
                            .addGap(3, 3, 3)
                            .addComponent(currentStocksLabel, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addPreferredGap(ComponentPlacement.UNRELATED)
                    .addComponent(separator, PREFERRED_SIZE, 10, PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(scrollPane, PREFERRED_SIZE, 384, PREFERRED_SIZE)
                    .addGap(56, 56, 56)));

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(mainPanel, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)));
        layout.setVerticalGroup(
            layout.createParallelGroup(LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(mainPanel, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)));
    }

    public void loadData() {
        try {
            ProductDAO productDAO = new ProductDAO();
            table.setModel(productDAO.buildTableModel(productDAO.getQueryResultOfCurrentStocks()));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private JTable table;
}

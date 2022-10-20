/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.inventory.ui;

import javax.swing.GroupLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import static javax.swing.GroupLayout.*;
import static javax.swing.GroupLayout.Alignment.*;

/**
 * @author ADMIN
 */
public class Logs extends JPanel {

    /**
     * Creates new form Logs
     */
    public Logs() {
        initComponents();
    }

    private void initComponents() {
        mainPanel = new JPanel();
        JScrollPane scrollPane = new JScrollPane();
        JTable table = new JTable();

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
        scrollPane.setViewportView(table);

        GroupLayout mainPanelLayout = new GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(LEADING)
                .addGroup(mainPanelLayout.createSequentialGroup()
                    .addComponent(scrollPane, PREFERRED_SIZE, 742, PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(LEADING)
                .addGroup(mainPanelLayout.createSequentialGroup()
                    .addGap(64, 64, 64)
                    .addComponent(scrollPane, PREFERRED_SIZE, 329, PREFERRED_SIZE)
                    .addContainerGap(72, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(LEADING)
                .addComponent(mainPanel, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(LEADING)
                .addComponent(mainPanel, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }

    public JPanel mainPanel;
}

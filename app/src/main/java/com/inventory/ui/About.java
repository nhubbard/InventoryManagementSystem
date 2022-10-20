/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.inventory.ui;

import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;

import static javax.swing.GroupLayout.*;
import static javax.swing.LayoutStyle.*;

public class About extends JPanel {
    public About() {
        initComponents();
    }

    private void initComponents() {
        JPanel mainPanel = new JPanel();
        JLayeredPane layeredPane = new JLayeredPane();
        JLabel developerInfoLabel = new JLabel();
        JLabel developerNameLabel = new JLabel();
        JLabel developerEmailLabel = new JLabel();
        JLabel developerWebsiteLabel = new JLabel();

        developerInfoLabel.setFont(new Font("Comfortaa", Font.PLAIN, 24)); // NOI18N
        developerInfoLabel.setText("Developer Info");

        developerNameLabel.setFont(new Font("Comfortaa", Font.PLAIN, 14)); // NOI18N
        developerNameLabel.setForeground(new Color(0, 0, 102));
        developerNameLabel.setText("Name: Sajan Rajbhandari");

        developerEmailLabel.setFont(new Font("Comfortaa", Font.PLAIN, 14)); // NOI18N
        developerEmailLabel.setForeground(new Color(0, 0, 102));
        developerEmailLabel.setText("Email: sazanrjb@gmail.com");

        developerWebsiteLabel.setFont(new Font("Comfortaa", Font.PLAIN, 14)); // NOI18N
        developerWebsiteLabel.setForeground(new Color(0, 0, 102));
        developerWebsiteLabel.setText("Website: http://sazanrjb.com.np");

        layeredPane.setLayer(developerInfoLabel, JLayeredPane.DEFAULT_LAYER);
        layeredPane.setLayer(developerNameLabel, JLayeredPane.DEFAULT_LAYER);
        layeredPane.setLayer(developerEmailLabel, JLayeredPane.DEFAULT_LAYER);
        layeredPane.setLayer(developerWebsiteLabel, JLayeredPane.DEFAULT_LAYER);

        GroupLayout layeredPaneLayout = new GroupLayout(layeredPane);
        layeredPane.setLayout(layeredPaneLayout);
        layeredPaneLayout.setHorizontalGroup(
                layeredPaneLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(layeredPaneLayout.createSequentialGroup()
                                .addGap(150, 150, 150)
                                .addGroup(layeredPaneLayout.createParallelGroup(Alignment.LEADING)
                                        .addComponent(developerNameLabel)
                                        .addComponent(developerEmailLabel)
                                        .addComponent(developerWebsiteLabel)
                                        .addComponent(developerInfoLabel))
                                .addContainerGap(133, Short.MAX_VALUE))
        );
        layeredPaneLayout.setVerticalGroup(
            layeredPaneLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(layeredPaneLayout.createSequentialGroup()
                    .addGap(19, 19, 19)
                    .addComponent(developerInfoLabel)
                    .addGap(41, 41, 41)
                    .addComponent(developerNameLabel)
                    .addPreferredGap(ComponentPlacement.RELATED)
                    .addComponent(developerEmailLabel)
                    .addPreferredGap(ComponentPlacement.RELATED)
                    .addComponent(developerWebsiteLabel)
                    .addContainerGap(94, Short.MAX_VALUE))
        );

        GroupLayout mainPanelLayout = new GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(mainPanelLayout.createSequentialGroup()
                    .addGap(44, 44, 44)
                    .addComponent(layeredPane, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                    .addContainerGap(176, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(mainPanelLayout.createSequentialGroup()
                    .addGap(35, 35, 35)
                    .addComponent(layeredPane, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                    .addContainerGap(112, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(mainPanel, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(mainPanel, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE))
        );
    }
}

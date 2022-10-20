/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.ui;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.util.Objects;

import static javax.swing.GroupLayout.*;
import static javax.swing.GroupLayout.Alignment.*;
import static javax.swing.LayoutStyle.ComponentPlacement.*;

public class HomePage extends JPanel {
    public HomePage() {
        initComponents();
    }

    private void initComponents() {

        mainPanel = new JPanel();
        JLabel headerImageLabel = new JLabel();
        JPanel secondaryPanel = new JPanel();

        headerImageLabel.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/com/inventory/ui" +
            "/images/front-image.png")))); // NOI18N

        GroupLayout secondaryPanelLayout = new GroupLayout(secondaryPanel);
        secondaryPanel.setLayout(secondaryPanelLayout);
        secondaryPanelLayout.setHorizontalGroup(
            secondaryPanelLayout.createParallelGroup(LEADING)
                .addGap(0, 100, Short.MAX_VALUE)
        );
        secondaryPanelLayout.setVerticalGroup(
            secondaryPanelLayout.createParallelGroup(LEADING)
                .addGap(0, 100, Short.MAX_VALUE)
        );

        GroupLayout mainPanelLayout = new GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(LEADING)
                .addGroup(mainPanelLayout.createSequentialGroup()
                    .addGap(103, 103, 103)
                    .addGroup(mainPanelLayout.createParallelGroup(LEADING)
                        .addComponent(headerImageLabel)
                        .addComponent(secondaryPanel, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE))
                    .addContainerGap(113, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(LEADING)
                .addGroup(mainPanelLayout.createSequentialGroup()
                    .addGap(40, 40, 40)
                    .addComponent(headerImageLabel)
                    .addPreferredGap(RELATED, 47, Short.MAX_VALUE)
                    .addComponent(secondaryPanel, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                    .addGap(183, 183, 183))
        );

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(LEADING)
                .addGap(0, 868, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(mainPanel, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(LEADING)
                .addGap(0, 850, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(mainPanel, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
        );
    }

    public JPanel mainPanel;
}

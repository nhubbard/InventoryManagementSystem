/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.ui;

import com.inventory.ui.util.MouseClickedListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

import static javax.swing.GroupLayout.Alignment.LEADING;
import static javax.swing.GroupLayout.Alignment.TRAILING;
import static javax.swing.GroupLayout.DEFAULT_SIZE;
import static javax.swing.GroupLayout.PREFERRED_SIZE;
import static javax.swing.LayoutStyle.ComponentPlacement.RELATED;

public class Dashboard extends JFrame {
    CardLayout layout;
    String userSelect;
    String username;

    public Dashboard(String user, String username) {
        initComponents();
        navPanel.setVisible(true);
        menuPanel.setVisible(true);
        layout = new CardLayout();
        userSelect = user;
        this.username = username;
        if ("NORMAL USER".equalsIgnoreCase(userSelect)) notForNormalUser();
        mainPanel.setLayout(layout);
        mainPanel.add("Home", new HomePage());
        mainPanel.add("Products", new Products(username));
        mainPanel.add("Customers", new Customers());
        mainPanel.add("Suppliers", new Suppliers());
        mainPanel.add("Users", new Users());
        mainPanel.add("Logs", new Logs());
        mainPanel.add("Change Details", new ChangeDetails(username));
        mainPanel.add("Current Stocks", new CurrentStocks(username));
        mainPanel.add("Sales Report", new SalesReport(username));
        mainPanel.add("Purchases", new Purchase());
        mainPanel.add("About", new About());
        layout.next(mainPanel);
        layout.next(mainPanel);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("ims-logo.png")));
        Toolkit theKit = getToolkit();
        Dimension dim = theKit.getScreenSize();
        setSize(dim);
        setTitle("Inventory Management System");
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void addProductsPage() {
        layout.show(mainPanel, "Products");
    }

    public void addCustomersPage() {
        layout.show(mainPanel, "Customers");
    }

    public void addSuppliersPage() {
        layout.show(mainPanel, "Suppliers");
    }

    public void addUsersPage() {
        layout.show(mainPanel, "Users");
    }

    public void addLogsPage() {
        layout.show(mainPanel, "Logs");
    }

    public void addChangeDetailsPage() {
        layout.show(mainPanel, "Change Details");
    }

    public void addCurrentStocksPage() {
        layout.show(mainPanel, "Current Stocks");
    }

    public void addSalesReportPage() {
        layout.show(mainPanel, "Sales Report");
    }

    public void addPurchasePage() {
        layout.show(mainPanel, "Purchases");
    }

    public void addAboutPage() {
        layout.show(mainPanel, "About");
    }

    private void initComponents() {
        mainPanel = new JPanel();
        JPanel firstPanel = new JPanel();
        JPanel buttonPanel = new JPanel();
        navPanel = new JPanel();
        JLabel productsLabel = new JLabel();
        JLabel addProductButton = new JLabel();
        JLabel customersButton = new JLabel();
        JLabel customersLabel = new JLabel();
        JLabel suppliersButton = new JLabel();
        JLabel suppliersLabel = new JLabel();
        userButton = new JLabel();
        userLabel = new JLabel();
        JLabel currentStocksButton = new JLabel();
        JLabel currentStocksLabel = new JLabel();
        JLabel salesReportButton = new JLabel();
        JLabel salesReportLabel = new JLabel();
        JLabel homeLabel = new JLabel();
        JLabel purchaseButton = new JLabel();
        JLabel purchaseLabel = new JLabel();
        menuPanel = new JPanel();
        JLabel menuButton = new JLabel();
        JMenuBar mainMenuBar = new JMenuBar();
        JMenu fileMenu = new JMenu();
        JMenuItem homeMenuItem = new JMenuItem();
        JMenuItem aboutMenuItem = new JMenuItem();
        JMenu salesMenuItem = new JMenu();
        JMenuItem changeDetailsMenuItem = new JMenuItem();
        JMenuItem logoutMenuItem = new JMenuItem();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        GroupLayout firstPanelLayout = new GroupLayout(firstPanel);
        firstPanel.setLayout(firstPanelLayout);
        firstPanelLayout.setHorizontalGroup(
            firstPanelLayout.createParallelGroup(LEADING)
                .addGap(0, 100, Short.MAX_VALUE)
        );
        firstPanelLayout.setVerticalGroup(
            firstPanelLayout.createParallelGroup(LEADING)
                .addGap(0, 100, Short.MAX_VALUE)
        );

        buttonPanel.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));

        GroupLayout buttonPanelLayout = new GroupLayout(buttonPanel);
        buttonPanel.setLayout(buttonPanelLayout);
        buttonPanelLayout.setHorizontalGroup(
            buttonPanelLayout.createParallelGroup(LEADING)
                .addGap(0, 255, Short.MAX_VALUE)
        );
        buttonPanelLayout.setVerticalGroup(
            buttonPanelLayout.createParallelGroup(LEADING)
                .addGap(0, 164, Short.MAX_VALUE)
        );

        GroupLayout mainPanelLayout = new GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(LEADING)
                .addGroup(mainPanelLayout.createSequentialGroup()
                    .addGap(193, 193, 193)
                    .addComponent(firstPanel, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                    .addGap(570, 570, 570)
                    .addComponent(buttonPanel, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                    .addContainerGap(440, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(LEADING)
                .addGroup(mainPanelLayout.createSequentialGroup()
                    .addGap(486, 486, 486)
                    .addGroup(mainPanelLayout.createParallelGroup(LEADING)
                        .addGroup(mainPanelLayout.createSequentialGroup()
                            .addPreferredGap(RELATED, 130, Short.MAX_VALUE)
                            .addComponent(firstPanel, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                            .addGap(183, 183, 183))
                        .addGroup(mainPanelLayout.createSequentialGroup()
                            .addComponent(buttonPanel, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                            .addContainerGap(DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        navPanel.setBackground(new Color(255, 255, 255));
        navPanel.setBorder(BorderFactory.createLineBorder(null));
        navPanel.setForeground(new Color(255, 255, 255));

        productsLabel.setText("Products");

        addProductButton.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/com/inventory/ui" +
            "/images" +
            "/productLarge.png")))); 
        addProductButton.setToolTipText("Products");
        addProductButton.addMouseListener((MouseClickedListener) this::addProductButtonMouseClicked);

        customersButton.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/com/inventory/ui/images" +
            "/customerLarge.png"))));
        customersButton.setToolTipText("Customers");
        customersButton.addMouseListener((MouseClickedListener) this::customersButtonMouseClicked);

        customersLabel.setText("Customers");

        suppliersButton.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/com/inventory/ui/images" +
            "/supplierLarge.png")))); 
        suppliersButton.setToolTipText("Suppliers");
        suppliersButton.addMouseListener((MouseClickedListener) this::suppliersButtonMouseClicked);

        suppliersLabel.setText("Suppliers");

        userButton.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/com/inventory/ui/images" +
            "/userLarge.png"))));
        userButton.setToolTipText("Users");
        userButton.addMouseListener((MouseClickedListener) this::userButtonMouseClicked);

        userLabel.setText("Users");

        currentStocksButton.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/com/inventory/ui" +
            "/images" +
            "/inventory-maintenance-icon.png")))); 
        currentStocksButton.addMouseListener((MouseClickedListener) this::currentStocksButtonMouseClicked);

        currentStocksLabel.setText("Current Stocks");

        salesReportButton.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/com/inventory/ui" +
            "/images/saleLarge" +
            ".png")))); 
        salesReportButton.addMouseListener((MouseClickedListener) this::salesReportButtonMouseClicked);

        salesReportLabel.setText("Sales");

        homeLabel.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/com/inventory/ui/images/home" +
            ".png"))));
        
        homeLabel.setText("Home");
        homeLabel.addMouseListener((MouseClickedListener) this::homeLabelMouseClicked);

        purchaseButton.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/com/inventory/ui/images" +
            "/basket-icon" +
            ".png")))); 
        purchaseButton.addMouseListener((MouseClickedListener) this::purchaseButtonMouseClicked);

        purchaseLabel.setText("Purchase");

        GroupLayout navPanelLayout = new GroupLayout(navPanel);
        navPanel.setLayout(navPanelLayout);
        navPanelLayout.setHorizontalGroup(
            navPanelLayout.createParallelGroup(LEADING)
                .addGroup(navPanelLayout.createSequentialGroup()
                    .addGroup(navPanelLayout.createParallelGroup(LEADING)
                        .addGroup(TRAILING, navPanelLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(currentStocksLabel))
                        .addGroup(navPanelLayout.createSequentialGroup()
                            .addGap(14, 14, 14)
                            .addComponent(suppliersLabel))
                        .addGroup(navPanelLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(suppliersButton))
                        .addGroup(navPanelLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(addProductButton))
                        .addGroup(navPanelLayout.createSequentialGroup()
                            .addGap(16, 16, 16)
                            .addComponent(productsLabel))
                        .addGroup(navPanelLayout.createSequentialGroup()
                            .addGap(15, 15, 15)
                            .addGroup(navPanelLayout.createParallelGroup(LEADING)
                                .addGroup(navPanelLayout.createSequentialGroup()
                                    .addGap(10, 10, 10)
                                    .addComponent(userLabel))
                                .addComponent(userButton, PREFERRED_SIZE, 67, PREFERRED_SIZE)))
                        .addGroup(navPanelLayout.createSequentialGroup()
                            .addGap(15, 15, 15)
                            .addComponent(customersButton))
                        .addGroup(navPanelLayout.createSequentialGroup()
                            .addGap(15, 15, 15)
                            .addComponent(customersLabel))
                        .addGroup(navPanelLayout.createSequentialGroup()
                            .addGap(14, 14, 14)
                            .addGroup(navPanelLayout.createParallelGroup(LEADING)
                                .addComponent(purchaseButton)
                                .addComponent(purchaseLabel)))
                        .addGroup(navPanelLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(currentStocksButton))
                        .addGroup(navPanelLayout.createSequentialGroup()
                            .addGap(15, 15, 15)
                            .addGroup(navPanelLayout.createParallelGroup(LEADING)
                                .addGroup(navPanelLayout.createSequentialGroup()
                                    .addGap(10, 10, 10)
                                    .addComponent(salesReportLabel))
                                .addComponent(salesReportButton)))
                        .addGroup(navPanelLayout.createSequentialGroup()
                            .addGap(5, 5, 5)
                            .addComponent(homeLabel)))
                    .addContainerGap())
        );
        navPanelLayout.setVerticalGroup(
            navPanelLayout.createParallelGroup(LEADING)
                .addGroup(navPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(homeLabel)
                    .addGap(18, 18, 18)
                    .addComponent(suppliersButton)
                    .addPreferredGap(RELATED)
                    .addComponent(suppliersLabel)
                    .addGap(18, 18, 18)
                    .addComponent(addProductButton)
                    .addPreferredGap(RELATED)
                    .addComponent(productsLabel)
                    .addGap(18, 18, 18)
                    .addComponent(purchaseButton)
                    .addPreferredGap(RELATED)
                    .addComponent(purchaseLabel)
                    .addGap(18, 18, 18)
                    .addComponent(customersButton)
                    .addPreferredGap(RELATED)
                    .addComponent(customersLabel)
                    .addGap(18, 18, 18)
                    .addComponent(currentStocksButton)
                    .addPreferredGap(RELATED)
                    .addComponent(currentStocksLabel)
                    .addGap(18, 18, 18)
                    .addComponent(salesReportButton)
                    .addPreferredGap(RELATED)
                    .addComponent(salesReportLabel)
                    .addGap(18, 18, 18)
                    .addComponent(userButton)
                    .addPreferredGap(RELATED)
                    .addComponent(userLabel)
                    .addContainerGap(355, Short.MAX_VALUE))
        );

        menuPanel.setPreferredSize(new Dimension(61, 16));

        menuButton.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/com/inventory/ui/images/menu" +
            ".png"))));
        
        menuButton.setPreferredSize(new Dimension(77, 16));
        menuButton.addMouseListener((MouseClickedListener) this::menuButtonMouseClicked);

        GroupLayout menuPanelLayout = new GroupLayout(menuPanel);
        menuPanel.setLayout(menuPanelLayout);
        menuPanelLayout.setHorizontalGroup(
            menuPanelLayout.createParallelGroup(LEADING)
                .addGroup(menuPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(menuButton, PREFERRED_SIZE, 99, PREFERRED_SIZE)
                    .addContainerGap(DEFAULT_SIZE, Short.MAX_VALUE))
        );
        menuPanelLayout.setVerticalGroup(
            menuPanelLayout.createParallelGroup(LEADING)
                .addGroup(TRAILING, menuPanelLayout.createSequentialGroup()
                    .addComponent(menuButton, PREFERRED_SIZE, 21, PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE))
        );

        fileMenu.setMnemonic('f');
        fileMenu.setText("File");

        homeMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, InputEvent.CTRL_DOWN_MASK));
        homeMenuItem.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/com/inventory/ui/images" +
            "/home.png")))); 
        homeMenuItem.setText("Home");
        homeMenuItem.addActionListener(this::homeMenuItemActionPerformed);
        fileMenu.add(homeMenuItem);

        aboutMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_DOWN_MASK));
        aboutMenuItem.setText("About");
        aboutMenuItem.addActionListener(this::aboutMenuItemActionPerformed);
        fileMenu.add(aboutMenuItem);

        mainMenuBar.add(fileMenu);

        salesMenuItem.setText("Action");

        changeDetailsMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, InputEvent.CTRL_DOWN_MASK));
        changeDetailsMenuItem.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/com/inventory/ui" +
            "/images" +
            "/changeDetails.png")))); 
        changeDetailsMenuItem.setText("Change Details");
        changeDetailsMenuItem.addActionListener(this::changeDetailsMenuItemActionPerformed);
        salesMenuItem.add(changeDetailsMenuItem);

        logoutMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_3,
            InputEvent.CTRL_DOWN_MASK));
        logoutMenuItem.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/com/inventory/ui/images" +
            "/logoutSmall" +
            ".png")))); 
        logoutMenuItem.setText("Logout");
        logoutMenuItem.addActionListener(this::logoutMenuItemActionPerformed);
        salesMenuItem.add(logoutMenuItem);

        mainMenuBar.add(salesMenuItem);

        setJMenuBar(mainMenuBar);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(navPanel, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                    .addPreferredGap(RELATED)
                    .addComponent(mainPanel, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                    .addContainerGap(DEFAULT_SIZE, Short.MAX_VALUE))
                .addComponent(menuPanel, DEFAULT_SIZE, 1710, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(menuPanel, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                    .addPreferredGap(RELATED)
                    .addGroup(layout.createParallelGroup(LEADING)
                        .addComponent(navPanel, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                        .addComponent(mainPanel, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE))
        );
        pack();
    }


    private void logoutMenuItemActionPerformed(ActionEvent ignoredEvt) {
        dispose();
        LoginDialog ld = new LoginDialog();
        ld.setLocationRelativeTo(null);
        ld.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ld.setVisible(true);
    }

    private void changeDetailsMenuItemActionPerformed(ActionEvent ignoredEvt) {
        addChangeDetailsPage();
    }

    private void currentStocksButtonMouseClicked(MouseEvent ignoredEvt) {
        addCurrentStocksPage();
    }

    private void userButtonMouseClicked(MouseEvent ignoredEvt) {
        addUsersPage();
    }

    private void suppliersButtonMouseClicked(MouseEvent ignoredEvt) {
        addSuppliersPage();
    }

    private void customersButtonMouseClicked(MouseEvent ignoredEvt) {
        addCustomersPage();
    }

    private void addProductButtonMouseClicked(MouseEvent ignoredEvt) {
        addProductsPage();
    }

    private void salesReportButtonMouseClicked(MouseEvent ignoredEvt) {
        addSalesReportPage();
    }

    private void menuButtonMouseClicked(MouseEvent ignoredEvt) {
        navPanel.setVisible(!navPanel.isVisible());
    }

    private void homeMenuItemActionPerformed(ActionEvent ignoredEvt) {
        new Dashboard(userSelect, username);
        dispose();
    }

    private void homeLabelMouseClicked(MouseEvent ignoredEvt) {
        new Dashboard(userSelect, username);
        dispose();
    }

    private void purchaseButtonMouseClicked(MouseEvent ignoredEvt) {
        addPurchasePage();
    }

    private void aboutMenuItemActionPerformed(ActionEvent ignoredEvt) {
        addAboutPage();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | UnsupportedLookAndFeelException |
                 IllegalAccessException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void notForNormalUser() {
        navPanel.remove(userButton);
        navPanel.remove(userLabel);
    }

    private JPanel mainPanel;
    private JPanel menuPanel;
    private JPanel navPanel;
    private JLabel userButton;
    private JLabel userLabel;
}

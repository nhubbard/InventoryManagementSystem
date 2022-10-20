package com.inventory.ui.util;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

@FunctionalInterface
public interface KeyPressListener extends KeyListener {
    @Override
    default void keyTyped(KeyEvent e) {}

    @Override
    void keyPressed(KeyEvent e);

    @Override
    default void keyReleased(KeyEvent e) {}
}

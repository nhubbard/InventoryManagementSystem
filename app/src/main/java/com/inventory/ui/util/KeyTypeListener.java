package com.inventory.ui.util;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

@FunctionalInterface
public interface KeyTypeListener extends KeyListener {
    @Override
    void keyTyped(KeyEvent e);

    @Override
    default void keyPressed(KeyEvent e) {}

    @Override
    default void keyReleased(KeyEvent e) {}
}

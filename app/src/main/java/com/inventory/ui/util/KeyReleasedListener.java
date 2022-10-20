package com.inventory.ui.util;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

@FunctionalInterface
public interface KeyReleasedListener extends KeyListener {
    @Override
    default void keyTyped(KeyEvent e) {}

    @Override
    default void keyPressed(KeyEvent e) {}

    @Override
    void keyReleased(KeyEvent e);
}

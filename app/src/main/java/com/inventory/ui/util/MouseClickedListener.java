package com.inventory.ui.util;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * @see <a href="https://stackoverflow.com/a/36603564">[SO] Functional interface in java to react on mouseclick</a>
 */
@FunctionalInterface
public interface MouseClickedListener extends MouseListener {
    @Override
    default void mouseEntered(final MouseEvent e) {}

    @Override
    default void mouseExited(final MouseEvent e) {}

    @Override
    default void mousePressed(final MouseEvent e) {}

    @Override
    default void mouseReleased(final MouseEvent e) {}
}

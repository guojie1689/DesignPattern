package com.gj.dp.proxy;

import java.awt.*;

public interface Icon {
    int getWidth();

    int getHeight();

    void paintIcon(Component c, Graphics g, int x, int y);
}


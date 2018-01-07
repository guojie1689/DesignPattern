package com.gj.dp.proxy;

import java.awt.*;
import java.net.URL;

public class ImageIcon implements Icon {

    private URL imageUrl;
    private String msg;

    public ImageIcon(URL imageUrl, String msg) {
        this.imageUrl = imageUrl;
        this.msg = msg;
    }


    @Override
    public int getWidth() {
        return 0;
    }

    @Override
    public int getHeight() {
        return 0;
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {

    }
}

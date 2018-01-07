package com.gj.dp.proxy;

import java.awt.*;
import java.net.URL;

public class ImageProxy implements Icon {

    private ImageIcon imageIcon;
    private URL imageUrl;
    private Thread loadImageThread;
    private boolean retriving = false;

    public ImageProxy(URL url) {
        this.imageUrl = url;
    }


    @Override
    public int getWidth() {
        if (imageIcon != null)
            return imageIcon.getWidth();

        return 0;
    }

    @Override
    public int getHeight() {
        if (imageIcon != null)
            return imageIcon.getHeight();

        return 0;
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        if (imageIcon != null) {
            imageIcon.paintIcon(c, g, x, y);
        } else {
            if (!retriving) {//加载图片
                retriving = true;

                loadImageThread = new Thread() {
                    @Override
                    public void run() {
                        imageIcon = new ImageIcon(imageUrl, "CD Conver");
                        c.repaint();
                    }
                };

                loadImageThread.start();
            }
        }
    }
}

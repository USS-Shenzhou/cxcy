package cn.ussshenzhou.cxcy.widgets;

import cn.ussshenzhou.cxcy.utils.ColorControl;

import javax.swing.*;
import java.awt.*;
import java.awt.color.ColorSpace;

/**
 * @author USS_Shenzhou
 */
public class DepthGradientBar extends JPanel {
    public DepthGradientBar() {
        super();
    }

    @Override
    protected void paintComponent(Graphics g) {
        int width = this.getWidth();
        int height = this.getHeight();

        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        GradientPaint paint = new GradientPaint(0, 0, ColorControl.MIN_DEPTH, width, height, ColorControl.MAX_DEPTH);

        graphics2D.setPaint(paint);
        g.fillRect(0, 0, width, height);
    }
}

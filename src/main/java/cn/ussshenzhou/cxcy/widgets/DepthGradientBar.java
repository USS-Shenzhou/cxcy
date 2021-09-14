package cn.ussshenzhou.cxcy.widgets;

import cn.ussshenzhou.cxcy.utils.ColorManager;

import javax.swing.*;
import java.awt.*;

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

        GradientPaint paint = new GradientPaint(0, 0, ColorManager.MIN_DEPTH_COLOR, width, height, ColorManager.MAX_DEPTH_COLOR);

        graphics2D.setPaint(paint);
        g.fillRect(0, 0, width, height);
    }
}

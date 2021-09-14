package cn.ussshenzhou.cxcy.widgets;

import javax.swing.*;
import javax.swing.plaf.PanelUI;
import java.awt.*;
import java.awt.geom.Arc2D;

/**
 * @author USS_Shenzhou
 */
public class Dot extends JPanel {
    public Dot() {
        //super();
        this.setOpaque(false);
    }

    private Color color;
    private int radius = 5;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics2D.setPaint(color);
        graphics2D.fillOval(0,0, radius * 2, radius * 2);
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getRadius() {
        return radius;
    }

}

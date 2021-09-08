package cn.ussshenzhou.cxcy.widgets;

import javax.swing.*;
import java.awt.*;

/**
 * @author USS_Shenzhou
 */
public class Square extends JPanel {
    private Color color;
    public Square(LayoutManager layout, boolean isDoubleBuffered,Color color) {
        super(layout, isDoubleBuffered);
        this.color = color;
    }

    public Square(LayoutManager layout,Color color) {
        super(layout);
        this.color = color;
    }

    public Square(boolean isDoubleBuffered,Color color) {
        super(isDoubleBuffered);
        this.color = color;
    }

    public Square(Color color) {
        super();
        this.color = color;
    }

    @Override
    protected void paintComponent(Graphics g) {
        int width = this.getWidth();
        int height = this.getHeight();
        g.setColor(color);
        g.fillRect(0,0,width,height);
    }
}

package cn.ussshenzhou.cxcy.widgets;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Arc2D;

/**
 * @author USS_Shenzhou
 */
public class RadarPanel extends JPanel {
    private int pointX = 0;
    private int pointY = 0;
    /**
     * Z:depth
     */
    private int pointZ = 0;

    @Override
    protected void paintComponent(Graphics g) {
        int width = this.getWidth();
        int height = this.getHeight();

        this.drawArc(g);
    }

    private void drawArc(Graphics g) {
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        graphics2D.setPaint(new Color(0x0F171C));
        graphics2D.fillOval(0, 0, getWidth(), getHeight());

        this.drawMultiArcs(graphics2D, new Color(0x173344), 8, (int) (getWidth() * 0.15), (int) (getWidth() * 0.5), (int) (getHeight() * 0.5));
        this.drawMultiArcs(graphics2D, new Color(0x173344), 8, (int) (getWidth() * 0.30), (int) (getWidth() * 0.5), (int) (getHeight() * 0.5));
        this.drawMultiArcs(graphics2D, new Color(0x173344), 8, (int) (getWidth() * 0.45), (int) (getWidth() * 0.5), (int) (getHeight() * 0.5));

        this.drawTarget(graphics2D);
    }

    private Shape drawArc(int radius, int centerX, int centerY, double startAngle, double endAngle) {
        Rectangle rectangle = new Rectangle(centerX - radius, centerY - radius, radius * 2, radius * 2);
        return new Arc2D.Double(rectangle, startAngle, endAngle, Arc2D.PIE);
    }

    private void drawMultiArcs(Graphics2D graphics2D, Color color, int mount, int radius, int centerX, int centerY) {
        graphics2D.setPaint(color);
        for (int i = 0; i < mount; i++) {
            graphics2D.draw(drawArc(radius, centerX, centerY, 360d / mount * i, 360d / mount * (i + 1)));
        }
    }

    private void drawTarget(Graphics2D graphics2D) {
        //Color color = new Color();
        //graphics2D.setPaint();
    }

    public void setPoint(int x, int y, int z) {
        this.pointX = x;
        this.pointY = y;
        this.pointZ = z;
    }

    public void setPoint(double x, double y, double z) {
        this.setPoint((int) x, (int) y, (int) z);
    }
}

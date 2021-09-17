package cn.ussshenzhou.cxcy.widgets;

import cn.ussshenzhou.cxcy.utils.ColorManager;
import cn.ussshenzhou.cxcy.utils.LogManager;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Arc2D;
import java.util.ArrayList;

/**
 * @author USS_Shenzhou
 */
public class RadarPanel extends JPanel {
    private int pointX = 0;
    private int pointY = 0;
    /**
     * Z:depth in cm
     */
    private int pointZ = 300;
    public static final double MAX_RANGE = 50d;
    private Dot target = new Dot();

    public RadarPanel() {
        this.setLayout(new Layout());
        target.setColor(this.getColorByDepth());
        this.add(target);
        this.setOpaque(false);
        target.setVisible(false);
    }

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

    private void setPoint(int x, int y, int z) {
        this.pointX = x;
        this.pointY = y;
        this.pointZ = z;
        target.setColor(this.getColorByDepth());
        this.target.updateUI();
        this.target.setVisible(true);
    }

    @Deprecated
    public void setPoint(double x, double y, double z) {
        this.setPoint((int) x, (int) y, (int) z);
    }

    public void setPointByCenteredAndRelativeXYZ(int x, int y, int z) {
        this.setPoint(
                x / MAX_RANGE * this.getWidth() / 2d + this.getWidth() / 2d,
                (-y / MAX_RANGE * this.getHeight() / 2d + this.getHeight() / 2d),
                z
        );
    }

    public void setPointByStringArray(ArrayList<String> strings) {
        try {
            this.setPointByCenteredAndRelativeXYZ(Integer.parseInt(strings.get(0)), Integer.parseInt(strings.get(1)), Integer.parseInt(strings.get(2)));
        } catch (Exception e) {
            e.printStackTrace();
            LogManager.LOGGER.severe(e.getMessage());
        }
    }

    @Deprecated
    public void setPointByRAZ(double r, double angle, double z) {
        angle = angle % 360;
        this.setPoint(
                (int) (r * Math.cos(angle) + this.getWidth() / 2),
                (int) (r * Math.sin(angle) + this.getHeight() / 2),
                (int) z
        );
    }

    public Color getColorByDepth() {
        double factor;
        double max = ColorManager.MAX_TARGET_Z;
        double min = ColorManager.MIN_TARGET_Z;
        if (pointZ <= min) {
            factor = 0;
        } else if (pointZ >= max) {
            factor = 1;
        } else {
            factor = (pointZ - min) / (max - min);
        }
        int r = ColorManager.MIN_DEPTH_COLOR.getRed() + (int) ((ColorManager.MAX_DEPTH_COLOR.getRed() - ColorManager.MIN_DEPTH_COLOR.getRed()) * factor);
        int g = ColorManager.MIN_DEPTH_COLOR.getGreen() + (int) ((ColorManager.MAX_DEPTH_COLOR.getGreen() - ColorManager.MIN_DEPTH_COLOR.getGreen()) * factor);
        int b = ColorManager.MIN_DEPTH_COLOR.getBlue() + (int) ((ColorManager.MAX_DEPTH_COLOR.getBlue() - ColorManager.MIN_DEPTH_COLOR.getBlue()) * factor);

        return new Color(r, g, b);
    }

    private class Layout implements LayoutManager {

        @Override
        public void addLayoutComponent(String name, Component comp) {

        }

        @Override
        public void removeLayoutComponent(Component comp) {

        }

        @Override
        public Dimension preferredLayoutSize(Container parent) {
            return null;
        }

        @Override
        public Dimension minimumLayoutSize(Container parent) {
            return null;
        }

        @Override
        public void layoutContainer(Container parent) {
            int width = parent.getWidth();
            int height = parent.getHeight();
            if (target.isVisible()) {
                int r = target.getRadius();
                target.setBounds(pointX - 2, pointY - 2, r * 2, r * 2);
            }
        }
    }
}
